create table departments(
                            id serial primary key,
                            name varchar(255)
);

create table employee(
                         id serial primary key,
                         name varchar(255),
                         departments_id int references departments(id)
);

insert into departments(name) values ('department1');
insert into departments(name) values ('department2');
insert into departments(name) values ('department3');
insert into departments(name) values ('department4');
insert into employee(name, departments_id) values ('Name1', 1);
insert into employee(name, departments_id) values ('Name2', 1);
insert into employee(name, departments_id) values ('Name3', 1);
insert into employee(name, departments_id) values ('Name4', 2);
insert into employee(name, departments_id) values ('Name5', 2);
insert into employee(name, departments_id) values ('Name6', 3);
insert into employee(name) values ('Name7');

select * from employee e left join departments d on e.departments_id = d.id;
select * from departments d right join employee e on d.id = e.departments_id;

select * from employee e right join departments d on e.departments_id = d.id;
select * from departments d left join employee e on d.id = e.departments_id;

select * from employee e full join departments d on e.departments_id = d.id;

select * from employee cross join departments;

select * from employee e left join departments d on e.departments_id = d.id where d.id is null;

create table teens(
                      id serial primary key,
                      name varchar(255),
                      gender varchar(1)
);

insert into teens(name, gender) values ('Man1', 'M');
insert into teens(name, gender) values ('Man2', 'M');
insert into teens(name, gender) values ('Man3', 'M');
insert into teens(name, gender) values ('Man4', 'M');
insert into teens(name, gender) values ('Man5', 'M');
insert into teens(name, gender) values ('Woman1', 'W');
insert into teens(name, gender) values ('Woman2', 'W');
insert into teens(name, gender) values ('Woman3', 'W');
insert into teens(name, gender) values ('Woman4', 'W');
insert into teens(name, gender) values ('Woman5', 'W');

select t1.name, concat(t1.gender, t2.gender), t2.name from teens t1 cross join teens t2
where t1.gender != t2.gender;