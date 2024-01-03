# 이미 같은 port번호를 사용중인 에러 
> Description:
>
> Web server failed to start. Port 8080 was already in use.
>
>Action:
>
>Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.

1. port번호 확인 
```bash 
lsof -i :8080
```

2. 사용중인 포트번호를 PID를 사용하여 종료 
```bash 
kill <PID>
```



