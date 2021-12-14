CREATE DATABASE  IF NOT EXISTS `restaurantappdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurantappdb`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86restaurantappdb_64)
--
-- Host: localhost    Database:
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `edad` varchar(3) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `correoElectronico_UNIQUE` (`correoElectronico`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Simon','Bolivar','CR 10 # 9-15','25','3285679','simon.bolivar@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienteencuesta`
--

DROP TABLE IF EXISTS `clienteencuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienteencuesta` (
  `idCliente` int(11) NOT NULL,
  `idEncuesta` int(11) NOT NULL,
  KEY `idCliente_idx` (`idCliente`),
  KEY `idEncuesta_idx` (`idEncuesta`),
  CONSTRAINT `fk_ClienteEncuesta_Cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_ClienteEncuesta_Encuesta` FOREIGN KEY (`idEncuesta`) REFERENCES `encuesta` (`idEncuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienteencuesta`
--

LOCK TABLES `clienteencuesta` WRITE;
/*!40000 ALTER TABLE `clienteencuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `clienteencuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encuesta` (
  `idEncuesta` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEncuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` VALUES (1,'Percepción Diciembre');
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuestapregunta`
--

DROP TABLE IF EXISTS `encuestapregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encuestapregunta` (
  `idEncuesta` int(11) NOT NULL,
  `idPregunta` int(11) NOT NULL,
  KEY `idEncuesta_idx` (`idEncuesta`),
  KEY `idPregunta_idx` (`idPregunta`),
  CONSTRAINT `fk_EncuestaPregunta_Encuesta` FOREIGN KEY (`idEncuesta`) REFERENCES `encuesta` (`idEncuesta`),
  CONSTRAINT `fk_EncuestaPregunta_Pregunta` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`idPregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuestapregunta`
--

LOCK TABLES `encuestapregunta` WRITE;
/*!40000 ALTER TABLE `encuestapregunta` DISABLE KEYS */;
INSERT INTO `encuestapregunta` VALUES (1,1),(1,2),(1,3),(1,4);
/*!40000 ALTER TABLE `encuestapregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opcion` (
  `idOpcion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idOpcion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
INSERT INTO `opcion` VALUES (1,'Buena'),(2,'Regular'),(3,'Mala'),(4,'Delicioso'),(5,'Moderado'),(6,'Horrible');
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `idPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(500) DEFAULT NULL,
  `idTipoPregunta` int(11) NOT NULL,
  PRIMARY KEY (`idPregunta`),
  KEY `idTipoPregunta_idx` (`idTipoPregunta`),
  CONSTRAINT `fk_Pregunta_TipoPregunta` FOREIGN KEY (`idTipoPregunta`) REFERENCES `tipopregunta` (`idTipoPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'¿Como le parecio la atención brindada por nuestros meseros?',2),(2,'¿Que fue lo que más le gusto o disgusto del servicio?',1),(3,'¿Cual es el nombre del plato que consumio?',1),(4,'¿Como calificaria el sabor del plato degustado?',2);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntaopcion`
--

DROP TABLE IF EXISTS `preguntaopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntaopcion` (
  `idPregunta` int(11) NOT NULL,
  `idOpcion` int(11) NOT NULL,
  KEY `idPregunta_idx` (`idPregunta`),
  KEY `idOpcion_idx` (`idOpcion`),
  CONSTRAINT `fk_PreguntaOpcion_Opcion` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`idOpcion`),
  CONSTRAINT `fk_PreguntaOpcion_Pregunta` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`idPregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntaopcion`
--

LOCK TABLES `preguntaopcion` WRITE;
/*!40000 ALTER TABLE `preguntaopcion` DISABLE KEYS */;
INSERT INTO `preguntaopcion` VALUES (1,1),(1,2),(1,3),(4,4),(4,5),(4,2),(4,6);
/*!40000 ALTER TABLE `preguntaopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `idPregunta` int(11) NOT NULL,
  `comentarios` varchar(500) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idEncuesta` int(11) NOT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `idPregunta_idx` (`idPregunta`),
  KEY `fk_Respuesta_Cliente_idx` (`idCliente`),
  KEY `fk_Respuesta_Encuesta_idx` (`idEncuesta`),
  CONSTRAINT `fk_Respuesta_Cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Respuesta_Encuesta` FOREIGN KEY (`idEncuesta`) REFERENCES `encuesta` (`idEncuesta`),
  CONSTRAINT `fk_Respuesta_Pregunta` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`idPregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestaopcion`
--

DROP TABLE IF EXISTS `respuestaopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestaopcion` (
  `idRespuesta` int(11) NOT NULL,
  `idOpcion` int(11) NOT NULL,
  KEY `idRespuesta_idx` (`idRespuesta`),
  KEY `idOpcion_idx` (`idOpcion`),
  CONSTRAINT `fk_RespuestaOpcion_Opcion` FOREIGN KEY (`idOpcion`) REFERENCES `opcion` (`idOpcion`),
  CONSTRAINT `fk_RespuestaOpcion_Respuesta` FOREIGN KEY (`idRespuesta`) REFERENCES `respuesta` (`idRespuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestaopcion`
--

LOCK TABLES `respuestaopcion` WRITE;
/*!40000 ALTER TABLE `respuestaopcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestaopcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopregunta`
--

DROP TABLE IF EXISTS `tipopregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopregunta` (
  `idTipoPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopregunta`
--

LOCK TABLES `tipopregunta` WRITE;
/*!40000 ALTER TABLE `tipopregunta` DISABLE KEYS */;
INSERT INTO `tipopregunta` VALUES (1,'Abierta'),(2,'Cerrada');
/*!40000 ALTER TABLE `tipopregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'restaurantappdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13 12:08:09
