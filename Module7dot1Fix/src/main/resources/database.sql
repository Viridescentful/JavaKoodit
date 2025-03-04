DROP DATABASE IF EXISTS currencyconverter;
CREATE DATABASE currencyconverter;
USE currencyconverter;

CREATE TABLE CURRENCIES (
    code VARCHAR(3) NOT NULL,
    currency_name VARCHAR(50) NOT NULL,
    conversion_rate FLOAT(5,2) NOT NULL,
    PRIMARY KEY (code)
);

INSERT INTO CURRENCIES (code, currency_name, conversion_rate) VALUES
    ('USD', 'US Dollar', 1.0),
    ('EUR', 'Euro', 0.95),
    ('GBP', 'British Pound', 0.78),
    ('INR', 'Indian Rupee', 87.35),
    ('AUD', 'Australian Dollar', 1.60),
    ('CAD', 'Canadian Dollar', 1.44),
    ('SGD', 'Singapore Dollar', 1.34),
    ('CHF', 'Swiss Franc', 0.89),
    ('MYR', 'Malaysian Ringgit', 4.47),
    ('JPY', 'Japanese Yen', 0.007);

UPDATE CURRENCIES SET conversion_rate = 0.94 WHERE code = 'EUR';
UPDATE CURRENCIES SET conversion_rate = 0.78 WHERE code = 'GBP';
UPDATE CURRENCIES SET conversion_rate = 87.22 WHERE code = 'INR';
UPDATE CURRENCIES SET conversion_rate = 1.59 WHERE code = 'AUD';
UPDATE CURRENCIES SET conversion_rate = 1.44 WHERE code = 'CAD';
UPDATE CURRENCIES SET conversion_rate = 1.34 WHERE code = 'SGD';
UPDATE CURRENCIES SET conversion_rate = 0.89 WHERE code = 'CHF';
UPDATE CURRENCIES SET conversion_rate = 4.46 WHERE code = 'MYR';
UPDATE CURRENCIES SET conversion_rate = 149.74 WHERE code = 'JPY';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON currencyconverter.* TO 'appuser'@'localhost';
GRANT SELECT ON currencyconverter.currencies TO 'appuser'@'139.112.64.8';



