CREATE TABLE `tb_book_2` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `type` varchar(20) DEFAULT NULL,
    `name` varchar(50) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;