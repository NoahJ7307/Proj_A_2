create database reddb;
use reddb;

create user`reduser`@`%` identified by '1234'; 
grant all privileges on reddb.* to `reduser`@`%`;

show tables;

create table tbl_todo(
	  tno  int  primary key auto_increment,
    title varchar(100) ,
    dueDate Date,
    finished boolean
);
create table tbl_product(
	pno  int  primary key auto_increment,
    pname varchar(100) ,
    pdesc varchar(100) ,
    price int
);

drop table tbl_attach;
create table tbl_attach(
	uuid varchar(100) not null,
	uploadPath varchar(200) not null,
    fileName varchar(100) not null,
    image char(1) default 'I',
    pno int
);
alter table tbl_attach add constraint pk_attach primary key(uuid);
alter table tbl_attach add constraint fk_board_attach foreign key(pno) references tbl_product(pno);

drop table tbl_reply;
create table tbl_reply(
	rno int primary key auto_increment,
    pno int not null,
    reply varchar(1000) not null,
    replyer varchar(50) not null,
    foreign key (pno) references tbl_product(pno)
);

set sql_safe_updates = 0;
select * from tbl_product order by pno desc;
select * from tbl_reply order by pno desc;
delete from tbl_product where price = 0;