-- 1
CREATE TABLE `passport` (
  `pasport_number` int(11) NOT NULL,
  `series` varchar(45) NOT NULL,
  `issue` date NOT NULL,
  PRIMARY KEY (`pasport_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) NOT NULL,
  `gender` enum('MALE','FEMALE') DEFAULT NULL,
  `role` enum('ADMIN','MANAGER','CLIENT') NOT NULL,
  `blocked` tinyint(1) DEFAULT '0',
  `passport` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `passport_id_idx` (`passport`),
  CONSTRAINT `passport` FOREIGN KEY (`passport`) REFERENCES `passport` (`pasport_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- 3
CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) NOT NULL,
  `car_type` enum('Economy','Compact','Standard','Premium','Minivan','SportCar','Van') NOT NULL,
  `color` varchar(45) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '0',
  `photo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_id_idx` (`brand_id`),
  CONSTRAINT `brand_id` FOREIGN KEY (`brand_id`) REFERENCES `car_brands` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 4
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_contract` int(11) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_contract_idx` (`id_contract`),
  CONSTRAINT `id_contract` FOREIGN KEY (`id_contract`) REFERENCES `contracts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 5
CREATE TABLE `contracts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_contract` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  `client_id` int(11) NOT NULL,
  `driver` tinyint(1) NOT NULL DEFAULT '0',
  `approved` tinyint(1) NOT NULL DEFAULT '0',
  `reason` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id_idx` (`client_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 6
CREATE TABLE `accidents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `loss` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contract_id_idx` (`contract_id`),
  CONSTRAINT `contract_id` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 7
CREATE TABLE `car_brands` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_UNIQUE` (`brand`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


