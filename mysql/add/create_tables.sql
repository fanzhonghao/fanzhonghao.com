use student_sys;
create table Student(
  Sno numeric(11) primary key,
  Sname char(10) not null
);
create table Course(
  Cno numeric(10) not null primary key,
  Cname char(10) not null
);
create table SC(
  Sno numeric(11) not null,
  Cno numeric(11) not null,
  primary key (Sno,Cno)
);
