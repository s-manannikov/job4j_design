CREATE TABLE company(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'company1');
insert into company(id, name) values (2, 'company2');
insert into company(id, name) values (3, 'company3');
insert into company(id, name) values (4, 'company4');
insert into company(id, name) values (5, 'company5');

insert into person(id, name, company_id) values (1, 'name1', 1);
insert into person(id, name, company_id) values (2, 'name2', 1);
insert into person(id, name, company_id) values (3, 'name3', 2);
insert into person(id, name, company_id) values (4, 'name4', 2);
insert into person(id, name, company_id) values (5, 'name5', 2);
insert into person(id, name, company_id) values (6, 'name6', 3);
insert into person(id, name, company_id) values (7, 'name7', 4);
insert into person(id, name, company_id) values (8, 'name8', 4);
insert into person(id, name, company_id) values (9, 'name9', 5);
insert into person(id, name, company_id) values (10, 'name10', 5);
insert into person(id, name, company_id) values (11, 'name11', 5);
insert into person(id, name, company_id) values (12, 'name12', 5);

select person.name as person, company.name as company
from person join company on person.company_id = company.id 
where company_id != 5 ;

select company.name as company, count (person.name) as people
from company join person on person.company_id = company.id
group by company.name
order by count(person.name) desc
limit 1;