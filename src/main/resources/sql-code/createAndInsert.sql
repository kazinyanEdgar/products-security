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