-- sequence 
DROP SEQUENCE DEPT_NO_SEQ;

CREATE SEQUENCE DEPT_NO_SEQ
INCREMENT BY 10
START WITH 10
NOMAXVALUE
NOCYCLE
NOCACHE;

-- table
drop table dept;
create table dept (deptno number not null primary key, 
                   dname varchar2(30), 
                   location varchar2(20));

delete from dept;
commit;

select * from dept order by deptno;