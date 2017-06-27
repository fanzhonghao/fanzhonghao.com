/*search teachers*/
use school_roll;
select distinct student_name,teacher_name
from student as a inner join teacher as b
on a.class_id = b.class_id ;

select distinct student_name,teacher_name
from student as a inner join opcourse as b inner join teacher as c
on a.student_id = b.student_id and b.course_name = c.course_name;

select distinct student_name,teacher_name
from student as a inner join teacher as b
on a.class_id = b.class_id
where student_name = "范中豪";

select distinct student_name,teacher_name
from student as a inner join opcourse as b inner join teacher as c
on a.student_id = b.student_id and b.course_name = c.course_name
where student_name = "范中豪";
