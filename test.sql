-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idorigen` int(11) NOT NULL,
  `iddestino` int(11) NOT NULL,
  `texto` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguidor`
--

DROP TABLE IF EXISTS `seguidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seguidor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `idseguidor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguidor`
--

LOCK TABLES `seguidor` WRITE;
/*!40000 ALTER TABLE `seguidor` DISABLE KEYS */;
INSERT INTO `seguidor` VALUES (1,43,51),(11,43,65),(12,43,55),(22,43,60),(23,43,56),(24,43,69),(25,43,52),(26,43,73),(27,73,43),(28,51,43),(29,74,43),(30,43,53),(31,74,55),(32,43,63),(33,43,58),(34,74,60);
/*!40000 ALTER TABLE `seguidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nacimiento` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (43,'2014-11-07 00:00:00','kaluli@gmail.com','karina','pangaro','kaluli32','kaluli'),(51,'2014-01-12 00:00:00','kalu@hotmail.com','juan','gonzalez','kaluli32','kaluli2'),(52,'2014-01-12 00:00:00','kalu@hotmail.com','lucas','garcia','kaluli32','kaluli343'),(53,'2014-01-12 00:00:00','kalu@hotmail.com','mariel','martinez','kaluli32','kalu'),(54,'2014-01-12 00:00:00','kalu@hotmail.com','maria','pangaro','kaluli32','kalulisd'),(55,'2014-01-12 00:00:00','kalu@hotmail.com','benja','vicuña','benja','benjamin'),(56,'2014-01-12 00:00:00','kalu@hotmail.com','juana','viale','kaluli32','kalulis'),(57,'2014-01-10 00:00:00','kalu@hotmail.com','ramon','valdez','kaluli32','kaluliss'),(58,'2014-01-12 00:00:00','kalu@hotmail.com','susana','gimenez','kaluli32','kalulia'),(59,'2014-01-12 00:00:00','ad@asd.com','maria','simon','kaluli32','sasddas'),(60,'2014-01-12 00:00:00','ad@asd.com','laura','novoa','kaluli32','asdasdkaluli'),(61,'2014-01-12 00:00:00','ad@asd.com','ricardo','gutierrez','kaluli32','kaaa'),(62,'2014-01-12 00:00:00','ad@asd.com','renzo','maidana','kaluli32','dddddd'),(63,'2014-01-12 00:00:00','ad@asd.com','silvio','rodriguez','kaluli32','kaluliasdsad'),(64,'2014-04-07 00:00:00','kaluil@gmail.com','karina','pangaro','kaluli','kalalal'),(65,'2014-01-12 00:00:00','kalu@sd.com','andrea','rincon','kalu','sadadasd'),(66,'2014-01-10 00:00:00','ad@asd.com','karina','pangaro','kaluli','blabla'),(67,'2014-01-12 00:00:00','asd@asd.com','kalu','kalu','kalu','blabla2'),(68,'2014-01-12 00:00:00','ad@asd.com','kalu','pang','1234','kalulias'),(69,'2014-01-12 00:00:00','ad@asd.com','lucas','biglia','kalu','lucas'),(73,'2014-12-01 00:00:00','ad@asd.com','kalu','kalu','prueba','prueba'),(74,'2014-10-01 00:00:00','kalu@asd.com','karina','pangaro','test','test');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-04  9:26:52
