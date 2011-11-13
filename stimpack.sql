DROP DATABASE IF EXISTS stimpack;
CREATE DATABASE IF NOT EXISTS stimpack;

USE stimpack;

CREATE TABLE student
(
student_id int NOT NULL AUTO_INCREMENT,
username varchar(30),
password varchar(32),
firstname varchar(30),
lastname varchar(30),
phone varchar(32),
email varchar(100),
age tinyint UNSIGNED,
PRIMARY KEY(student_id)
);

CREATE TABLE teacher
(
teacher_id int NOT NULL AUTO_INCREMENT,
username varchar(30),
password varchar(32),
firstname varchar(30),
lastname varchar(30),
phone varchar(32),
email varchar(100),
age tinyint UNSIGNED,
PRIMARY KEY(teacher_id)
);

CREATE TABLE subject
(
class_id int NOT NULL AUTO_INCREMENT,
teacher_id int,
name varchar(50),
maxstudents tinyint UNSIGNED,
schedule time,
PRIMARY KEY(class_id),
FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id) ON DELETE CASCADE
);

CREATE TABLE student_subject
(
class_id int NOT NULL,
student_id int NOT NULL,
FOREIGN KEY(class_id) REFERENCES subject(class_id) ON DELETE CASCADE,
FOREIGN KEY(student_id) REFERENCES student(student_id) ON DELETE CASCADE
);

GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,ALTER ON stimpack.* TO 'stimpack'@'localhost' IDENTIFIED BY 'stimpackuser' ;
