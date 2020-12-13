create table club(
                     id serial primary key,
                     name varchar(255),
                     played date
);
create table player(
                       id serial primary key,
                       name varchar(255),
                       points integer,
                       club_id int references club(id)
);
insert into club(name, played) values ('Club01', '10.10.2020');
insert into club(name, played) values ('Club02', '10.10.2020');
insert into club(name, played) values ('Club03', '11.11.2020');
insert into club(name, played) values ('Club04', '20.11.2020');
insert into player(name, points, club_id) values ('Player1', 10, 1);
insert into player(name, points, club_id) values ('Player2', 15, 1);
insert into player(name, points, club_id) values ('Player3', 22, 1);
insert into player(name, points, club_id) values ('Player4', 25, 2);
insert into player(name, points, club_id) values ('Player5', 20, 2);
insert into player(name, points, club_id) values ('Player6', 11, 3);
insert into player(name, club_id) values ('Player7', 4);
insert into player(name) values ('Player8');
select p.name as player, c.name as club from player as p join club as c on p.club_id = c.id;
select p.name, c.played from player as p join club as c on p.club_id = c.id;
select p.name, p.points, c.name from player as p join club as c on p.club_id = c.id;