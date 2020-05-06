======alter==============

alter table employee add age number;

alter table  emp  modify sal varchar2(30);

alter table emp rename  column sal to salary

alter table employee rename  column ename to name

alter table emp rename to employee

delete employee column comm
==========alter===========
drop  table student

select *from floor

create table student (id number(10),name varchar2(30))

insert into student (id,name) select id,name from employee

select t1.id,t2.id from student t1,employee t2 where t1.id=t2.id

update employee set comm=10 where id=12;

=======case statement=============

declare 
grade varchar2(1):='3';
begin 
case grade
when '1' then dbms_output.put_line('excellent');
when '2' then dbms_output.put_line('verygood');
when '3' then dbms_output.put_line('good');
when '4' then dbms_output.put_line('avreage');
when '5' then dbms_output.put_line('notgood');
else dbms_output.put_line('no such range');
end case;
end;

update employee set comm=
case
where comm=0,then 100
where comm=10,then 1000
else comm
end;

===============distinct================

select distinct salary,comm  from employee

select dept, count(*) from employee group by dept 

select *from employee order by name
====================================

create table emp (id number,name varchar2(30),age number,salary number,dept varchar2(30));

insert into emp values(1,'ram',29,50000,'banking');

insert into emp values(2,'manohar',29,50000,'insurance');

insert into emp values(3,'chiru',30,60000,'telecom');

insert into emp values(4,'pawan',30,70000,'banking');

insert into emp values(5,'kalyan',35,80000,'insurance');

insert into emp values(6,'nagababu',39,90000,'telecom');


select name, count(*) from emp group by name 


select dept, count(*) from emp group by dept 

select dept, sum(salary) from emp group by dept having sum(salary)>100000

============================foreign key=================================

create table customers(id number not null,name varchar2(20)not null,
age number not null,address varchar(25),salary number(18,2),primary key(id));


create table orders(
id number not null,
created_date date,
amount number,
customer_id number references customers(id),
primary key(id));


alter table orders add foreign key (customers_id) references cutomers(id);

======================constraints=================
check ,index,foreign key 

alter table customers modify age number check(age>18)

========================================================
alter table customers add constraint myConstraintCheck age number check(age>18)

alter table customers drop constraint myConstraintCheck

======================================================

create index index_age on customers(age)

select *from customers

alter table customers drop index index_age;xx

=========================joins==============================

create table temp1(
empno number(4) not null,
ename varchar2(10) default null,
job varchar2(9) default null,
mgr number(4) default null,
hiredate date default null,
sal decimal(7,2) default null,
comm decimal (7,2) default null,
deptno decimal(2,0) default null
);


create table dept(
deptno decimal(2,0)default null,
dname varchar2(14)default null,
loc varchar2(13) default null);

alter table dept rename column dept to deptno

insert into temp1 values(7369,'smith','clerk',7902,'17-dec-1980',800,null,20);
insert into temp1 values(7499,'allen','salesmen',7698,'20-feb-1981',1600,300,30);
insert into temp1 values(7521,'ward','salesmen',7698,'22-feb-1981',1250,500,30);
insert into temp1 values(7566,'jones','manager',7839,'2-apr-1981',2975,null,20);
insert into temp1 values(7654,'martin','salesmen',7698,'28-sep-1981',1250,1400,30);
insert into temp1 values(7698,'blake','manager',7839,'1-may-1981',2850,null,30);
insert into temp1 values(7782,'clark','manager',7839,'9-jun-1981',2450,null,10);
insert into temp1 values(7788,'scott','analyst',7566,'9-dec-1982',3000,null,20);
insert into temp1 values(7839,'king','president',null,'17-nov-1981',5000,null,10);
insert into temp1 values(7844,'turner','salesmen',7698,'8-seep-1981',1500,0,30);
insert into temp1 values(7876,'adams','clerk',7788,'12-jan-1983',1100,null,20);
insert into temp1 values(7900,'james','clerk',7698,'3-dec-1981',950,null,30);
insert into temp1 values(7902,'ford','analyst',7566,'3-dec-1981',3000,null,20);
insert into temp1 values(7934,'miller','clerk',7782,'23-jan-1982',1300,null,10);


insert into dept values (10,'accounting','newyork');
insert into dept values (20,'research','dallas');
insert into dept values (30,'sales','chicago');
insert into dept values (40,'operations','bostan');

alter table temp1 rename to emp1

update temp1 set deptno=50 where empno=7788

select empno,ename,d.deptno,dname from temp1 e full outer join dept d on e.deptno=d.deptno;

select e1.empno,e2.ename from temp1 e1,temp1 e2 where e1.empno=e2.mgr

select empno,ename,job,mgr,hiredate,sal,comm from temp1 t, dept d where d.deptno=t.deptno(+)

select job from emp1 where deptno=20 minus select job from emp1 where deptno=30


select *from floor

=========================intersect minus not null like between exist not condition ===========

create table address (hno number,street varchar2(25),city varchar2(25),state varchar2(25),country varchar2(25));

insert into address(hno,street,city,state,country) values(1,'ameerpet','hyd','ts','india');
insert into address(hno,street,city,state,country) values(2,'yousufguda','hyd','ts','india');
insert into address (hno,street,city,state,country) values(1,'punjagutta','hyd','ts','india');
insert into address (hno,city,state,country) values(1,'hyd','ts','india');
insert into address (hno,city,state,country) values(1,'hyd','ts','india');
insert into address (hno,street,state,country) values(1,'srnagar','ts','india');
insert into address (hno,state,country) values(1,'ts','india');

select *from address where city is null
update address set city='hyd' where city is null
delete address where street is null

select * from address where hno between 1 and 4; 


select * from emp1 where not exists(select * from dept where emp1.deptno=dept.deptno);

select *from address where street not in('ameerpet','yousufguda');
select *from address where street not like('ameer%');


=======================to_number,date,char,nvl,substr,instr==============

select to_number('12345')from dual;

select to_char(sysdate,'yyyy/mm/dd') from dual;

select to_char(sysdate,'Mon ddth,yyyy') from dual;

select nvl(comm,0)from emp1


==================decode================

select ename,job,decode(job,'clerk','executive','manager','rm',job)from emp1;

select sysdate from dual
select 1+1 from dual


==================seuence============


create sequence emp_id_seq

minvalue 5;
maxvalue 10;
start with 5;
increment by 1;

select emp_id_seq.nextval from dual



create sequence std_id_seq

minvalue 10;
maxvalue 20;
start with 10;
increment by 1;

select std_id_seq.nextval from dual

===================procedure================

create or replace procedure proc_emp(salary in number,comm in number,gross_sal out number))

is 
begin
gross_sal:=salary+comm;
end;


drop procedure proc_emp

execute proc_emp(500,200)
==============function===========================

create function func_emp(sal number,comm number)
return number
as 
gross_sal number
begin 
gross_sal:=sal+comm;
exception 
end func_emp;

drop function f;

declare
gross_sal number;
begin 
gross_sal:=func_emp(500,200);
dbms_output.put_line(gross_sal);
end;

create table test(id number,name varchar2(20),salary number,doj date);

create or replace function f(x in out date) return date
is
y date;
begin 
select salary,doj into x,y from  test where id=x;
return (y);
end;

declare 
a date;
b salary.salary%type;
begin
b:=1;
a:=f(b);
dbms_output.put_line(a);
dbms_output.put_line(b);
end ;
=================trigger====================

create or replace trigger aft_ins_emp
after insert on employee
for eachrow
begin
if  inserting then
dbms_output.put_line('before insert');
else if updating then
dbms_output.put_line('before delete');
end if;
end;

============================example====================

select count(*) total_count from floor;
SELECT COUNT(*) TOTAL_COUNT FROM FLOOR

======================ex=======================

select f.* FROM(select ROWNUM,FLOOR_ID,FLOOR_NAME,FLOOR_DESC FROM FLOOR)F WHERE ROWNUM BETWEEN 1 AND 2