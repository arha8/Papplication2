DROP TABLE IF EXISTS passport;
DROP TABLE IF EXISTS ordered_auto;
DROP TABLE IF EXISTS order_list;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS client;

CREATE TABLE client
(
    client_id SERIAL,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    patronymic varchar(100),
    date_birth date not null,
	PRIMARY KEY (client_id)
);


CREATE TABLE order_list (
    order_id SERIAL,
    client_id integer not null,
    order_name varchar(10) not null,
    order_date date not null,
    PRIMARY KEY (order_id),
    FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE RESTRICT
);


CREATE TABLE passport (
    passport_id SERIAL,
    client_id integer not null,
    seria varchar(10) not null,
    number varchar(10) not null,
    date_issue date not null,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE RESTRICT
);

CREATE TABLE address (
    address_id SERIAL,
    client_id integer not null,
    building varchar(10) not null,
    extension varchar(10),
    apartment varchar(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (client_id) REFERENCES client (client_id) ON DELETE RESTRICT
);

CREATE TABLE ordered_auto (
    ordered_auto_id SERIAL,
    order_id integer not null,
    auto_model varchar(100) not null,
    PRIMARY KEY (ordered_auto_id),
    FOREIGN KEY (order_id) REFERENCES order_list (order_id) ON DELETE RESTRICT
);

INSERT INTO client (first_name, last_name, patronymic, date_birth)
VALUES ('ivan', 'ivanov', 'ivanovich', '1985-05-17');

INSERT INTO order_list (client_id, order_name, order_date)
VALUES (1, '1234ab', '2022-01-17');

INSERT INTO passport (client_id, seria, number, date_issue, issue_department)
VALUES (1, '1234', '5678', '2000-03-22', '90');

INSERT INTO address (client_id, building, extension, apartment)
VALUES (1, '10', '2', '121');

INSERT INTO ordered_auto (order_id, auto_model)
VALUES (1, 'audi');

<!-- v2-->
INSERT INTO client (first_name, last_name, patronymic, date_birth)
VALUES ('vadim', 'safronov', 'ivanovich', '1970-03-22');

INSERT INTO order_list (client_id, order_name, order_date)
VALUES (2, '5678bn', '2022-01-13');

INSERT INTO passport (client_id, seria, number, date_issue, issue_department)
VALUES (2, '5656', '6565', '1996-09-25', '77');

INSERT INTO address (client_id, building, extension, apartment)
VALUES (2, '24', '3', '101');

INSERT INTO ordered_auto (order_id, auto_model)
VALUES (2, 'bmw');





