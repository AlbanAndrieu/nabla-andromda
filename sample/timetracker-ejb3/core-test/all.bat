cls

call setenv.bat
REM call mvn dependency:tree > dependency.log
call mvn clean install -Psample,arq-jbossas-managed > install.log

pause
