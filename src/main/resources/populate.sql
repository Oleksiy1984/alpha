-- Passport
INSERT INTO `rental`.`passport` (`pasport_number`, `series`, `issue`) VALUES
(195195, 'KE','1984-10-1');
INSERT INTO `rental`.`passport` (`pasport_number`, `series`, `issue`) VALUES
(961150, 'KH','1994-12-20');

-- Clients
INSERT INTO `rental`.`clients`
(`password`, `client_name`, `passport_id`, `address`, `mobile`)
VALUES ('abc','Alex B.', 195195, 'Poltava', '066554455');
INSERT INTO `rental`.`clients`
(`password`, `client_name`, `passport_id`, `address`, `mobile`)
VALUES ('123','John D.', 961150, 'London', '0991574551');

-- Brands
INSERT INTO `rental`.`car_brands`
(`brand`) VALUES ('BMW');
INSERT INTO `rental`.`car_brands`
(`brand`) VALUES ('TOYOTA');
INSERT INTO `rental`.`car_brands`
(`brand`) VALUES ('AUDI');
INSERT INTO `rental`.`car_brands`
(`brand`) VALUES ('Opel');
INSERT INTO `rental`.`car_brands`
(`brand`) VALUES ('Mazda');

-- Cars
INSERT INTO `rental`.`cars`
(`brand_id`, `car_type`, `color`, `price`)
VALUES(1, 'Standard', 'red', 150.55);
INSERT INTO `rental`.`cars`
(`brand_id`, `car_type`, `color`, `price`)
VALUES(2, 'Van', 'white', 250.55);
INSERT INTO `rental`.`cars`
(`brand_id`, `car_type`, `color`, `price`)
VALUES(1, 'Standard', 'blue', 650.55);
INSERT INTO `rental`.`cars`
(`brand_id`, `car_type`, `color`, `price`)
VALUES(2, 'Van', 'black', 50.55);
--