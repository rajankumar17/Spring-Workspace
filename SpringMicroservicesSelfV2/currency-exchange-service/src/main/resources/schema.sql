/*If you are Spring Boot >=2.5.0, You would need to configure this in application.properties spring.jpa.defer-datasource-initialization=true
OR use schema.sql instead of data.sql*/

DROP TABLE IF EXISTS exchange_value;
 
CREATE TABLE exchange_value(id integer not null,currency_from VARCHAR(250) NOT NULL,currency_to VARCHAR(250) NOT NULL,conversion_multiple integer,port integer);
