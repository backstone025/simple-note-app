
-- note

insert into note(ID, USERNAME, TYPE, STATE, TITLE, METAINFO, CONTEXT, DATE)
values (10001, 'backstone', 'TEXT', 1, 'TEST 1', '', 'This note is for test', CURRENT_DATE());

insert into note(ID, USERNAME, TYPE, STATE, TITLE, METAINFO, CONTEXT, DATE)
values (10002, 'backstone', 'TEXT', 1, 'TEST 2', '', 'This note is for test', DATEADD('DAY', 1, CURRENT_DATE));

insert into note(ID, USERNAME, TYPE, STATE, TITLE, METAINFO, CONTEXT, DATE)
values (10003, 'backstone', 'TEXT', 1, 'TEST 3', '', 'This note is for test', DATEADD('DAY', 3, CURRENT_DATE));

insert into note(ID, USERNAME, TYPE, STATE, TITLE, METAINFO, CONTEXT, DATE)
values (10004, 'backstone', 'TEXT', 1, 'TEST 4', '', 'This note is for test', DATEADD('DAY', 10, CURRENT_DATE));

insert into note(ID, USERNAME, TYPE, STATE, TITLE, METAINFO, CONTEXT, DATE)
values (10005, 'backstone', 'TEXT', 1, 'TEST 5', '', 'This note is for test', DATEADD('DAY', 5, CURRENT_DATE));

-- category

insert into category(ID, NAME, PARENT_ID)
VALUES (1, 'ROOT', NULL);

insert into category(ID, NAME, PARENT_ID)
VALUES (2, 'node2', 1);

insert into category(ID, NAME, PARENT_ID)
VALUES (3, 'node3', 1);

insert into category(ID, NAME, PARENT_ID)
VALUES (4, 'node4', 2);

insert into category(ID, NAME, PARENT_ID)
VALUES (5, 'node5', 3);

insert into category(ID, NAME, PARENT_ID)
VALUES (6, 'node6', 3);

insert into category(ID, NAME, PARENT_ID)
VALUES (7, 'node7', 3);

insert into category(ID, NAME, PARENT_ID)
VALUES (8, 'node8', 4);

