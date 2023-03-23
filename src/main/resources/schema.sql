CREATE TABLE IF NOT EXISTS Employee
(
    id      int primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
);

CREATE TABLE IF NOT EXISTS Student
(
    id      int primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
);
CREATE TABLE IF NOT EXISTS Customer
(
    id      int primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
);
CREATE TABLE IF NOT EXISTS Teacher
(
    id      int primary key,
    name    VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
);

