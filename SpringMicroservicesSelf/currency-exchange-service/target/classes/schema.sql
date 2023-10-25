DROP TABLE IF EXISTS exchange_value;
 
CREATE TABLE exchange_value(id integer not null,currency_from VARCHAR(250) NOT NULL,currency_to VARCHAR(250) NOT NULL,conversion_multiple integer,port integer);
