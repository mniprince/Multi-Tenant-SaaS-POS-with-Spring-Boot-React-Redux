-- MySQL dump 10.13  Distrib 9.7.1, for macos15 (arm64)
--
-- Host: localhost    Database: pos_prime
-- ------------------------------------------------------
-- Server version	9.7.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `store_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqdaotwkf5g9vmdox82ttt50i5` (`store_id`),
  CONSTRAINT `FKqdaotwkf5g9vmdox82ttt50i5` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_seq`
--

DROP TABLE IF EXISTS `category_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_seq`
--

LOCK TABLES `category_seq` WRITE;
/*!40000 ALTER TABLE `category_seq` DISABLE KEYS */;
INSERT INTO `category_seq` VALUES (1);
/*!40000 ALTER TABLE `category_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `mrp` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `selling_price` double NOT NULL,
  `sku` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `store_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKq1mafxn973ldq80m1irp3mpvq` (`sku`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FKjlfidudl1gwqem0flrlomvlcl` (`store_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKjlfidudl1gwqem0flrlomvlcl` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_seq`
--

DROP TABLE IF EXISTS `product_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_seq`
--

LOCK TABLES `product_seq` WRITE;
/*!40000 ALTER TABLE `product_seq` DISABLE KEYS */;
INSERT INTO `product_seq` VALUES (1);
/*!40000 ALTER TABLE `product_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `id` bigint NOT NULL,
  `brand` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `store_type` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `store_admin_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkn8mpd5nuqbhngi6uafgkbfst` (`store_admin_id`),
  CONSTRAINT `FKmv6k6ch30s2tyd68y5joekb99` FOREIGN KEY (`store_admin_id`) REFERENCES `user` (`id`),
  CONSTRAINT `store_chk_1` CHECK ((`status` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'Prime Shop',NULL,NULL,NULL,NULL,'Supper Shop where you trust..',NULL,'Physical Product','2026-08-26 01:40:26.589880',1);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_seq`
--

DROP TABLE IF EXISTS `store_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_seq`
--

LOCK TABLES `store_seq` WRITE;
/*!40000 ALTER TABLE `store_seq` DISABLE KEYS */;
INSERT INTO `store_seq` VALUES (101);
/*!40000 ALTER TABLE `store_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` tinyint NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `store_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `FK1k3x2kt9pxcmon8jhquv31qe4` (`store_id`),
  CONSTRAINT `FK1k3x2kt9pxcmon8jhquv31qe4` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `user_chk_1` CHECK ((`role` between 0 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'mniprince@gmail.com','Monirul Islam','2026-11-24 02:14:53.044016','$2a$10$H/vl316GMbN1iVPwxBrnP.eTKQuAigFD7dyNYjDV4DeBdDmGZ63Oi',NULL,2,'2026-08-25 02:51:23.776604',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (51);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-25  1:38:40
