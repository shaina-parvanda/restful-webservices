create database onlineshopping;
use onlineshopping;
create table products(PRODUCT_ID int primary key auto_increment not null,
PRODUCT_NAME varchar(30) not null,
CATEGORY varchar(30) not null,
PRICE double ,
STOCK_NUMBER int ,
REMARKS varchar(120));
insert into products(PRODUCT_NAME, CATEGORY , PRICE ,STOCK_NUMBER ,REMARKS) values("Denim Dress","Dress",2000,20,"Material:Polyster");
insert into products(PRODUCT_NAME, CATEGORY , PRICE ,STOCK_NUMBER ,REMARKS) values("Shoes","Shoes",5000,25,"Material:Leather");


