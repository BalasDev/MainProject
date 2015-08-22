CREATE TABLE ACTIVITY (  
  ID int(6) NOT NULL AUTO_INCREMENT,
  _DATE timestamp NOT NULL,
  DURATION int(6) ,
  COMMENT VARCHAR(255) ,
  MEMBERID int(6) ,
  ASSIGMENTID int(6),
  PRIMARY KEY (ID) 
) ; 

ALTER TABLE activity ADD CONSTRAINT activity_ibfk_1 FOREIGN KEY (MEMBERID) REFERENCES member (id);
ALTER TABLE activity ADD CONSTRAINT activity_ibfk_2 FOREIGN KEY (ASSIGMENTID) REFERENCES assigment (id);

insert into activity (`DURATION`, `COMMENT`, `MEMBERID`, `ASSIGMENTID`) values (5, 'doing task1', 1, 1);
insert into activity (`DURATION`, `COMMENT`, `MEMBERID`, `ASSIGMENTID`) values (4, 'doing task2', 2, 2);
