/*If you are Spring Boot >=2.5.0, You would need to configure this in application.properties spring.jpa.defer-datasource-initialization=true
OR use schema.sql instead of data.sql*/
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10001,'USD','INR',65,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10002,'EUR','INR',75,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10003,'AUD','INR',25,0);