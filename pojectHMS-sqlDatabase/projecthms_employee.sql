-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projecthms
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `salary` varchar(10) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (' Clay Jensen','21','Male','Manager','80000','1593578520','137591962801','clay@gmail.com'),(' Hannah Baker','21','Female','Manager','80000','8479360299','714994189967','hannah@gmail.com'),('Tony Padilla','22','Male','Room Service','20000','2674777766','152897891432','tony@gmail.com'),('Jessica Davis','23','Female','Waiter/Waitress','20000','7851667507','364215437314','jessica@gmail.com'),('Justin Foley','20','Male','Accountant','30000','7809021185','777480098925','justin@gmail.com'),(' Bryce Walker','24','Male','Manager','80000','1846138304','300865982673','bryce@gmil.com'),('Alex Standal','22','Male','Kitchen Staff','20000','6435636706','158248930130','alex@gmail.com'),('Zach Dempsey','23','Male','Waiter/Waitress','20000','0436602575','870453310535','zzach@gmail.com'),('Monty De La Cruz','24','Male','Kitchen Staff','20000','6132004739','977707242638','monty@gmail.com'),('Bill Standall','49','Male','Chef','40000','0249683648','410234390900','bill@gmail.com'),('Nora Walker','55','Female','Front Desk Clerks','40000','3850218451','576361904885','nora@gmail.com'),('Lainie Jensen','50','Female','Porters','20000','0160315114','364614860249','lainie@gmail.com'),('Tyler Down','22','null','Housekeeping','18000','8997374698','144080821421','tyler@gmail.com'),('','','null','Front Desk Clerks','','','',''),('hello','21','Male','Room Service','20000','1324569870','12346578912','hello@gmail.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-01 22:00:38
