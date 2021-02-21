DROP TABLE IF EXISTS `planets`;

CREATE TABLE `planets` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `climate` VARCHAR(50) NOT NULL,
    `terrain` VARCHAR(50) NOT NULL,
    `films_count` INT UNSIGNED DEFAULT NULL,
    `sw_id` INT UNSIGNED DEFAULT NULL,
PRIMARY KEY (`id`));