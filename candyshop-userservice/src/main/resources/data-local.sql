INSERT INTO USER(ID, USERNAME) VALUES (1, 'Dirk');

INSERT INTO USER_CHANGE_EVENT(ID, USER_ID, TYPE) VALUES (1, 1, 'CREATED');
INSERT INTO USER_CHANGE_EVENT(ID, USER_ID, TYPE) VALUES (2, 1, 'UPDATED');
INSERT INTO USER_CHANGE_EVENT(ID, USER_ID, TYPE) VALUES (3, 1, 'UPDATED');