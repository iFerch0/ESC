-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.28 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para control_equipos
CREATE DATABASE IF NOT EXISTS `control_equipos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `control_equipos`;

-- Volcando estructura para tabla control_equipos.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `RUT` varchar(50) NOT NULL,
  `Nombres` varchar(150) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Ciudad` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`RUT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.clientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`RUT`, `Nombres`, `Departamento`, `Ciudad`, `Direccion`, `Telefono`) VALUES
	('1067938445', 'FERNANDO RHENALS', 'CORDOBA', 'MONTERIA', 'LA GRANJA', '3008474121');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `em_Nombres` varchar(200) NOT NULL DEFAULT '0',
  `em_Telefono` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.empleado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`idEmpleado`, `em_Nombres`, `em_Telefono`) VALUES
	(1, 'kljhlk', '15645');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `tipo` varchar(50) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `observaciones` varchar(1000) DEFAULT NULL,
  `cli_rut` varchar(150) NOT NULL,
  PRIMARY KEY (`sn`,`cli_rut`) USING BTREE,
  KEY `FK_cli_rut` (`cli_rut`),
  CONSTRAINT `FK_cli_rut` FOREIGN KEY (`cli_rut`) REFERENCES `clientes` (`RUT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.equipos: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` (`tipo`, `marca`, `modelo`, `sn`, `observaciones`, `cli_rut`) VALUES
	('COMPUTADOR PORTÃTIL', 'LLL', 'LL', 'LLL', '	LLLL', '1067938445');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.facturacion
CREATE TABLE IF NOT EXISTS `facturacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cl_RUT` varchar(50) NOT NULL,
  `eq_Serial` varchar(50) NOT NULL,
  `em_Nombres` varchar(50) DEFAULT NULL,
  `Fecha_Ingreso` varchar(50) DEFAULT NULL,
  `txtFecha_Salida` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`cl_RUT`,`eq_Serial`),
  KEY `FK_facturacion_clientes` (`cl_RUT`),
  KEY `FK_facturacion_equipos` (`eq_Serial`),
  CONSTRAINT `FK_facturacion_clientes` FOREIGN KEY (`cl_RUT`) REFERENCES `clientes` (`RUT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_facturacion_equipos` FOREIGN KEY (`eq_Serial`) REFERENCES `equipos` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.facturacion: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `facturacion` DISABLE KEYS */;
INSERT INTO `facturacion` (`id`, `cl_RUT`, `eq_Serial`, `em_Nombres`, `Fecha_Ingreso`, `txtFecha_Salida`) VALUES
	(2, '1067938445', 'LLL', 'kljhlk', '02/12/2017', '  /  /    ');
/*!40000 ALTER TABLE `facturacion` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.login
CREATE TABLE IF NOT EXISTS `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL DEFAULT '0',
  `contraseña` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.login: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`id`, `usuario`, `contraseña`) VALUES
	(1, 'admin', 'admin'),
	(2, 'user', 'user');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.test
CREATE TABLE IF NOT EXISTS `test` (
  `cm_codigo` int NOT NULL AUTO_INCREMENT,
  `cm_nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cm_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.test: ~30 rows (aproximadamente)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`cm_codigo`, `cm_nombre`) VALUES
	(5, 'Establishing Connection ...'),
	(6, 'Establishing Connection ...'),
	(7, 'Establishing Connection ...'),
	(8, 'Establishing Connection ...'),
	(9, 'Establishing Connection ...'),
	(10, 'Established Connection ...'),
	(17, 'Established Connection ...'),
	(18, 'Established Connection ...'),
	(19, 'Established Connection ...'),
	(20, 'Loading Driver ...'),
	(21, 'Loading Driver ...'),
	(22, 'Loading Driver ...'),
	(23, 'Loading Classes ...'),
	(24, 'Loading Classes ...'),
	(25, 'Loading Classes ...'),
	(26, 'Loading User Interface ...'),
	(27, 'Loading User Interface ...'),
	(28, 'Loading User Interface ...'),
	(29, 'Starting... Please Wait...'),
	(30, 'Starting... Please Wait...'),
	(31, 'Starting... Please Wait...'),
	(32, 'Starting... Please Wait...'),
	(33, 'Starting... Please Wait...'),
	(34, 'Starting... Please Wait...'),
	(35, 'Starting... Please Wait...'),
	(36, 'Starting... Please Wait...'),
	(37, 'Starting... Please Wait...'),
	(38, 'Starting... Please Wait...'),
	(39, 'Starting... Please Wait...'),
	(40, 'Starting... Please Wait...');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;

-- Volcando estructura para tabla control_equipos.tipo_equipo
CREATE TABLE IF NOT EXISTS `tipo_equipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Volcando datos para la tabla control_equipos.tipo_equipo: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_equipo` DISABLE KEYS */;
INSERT INTO `tipo_equipo` (`id`, `tipo`) VALUES
	(1, 'COMPUTADOR PORTÃTIL'),
	(2, 'COMPUTADOR ESCRITORIO'),
	(3, 'TABLET'),
	(4, 'CELULAR / SMARTPHONE'),
	(5, 'CPU / TORRE'),
	(6, 'PANTALLA / MONITOR'),
	(7, 'UPS'),
	(8, 'ESTABILIZADOR'),
	(9, 'IMPRESORA'),
	(10, 'FOTOCOPIADORA'),
	(11, 'OTRO');
/*!40000 ALTER TABLE `tipo_equipo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
