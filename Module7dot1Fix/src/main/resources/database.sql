DROP DATABASE IF EXISTS currencyconverter;
CREATE DATABASE currencyconverter;
USE currencyconverter;

CREATE TABLE CURRENCIES (
    code VARCHAR(3) NOT NULL,
    currency_name VARCHAR(50) NOT NULL,
    conversion_rate FLOAT(5,2) NOT NULL,
    PRIMARY KEY (code)
);

CREATE TABLE TRANSACTION (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT(10,2) NOT NULL,
    sourceCurrency_code VARCHAR(3) NOT NULL,
    targetCurrency_code VARCHAR(3) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (sourceCurrency_code) REFERENCES CURRENCIES(code),
    FOREIGN KEY (targetCurrency_code) REFERENCES CURRENCIES(code)
);

INSERT INTO CURRENCIES (code, currency_name, conversion_rate) VALUES
    ('USD', 'US Dollar', 1.0),
    ('EUR', 'Euro', 0.94),
    ('GBP', 'British Pound', 0.78),
    ('INR', 'Indian Rupee', 87.22),
    ('AUD', 'Australian Dollar', 1.59),
    ('CAD', 'Canadian Dollar', 1.44),
    ('SGD', 'Singapore Dollar', 1.34),
    ('CHF', 'Swiss Franc', 0.89),
    ('MYR', 'Malaysian Ringgit', 4.46),
    ('JPY', 'Japanese Yen', 149.74);

/*
 UPDATE INTO CURRENCIES (code, currency_name, conversion_rate) VALUES
    ('USD', 'US Dollar', 1.0),
    ('EUR', 'Euro', 0.94),
    ('GBP', 'British Pound', 0.78),
    ('INR', 'Indian Rupee', 87.22),
    ('AUD', 'Australian Dollar', 1.59),
    ('CAD', 'Canadian Dollar', 1.44),
    ('SGD', 'Singapore Dollar', 1.34),
    ('CHF', 'Swiss Franc', 0.89),
    ('MYR', 'Malaysian Ringgit', 4.46),
    ('JPY', 'Japanese Yen', 149.74);

 */

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON currencyconverter.* TO 'appuser'@'localhost';
GRANT SELECT ON currencyconverter.currencies TO 'appuser'@'localhost';
FLUSH PRIVILEGES;



