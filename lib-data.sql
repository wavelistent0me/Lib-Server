-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lib_database
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `view` int DEFAULT '0',
  `author` varchar(25) DEFAULT NULL,
  `is_recommend` int DEFAULT '0',
  `category_id` bigint DEFAULT NULL,
  `like_num` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1752959989644042241,'全职高手','http://localhost:8080/images/2024.02.01/76db5133-7a12-446d-8871-79ba02e94394.jpg',7,'蝴蝶兰',1,1752959989581127682,1),(1752962016025550851,'道诡异仙','http://localhost:8080/images/2024.02.01/98bfe49f-38b3-4943-8b45-b70180930ae8.jpg',1,'狐尾',0,1752962016025550850,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

--
-- Table structure for table `book_like`
--

DROP TABLE IF EXISTS `book_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_like` (
  `id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `book_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_like`
--

/*!40000 ALTER TABLE `book_like` DISABLE KEYS */;
INSERT INTO `book_like` VALUES (1784859096704712706,0,1752959989644042241),(1784861824054988802,0,1752962016025550851);
/*!40000 ALTER TABLE `book_like` ENABLE KEYS */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1752959989581127682,'现实'),(1752962016025550850,'玄幻');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter` (
  `id` bigint DEFAULT NULL,
  `content` text,
  `book_id` bigint DEFAULT NULL,
  `title` varchar(25) DEFAULT NULL,
  `price` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
INSERT INTO `chapter` VALUES (1730500315216936962,'啊啊啊\n恰恰恰\n额鹅鹅鹅\n反反复复\n走走',1730062707127009282,'章节1',NULL),(1730509317153824769,'Test\n1',1730062707127009282,'章节2',NULL),(1731506896624738305,'很久很久以前12',1730062936287002625,'初入茅庐',NULL),(1734755211806011394,'一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的一:标准盒模型和怪异盒模型的区别\n标准盒模型:这种盒模型设置width的时候的值是内容区的宽度,如果再设置padding和margin,border的话盒子的实际宽度会增大\n怪异盒模型:这种盒子的width设置的值为盒子实际的宽度,border和padding的设置不会影响盒子的',1730062936287002625,'123',NULL),(1749332895647141890,'很久很久以前...',1749331325412970498,'第一章 气味儿',0),(1749337645910343682,'又是那一天...',1749331325412970498,'第二章 出示',1),(1750075871541354497,'又过了一天',1749331325412970498,'第三章 落寞',3),(1750792057300234241,'t',1750791984680054786,'第一章',0),(1750792096324038657,'t',1750791984680054786,'第二章',3),(1752254659775774721,'longlong',1749331325412970498,'第四章 想不出',10),(1752962117880029185,'123\r\n1\r\n2\r\n3',1752959989644042241,'第一章',0),(1752962179515326465,'夜雨声烦',1752959989644042241,'第二章',1),(1752962225149353985,'打',1752959989644042241,'第三章',3),(1752962315058454530,'现',1752962016025550851,'第一章',0),(1752962354107424770,'反',1752962016025550851,'第二章',2);
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1735838350523600897,'1111',0,1730062707127009282,NULL),(1735838355267358721,'111111',0,1730062707127009282,NULL),(1735838361705615362,'111111',0,1730062707127009282,NULL),(1752963292746522626,'好看',0,1752959989644042241,NULL),(1784781296672968706,'123',0,1752959989644042241,'2024-04-29 11:06:35');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `book_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (1752978646839353345,1752978523619090434,1752959989644042241),(1784792125459959809,0,1752959989644042241);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `id` bigint DEFAULT NULL,
  `content` text,
  `user_id` bigint DEFAULT NULL,
  `chapter_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1731931594005229570,'写的很好',0,1730500315216936962),(1742793292790484993,'1',0,1731506896624738305),(1750071250903134209,'111',0,1749332895647141890);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;

--
-- Table structure for table `purchase_history`
--

DROP TABLE IF EXISTS `purchase_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_history` (
  `id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `chapter_id` bigint DEFAULT NULL,
  `cost` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_history`
--

/*!40000 ALTER TABLE `purchase_history` DISABLE KEYS */;
INSERT INTO `purchase_history` VALUES (1752962473301155842,0,1752962179515326465,1,'2024-02-01 15:49:57'),(1752978638824038401,1752978523619090434,1752962179515326465,1,'2024-02-01 16:54:11');
/*!40000 ALTER TABLE `purchase_history` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `type` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'admin','123456',0),(1727972646331879426,'4','1234',1),(1727973595062476802,'3','1234',1),(1731933008169312257,'123','321',1),(1731933981503696897,'111','111',1),(1731936992380612610,'444241','123',1),(1735195496340017154,'333','1',1),(1752978523619090434,'d123','123',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-29 16:29:02
