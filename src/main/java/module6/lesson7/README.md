# 10.07.2024 databasedan birinchi darsni boshladik

```shell
docker run --name g42postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres postgres:15.7
```