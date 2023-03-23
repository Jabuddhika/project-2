CREATE TABLE IF NOT EXISTS Employee
(
    id      VARCHAR(20) primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Student
(
    id      VARCHAR(20) primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );
CREATE TABLE IF NOT EXISTS Customer
(
    id      VARCHAR(20) primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );
CREATE TABLE IF NOT EXISTS Teacher
(
    id      VARCHAR(20) primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );