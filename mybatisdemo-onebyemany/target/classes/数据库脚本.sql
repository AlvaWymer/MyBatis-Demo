DROP DATABASE IF EXISTS mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE item(
	iid		bigint AUTO_INCREMENT ,
	title	varchar(50) ,
	CONSTRAINT pk_iid PRIMARY KEY(iid)
) engine="innodb";
CREATE TABLE subitem(
	sid		bigint AUTO_INCREMENT ,
	title	varchar(50) ,
	iid 	bigint ,
	CONSTRAINT pk_sid PRIMARY KEY(sid) ,
	CONSTRAINT fk_iid FOREIGN KEY(iid) REFERENCES item(iid) ON DELETE CASCADE
) engine="innodb";
INSERT INTO item(title) VALUES ('家居用品') ;
INSERT INTO item(title) VALUES ('电子产品') ;
