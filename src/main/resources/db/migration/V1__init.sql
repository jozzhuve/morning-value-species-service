CREATE TABLE `species`
(
    `id`               bigint NOT NULL,
    `name`             varchar(255) DEFAULT NULL,
    `power_level`      int(255) DEFAULT NULL,
    `special_ability`  varchar(11)  DEFAULT NULL,
    PRIMARY KEY (`id`)
)
