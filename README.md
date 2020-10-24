# demo app

[![Build Status](https://cloud.drone.io/api/badges/NobuhisaAbe/demo/status.svg)](https://cloud.drone.io/NobuhisaAbe/demo)

### How to setup
before setup, run docker
```
cd docker
docker-compose up -d
```

### How to run
#### web app
```
./grandlew bootRun
```

#### test
```
./grandlew test
```

#### lint

```
# Check
./grandlew ktlintCheck

# Format(Caution!)
._grandlew ktlintFormat
```
And you can run app from intelliJ IDEA
