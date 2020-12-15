create table type(
                     id serial primary key,
                     name varchar(255)
);

create table product(
                        id serial primary key,
                        name varchar(255),
                        type_id int references type(id),
                        expired_date date,
                        price float
);

insert into type(name) values ('cheese');
insert into type(name) values ('milk');
insert into type(name) values ('bread');
insert into product(name, type_id, expired_date, price) values ('cheese01', 1, '20-Dec-2021', 500.00);
insert into product(name, type_id, expired_date, price) values ('cheese02', 1, '10-Jan-2022', 650.00);
insert into product(name, type_id, expired_date, price) values ('cheese03', 1, '11-Nov-2021', 300.00);
insert into product(name, type_id, expired_date, price) values ('milk01', 2, '12-Dec-2020', 100.00);
insert into product(name, type_id, expired_date, price) values ('bread01', 3, '20-Dec-2020', 50.00);
insert into product(name, type_id, expired_date, price) values ('ice-cream01', 2, '1-Jan-2021', 200.00);

select product.name, type.name
from type join product on product.type_id = type.id
where type.name = 'cheese';

select name
from product
where name like 'ice-cream%';

select name
from product
where date_trunc ('month', expired_date) = date_trunc ('month', current_date + interval '1 month');

select name, price from product
order by price desc
limit 1;

select type.name, count (product.name)
from product join type on product.type_id = type.id
group by type.name;

select product.name as products, type.name as types
from product join type on product.type_id = type.id
where type.name = 'cheese' OR type.name = 'milk';

select type.name, count (product.name)
from product join type on product.type_id = type.id
group by type.name
having count (product.name) < 10;

select product.name as products, type.name as type
from product join type on product.type_id = type.id;
