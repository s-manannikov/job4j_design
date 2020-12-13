create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Device1', 3000.00);
insert into devices(name, price) values ('Device2', 4900.00);
insert into devices(name, price) values ('Device3', 10000.00);
insert into devices(name, price) values ('Device4', 20500.00);
insert into devices(name, price) values ('Device5', 8000.00);
insert into devices(name, price) values ('Device6', 100000.00);
insert into devices(name, price) values ('Device7', 30000.00);

insert into people(name) values ('Name01');
insert into people(name) values ('Name02');
insert into people(name) values ('Name03');
insert into people(name) values ('Name04');
insert into people(name) values ('Name05');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (3, 2);
insert into devices_people(device_id, people_id) values (4, 3);
insert into devices_people(device_id, people_id) values (5, 3);
insert into devices_people(device_id, people_id) values (6, 4);
insert into devices_people(device_id, people_id) values (7, 5);

select avg(price) from devices;

select p.name, avg(d.price) from people as p join devices_people as dp on dp.people_id = p.id join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from people as p join devices_people as dp on dp.people_id = p.id join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;