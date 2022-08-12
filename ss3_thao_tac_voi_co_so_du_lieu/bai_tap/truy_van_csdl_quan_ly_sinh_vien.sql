use quanly_sinhvien;

select * from student where StudentName like 'h%';

select * from class where month(StartDate)=12;

select * from `subject` where Credit between 3 and 5;

update student 
set ClassId=2
where StudentName='Hung';

-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

 select StudentName, SubName, Mark from student stu
 inner join Mark mar on stu.StudentId=mar.StudentId
 inner join `Subject` sub on sub.SubId=mar.SubId
 order by mar.Mark desc, stu.StudentName asc;
 
 
 