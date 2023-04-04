-- Volcando estructura de base de datos para demospring
CREATE DATABASE IF NOT EXISTS `demospring` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `demospring`;

-- Volcando estructura para tabla demospring.area
CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demospring.area: ~0 rows (aproximadamente)
DELETE FROM `area`;

-- Volcando estructura para tabla demospring.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `alreadyVoted` int(11) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `baseline` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `creationdate` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `firstlogin` int(11) DEFAULT NULL,
  `hash` varchar(255) DEFAULT NULL,
  `iban` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  `idoffice` int(11) DEFAULT NULL,
  `idprovince` int(11) DEFAULT NULL,
  `idrol` int(11) DEFAULT NULL,
  `idschedule` int(11) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `leavingdate` date DEFAULT NULL,
  `loginretries` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nip` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `passreset` varchar(255) DEFAULT NULL,
  `passresetdate` datetime(6) DEFAULT NULL,
  `rgpd` varchar(255) DEFAULT NULL,
  `ssnumber` varchar(255) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `vacationLimit` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `already_voted` int(11) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `vacation_limit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demospring.employees: ~0 rows (aproximadamente)
DELETE FROM `employees`;

-- Volcando estructura para tabla demospring.permissions
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;



-- Volcando estructura para tabla demospring.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;



-- Volcando estructura para tabla demospring.role_permissions
CREATE TABLE IF NOT EXISTS `role_permissions` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FKegdk29eiy7mdtefy5c7eirr6e` (`permission_id`),
  KEY `FKn5fotdgk8d1xvo8nav9uv3muc` (`role_id`),
  CONSTRAINT `FKegdk29eiy7mdtefy5c7eirr6e` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
  CONSTRAINT `FKn5fotdgk8d1xvo8nav9uv3muc` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- Volcando estructura para tabla demospring.seq_m_asociaciones
CREATE TABLE IF NOT EXISTS `seq_m_asociaciones` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demospring.seq_m_asociaciones: ~1 rows (aproximadamente)
DELETE FROM `seq_m_asociaciones`;
INSERT INTO `seq_m_asociaciones` (`next_val`) VALUES
	(1);

-- Volcando estructura para tabla demospring.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;


-- Volcando estructura para tabla demospring.user_roles

CREATE TABLE IF NOT EXISTS `user_roles` (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  KEY pk_user_id (user_id),
  KEY pk_role_id (role_id),
  CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

