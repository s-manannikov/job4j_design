create table "user"(
    id serial primary key,
    "user" varchar(255),
    role_id int references role(id)
);
create table role(
    id serial primary key,
    role varchar(255)
);
create table rules(
    id serial primary key,
    rules varchar(255)
);
create table item(
    id serial primary key,
    item varchar(255),
    user_id int references "user"(id),
    category_id int references category(id),
    state_id int references state(id)
);
create table comments(
    id serial primary key,
    comments varchar(255),
    item_id int references item(id)
);
create table attaches(
    id serial primary key,
    attaches varchar(255),
    item_id int references item(id)
);
create table state(
    id serial primary key,
    state varchar(255)
);
create table category(
    id serial primary key,
    category varchar(255)
);
create table role_rules(
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);