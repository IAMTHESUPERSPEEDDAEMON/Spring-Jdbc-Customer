-- For MySQL
CREATE DATABASE demo_db;
USE demo_db;

CREATE TABLE IF NOT EXISTS customers
( id BIGINT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    ssn VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );


CREATE USER 'demoUser'@'localhost' IDENTIFIED BY '983hHF()Ifww';
GRANT ALL PRIVILEGES ON demo_db.* TO 'demoUser'@'localhost';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'demoUser'@'localhost';
