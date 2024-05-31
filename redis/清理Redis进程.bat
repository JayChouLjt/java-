taskkill /f /t /im redis* 终止所有redis程序
@REM taskkill /f /t /im redis-server.exe
pause

@REM powershell -Command "Get-Process -Name redis* | Stop-Process -Force"
@REM pause

@REM taskkill: 这是用于终止进程的命令。它允许你在Windows系统上终止一个或多个进程。

@REM /f: 这个选项表示强制终止进程，即不会询问用户确认，而是立即终止进程。

@REM /t: 这个选项表示终止指定的进程及其所有子进程。

@REM /im: 这个选项后面跟着一个进程名，用来指定要终止的进程。在这个例子中，redis-server.exe是进程名。
