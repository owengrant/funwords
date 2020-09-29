@echo off
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"bin\java" %JLINK_VM_OPTIONS% -m owen.funwords/owen.funwords.App %*
