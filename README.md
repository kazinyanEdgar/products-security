# Products-security

Данное приложение позволяет добавлять, просматривать, изменять и удалять продукты.
Возможность выполнять те или иные действия, зависит от роли пользователя
в системе. К примеру, неаутентифицированные пользователи могут
получить доступ только к списку продуктов. Также я добавил в проект логирование и написал
тесты.

## Предварительные условия
В MySQL необходимо выполнить скрипт из **createAndInsert.sql**
и в файле **application.properties** поменять
username и password при необходимости
``` sql
CREATE SCHEMA `database` DEFAULT CHARACTER SET utf8;

CREATE TABLE `database`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `database`.`products` (`name`, `price`) VALUES ('Смартфон', '4500');
INSERT INTO `database`.`products` (`name`, `price`) VALUES ('Планшет', '2500');
INSERT INTO `database`.`products` (`name`, `price`) VALUES ('Клавиатура', '1000');
INSERT INTO `database`.`products` (`name`, `price`) VALUES ('Мышь', '250');
INSERT INTO `database`.`products` (`name`, `price`) VALUES ('Наушники', '200');
```

## Запуск
* В командной строке перейти в папку проекта
(где присутствует файл pom.xml) и выполнить одну команду
*mvn spring-boot:run* и перейти к следующему шагу, т.е.
перейти в браузере по ссылке localhost:8080/products

Либо можно пойти другим путем. Необходимо из той же папки вызвать
следующие команды

*mvn clean*

*mvn package*

В результате в папке проекта появится папка "target",
в которой будет файл "products-security-0.0.1-SNAPSHOT.jar".
Необходимо выполнить следующую команду из командной строки,
предварительно перейдя в эту папку "target"

*java -jar products-security-0.0.1-SNAPSHOT.jar*

* Перейти в браузере по ссылке localhost:8080/products.
К данной странице могут получить доступ все, даже неаутентифицированные
пользователи. Просматривать, изменять и удалять продукты могут
пользователи с ролью "USER". Те же действия, плюс возможность
добавлять продукты, могут выполнять пользователи с ролью "ADMIN".

Пройти авторизацию можно по следующим данным:
* Роль "USER": username=u, password=u
* Роль "ADMIN": username=a, password=a