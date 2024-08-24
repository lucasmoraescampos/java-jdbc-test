#### Books SQL

```
CREATE TABLE `books` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

#### Build notes

`rm -rf out` <br>
`javac -cp lib/mysql-connector-java-8.0.30.jar -d out src/main/java/App.java`<br>
`java -cp "out:lib/mysql-connector-java-8.0.30.jar" App`<br>
