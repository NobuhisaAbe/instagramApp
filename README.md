#demo app

[![Build Status](https://cloud.drone.io/api/badges/NobuhisaAbe/demo/status.svg)](https://cloud.drone.io/NobuhisaAbe/demo)

###docker上での起動
docker上でnginx,app,mysqlコンテナを構築しappを起動する
```
docker-compose up
```

###local開発環境での起動
docker上でmysqlコンテナを構築
```
docker-compose -f docker-compose-local.yml up
```
app起動
```
./grandlew bootRun
```
test
```
./grandlew test
```
lint
```
# Check
./grandlew ktlintCheck

# Format(Caution!)
._grandlew ktlintFormat
```
And you can run app from intelliJ IDEA