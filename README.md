# configuration-management-system

A Hiring Assignment

The `./backend` folder contains the code for the REST API server.

The `./frontend` folder contains the code for the frontend.

## TODOs

- [ ] Swagger
- [ ] UserController
- [ ] Authentication and authorization with JWT
- [WIP] test the ConfigController
  - [x] Create
  - [ ] Update
  - [ ] Read
  - [ ] Delete
- [x] create database
- [x] user table via jpa
- [x] create configuration table
  - [x] foreign key to user table
- [ ] Dockerize
- [ ] Docker compose

## Data Definition Language

I chose 'user' and 'configuration' as table names. The convention to use singular, leaves room for actual cases where plurals are needed.

```
mysql> show create table user;
+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table | Create Table |
+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| user | CREATE TABLE `user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`hashed_pass` varchar(255) NOT NULL,
`username` varchar(255) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.01 sec)

mysql> show create table configuration;
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table | Create Table |
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| configuration | CREATE TABLE `configuration` (
`id` bigint NOT NULL AUTO_INCREMENT,
`_key` varchar(255) DEFAULT NULL,
`value` varchar(255) DEFAULT NULL,
`user_id` bigint NOT NULL,
PRIMARY KEY (`id`),
KEY `FK5u3jsr211iwxnybkb9fn9m1lr` (`user_id`),
CONSTRAINT `FK5u3jsr211iwxnybkb9fn9m1lr` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci |
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)
```
