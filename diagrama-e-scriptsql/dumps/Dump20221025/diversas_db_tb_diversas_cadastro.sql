CREATE DATABASE  IF NOT EXISTS `diversas_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `diversas_db`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: diversas_db
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `tb_diversas_cadastro`
--

DROP TABLE IF EXISTS `tb_diversas_cadastro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_diversas_cadastro` (
  `id` bigint NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(170) NOT NULL,
  `nome` varchar(130) NOT NULL,
  `senha` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_errnixbsb96g7ikym926khtxo` (`cpf`),
  UNIQUE KEY `UK_s1pi3t759oqwhfurx3cxswkul` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_diversas_cadastro`
--

LOCK TABLES `tb_diversas_cadastro` WRITE;
/*!40000 ALTER TABLE `tb_diversas_cadastro` DISABLE KEYS */;
INSERT INTO `tb_diversas_cadastro` VALUES (6,'12345678945','lucasuanderson159@live.com','LUCAS UANDERSON FERREIRA DA SILVA','000000,000000'),(7,'1234456777','lougg@gmail.com','teste2','000000,000000'),(9,'888888','teste4@gmail.com','LUCAS UANDERSON FERREIRA DA SILVA','888888,888888'),(14,'999999','teste5@gmail.com','UANDERSON FERREIRA DA SILVA','888888,888888');
/*!40000 ALTER TABLE `tb_diversas_cadastro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-25 13:27:00
