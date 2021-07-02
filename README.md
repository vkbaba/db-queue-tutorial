# db-queue-tutorial
This demo application is a tutorial to study how mysql, redis, and rabbitmq work.

Note that my environment is win10 so some commands below are slightly different for other operating systems.
![architecture](https://github.com/vkbaba/db-queue-tutorial/blob/main/images/architecture.png)
## How to use
1. Change CLIENT_IP in docker-compose.yaml to your client IP address like 192.168.1.10
2. docker build -t db-queue-tutorial ./demo/
3. docker build -t db-queue-tutorial-consumer ./demo-consumer/
4. docker-compose up -d
5. curl.exe -X POST http://localhost:8080/items/ -H "cache-control: no-cache" -H "content-type: application/json" -d '{&#92;"productName&#92;": &#92;"T-shirt&#92;",&#92;"price&#92;": 1200}'
6. Access rabbitmq to check the data in a queue
    - http://localhost:15672/ user:guest, pass:guest
![rabbitmq](https://github.com/vkbaba/db-queue-tutorial/blob/main/images/rabbitmq.png)
7. Access mysql adminer to check the data in DB
    - http://localhost:8092/ user:root, pass:VMware1!
![mysql](https://github.com/vkbaba/db-queue-tutorial/blob/main/images/mysql.png)
8. Get the data from mysql to cache the data
    - http://localhost:8080/items/1
9. Access redis-commander to check the data on a cache
    - http://localhost:8091 
![redis](https://github.com/vkbaba/db-queue-tutorial/blob/main/images/redis.png)
10. docker-compose down 

## Some Cool References
https://springhow.com/spring-boot-redis-cache/

https://kennay-kermani.medium.com/simple-pub-sub-implementation-with-spring-boot-docker-and-rabbitmq-4ed7461de239
