-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: booksdb
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `isbn` varchar(12) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL,
  `authors` varchar(60) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('123-456-789','Yusuf Ozbek','Java Servlets',49.55),('963-852-741','Rick Sherman','Data Warehousing',64.99),('123-456-898','Yusuf Ozbek','Java Servlets',49.55),('963-852-741','Rick Sherman','Data Warehousing',64.99),('852','Dan Maranan','Business Analysis',71.95),('5963','Abdul Kalam','Wings of fire',45.39),('963','Salman Rushdie','Midnight Children',75.68),('1596','Paulo Coelho','The Aleph',20.82),('32165','Lewis Carroll','Alice In Wonderland',35.26),('6548','Paulo Coelho','Witch of Pertobello',85.91),('48520','Kal Bugrara','AED',56.54),('48596','Yashavant Kanetkar','Let us C',20.82),('159','frgrhy','ghujmk',1263),('852741456','JohnGrisham','TheStreetLawyer',5987),('654963753','Malala','IamMalala',5148),('95412','poiuytrewq','lkjhgfdsa',15.96),('95147885236','zxawsrhcvbhm','mnbhuijofdf',12.59),('dcfvb','xhfcnvb','24576fvhnb',80.26),('941532','gycjh','fcthvcwrjfbcyuj',16.59),('895623','gyjgycj','thbjkukjnfbuikjc',99.99),('852','shucGFYJ','utftd',77.77),('vyf','cfb','feaf',4531),('dvbj','gvyd','vdhuk',5241),('7854','45120','9562',15.63),('gb','sedfvbh','esfdgvhb',45.39),('7845120','xdcfvgbhnj','xdcfvgbhnjmk',55.55);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'booksdb'
--

--
-- Dumping routines for database 'booksdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-13 19:02:55
