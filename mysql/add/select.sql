use student_sys;
SELECT Sname
FROM Student
WHERE NOT EXISTS
(SELECT *
FROM Course
WHERE NOT EXISTS
(SELECT *
  FROM SC
    WHERE Sno = Student.Sno AND Cno = Course.Cno));
