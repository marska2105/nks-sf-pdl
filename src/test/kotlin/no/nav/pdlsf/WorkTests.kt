package no.nav.pdlsf
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class WorkTests : StringSpec() {

    init {
        val aktoerIdOne = "a1"
        val personOne = Person(identifikasjonsnummer = "1")
        val aktoerIdTwo = "a2"
        val personTwo = Person(identifikasjonsnummer = "2")
        val aktoerIdThree = "a3"
        val personThree = Person(identifikasjonsnummer = "3")

        val aktoerIdNew = "a4"
        val personNew = Person(identifikasjonsnummer = "4")
        val personUpdated = Person(identifikasjonsnummer = "5")

        val personCache = mapOf(
                aktoerIdOne to personOne.hashCode(),
                aktoerIdTwo to personTwo.hashCode(),
                aktoerIdThree to personThree.hashCode()
        )

        "Verify exists check on cache" {
            personCache.exists(aktoerIdOne, personOne.hashCode()) shouldBe ObjectInCacheStatus.NoChange
            personCache.exists(aktoerIdNew, personNew.hashCode()) shouldBe ObjectInCacheStatus.New
            personCache.exists(aktoerIdOne, personUpdated.hashCode()) shouldBe ObjectInCacheStatus.Updated
        }
    }
}