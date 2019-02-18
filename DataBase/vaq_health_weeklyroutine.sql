-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vaq_health
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `weeklyroutine`
--

DROP TABLE IF EXISTS `weeklyroutine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weeklyroutine` (
  `ID` int(11) NOT NULL,
  `ExerciseRoutineID` int(11) NOT NULL,
  `workOutDay` varchar(45) NOT NULL,
  `seqNum` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`,`ExerciseRoutineID`,`seqNum`,`workOutDay`),
  KEY `ExerciseRoutineFK_idx` (`ExerciseRoutineID`),
  CONSTRAINT `ExerciseRoutineFK` FOREIGN KEY (`ExerciseRoutineID`) REFERENCES `exerciseroutine` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weeklyroutine`
--

LOCK TABLES `weeklyroutine` WRITE;
/*!40000 ALTER TABLE `weeklyroutine` DISABLE KEYS */;
INSERT INTO `weeklyroutine` VALUES (1,1,'Friday',1,'Routine1'),(1,1,'Monday',1,'Routine1'),(1,1,'Saturday',1,'Routine1'),(1,1,'Sunday',1,'Routine1'),(1,1,'Thursday',1,'Routine1'),(1,1,'Wednesday',1,'Routine1'),(1,2,'Tuesday',1,'Routine1'),(1,2,'Monday',2,'Routine1'),(1,3,'Monday',3,'Routine1'),(1,3,'Monday',4,'Routine1');
/*!40000 ALTER TABLE `weeklyroutine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 12:35:45
