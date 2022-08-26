USE QuanLynghiduongFurama;

SELECT * FROM hop_dong_chi_tiet;


-- Cau2
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and CHAR_LENGTH(ho_ten)<=15;

-- cau 3
select * from khach_hang
where (datediff(curdate(),ngay_sinh)/365 between 18 and 50) and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');


-- cau 4
select kh.ma_khach_hang, kh.ho_ten 'Họ Tên', count(kh.ma_khach_hang) 'Số lần đặt phòng' from khach_hang kh
join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
where ten_loai_khach='Diamond'
group by kh.ma_khach_hang
order by count(kh.ma_khach_hang) ;

-- cau 5
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , dv.chi_phi_thue+sum(hdct.so_luong*dvdk.gia) as tong_tien 
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by ma_hop_dong
having tong_tien >0
union
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , dv.chi_phi_thue 'tong_tien'
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
having
hd.ma_hop_dong
 not in (
select hda.ma_hop_dong
from khach_hang kha
left join loai_khach lka on kha.ma_loai_khach=lka.ma_loai_khach
left join hop_dong hda on hda.ma_khach_hang=kha.ma_khach_hang
left join dich_vu dva on dva.ma_dich_vu=hda.ma_dich_vu
left join hop_dong_chi_tiet hdcta on hdcta.ma_hop_dong=hda.ma_hop_dong
left join dich_vu_di_kem dvdka on dvdka.ma_dich_vu_di_kem=hdcta.ma_dich_vu_di_kem
group by hda.ma_hop_dong
having sum(hdcta.so_luong*dvdka.gia) >0);

-- Tạo view cau 5
create view gia_hop_dong_all as
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , dv.chi_phi_thue+sum(hdct.so_luong*dvdk.gia) as tong_tien 
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by ma_hop_dong
having tong_tien >0
union
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc , dv.chi_phi_thue 'tong_tien'
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach=lk.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang=kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu=hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong=hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem=hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
having
hd.ma_hop_dong
 not in (
select hda.ma_hop_dong
from khach_hang kha
left join loai_khach lka on kha.ma_loai_khach=lka.ma_loai_khach
left join hop_dong hda on hda.ma_khach_hang=kha.ma_khach_hang
left join dich_vu dva on dva.ma_dich_vu=hda.ma_dich_vu
left join hop_dong_chi_tiet hdcta on hdcta.ma_hop_dong=hda.ma_hop_dong
left join dich_vu_di_kem dvdka on dvdka.ma_dich_vu_di_kem=hdcta.ma_dich_vu_di_kem
group by hda.ma_hop_dong
having sum(hdcta.so_luong*dvdka.gia) >0);




-- cau 6
select DISTINCT dich_vu.ma_dich_vu , ten_dich_vu, dien_tich, chi_phi_thue,ten_loai_dich_vu
 from dich_vu
join loai_dich_vu using(ma_loai_dich_vu)
where ma_dich_vu not in (select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong)=2021 and month(ngay_lam_hop_dong) between 1 and 3);

-- cau 7
select DISTINCT dv.ma_dich_vu 'ma_dich_vu', ten_dich_vu, dien_tich,
so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu using(ma_loai_dich_vu)
inner join hop_dong  using(ma_dich_vu)
where 
year(ngay_lam_hop_dong)=2020
and
not exists (select * from hop_dong where dv.ma_dich_vu=ma_dich_vu and year(ngay_lam_hop_dong) = 2021);


-- cau 8
-- cach 1
select DISTINCT ho_ten from khach_hang;

-- cach 2
select ho_ten from khach_hang
group by ho_ten;

-- cach 3
select ho_ten from khach_hang
union
select ho_ten from khach_hang;

-- cau 9
select month(ngay_lam_hop_dong) 'thang',count(kh.ma_khach_hang) 'so_khach_dat' from khach_hang kh
join hop_dong hd using(ma_khach_hang)
where year(ngay_lam_hop_dong)=2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- cau 10
select ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, sum(so_luong)'so_luong_dich_vu_di_kem'
from hop_dong
left join hop_dong_chi_tiet using(ma_hop_dong)
group by ma_hop_dong;


-- cau 11
select ma_dich_vu_di_kem ,ten_dich_vu_di_kem, gia, don_vi, trang_thai
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct using(ma_dich_vu_di_kem)
join hop_dong hd using(ma_hop_dong)
join khach_hang kh using(ma_khach_hang)
join loai_khach lk using(ma_loai_khach)
where ten_loai_khach='Diamond' and (dia_chi like '%Vinh%' or dia_chi like '%Quảng Ngãi%');

-- cau 12
select ma_hop_dong,nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, 
ten_dich_vu, sum(so_luong)'so_luong_dich_vu_di_kem', sum(tien_dat_coc) 'tong_tien_coc'
from hop_dong
left join dich_vu using(ma_dich_vu)
left join hop_dong_chi_tiet using(ma_hop_dong)
left join nhan_vien nv using(ma_nhan_vien)
left join khach_hang kh using(ma_khach_hang)
where 
(ngay_lam_hop_dong between '2020-10-01' and '2020-12-30')
and 
(ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30')
group by ma_hop_dong;


-- cau 13
select dvdk.ma_dich_vu_di_kem 'dich_vu_di_kem', ten_dich_vu_di_kem, gia, don_vi, trang_thai, sum(so_luong) 'so_lan_da_dung'
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet using(ma_dich_vu_di_kem)
group by ma_dich_vu_di_kem
having sum(so_luong) 
= 
(select sum(so_luong) from dich_vu_di_kem join hop_dong_chi_tiet using(ma_dich_vu_di_kem)
 group by ma_dich_vu_di_kem order by sum(so_luong) DESC limit 1);
 
--  cau 14
select hd.ma_hop_dong 'ma_hop_dong', ten_loai_dich_vu, ten_dich_vu_di_kem,count(ma_dich_vu_di_kem) 'so_lan_su_dung'
from hop_dong hd
join hop_dong_chi_tiet hdct using(ma_hop_dong)
join dich_vu_di_kem using(ma_dich_vu_di_kem)
join dich_vu using(ma_dich_vu)
join loai_dich_vu using(ma_loai_dich_vu)
group by ma_dich_vu_di_kem
having count(ma_dich_vu_di_kem)=1;

-- cau 15
select nhan_vien.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
from nhan_vien
join trinh_do using(ma_trinh_do)
join bo_phan using(ma_bo_phan)
join hop_dong using(ma_nhan_vien)
where year(ngay_lam_hop_dong) between 2020 and 2021
group by ma_nhan_vien
having count(ma_hop_dong)<=3;

-- cau 16
delete from nhan_vien 
where ma_nhan_vien 
not in (select ma_nhan_vien from (select ma_nhan_vien from nhan_vien join hop_dong using(ma_nhan_vien) where year(ngay_lam_hop_dong) between 2019 and 2021 group by ma_nhan_vien) as temp);

-- cau 17

update khach_hang
set ma_loai_khach=1
where ma_khach_hang in
(select ma_khach_hang from gia_hop_dong_all
where ten_loai_khach='Platinium' and year(ngay_lam_hop_dong)=2021
group by ma_khach_hang
having
sum(tong_tien)>10000000);

-- cau 18
delete from  khach_hang kh
where kh.ma_khach_hang in 
(select hd.ma_khach_hang from hop_dong hd
where year(hd.ngay_ket_thuc)<2021);

-- cau 19
update dich_vu_di_kem
set gia=gia*2
where ma_dich_vu_di_kem in 
(
select ma_dich_vu_di_kem from
(select dvdk.ma_dich_vu_di_kem from hop_dong hd
join hop_dong_chi_tiet hdct using(ma_hop_dong)
join dich_vu_di_kem dvdk using(ma_dich_vu_di_kem)
where year(ngay_lam_hop_dong)=2020
group by ma_dich_vu_di_kem
having sum(so_luong)>10) as ma_ud);

-- cau 20
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union
select ma_khach_hang as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;


-- cau 21
create view v_nhan_vien as
select distinct nv.ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan
from nhan_vien nv
join hop_dong hd using(ma_nhan_vien)
where dia_chi like '%Hải Châu%' and ngay_lam_hop_dong='2019-12-12';


-- cau 22
update nhan_vien
set dia_chi='Liên Chiểu'
where ma_nhan_vien in (select ma_nhan_vien from v_nhan_vien);

-- cau 23
delimiter //
create procedure sp_xoa_khach_hang(IN id int)
BEGIN
	delete from khach_hang
    where ma_khach_hang=id;
END //
delimiter ;

INSERT INTO khach_hang
VALUE(99, 3, 'Nguyễn Thị Hương', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng');

call sp_xoa_khach_hang(99);


-- cau 24
delimiter //
create procedure sp_them_moi_hop_dong
(IN id int,IN ngay_lam_hop_dong datetime,IN ngay_ket_thuc datetime, IN tien_dat_coc double,
IN id_nhan_vien int,IN id_khach_hang int,IN id_dich_vu int)
BEGIN
    if id in (select ma_hop_dong from hop_dong) then 
    SIGNAL sqlstate '45011' set message_text = 'Trung khoa chinh hop dong!';
    end if;
    if id_nhan_vien not in (select ma_nhan_vien from nhan_vien) then 
    SIGNAL sqlstate '45012' set message_text = 'Nhan vien này không tồn tại!';
    end if;
    if id_khach_hang not in (select ma_khach_hang from khach_hang) then 
    SIGNAL sqlstate '45013' set message_text = 'Khách hàng này không tồn tại!';
    end if;
    if id_dich_vu not in (select ma_dich_vu from dich_vu) then 
    SIGNAL sqlstate '45014' set message_text = 'Dịch vụ này không tồn tại';
    end if;
	insert into hop_dong
    values(id, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, id_nhan_vien, id_khach_hang, id_dich_vu);
END //
delimiter ;

call sp_them_moi_hop_dong(16, '2018-04-25', '2018-11-25', 1500000, 2, 2, 1);


-- cau 25
delimiter //
create trigger tr_xoa_hop_dong
after delete on hop_dong
for each row
Begin
    declare number_count int default 0;
    select count(1) into number_count from hop_dong ;
    SIGNAL sqlstate '45001' set message_text=number_count;
End //
delimiter ;


-- cau 26
drop trigger IF EXISTS tr_cap_nhat_hop_dong;

delimiter //
create trigger tr_cap_nhat_hop_dong
before update on hop_dong
for each row
Begin
    if datediff(old.ngay_lam_hop_dong,new.ngay_ket_thuc)<=2
    then SIGNAL sqlstate '45002' set message_text = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    end if;
End //
delimiter ;

-- cau 27
-- cau a

drop function if exists number_tong_tien;

SET GLOBAL log_bin_trust_function_creators = 1;
delimiter //
create function number_tong_tien()
returns int
BEGIN
	declare count int default 0;
    select count(1) into count from
    (select * from hop_dong hd
    join dich_vu dv using(ma_dich_vu)
    group by dv.ma_dich_vu
    having count(hd.ma_hop_dong)*chi_phi_thue >2000000) as tt1;
    return count;
END //
delimiter ;

select number_tong_tien();

-- cau b
delimiter //
create function func_tinh_thoi_gian_hop_dong(id_kh int)
returns int
BEGIN
	declare count_x int default 0;
    select max(thoi_gian) into count_x from
    (select datediff(ngay_ket_thuc,ngay_lam_hop_dong) as thoi_gian
    from hop_dong
    join khach_hang using(ma_khach_hang)
    where id_kh=ma_khach_hang) as ttt3;
    return count_x;
END //
delimiter ;

select func_tinh_thoi_gian_hop_dong(22);

-- cau 28
delimiter //
create procedure sp_xoa_dich_vu_va_hd_room()
BEGIN
    delete from dich_vu 
    where ma_dich_vu in
    (select ma_dich_vu from khach_hang 
    join hop_dong using(ma_khach_hang)
    join dich_vu using(ma_dich_vu)
    where (year(ngay_lam_hop_dong) between 2015 and 2019) and ten_dich_vu like '%Room%');
END //
delimiter ;