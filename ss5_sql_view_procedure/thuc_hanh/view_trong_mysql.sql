use classicmodels;

CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;

select * from customer_views;

