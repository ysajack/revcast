drop database revcast;
create database revcast;
use revcast;

create table project(
  id int not null primary key auto_increment,
  bio varchar(26) not null,
  project_id varchar(26) not null,
  prj_name varchar(50) not null,
  prj_type varchar(13) not null,
  associate_id varchar(26) not null
);

create table associate(
  id int not null primary key auto_increment,
  associate_id varchar(26) not null,
  associate_name varchar(50) not null,
  designation varchar(13) not null,
  status varchar(13) not null,
  rev_cat varchar(13) not null,
  practice varchar(13) not null,
  onsite_offshore varchar(13) not null,
  rev_type varchar(13) not null,
  prj_start varchar(13) not null,
  prj_end varchar(13) not null,
  allocation int(13) not null,
  rate int(13) not null,
  project_id varchar(26) not null
);

create table forecast(
  id int not null primary key auto_increment,
  jan int(13) null,
  feb int(13) null,
  mar int(13) null,
  apr int(13) null,
  may int(13) null,
  jun int(13) null,
  jul int(13) null,
  aug int(13) null,
  sep int(13) null,
  oct int(13) null,
  nov int(13) null,
  decbr int(13) null,
  associate_id varchar(26) not null
);

create table leaveplan(
  id int not null primary key auto_increment,
  year_taken varchar(13) null,
  month_taken varchar(13) null,
  num_of_days int(13) null,
  date_taken varchar(50) null,
  leave_status varchar(13) null,
  comments varchar(50) null,
  associate_id varchar(26) not null
);

insert into project values (1,'Digital','P1234567','Find Doctor Location','BTM','A12345');
insert into associate values (1,'A12345','Apple Orange','Associate','Active','BL','QE&A','Onsite','TM','5/1/19','TBD',100,120,'P1234567');
insert into forecast values (1,15000,18000,20000,14000,13000,12500,15000,15000,15000,15000,15000,15000,'P1234567');
insert into leaveplan values(1,'2019','April',2,'4/2,4/3','Confirmed','LA trip','A12345');
insert into leaveplan values(3,'2019','May',1,'5/1','Confirmed','Personal','A12345');
insert into leaveplan values(2,'2018','March',1,'3/2','Confirmed','Personal','A12345');
