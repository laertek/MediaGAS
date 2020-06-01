-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: db_gas
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_posto`
--

DROP TABLE IF EXISTS `tb_posto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_posto` (
  `idposto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `cep` int(11) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  PRIMARY KEY (`idposto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_posto`
--

LOCK TABLES `tb_posto` WRITE;
/*!40000 ALTER TABLE `tb_posto` DISABLE KEYS */;
INSERT INTO `tb_posto` VALUES (1,'SEM CADASTRO','',NULL,0,0,'','','',0,0),(2,'Posto Angeloni',NULL,NULL,2,0,NULL,NULL,NULL,0,0),(3,'Posto Apolo','',' ',0,0,'','','',0,0),(4,'Posto Maracaja','',' ',0,0,'','','',0,0),(5,'Rede SIM','',' ',0,0,'','Itajai','',0,0),(6,'Posto Teste com Bairro','Bairro',' ',123,89046100,'479999999','Blumenau','Santa Catarina',12,12),(7,'Posto Zandoná','BR-101','',0,88385000,'47991448628','Penha','Santa Catarina',0,0),(8,'Posto Mantra Contorno','Rua Eurico Julio Bettega','Cidade Industrial',99,81290040,'4133731001','Curitiba','Paraná',0,0),(9,'Auto Posto Texano Shopping Center Ltda','BR 277 KM123','Guabirotuba',0,0,'','Campo Largo','Paraná',0,0),(10,'Posto Agricopel','Rua São Paulo','CENTRO',121,89010175,'4735135930','Blumenau','Santa Catarina',0,0);
/*!40000 ALTER TABLE `tb_posto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 11:19:30
