cls
setlocal
REM set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000 %MAVEN_OPTS%
call mvn tomcat:deploy > tomcat.log
pause
