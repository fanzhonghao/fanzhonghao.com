/*search score*/
use school_roll;

select distinct student_name,a.course_name as course_name,score_score as score
from opcourse as a inner join score as b inner join student as c
on a.student_id = b.student_id and a.student_id = c.student_id and a.course_name = b.course_name;
/*group by student_name;*/
/*where student_name = "范中豪";*/

select student_name,avg(score_score) as avg_opcourse
from opcourse as a inner join score as b inner join student as c
on a.student_id = b.student_id and a.student_id = c.student_id and a.course_name = b.course_name
group by student_name;

select student_name,avg(score_score) as avg_course
from score as a inner join student as b
on a.student_id = b.student_id
group by student_name;
