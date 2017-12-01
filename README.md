# Log4J JSON Layout
A JSON layout for Log4J (v1.2).

## Output format
```
{"timestamp":"<DATE>","level":"<LEVEL>","logger":"<LOGGER>","thread":"<THREAD>","message":"<MESSAGE>","stacktrace":"<STACKTRACE>"}
```
The "stacktrace" item is optional and will only be in the JSON object if the log message has a trace message.

## Build the project
```
mvn package
```
This creates the file "target/log4j-json-layout-1.0-SNAPSHOT.jar" which needs to be added to the JVM classpath.

## Example log4j.properties
```
log4j.appender.myAppender=org.apache.log4j.DailyRollingFileAppender
log4j.appender.myAppender.File=/var/log/my.log
log4j.appender.myAppender.layout=de.thmshmm.log4j.JsonLayout
log4j.appender.myAppender.layout.DatePattern=yyyy-MM-dd HH:mm:ss,SSS
```

## Layout configuration
| Name | Options | Default |
|------|---------|---------|
| DatePattern | all valid SimpleDateFormat patterns | yyyy-MM-dd HH:mm:ss,SSS |
