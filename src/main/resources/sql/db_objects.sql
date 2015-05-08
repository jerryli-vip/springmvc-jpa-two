-- 1. sequence 
drop sequence DEPT_NO_SEQ;
drop sequence EMP_NO_SEQ;

create sequence DEPT_NO_SEQ
minvalue 10
maxvalue 999999999999999999999999999
start with 10
increment by 10
nocache;

create sequence EMP_NO_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

-- 2. table
drop table EMP;
drop table DEPT;

create table DEPT
(
  deptno     NUMBER not null,
  dname      VARCHAR2(30),
  location   VARCHAR2(20)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table DEPT add constraint PK_DEPT primary key (DEPTNO);

create table EMP
(
  empno    NUMBER(4) not null,
  ename    VARCHAR2(10),
  gender   VARCHAR(1),
  hiredate DATE,
  sal      NUMBER(7,2),
  deptno   NUMBER
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table EMP
  add constraint PK_EMP primary key (EMPNO);
alter table EMP
  add constraint FK_DEPTNO foreign key (DEPTNO)
  references DEPT (DEPTNO);