FROM navikt/java:11
ENV JAVA_OPTS="-Dlogback.configurationFile=logback-remote.xml -Xms1024M -Xmx4096M"
COPY build/libs/app*.jar app.jar