create database clients;
create table clients(
                        id serial primary key,
                        name text,
                        age integer,
                        contacted boolean,
                        date date
);
insert into clients(name, age, contacted, date) values ('Name1', 11, true, '12/12/2020');
select * from clients;
update clients set age = 12;
update clients set contacted = false;
delete from clients;