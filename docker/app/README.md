# ローカル開発環境構築
起動
```
docker-compose up -d
```
状態確認
```
docker-compose ps
```
停止
```
doker-compose stop
```

### MEMO
#### mysql
*MySQLクライアントからDockerのMySQLにアクセスする場合は127.0.0.1(not localhost)でアクセスすること

# docker上でのアプリケーション起動
起動
```
docker build --build-arg JAR_FILE=build/libs/*.jar -t nobuhisaabe/demo .
```
実行
```
docker run -p 8080:8080 nobuhisaabe/demo
```