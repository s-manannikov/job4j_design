insert into "user"("user", role_id) values ('User01', 1);
insert into role(role) values ('Role01');
insert into rules(rules) values ('Rule01');
insert into item(item, user_id, category_id, state_id) values ('Item01', 1, 1, 1);
insert into comments(comments, item_id) values ('Comment01', 1);
insert into attaches(attaches, item_id) values ('Attach01', 1);
insert into state(state) values ('State01');
insert into category(category) values ('Category01');
insert into role_rules(role_id, rules_id) values (1, 1);