create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255),
    body_id int references body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into body(name) values ('body1');
insert into body(name) values ('body2');
insert into body(name) values ('body3');
insert into body(name) values ('body4');

insert into engine(name) values ('engine1');
insert into engine(name) values ('engine2');
insert into engine(name) values ('engine3');
insert into engine(name) values ('engine4');

insert into transmission(name) values ('transmission1');
insert into transmission(name) values ('transmission2');
insert into transmission(name) values ('transmission3');
insert into transmission(name) values ('transmission4');

insert into car(name, body_id, engine_id, transmission_id) values ('car1', 1, 2, 3);
insert into car(name, body_id, engine_id, transmission_id) values ('car2', 3, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car3', 2, 3, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car4', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('car5', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('car6', 3, 3, 3);
insert into car(name, body_id) values ('car7', 1);
insert into car(name, engine_id) values ('car8', 2);
insert into car(name, transmission_id) values ('car9', 3);
insert into car(name) values ('car10');

select * from car
left join body on car.body_id = body.id
left join engine on car.engine_id = engine.id
left join transmission on car.transmission_id = transmission.id;

select body.name from body
left join car on car.body_id = body.id
where car.name is null;

select engine.name from engine
left join car on car.engine_id = engine.id
where car.name is null;

select transmission.name from transmission
left join car on car.transmission_id = transmission.id
where car.name is null;