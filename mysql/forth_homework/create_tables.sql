use school_roll;
create table domain(/*专业*/
  domain_name char(30) not null primary key,/*专业名*/
  domain_department char(30) not null  /*专业所属系*/
);
create table class(/*班级*/
  class_id numeric(20) not null primary key,
  domain_name char(30) not null, /*专业*/
  foreign key (domain_name) references domain(domain_name)
);
create table student(
  student_id numeric(11) not null primary key,/*学号*/
  student_name char(20) not null,/*名字*/
  class_id numeric(20) not null,/*班级*/
  student_sex char(10) not null check (student_sex = "男" or student_sex = "女"), /*性别*/
  student_status char(10) not null,/*是否开除 在校或开除*/
  student_enter_time numeric(4) not null,/*入学年份*/
  foreign key (class_id) references class(class_id)
);
create table course(/*全部课程*/
  course_name char(20) not null primary key,
  course_score numeric(5) not null check (course_score > 0),/*课程学分*/
  course_kind char(10) not null,/*必修，选修，限选*/
  course_grade char(10) not null, /*课程所属年级*/
  check (course_grade = "大一" or course_grade = "大二" or course_grade = "大三" or course_grade = "大四"),
  check (course_kind = "必修" or course_kind = "任选" or course_kind = "限选")
);
create table teacher(
  teacher_id numeric(20) not null,
  teacher_name char(20) not null,
  course_name char(20) not null,/*所教课程*/
  class_id numeric(20) not null,/*所教班级*/
  domain_name char(30) not null,/*教师所属系*/
  primary key (course_name,class_id),
  foreign key (course_name) references course(course_name),
  foreign key (domain_name) references domain(domain_name),
  foreign key (class_id) references class(class_id)
);

create table opcourse(/*学生选的选修课*/
  student_id numeric(11) not null,
  course_name char(20) not null,
  primary key(student_id,course_name),
  foreign key (student_id) references student(student_id),
  foreign key (course_name) references course(course_name)
);
create table techprogram(/*教学计划*/
  mucourse_score numeric(10) not null check(mucourse_score > 0),/*必修分*/
  opcourse_score numeric(10) not null check(opcourse_score > 0),/*任选分*/
  licourse_score numeric(10) not null check(licourse_score > 0),/*限选分*/
  grade char(10) not null,/*年级*/
  domain_name char(30) not null,
  primary key (grade,domain_name),
  foreign key (domain_name) references domain(domain_name),
  check (grade = "大一" or grade = "大二" or grade = "大三" or grade = "大四")
);
create table score(
  student_id numeric(11) not null,
  course_name char(20) not null,
  score_score numeric(10) not null check(score_score > 0),
  make_up numeric(1) not null check(make_up = 0 or make_up = 1),/*补考次数*/
  primary key (student_id,course_name),
  foreign key (student_id) references student(student_id),
  foreign key (course_name) references course(course_name)
);
show tables;
