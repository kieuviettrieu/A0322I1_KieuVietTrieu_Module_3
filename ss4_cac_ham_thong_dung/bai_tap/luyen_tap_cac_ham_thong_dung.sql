use quanly_sinhvien;

select * from subject 
where Credit >= all (select Credit from subject);

select SubId, SubName, Credit,`Status`, Max(Mark) as Point_ from `subject` 
join mark using(SubId)
group by SubId
having Point_;

select StudentId,StudentName,Address,Phone,`Status`,ClassId, avg(Mark) from student 
join mark using(StudentId)
group by StudentId 
order by avg(Mark) DESC;
