select * from currencyconverter.currencies;

select * from currencyconverter.currencies where currency_code = 'EUR';

select COUNT(*) from currencyconverter.currencies;

select * from currencyconverter.currencies where conversion_rate = (SELECT MAX(conversion_rate) FROM currencyconverter.currencies);

