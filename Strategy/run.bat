@echo off
echo 	======== Java batch compile by Alexandre Alapetite ========
echo 	== 2007-09-30 / 2011-09-09 http://alexandre.alapetite.fr ==

rem Compile .\src\\*.java into .\bin\\*.class using libraries in .\lib\\*.jar
subst m: %0\..
rem "%0\.." is the real path of the batch file
pushd m:
cd \
echo Search java sources in .\src\...
dir src\*.java /B/S > javasrc.tmp~
if ERRORLEVEL 1 (
echo Cannot find Java source files in .\src\
goto abort
)
echo Search jar libraries in .\lib\...
if exist lib for /F "usebackq delims==" %%l in (`dir lib\*.jar /B/S`) do echo -classpath %%l >> javasrc.tmp~
echo Compile in .\bin\...
if exist bin rmdir /S /Q bin
mkdir bin
echo on
"javac" -d bin @javasrc.tmp~
@echo off
echo Done.
:abort
del javasrc.tmp~
popd
subst m: /d

echo Running...
cd bin
java strategy.Main %1 
cd ..
echo.

:end
