INSERT INTO chat.user (login, password) VALUES ('John', '123');
INSERT INTO chat.user (login, password) VALUES ('Jim', '12345');
INSERT INTO chat.user (login, password) VALUES ('Alex', '1234567');
INSERT INTO chat.user (login, password) VALUES ('Olivia', 'qwe');
INSERT INTO chat.user (login, password) VALUES ('Ashley', 'qwerty');
INSERT INTO chat.user (login, password) VALUES ('Kate', 'qwetyuiop');

INSERT INTO chat.room (chat_name, chat_owner) VALUES ('general', 1);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('random', 2);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('moscow_adm', 3);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('msk_report', 4);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('msk_services', 5);
INSERT INTO chat.room (chat_name, chat_owner) VALUES ('piscine_java', 6);

INSERT INTO chat.message (room_id, sender, message, time) VALUES (1, 6, 'Hello', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));
INSERT INTO chat.message (room_id, sender, message, time) VALUES (2, 5, 'World', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));
INSERT INTO chat.message (room_id, sender, message, time) VALUES (3, 4, 'ttt', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));
INSERT INTO chat.message (room_id, sender, message, time) VALUES (4, 3, '123', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));
INSERT INTO chat.message (room_id, sender, message, time) VALUES (5, 2, 'Java Piscine', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));
INSERT INTO chat.message (room_id, sender, message, time) VALUES (6, 1, 'HELP!', to_timestamp('05 Dec 2000', 'DD Mon YYYY'));