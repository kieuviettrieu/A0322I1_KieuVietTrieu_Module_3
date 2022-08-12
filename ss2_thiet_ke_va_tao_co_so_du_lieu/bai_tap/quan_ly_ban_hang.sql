create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
id_c int not null primary key auto_increment,
name_c varchar(50) not null,
age_c int not null
);

create table product(
id_p int not null primary key auto_increment,
name_p varchar(50) not null,
price_p float default 0 
);

create table oder(
id_o int not null primary key auto_increment,
id_c int not null,
date_o date  not null,
total_price_o double,
constraint khoa_idc foreign key (id_c) references customer(id_c)
);

create table oder_detail(
id_o int not null,
id_p int not null,
odQTY int not null,

constraint khoa_idp foreign key (id_p) references product(id_p),
constraint khoa_ido foreign key (id_o) references oder(id_o)
);




