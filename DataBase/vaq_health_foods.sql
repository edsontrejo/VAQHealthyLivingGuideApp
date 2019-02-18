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
-- Table structure for table `foods`
--

DROP TABLE IF EXISTS `foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `groupId` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `calories` double NOT NULL,
  `fats` double NOT NULL,
  `cholesterol` double NOT NULL,
  `sodium` double NOT NULL,
  `potassium` double NOT NULL,
  `carbohydrates` double NOT NULL,
  `proteins` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foods`
--

LOCK TABLES `foods` WRITE;
/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
INSERT INTO `foods` VALUES (1,'Apple',1,'apple.jpg',198,0.3,0,0.002,0.1915,24.7,191.5),(2,'Avocado',1,'avocado.jpg',145,234,21.4,0,0.01,0.708,12.5),(3,'Banana',1,'banana.jpg',108,105,0.2,0,0.001,0.194,12.4),(4,'Broccoli',1,'broccoli.jpg',88,30,0.3,0,0.029,0.278,5.8),(5,'Cabbage',1,'cabbage.jpg',71,17,0,0,0,0.013,0.172),(6,'Carrot',1,'carrot.jpg',110,45,0.3,0,0.076,0.352,10.5),(7,'Cucumber',1,'cucumber.png',104,16,0,0,0.002,0.152,3.8),(8,'Eggplant',1,'eggplant.jpg',82,20,0.2,0,0.002,0.188,4.7),(9,'Grapefruit',1,'grapefruit.jpg',400,64,0.2,0,0,0.278,16.2),(10,'Grapes',1,'grapes.jpg',150,104,0.2,0,3,0.288,27.3),(11,'Lettuce',1,'lettuce.jpg',54,8,0,0,0.006,0.0776,1.6),(12,'Mango',1,'mango.jpg',107,57,0.2,0,0.001,0.117,15.1),(13,'Orange',1,'orange.jpg',178,62,0.2,0,0,0.2371,15.4),(14,'Papaya',1,'papaya.jpg',138,55,0.2,0,0.004,0.4,13.7),(15,'Pineapple',1,'pineapple.jpg',57,28,0.1,0,0.001,0.061,7.3),(16,'potato',1,'potato.png',150,116,0.1,0,0.009,0.009,0.631),(17,'spinach',1,'spinach.jpg',31,7,0.1,0,0.024,0.167,1.1),(18,'strawberry',1,'strawberry.jpg',153,49,0.5,0,0.002,0.232,11.7),(19,'tomato',1,'tomato.jpg',150,27,0.3,0,0.007,0.353,5.8),(20,'watermelon',1,'watermelon.jpg',153,46,0.2,0,0.002,170.2,11.5),(21,'Cheerios',2,'cheerios.png',28,100,2,0,0.14,0.18,20),(22,'Fiber One Cereal Original',2,'FiberOne_Cereal_Original.png',30,60,1,0,0.11,0.11,25),(23,'Fiber One 100% Whole Wheat Bread',2,'fiberone-bread-wholewheat.png',48,15,1.5,0,0.17,0,23),(24,'Fiber One Multigrain Bread',2,'FiberOne_Bread_Multigrain-1.png',48,110,1.5,0,0.135,0,25),(25,'Fiber One 9 Grain Bread',2,'FiberOne_Bread_9Grain.png',48,110,1.5,0,0.135,0,25),(26,'Honey Bunches of Oats Honey Roasted',2,'HBO-Honey-Roasted.png',30,120,1.5,0,0.135,0.055,25),(27,'Riceland Extral Long Grain Brown Rice',2,'riceland-brown-rice.jpg',42,150,1,0,0,0.1,32),(28,'Great Value Brown Rice',2,'Great_Value_Brown_Rice.jpg',45,160,1.5,0,0,0.1,35),(29,'Great Value 100% Whole Wheat Bread',2,'Great_Value_100-Whole-Wheat-Bread.jpg',28,60,1,0,0.12,0.06,12),(30,'Great Value Multi-Grain Bread',2,'Great_Value_Multi-Grain-Bread.jpg',45,120,1.5,0,0.19,0.095,24),(31,'HEB 100% Whole Grain Brown Rice',2,'h-e-b_brown_rice.jpg',42,150,1,0,0,0,32),(32,'HEB Bake Shop 100% Whole Wheat Bread',2,'h-e-b-bake-shop-100-whole-wheat-bread.jpg',28,60,1,0,0.085,0.09,11),(33,'HEB Essential Grains 12 Grain Bread',2,'h-e-b-essential-grains-12-grain-bread.jpg',45,120,2,0,0.19,0,22),(34,'Skinny Pop Original Popped Popcorn',2,'SkinnyPop_Popcorn.jpg',28,150,10,0,0.075,0,15),(35,'Orville Redenbacher\'s Naturals Simply Salted',2,'OrvilleRedenbachers-naturals-simply-salted.png',35,170,11,0,0.4,0.065,17),(36,'Honey Bunches of Oats Protein Granola with Dark Chocolate',2,'HBO-Granola-Dark-Chocolate.png',50,220,7,0,0.095,0.16,32),(37,'Natural Valley Baked Oat Bites Cereal',2,'NatureValley_BoxedCereal_BakedOatBites.png',24,210,6,0,0.16,0.105,34),(38,'Natural Valley Protein Oatmeal Maple Pecan Crunch',2,'NatureValley_OatmealCups_MaplePecanCrunch.png',48,290,8,0,0.15,0.21,47),(39,'Natural Valley Oats \'N Honey Crunchy Granola Bars',2,'NatureValley_CrunchyBar_OatsnHoney.png',16,190,7,0,0.18,0,29),(40,'Erin Baker\'s Granola Oatmeal Rasin',2,'ErinBakers-Granola-Oatmeal-Raisin.jpg',55,250,9,0,0.01,0,38),(41,'Great Value Reduced Fat 2% Milk',3,'2percentmilk.jpg',240,150,8,0.035,0.12,0.38,12),(42,'Great Value Low Fat 1% Milk',3,'1percentmilk.jpg',240,150,8,0.035,0.12,0.38,12),(43,'Oak Farms Vitamin D Whole Milk',3,'wholemilk.jpg',240,150,8,0.035,0.12,0.38,12),(44,'Blue Diamond Almonds Almond Breeze Unsweetened Original Almondmilk',3,'almondmilk.jpg',240,30,2.5,0,0.15,0.16,1),(45,'Borden Sweetened Condensed Eagle Brand Milk',3,'condensedmilk.jpg',39,130,3,0.01,0.04,0,23),(46,'Silk Vanilla Soymilk',3,'silksoymilk.jpg',240,30,3.5,0,0.1,0.3,9),(47,'Soy Slender Chocolate Soy Milk',3,'chocolatesoymilk.jpg',240,70,3,0,0.125,0.29,5),(48,'Great Value Vanilla Light Nonfat Yogurt',3,'vanillayogurt.jpg',240,110,0,0.005,0.105,0.32,20),(49,'Yoplait Creamy Strawberry Grande Yogurt',3,'strawberryyogurt.jpg',225,200,1.5,0.01,0.1,0.3,39),(50,'Chobani Blueberry on the Bottom Non-Fat Greek Yogurt',3,'chobaniblueberry_greekyogurt.jpg',150,120,0,0.005,0.06,0.22,18),(51,'Dannon Plain All Natural Nonfat Yogurt',3,'plainyogurt.jpg',225,120,0,0.005,0.15,0.51,18),(52,'La Yogurt Probiotic Banana Blended Lowfat Yogurt',3,'probioticbananayogurt.jpg',240,240,2.5,0.01,0.13,0.42,45),(53,'Chobani Vanilla Blended Non-Fat Greek Yogurt',3,'chobanivanillayogurt.jpg',170,0,0.01,0.095,0.36,23,20),(54,'Yoplait Light Banana Cream Pie Yogurt',3,'bananacreampie_yogurt.jpg',170,90,0,0.005,0.08,0,16),(55,'Kraft Velveeta Slices 16 ct Cheese',3,'velveetacheese.jpg',21,40,2,0.001,0.32,0,3),(56,'Kraft 100% Real Parmesan Grated Cheese',3,'parmesangratedcheese.jpg',30,20,1.5,0.005,0.085,0,0),(57,'Kraft Singles American Slices 16 ct Cheese',3,'americancheese.jpg',21,70,5,0.02,0.27,0,2),(58,'Kraft Deli Deluxe American Cheese Slices',3,'delideluxe_americancheese.jpg',19,60,4.5,0.015,0.3,0,1),(59,'Great Value Shredded Mozzarella Cheese',3,'mozzarellacheese.jpg',28,80,5,0.015,0.2,0.025,1),(60,'Borden American Singles Cheese',3,'bordencheese.jpg',21,45,5,0.015,0.29,0,3),(61,'Lean/27 Fat, Ground Beef Roll, 5',4,'ground_beefroll.jpg',112,340,30,0.085,0.075,0,0),(62,'Butterball Ground Turkey 93%Lean, 3lbs.',4,'ground_turkey.jpg',112,150,8,0.08,0.095,0,0),(63,'80Lean/20 Fat Great Value Beef Burgers, 3 Lbs',4,'beef_burger.jpg',113,290,23,0.09,0.085,0.31,0),(64,'SPAM Classic 12 oz. Can',4,'spam.jpg',56,180,16,0.04,0.79,0,1),(65,'Chicken Drumsticks, 5 lbs.',4,'chicken_drumsticks.jpg',112,90,10,0.1,0.16,0,0),(66,'Tyson Boneless Skinless Fresh Chicken Breasts, 1.5-2.0 lbs',4,'chicken_breast.jpg',112,20,2.5,0.065,0.18,0,0),(67,'Tyson Fresh Chicken Wings, 4.0 lbs.',4,'chicken_wing.jpg',112,220,17,0.105,0.19,0,0),(68,'Great Value Chunk Chicken Breast in Water, 12.5 oz, 2 Count',4,'chicken_breastinwater.jpg',56,45,1,0.025,0.26,0.14,0),(69,'Great Value Chunk Light Tuna in Water, 5 oz, 4 Count',4,'light_tuna.jpg',56,45,0.5,0.02,0.18,0.11,0),(70,'Frozen Tilpia Filets, 7 lbs',4,'tilapia_fillet.jpg',113,100,1.5,0.05,0.025,0,0),(71,'Medium Raw Shrimp 12 oz',4,'shrimp_raw.jpg',85,50,0.5,0.125,0.64,0.22,0),(72,'Great Value Large Grade A Eggs, 18 ct',4,'greatvalue_largeeggs.jpg',56,70,5,0.185,0.07,0,0),(73,'Farmhouse Cage Free Grade A Large Brown Eggs, 18 ct',4,'farmhouse_browneggs.jpg',50,70,5,0.185,0.07,0,0),(74,'Great Value 100% Liquid Egg Whites, 32 oz',4,'liquid_eggwhite.jpg',46,25,0,0,0.075,0.06,1),(75,'Great Value Pinto Beans, 64 oz',4,'pinto_beans.jpg',35,90,0,0,0.005,0.49,20),(76,'Great Value Black Beans, 32 oz',4,'black_beans.jpg',35,100,0.5,0,0,0.49,22),(77,'Great Value Light Red Kidney Beans, 16 oz',4,'kidney_beans.jpg',35,100,0,0,0.005,0.48,21),(78,'Fisher Chef\'s Naturals Pecans Halves, 24 oz',4,'fisher_pecanhalves.jpg',28,190,20,0,0,0,4),(79,'Great Value Whole Natural Almonds, 14 oz',4,'wholenatural_almonds.jpg',28,160,14,0,0,0.21,6),(80,'Wonderful® Roasted & Salted Pistachios 24 oz. Bag',4,'pistachios.jpg',30,160,14,0,0.16,0.31,8),(81,'Butter',5,'SmartBalancebutter.png',33,60,7,0,70,0,0),(82,'Peanutbutter',5,'wowbutter.jpg',16,200,15,0,100,300,8),(83,'AlmondButter',5,'barneyandcoalmond.jpg',14,180,15,0,100,0,8),(84,'Butter',5,'butterspray.jpg',1700,0,0,0,0,0,0),(85,'Butter',5,'canolabutter.jpg',30,100,11,15,85,0,0),(86,'Butter',5,'canolaolivebutter.jpg',30,100,11,15,85,0,0),(87,'Creamcheese',5,'creamcheese.jpg',7,80,7,20,125,0,2),(88,'hummus',5,'hummus.jpg',10,70,5,0,130,0,4),(89,'AlmondButter',5,'justin\'salmond.jpg',12,190,18,0,0,3500,6),(90,'Butter',5,'lightspreadbutter.jpg',30,40,4,0,80,3500,0),(91,'AlmondButter',5,'maranathaalmond.jpg',11,190,16,0,0,3500,7),(92,'AlmondButter',5,'nutsnmorealmond.jpg',14,207,15,1,56,3500,6),(93,'Butter',5,'omegabutter.jpg',32,70,8,0,80,3500,0),(94,'PeanutButter',5,'omegapeanutbutter.jpg',30,100,11,15,85,3500,0),(95,'AlmondButter',5,'onceagainalmond.jpg',15,190,17,0,0,3500,6),(96,'Oil',5,'bertolli.jpg',102,120,14,0,0,0,0),(97,'ricotta',5,'ricotta.jpg',30,100,11,15,85,3500,0),(98,'AlmondButter',5,'Sam\'sAlmondButter.jpg',11,190,16,0,60,65,7),(99,'Butter',5,'wildfriendsalmond.jpg',1,190,17,0,90,3500,7),(100,'Oil',5,'canolaoil.jpg',48,120,14,0,0,0,0),(101,'laysChips',6,'chips.png',28,160,10,0,170,350,15),(102,'crackers',6,'crackers.png',33,90,5,0,130,0,9),(103,'cookies',6,'cookie.jpg',30,130,5,0,65,0,20),(104,'popcorn',6,'popcorn.jpg',39,130,2,0,190,230,27),(105,'coke',6,'coke.jpg',35,140,0,0,45,0,39),(106,'cheerios',6,'cheerios.png',30,120,2,0,270,170,20),(107,'ketchup',6,'ketchup.jpg',15,25,0,0,200,0,6),(108,'chickenSoup',6,'chickenSoup.jpg',18.9,70,1,15,750,0,10),(109,'bread',6,'bread.jpg',40,100,1,0,180,0,20),(110,'tortilla',6,'tortilla.jpg',49,140,3.5,0,420,0,24),(111,'hotCheetos',6,'hotCheetos.png',28,160,11,0,250,0,13),(112,'pizza',6,'pizza.png',175,410,19,35,660,0,48),(113,'margarine',6,'margarine.jpg',85,250,11,5,350,0,33),(114,'frenchFry',6,'frenchFry.jpg',114,350,18,0,220,0,45),(115,'iceCream',6,'iceCream.jpg',65,150,9,80,45,0,15),(116,'candyBar',6,'candyBar.jpg',78,320,17,15,220,0,40),(117,'cheese',6,'cheese.jpg',28.35,100,10,30,230,0,0),(118,'soySauce',6,'soySauce.jpg',6,15,0,0,125,0,3),(119,'poundCake',6,'poundCake.jpg',65,230,10,55,135,0,34),(120,'bacon',6,'bacon.png',32,170,17,25,220,0,0);
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 12:35:46
