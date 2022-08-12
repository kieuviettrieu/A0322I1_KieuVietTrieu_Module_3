create database chuyen_doi_ERD;

use chuyen_doi_ERD;

create table vat_tu(
id_vtu int not null primary key auto_increment,
ten_vtu varchar(50) not null
);

create table phieu_xuat(
id_phieuxuat int not null primary key auto_increment,
ngayxuat Date not null,
id_vtu int not null ,
sol_xuat int not null,

foreign key (id_vtu) REFERENCES vat_tu(id_vtu)
);

create table phieu_nhap(
id_phieunhap int not null primary key auto_increment,
ngaynhap Date not null,
id_vtu int not null ,
sol_nhap int not null,

foreign key (id_vtu) REFERENCES vat_tu(id_vtu)
);

create table don_dat_hang(
id_donhang int not null primary key auto_increment,
ngay_dathang Date not null,
id_vtu int not null,

foreign key (id_vtu) REFERENCES vat_tu(id_vtu)
);

create table nhacc(
id_nhacc int not null primary key auto_increment,
ten_ncc varchar(50) not null,
diachi varchar(50) not null,
sdt char(10) not null,
id_donhang int not null,

foreign key (id_donhang) REFERENCES don_dat_hang(id_donhang)
);