create database demo;

use demo;

create table Products(
Id int not null primary key,
productCode int not null,
productName varchar(50),
productPrice float default 0 ,
productAmount int not null check(productAmount>=0),
productDescription varchar(49),
productStatus bit,
unique(Id,productCode)
);

insert into Products
values(1,1,'May Giat',5000,2,'Lam sach quan ao',1);

insert into Products
values(2,2,'Ban La',3000,3,'Ui quan ao',1);

insert into Products
values(3,3,'May say',500,1,'Say kho toc',1);

insert into Products
values(4,4,'Tu lanh',7500,2,'Lam lanh',1);

insert into Products
values(5,5,'Ti vi',12000,1,'Xem truyen hinh',1);

CREATE UNIQUE INDEX index_code_product ON Products(productCode);

ALTER TABLE Products ADD INDEX index_name_price (productName,productPrice);

explain select * from Products where productCode=4;

alter table Products 
drop index index_code_product;


explain select * from Products where productCode=4;

 -- productCode, productName, productPrice, productStatus từ bảng products.
 
 CREATE VIEW view_information_product AS

SELECT productCode, productName, productPrice, productStatus

FROM Products;

select * from view_information_product;

update view_information_product
set productPrice=13500
where productName='Ti vi';

delete from view_information_product
where productName='May say';


DROP VIEW view_information_product; 



DELIMITER //

CREATE PROCEDURE findAllProduct()

BEGIN

  SELECT * FROM Products;

END //

DELIMITER ;

call findAllProduct();

DELIMITER //

CREATE PROCEDURE addProducts(in Id int,in productCode int,in productName varchar(50),
in productPrice float, in productAmount int,in productDescription varchar(49), in productStatus bit)

BEGIN

  insert into Products
  values(Id,productCode,productName,productPrice,productAmount,productDescription,productStatus);

END //

DELIMITER ;

call addProducts(6,6,'May say sinh to',2500,2,'Lam nuoc ep',1);



DELIMITER //

CREATE PROCEDURE updateProducts(in Id_in int,in productCode_in int,in productName_in varchar(50),
in productPrice_in float, in productAmount_in int,in productDescription_in varchar(49), in productStatus_in bit)

BEGIN

  UPDATE Products
  SET productCode=productCode_in, productName=productName_in, productPrice=productPrice_in, productAmount=productAmount_in, 
  productDescription=productDescription_in, productStatus=productStatus_in
  WHERE Id=Id_in; 
  
END //

DELIMITER ;

call updateProducts(6,6,'May say sinh to',2200,2,'Lam nuoc ep',1);




DELIMITER //

CREATE PROCEDURE deleteProducts(in id_delete int)

BEGIN

    delete from Products
    where Id=id_delete;

END //

DELIMITER ;

call deleteProducts(6);
