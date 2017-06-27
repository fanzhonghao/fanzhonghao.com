use school_roll;

select student_id,student_name
from student
where(
  select sum(course_score) > 10
  from course
  where course_name in (
    select course_name
    from score
    where student.student_id =  score.student_id and score_score < 60
  )
)
