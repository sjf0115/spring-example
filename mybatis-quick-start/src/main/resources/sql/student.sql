-- 删除tb_student表
DROP TABLE IF EXISTS tb_student;

-- 创建tb_student表
CREATE TABLE tb_student (
    -- id 主键
    id INT PRIMARY KEY AUTO_INCREMENT,
    stu_id INT NOT NULL COMMENT '学生编号',
    stu_name VARCHAR(50) NOT NULL COMMENT '学生姓名',
    status INT NOT NULL COMMENT '状态：0:删除, 1:未删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SELECT * FROM tb_student;

-- 添加数据
INSERT INTO tb_student (stu_id, stu_name, status) VALUES ('10001', '梅西', 1);
INSERT INTO tb_student (stu_id, stu_name, status) VALUES ('10002', 'C罗', 1);
INSERT INTO tb_student (stu_id, stu_name, status) VALUES ('10003', '哈兰德', 1);
