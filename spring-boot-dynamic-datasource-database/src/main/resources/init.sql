----------------------------------------------------------------------------------
-- 画像平台

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;
DROP Table `datasource`;
CREATE TABLE `datasource` (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `datasource_id` varchar(40) NOT NULL COMMENT '数据源ID',
    `datasource_name` varchar(100) NOT NULL COMMENT '数据源名称',
    `datasource_desc` varchar(100) NOT NULL COMMENT '数据源描述',
    `config` text NOT NULL COMMENT '数据源配置',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE(`datasource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据源';

INSERT INTO `datasource` (`datasource_id`, `datasource_name`, `datasource_desc`, `config`)
    VALUES ('10001', '活动平台数据源', '投递人群到活动平台', '{"host":"localhost","port":"3306","database":"activity","user_name":"root","password":"root", "driver": "com.mysql.cj.jdbc.Driver"}');
INSERT INTO `datasource` (`datasource_id`, `datasource_name`, `datasource_desc`, `config`)
    VALUES ('10002', '运营平台数据源', '投递人群到运营平台', '{"host":"localhost","port":"3306","database":"op","user_name":"root","password":"root", "driver": "com.mysql.cj.jdbc.Driver"}');

----------------------------------------------------------------------------------
-- 活动平台数据库

DROP DATABASE IF EXISTS activity;
CREATE DATABASE activity;
USE activity;
CREATE TABLE `user_group` (
  `uid` bigint NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`uid`)
);

----------------------------------------------------------------------------------
-- 运营平台数据库

DROP DATABASE IF EXISTS op;
CREATE DATABASE op;
USE op;
CREATE TABLE `user_group` (
  `uid` bigint NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`uid`)
);