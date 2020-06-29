CREATE DATABASE gatewaydb;
USE gatewaydb;
--
-- Table structure for table `gateway`
--
DROP TABLE IF EXISTS `gateway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ki3yedqxnooh4nmcdhcv8gut6` (`serial_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `gateway` VALUES (1,'10.10.10.10','Some name','4619fd52-2afe-4c5a-947a-6ba730106857'),(2,'10.10.10.10','Some name2','7b156766-ae3e-43ae-a34b-f2005e6b2d2e');
UNLOCK TABLES;

--
-- Table structure for table `peripheral`
--

DROP TABLE IF EXISTS `peripheral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peripheral` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `is_online` bit(1) DEFAULT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `gateway_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5jmmc4fnfkoqnmn8uxjwnemqr` (`gateway_id`),
  CONSTRAINT `FK5jmmc4fnfkoqnmn8uxjwnemqr` FOREIGN KEY (`gateway_id`) REFERENCES `gateway` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `peripheral`
--

LOCK TABLES `peripheral` WRITE;
INSERT INTO `peripheral` VALUES (1,NULL,_binary '\0','Dell',1),(2,NULL,_binary '','mouse',2),(3,NULL,_binary '\0','printer',2),(4,NULL,_binary '\0','display',2);
UNLOCK TABLES;