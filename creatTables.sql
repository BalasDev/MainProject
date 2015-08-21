

CREATE TABLE EMPLOYEE (
  ID int(6) NOT NULL AUTO_INCREMENT,  
  FIRSTNAME varchar(255) NOT NULL,
  LASTNAME varchar(255) NOT NULL,  
  LOGIN varchar(255) NOT NULL,
  PASSWORD varchar(255) NOT NULL,
  POSITIONID int(6) NOT NULL,
  PRIMARY KEY (ID)
      
);   

CREATE TABLE POSITION (  
  ID int(6) NOT NULL AUTO_INCREMENT,  
  NAME varchar(255) NOT NULL,  
  PRIMARY KEY (ID) 
) ; 

CREATE TABLE ROLE (
    ID INT(6) NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE PROJECT (
    ID INT(6) NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE MEMBER (
    ID INT(6) NOT NULL AUTO_INCREMENT,
    PROJECTID INT(6) NOT NULL,
    EMPLOYEEID INT(6) NOT NULL,
    ROLEID INT(6) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE STATUS (  
  ID int(6) NOT NULL AUTO_INCREMENT,  
  NAME varchar(255) NOT NULL,  
  PRIMARY KEY (ID) 
) ; 

CREATE TABLE TASK (  
  ID int(6) NOT NULL AUTO_INCREMENT,
  PROJECTID int(6) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  PSD date not null,
  PDD int(10) NOT NULL,
  ASD date not null,
  AD int(10) NOT NULL,
  STATUSID int(6) NOT NULL, 
  PRIMARY KEY (ID) 
) ; 

CREATE TABLE ASSIGMENT (  
  ID int(6) NOT NULL AUTO_INCREMENT,
  MEMBERID int(6) NOT NULL,
  TASKID int(6) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID) 
) ; 

CREATE TABLE ATTACHMENT (  
  ID int(6) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL,
  SIZE VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL,
  PROJECTID int(6) NOT NULL,
  TASKID int(6) NOT NULL,
  PRIMARY KEY (ID) 
) ; 

CREATE TABLE ACTIVITY (  
  ID int(6) NOT NULL AUTO_INCREMENT,
  _DATE date NOT NULL,
  DURATION int(6) NOT NULL,
  COMMENT VARCHAR(255) NOT NULL,
  MEMBERID int(6) NOT NULL,
  ASSIGMENTID int(6) NOT NULL,
  PRIMARY KEY (ID) 
) ; 

ALTER TABLE employee ADD CONSTRAINT employee_ibfk_1 FOREIGN KEY (POSITIONID) REFERENCES position (id);
ALTER TABLE member ADD CONSTRAINT member_ibfk_1 FOREIGN KEY (PROJECTID) REFERENCES project (id);
ALTER TABLE member ADD CONSTRAINT member_ibfk_2 FOREIGN KEY (EMPLOYEEID) REFERENCES employee (id);
ALTER TABLE member ADD CONSTRAINT member_ibfk_3 FOREIGN KEY (ROLEID) REFERENCES role (id);
ALTER TABLE task ADD CONSTRAINT task_ibfk_1 FOREIGN KEY (PROJECTID) REFERENCES project (id);
ALTER TABLE task ADD CONSTRAINT task_ibfk_2 FOREIGN KEY (STATUSID) REFERENCES status (id);
ALTER TABLE assigment ADD CONSTRAINT assigment_ibfk_1 FOREIGN KEY (MEMBERID) REFERENCES member (id);
ALTER TABLE assigment ADD CONSTRAINT assigment_ibfk_2 FOREIGN KEY (TASKID) REFERENCES task (id);
ALTER TABLE attachment ADD CONSTRAINT attachment_ibfk_1 FOREIGN KEY (PROJECTID) REFERENCES project (id);
ALTER TABLE attachment ADD CONSTRAINT attachment_ibfk_2 FOREIGN KEY (TASKID) REFERENCES task (id);
ALTER TABLE activity ADD CONSTRAINT activity_ibfk_1 FOREIGN KEY (MEMBERID) REFERENCES member (id);
ALTER TABLE activity ADD CONSTRAINT activity_ibfk_2 FOREIGN KEY (ASSIGMENTID) REFERENCES assigment (id);

insert into position values (1,'Junior');
insert into position values (2,'Middle');
insert into position values (3,'Senior');

insert into employee values (2,'Evgen','Balykin','Balas','1',2);
insert into employee values (1,'Roman','Kondratenko','admin','1',1);

insert into project values (1,'pixar','help Misha');
insert into project values (2,'epam','project for epamsystem');

insert into role values (1,'development');
insert into role values (2,'key developer');
insert into role values (3,'team lead');
insert into role values (4,'manager');

insert into member values (1,1,1,1);
insert into member values (2,1,2,2);

insert into status values (1,'to do');
insert into status values (2,'in progress');
insert into status values (3,'delivered');
insert into status values (4,'done');

insert into task values (1, 1, 'task1', '2015-08-17', 2, '2015-08-17', 2, 1);
insert into task values (2, 1, 'task2', '2015-08-16', 2, '2015-08-16', 2, 1);

insert into attachment values(1, 'file', '200', 'descr_file', 1, 1);
insert into attachment values(2, 'file2', '200', 'descr_file2', 1, 2);

insert into assigment values (5, 1, 1, 'first person on the task1');
insert into assigment values (6, 2, 2, 'second person on the task2');

insert into activity values (1, '2015-08-17', 5, 'doing task1', 1, 1);
insert into activity values (6, '2015-08-17', 4, 'doing task2', 2, 2);









