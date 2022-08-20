CREATE DATABASE  IF NOT EXISTS `computer_for_you` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `computer_for_you`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: computer_for_you
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `category` varchar(25) NOT NULL,
  `price` double NOT NULL,
  `img` varchar(600) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
REPLACE  IGNORE INTO `product_details` (`id`, `name`, `category`, `price`, `img`) VALUES (1,'New 14\" Lenovo Quad Laptop, 4GB RAM, SSD, HD Graphics, Win 11 Pro, Office 2021 Pro Plus, Very Long Battery Life','Laptop',300,'Lenovo Monitor 5\'.jpg'),(2,'Optiplex Dell Intel i7-2600 Quad Core 16GB RAM 240GB SSD + 1TB HDD WiFi Windows 10 Desktop PC Computer','Processor',162.88,'Optiplex Dell i5 processor.jpg'),(3,'Mini PC Windows 11 AWOW Mini Desktop Computer Intel Celeron J4125 with 8GB DDR4/ NVMe M.2 128GB SSD with Triple Display 4K@60Hz, Dual Band WiFi, HDMI2, USB4, BT5.0, Gigabit Ethernet','Processor',209.59,'Mini Win11 CPU.jpg'),(4,'Wireless Mouse for Laptop Silent Cordless USB Mouse Wireless Optical Computer Mouse, 6 Buttons, AA Battery Used,1600DPI with 3 Adjustable Levels for Windows 10/8/7/XP/Mac/Macbook Pro/Air/HP/Acer','Mouse',8.99,'Wireless Mouse.jpg'),(5,'TECKNET Pro S2 High Performance Wired USB Mouse, Computer Mouse for Laptop, PC Mouse, Plug In, 6 Buttons, Upto 2000 DPI','Mouse',10.98,'USB Mouse.jpg'),(6,'Arteck 2.4G Wireless Keyboard Stainless Steel Ultra Slim Full Size Keyboard with Numeric Keypad for Computer/Desktop/PC/Laptop/Surface/Smart TV and Windows 10/8/ 7 Built in Rechargeable Battery','Keyboard',28.99,'Wireless Keyboard.jpg'),(7,'Kensington Keyboard - wired keyboard for PC, Laptop, Desktop PC, Computer, notebook. USB Keyboard compatible with Dell, Acer, HP, Samsung and more, with UK layout - Black (1500109)','Keyboard',8.77,'Keyboard.jpg'),(8,'Logitech MK270 Wireless Keyboard and Mouse Combo for Windows, 2.4 GHz Wireless, Compact Mouse, 8 Multimedia and Shortcut Keys, 2-Year Battery Life, for PC, Laptop, QWERTY UK English Layout - Black','Combo',27.99,'Keyboard_Mouse Combo.jpg'),(9,'Epson Expression Home XP-3100 Print/Scan/Copy Wi-Fi Printer, Black','Printer',98.99,'Epson Black.jpg'),(10,'Lenovo C22-25 21.5inch PC Computer Monitor, HDMI, FHD Resolution, Black','Monitor',79.99,'Lenovo Monitor 5\'.jpg'),(11,'Dell SE2422HX 24 Inch Full HD (1920 x 1080) Monitor, 75Hz, VA, 5ms, AMD FreeSync, HDMI, VGA, 3 Year Warranty','Monitor',124.99,'Dell Monitor FullHD 21.5\'.jpg'),(12,'Brother MFC-L2730DW Mono Laser Printer - All-in-One, Wireless/USB 2.0, Printer/Scanner/Copier/Fax Machine, 2 Sided Printing, A4 Printer, Small Office/Home Office Printer, UK Plug','Printer',203,'Brother_printer.jpg'),(13,'HP Laptop 15s-fq2039na, 15\" Full HD Laptop, Intel Core i3 , 4.1GHz, 4GB Ram, 128 GB SSD, Windows 10 in S Mode, Full Size Keyboard, Micro Edge Display, Anti-Glare, Silver','Laptop',299.99,'HP i3 Laptop.jpg'),(14,'Epson EcoTank ET-4850 Print/Scan/Copy Wi-Fi Ink Tank Printer, With Up To 3 Years Worth Of Ink Included','All in One Print',357.99,'Epson Wireless All-in-One.jpg');
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-20  8:21:56
