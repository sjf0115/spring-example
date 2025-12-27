DROP DATABASE IF EXISTS orders;
CREATE DATABASE orders;
USE orders;
CREATE TABLE `tb_order` (
  `id` bigint NOT NULL COMMENT '订单ID',
  `price` double DEFAULT NULL COMMENT '订单金额',
  PRIMARY KEY (`id`)
);

INSERT INTO tb_order VALUES (1, 18.8);
INSERT INTO tb_order VALUES (2, 201);
INSERT INTO tb_order VALUES (3, 25.3);
INSERT INTO tb_order VALUES (4, 11);

---

DROP DATABASE IF EXISTS goods;
CREATE DATABASE goods;
USE goods;
CREATE TABLE `tb_goods` (
  `id` bigint NOT NULL COMMENT '商品ID',
  `name` varchar(30) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`id`)
);

INSERT INTO tb_goods VALUES (1, "花");
INSERT INTO tb_goods VALUES (2, "剃须刀");
INSERT INTO tb_goods VALUES (3, "袜子");
INSERT INTO tb_goods VALUES (4, "笔记本");


