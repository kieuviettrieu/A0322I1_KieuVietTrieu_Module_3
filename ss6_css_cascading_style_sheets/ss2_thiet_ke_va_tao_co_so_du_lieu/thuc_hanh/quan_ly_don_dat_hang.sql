create database quan_ly_don_dat_hang;

use quan_ly_don_dat_hang;

create table don_vi_DH(
ID int not null auto_increment primary key,
Ten_don_vi varchar(50),
Dia_chi varchar(50),
Dien_thoai char(10) not null
);

create table nguoi_dat(
ID int not null auto_increment primary key,
Ten_nguoi varchar(50) not null
);

create table nguoi_giao(
ID int not null auto_increment primary key,
Ten_nguoi varchar(50) not null
);

create table noi_giao_DH(
ID int not null auto_increment primary key,
Ten_noi varchar(50) not null
);

create table don_dat_hang(
ID int not null auto_increment primary key,
ID_don_vi int not null,
Ngay_dat Date,
Ten_hang varchar(50),
Mo_ta varchar(50),
Don_gia Double,
So_luong int not null,
id_nguoi_dat int not null,

FOREIGN KEY (id_nguoi_dat) REFERENCES nguoi_dat(ID)
);

create table phieu_giao_hang(
ID int not null primary key,
id_don_vi int not null,
id_noi_giao int not null,
Ngay_giao Date not null,
Ten_hang varchar(50),
Don_vi_tinh varchar(10),
So_luong int not null,
Don_gia Double,
Thanh_tien Double,
Nguoi_nhan varchar(50),
Nguoi_giao varchar(50),

FOREIGN KEY (ID) REFERENCES don_dat_hang(ID)
);