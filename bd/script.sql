-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.31 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para blog_samueldb
CREATE DATABASE IF NOT EXISTS `blog_samueldb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blog_samueldb`;

-- Volcando estructura para tabla blog_samueldb.article
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_category_id` int(11) NOT NULL DEFAULT '0',
  `autor_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(75) DEFAULT NULL,
  `text` varchar(300) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `likes` int(11) DEFAULT '0',
  `showable` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FKiu3gnbl8tvk86o04rnm0jr0py` (`article_category_id`),
  KEY `FKabk424yf88wm4j3acw4vp6l1m` (`autor_id`),
  CONSTRAINT `FKabk424yf88wm4j3acw4vp6l1m` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`),
  CONSTRAINT `FKiu3gnbl8tvk86o04rnm0jr0py` FOREIGN KEY (`article_category_id`) REFERENCES `article_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla blog_samueldb.article: ~6 rows (aproximadamente)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `article_category_id`, `autor_id`, `title`, `text`, `date`, `likes`, `showable`) VALUES
	(4, 2, 1, 'Articulo 1', 'Soy un texto invisible', '2017-04-13', 6, 1),
	(5, 1, 1, 'Articulo 2', 'Texto del segundo articulo', '2017-04-13', 5, 0),
	(6, 2, 1, 'Articulo 3', 'Texto del tercer articulo', '2017-04-13', 4, 1),
	(7, 3, 1, 'Articulo 4', 'Mi texto y mi categoria estan modificadas', '2017-04-13', 3, 1),
	(8, 3, 4, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo li', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', '2017-04-14', 0, 1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- Volcando estructura para tabla blog_samueldb.article_category
CREATE TABLE IF NOT EXISTS `article_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla blog_samueldb.article_category: ~3 rows (aproximadamente)
DELETE FROM `article_category`;
/*!40000 ALTER TABLE `article_category` DISABLE KEYS */;
INSERT INTO `article_category` (`id`, `name`) VALUES
	(1, 'deportes'),
	(2, 'noticias'),
	(3, 'tecnologias');
/*!40000 ALTER TABLE `article_category` ENABLE KEYS */;

-- Volcando estructura para tabla blog_samueldb.autor
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla blog_samueldb.autor: ~6 rows (aproximadamente)
DELETE FROM `autor`;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` (`id`, `name`) VALUES
	(1, 'samuel'),
	(2, 'jorge'),
	(3, 'rodrigo'),
	(4, 'daniel'),
	(5, 'alvaro'),
	(6, 'kevin');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;

-- Volcando estructura para tabla blog_samueldb.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(200) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK5yx0uphgjc6ik6hb82kkw501y` (`article_id`),
  CONSTRAINT `FK5yx0uphgjc6ik6hb82kkw501y` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla blog_samueldb.comment: ~6 rows (aproximadamente)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `text`, `date`, `article_id`, `likes`) VALUES
	(13, 'Primer comentario del primer articulo', '2017-04-13', 4, 14),
	(14, 'Segundo comentario del primer articulo', '2017-04-13', 4, 9),
	(15, 'Tercer comentario del primer articulo', '2017-04-13', 4, 2),
	(16, 'Primer comentario del segundo articulo', '2017-04-13', 5, 5),
	(17, 'Segundo comentario del segundo articulo', '2017-04-13', 5, 15),
	(19, 'Soy el cuarto comentario', '2017-04-16', 4, 3);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
