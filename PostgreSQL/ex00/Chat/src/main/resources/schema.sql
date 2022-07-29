CREATE SCHEMA IF NOT EXISTS chat;

DROP TABLE IF EXISTS chat.user, chat.room, chat.message;

CREATE TABLE IF NOT EXISTS chat.user (
     id SERIAL PRIMARY KEY ,
     login TEXT NOT NULL ,
     password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.room (
     id SERIAL PRIMARY KEY ,
     chat_name TEXT NOT NULL ,
     chat_owner INT NOT NULL REFERENCES chat.user(id)
    );

CREATE TABLE IF NOT EXISTS chat.message (
    id SERIAL PRIMARY KEY ,
    room_id INT NOT NULL REFERENCES chat.room(id) ,
    sender INT NOT NULL REFERENCES chat.user(id) ,
    message TEXT NOT NULL ,
    time TIMESTAMP
    );