DELETE FROM user_roles;
DELETE FROM DISH;
delete from VOTE;
delete from RESTAURANT;
DELETE FROM users;

ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 10000;

insert into USERS(name, email, password)
values ('admin','admin@gmail.com','admin'),
       ('user','user@gmail.com','user');

INSERT INTO user_roles (role, user_id)
VALUES ('ADMIN', 10000),
       ('USER',10001);
insert into RESTAURANT(NAME)values ('Ласточка'),('СССР');
insert into VOTE(restaurantid, timeexist, userid) values
('10002','2020-01-30 10:00:00','10000'),
('10002','2020-01-29 10:00:00','10000'),
('10003','2020-01-30 10:00:00','10001'),
('10003','2020-01-29 10:00:00','10001');
INSERT INTO DISH (name, PRICE,RESTAURANTID)
VALUES ('супчик', '500', '10002'),
       ('мяско', '500', '10002'),
('кролик', '500', '10002'),
('рагу', '500', '10002'),
('еда', '500', '10003'),
('пища', '500', '10003'),
('ролы', '500', '10003'),
('суши', '500', '10003');


