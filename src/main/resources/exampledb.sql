-- DROP DATABASE IF EXISTS exampledb;
-- CREATE DATABASE exampledb DEFAULT CHARACTER SET utf8;
-- USE exampledb;

DROP TABLE IF EXISTS t_user;
--创建用户表
CREATE TABLE t_user (
   user_id   identity,
   user_name VARCHAR(30),
   password  VARCHAR(32),
   last_visit datetime,
   last_ip  VARCHAR(23),
   primary key (user_id)
);

DROP TABLE IF EXISTS t_login_log;
--创建用户登录日志表
CREATE TABLE t_login_log (
   login_log_id  identity,
   user_id   INT,
   ip  VARCHAR(23),
   login_datetime datetime,
   primary key (login_log_id)
);

--插入初始化数据
INSERT INTO t_user (user_name,password)
             VALUES('admin','123456');
COMMIT;