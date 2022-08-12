use quan_ly_ban_hang;

insert into customer 
values(1,'Minh Quan',10), (2,'Ngoc Oanh',20),(3,'Hong Ha',50);

insert into product
values(1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);

insert into oder 
values(1,1,'2006-03-21',null),(2,2,'2006-03-23',null),(3,1,'2006-03-16',null);

insert into oder_detail
values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

SELECT id_o,id_c,date_o FROM oder;

select distinct cus.name_c 'Name customer' from customer cus
inner join oder od on cus.id_c=od.id_c;

select distinct name_p 'Name product' from product p
inner join oder_detail o on p.id_p=o.id_p;

-- cách 1
select * from customer where id_c not in (select id_c from oder);
-- cách 2
select name_c from customer left join oder using (id_c) where id_o is null;


-- select * from oder join oder_detail using(id_o) join product using(id_p);

-- select * from oder join oder_detail using(id_o) join product using(id_p)
-- group by id_o;

select id_o, date_o, sum(odQTY * price_p) 'total' from oder join oder_detail using(id_o) join product using(id_p)
group by id_o;
