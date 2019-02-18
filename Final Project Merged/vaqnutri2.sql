/*
Navicat MySQL Data Transfer

Source Server         : phpmyadmin
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : vaqnutri

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-12-14 00:28:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for allergy
-- ----------------------------
DROP TABLE IF EXISTS `allergy`;
CREATE TABLE `allergy` (
  `ID` int(11) NOT NULL,
  `foodCatID` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `aFoodCatID_idx` (`foodCatID`),
  CONSTRAINT `aFoodCatID` FOREIGN KEY (`foodCatID`) REFERENCES `foodcat` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of allergy
-- ----------------------------
INSERT INTO `allergy` VALUES ('1', '1', 'Dairy', 'Dairy');
INSERT INTO `allergy` VALUES ('2', '2', 'Soy', 'Soy');
INSERT INTO `allergy` VALUES ('3', '3', 'Egg', 'Egg');
INSERT INTO `allergy` VALUES ('4', '4', 'Peanut', 'Peanut');
INSERT INTO `allergy` VALUES ('5', '5', 'Fish', 'Fish');
INSERT INTO `allergy` VALUES ('6', '6', 'Wheat', 'Wheat');
INSERT INTO `allergy` VALUES ('7', '7', 'Fructans', 'Fructans');
INSERT INTO `allergy` VALUES ('8', '8', 'Sesame', 'Sesame');
INSERT INTO `allergy` VALUES ('9', '9', 'Gluten', 'Gluten');
INSERT INTO `allergy` VALUES ('10', '10', 'Lactose', 'Lactose');
INSERT INTO `allergy` VALUES ('11', '11', 'Fructose', 'Fructose');
INSERT INTO `allergy` VALUES ('12', '12', 'Sulfites', 'Sulfites');
INSERT INTO `allergy` VALUES ('13', '13', 'Histamines', 'Histamines');
INSERT INTO `allergy` VALUES ('14', '14', 'Nitrites', 'Nitrites');
INSERT INTO `allergy` VALUES ('15', '15', 'Night Shades', 'Night Shades');

-- ----------------------------
-- Table structure for badexercisefordisease
-- ----------------------------
DROP TABLE IF EXISTS `badexercisefordisease`;
CREATE TABLE `badexercisefordisease` (
  `diseaseID` int(11) NOT NULL,
  `exerciseID` int(11) DEFAULT NULL,
  PRIMARY KEY (`diseaseID`),
  KEY `befdExerciseID_idx` (`exerciseID`),
  CONSTRAINT `befdDiseaseID` FOREIGN KEY (`diseaseID`) REFERENCES `disease` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `befdExerciseID` FOREIGN KEY (`exerciseID`) REFERENCES `exercise` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of badexercisefordisease
-- ----------------------------

-- ----------------------------
-- Table structure for badfoodfordisease
-- ----------------------------
DROP TABLE IF EXISTS `badfoodfordisease`;
CREATE TABLE `badfoodfordisease` (
  `diseaseID` int(11) NOT NULL,
  `foodCatID` int(11) DEFAULT NULL,
  PRIMARY KEY (`diseaseID`),
  KEY `foodCatID1_idx` (`foodCatID`),
  CONSTRAINT `diseaseID2` FOREIGN KEY (`diseaseID`) REFERENCES `disease` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foodCatID2` FOREIGN KEY (`foodCatID`) REFERENCES `foodcat` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of badfoodfordisease
-- ----------------------------

-- ----------------------------
-- Table structure for currentweeklyroutine
-- ----------------------------
DROP TABLE IF EXISTS `currentweeklyroutine`;
CREATE TABLE `currentweeklyroutine` (
  `userID` int(11) NOT NULL,
  `weeklyRoutineID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `weeklyRFK_idx` (`weeklyRoutineID`),
  CONSTRAINT `cwrUserFK` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `weeklyRFK` FOREIGN KEY (`weeklyRoutineID`) REFERENCES `weeklyroutine` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of currentweeklyroutine
-- ----------------------------

-- ----------------------------
-- Table structure for disease
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------
INSERT INTO `disease` VALUES ('1', 'Diabetes', 'Diabetes is a disease that affects your body\'s ability to produce or use insulin. Insulin is a hormone. When your body turns the food you eat into energy (also called sugar or glucose), insulin is released to help transport this energy to the cells. Insulin acts as a “key.”');
INSERT INTO `disease` VALUES ('2', 'Celiac', 'Celiac disease is a serious genetic autoimmune disease. It is triggered by consuming a protein called gluten, which is found in wheat, barley and rye. When people with celiac disease eat foods containing gluten, their immune system responds by damaging the finger-like villi of the small intestine.');
INSERT INTO `disease` VALUES ('3', 'High Cholesterol', 'Cholesterol is a waxy substance that\'s found in the fats (lipids) in your blood. While your body needs cholesterol to continue building healthy cells, having high cholesterol can increase your risk of heart disease. When you have high cholesterol, you may develop fatty deposits in your blood vessels.');
INSERT INTO `disease` VALUES ('4', 'Chronic Kidney', 'Chronic kidney disease, also called chronic kidney failure, describes the gradual loss of kidney function. Your kidneys filter wastes and excess fluids from your blood, which are then excreted in your urine.');
INSERT INTO `disease` VALUES ('5', 'Gout', 'Gout is characterized by sudden, severe attacks of pain, redness and tenderness in joints, often the joint at the base of the big toe. Gout — a complex form of arthritis — can affect anyone. Men are more likely to get gout, but women become increasingly susceptible to gout after menopause.');
INSERT INTO `disease` VALUES ('6', 'High Blood Pressure', 'Blood pressure is the force of blood pushing against the walls of the arteries as the heart pumps blood. High blood pressure, sometimes called hypertension, happens when this force is too high. Health care workers check blood pressure readings the same way for children, teens, and adults.');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `Id` int(11) NOT NULL,
  `Name` mediumtext NOT NULL,
  `Exercise Type` varchar(45) NOT NULL,
  `Primary Muscle` varchar(45) NOT NULL,
  `Secondary Muscle` varchar(45) DEFAULT NULL,
  `Description` longtext NOT NULL,
  `Image` blob,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------

-- ----------------------------
-- Table structure for exercise
-- ----------------------------
DROP TABLE IF EXISTS `exercise`;
CREATE TABLE `exercise` (
  `ID` int(11) NOT NULL,
  `name` mediumtext NOT NULL,
  `description` longtext NOT NULL,
  `difficulty` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `met` double DEFAULT '0',
  `equipmentID` varchar(45) DEFAULT NULL,
  `image` blob,
  `primaryMuscle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercise
-- ----------------------------

-- ----------------------------
-- Table structure for exerciseroutine
-- ----------------------------
DROP TABLE IF EXISTS `exerciseroutine`;
CREATE TABLE `exerciseroutine` (
  `ID` int(11) NOT NULL,
  `ExerciseID` int(11) DEFAULT NULL,
  `workOutTime` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `erExerciseFK_idx` (`ExerciseID`),
  CONSTRAINT `erExerciseFK` FOREIGN KEY (`ExerciseID`) REFERENCES `exercise` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exerciseroutine
-- ----------------------------
INSERT INTO `exerciseroutine` VALUES ('1', '1', '60');
INSERT INTO `exerciseroutine` VALUES ('2', '2', '2');
INSERT INTO `exerciseroutine` VALUES ('3', '11', '30');

-- ----------------------------
-- Table structure for exercisetype
-- ----------------------------
DROP TABLE IF EXISTS `exercisetype`;
CREATE TABLE `exercisetype` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercisetype
-- ----------------------------
INSERT INTO `exercisetype` VALUES ('1', 'CARDIO');

-- ----------------------------
-- Table structure for foodcat
-- ----------------------------
DROP TABLE IF EXISTS `foodcat`;
CREATE TABLE `foodcat` (
  `ID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `discription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of foodcat
-- ----------------------------
INSERT INTO `foodcat` VALUES ('1', 'Dairy', null);
INSERT INTO `foodcat` VALUES ('2', 'Soy', null);
INSERT INTO `foodcat` VALUES ('3', 'Eggs', null);
INSERT INTO `foodcat` VALUES ('4', 'Peanuts', null);
INSERT INTO `foodcat` VALUES ('5', 'Fish', null);
INSERT INTO `foodcat` VALUES ('6', 'Wheat', null);
INSERT INTO `foodcat` VALUES ('7', 'Fructans', null);
INSERT INTO `foodcat` VALUES ('8', 'Sesame', null);
INSERT INTO `foodcat` VALUES ('9', 'Gluten', null);
INSERT INTO `foodcat` VALUES ('10', 'Lactose', null);
INSERT INTO `foodcat` VALUES ('11', 'Fructose', null);
INSERT INTO `foodcat` VALUES ('12', 'Sulfites', null);
INSERT INTO `foodcat` VALUES ('13', 'Histamines', null);
INSERT INTO `foodcat` VALUES ('14', 'Nitrites', null);
INSERT INTO `foodcat` VALUES ('15', 'Night Shades', null);

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `groupId` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `calories` double NOT NULL,
  `fats` double NOT NULL,
  `cholesterol` double NOT NULL,
  `sodium` double NOT NULL,
  `potassium` double NOT NULL,
  `carbohydrates` double NOT NULL,
  `proteins` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES ('1', 'Apple', '1', 'apple.jpg', '128', '198', '0.3', '0', '0.002', '0.1915', '24.7', '191.5');
INSERT INTO `foods` VALUES ('2', 'Avocado', '1', 'avocado.jpg', '146', '145', '234', '21.4', '0', '0.01', '0.708', '12.5');
INSERT INTO `foods` VALUES ('3', 'Banana', '1', 'banana.jpg', '118', '105', '0.4', '0', '0.001', '0.422', '27', '1.3');
INSERT INTO `foods` VALUES ('4', 'Broccoli', '1', 'broccoli.jpg', '148', '50', '0.5', '0', '0.049', '0.468', '10', '4.2');
INSERT INTO `foods` VALUES ('5', 'Cabbage', '1', 'cabbage.jpg', '23', '6', '0', '0', '0.004', '0.039', '1.3', '0.3');
INSERT INTO `foods` VALUES ('6', 'Carrot', '1', 'carrot.jpg', '61', '25', '0.1', '0', '0.042', '0.195', '6', '0.6');
INSERT INTO `foods` VALUES ('7', 'Cucumber', '1', 'cucumber.png', '52', '8', '0.1', '0', '0.001', '0.076', '1.9', '0.3');
INSERT INTO `foods` VALUES ('8', 'Eggplant', '1', 'eggplant.jpg', '82', '20', '0.1', '0', '0.002', '0.188', '4.8', '0.8');
INSERT INTO `foods` VALUES ('9', 'Grapefruit', '1', 'grapefruit.jpg', '123', '52', '0.2', '0', '0', '0.166', '13', '0.9');
INSERT INTO `foods` VALUES ('10', 'Grapes', '1', 'grapes.jpg', '92', '62', '0.3', '0', '0.002', '0.176', '16', '0.6');
INSERT INTO `foods` VALUES ('11', 'Lettuce', '1', 'lettuce.jpg', '36', '5', '0.1', '0', '0.01', '0.07', '1', '0.5');
INSERT INTO `foods` VALUES ('12', 'Mango', '1', 'mango.jpg', '336', '201', '1.3', '0', '0.003', '0.564', '50', '2.8');
INSERT INTO `foods` VALUES ('13', 'Orange', '1', 'orange.jpg', '96', '45', '0.1', '0', '0', '0.174', '11', '0.9');
INSERT INTO `foods` VALUES ('14', 'Papaya', '1', 'papaya.jpg', '157', '67', '0.4', '0', '0.013', '0.286', '17', '0.7');
INSERT INTO `foods` VALUES ('15', 'Pineapple', '1', 'pineapple.jpg', '905', '452', '1.1', '0', '0.009', '0.986', '119', '4.9');
INSERT INTO `foods` VALUES ('16', 'Potato', '1', 'potato.png', '213', '163', '0.2', '0', '0.013', '0.897', '37', '4.3');
INSERT INTO `foods` VALUES ('17', 'Spinach', '1', 'spinach.jpg', '30', '7', '0.1', '0', '0.024', '0.167', '1.1', '0.9');
INSERT INTO `foods` VALUES ('18', 'Strawberry', '1', 'strawberry.jpg', '12', '4', '0', '0', '0', '0.018', '0.9', '0.1');
INSERT INTO `foods` VALUES ('19', 'Tomato', '1', 'tomato.jpg', '123', '22', '0.2', '0', '0.006', '0.292', '4.8', '1.1');
INSERT INTO `foods` VALUES ('20', 'Watermelon', '1', 'watermelon.jpg', '280', '85', '0.4', '0', '0.003', '0.314', '21', '1.7');
INSERT INTO `foods` VALUES ('21', 'Amaranth', '2', 'amaranth.jpg', '193', '717', '14', '0', '0.008', '0.98', '126', '26');
INSERT INTO `foods` VALUES ('22', 'Barley', '2', 'barley.jpg', '100', '354', '2.3', '0', '0.012', '0.452', '73', '12');
INSERT INTO `foods` VALUES ('23', 'Brown Rice', '2', 'brownrice.jpg', '195', '216', '1.8', '0', '0.01', '0.084', '45', '5');
INSERT INTO `foods` VALUES ('24', 'Buckwheat', '2', 'Buckwheat.jpg', '168', '155', '1.2', '0', '0.015', '0.135', '25', '5.2');
INSERT INTO `foods` VALUES ('25', 'Bulgur', '2', 'Bulgur.jpg', '140', '479', '1.9', '0', '0.024', '0.574', '106', '17');
INSERT INTO `foods` VALUES ('26', 'Flax', '2', 'Flax.jpg', '10.3', '55', '4.3', '0', '0.003', '0.084', '3', '1.9');
INSERT INTO `foods` VALUES ('27', 'Millet', '2', 'Millet.jpg', '100', '378', '4.2', '0', '0.005', '0.195', '73', '11');
INSERT INTO `foods` VALUES ('28', 'Oats', '2', 'Oats.jpg', '100', '389', '7', '0', '0.002', '0.429', '66', '17');
INSERT INTO `foods` VALUES ('29', 'Oat Bread', '2', 'OatBread.jpg', '38', '100', '2', '0', '0.135', '0', '18', '3');
INSERT INTO `foods` VALUES ('30', 'Oatmeal', '2', 'Oatmeal.jpg', '234', '158', '3.2', '0', '0.115', '0.143', '27', '6');
INSERT INTO `foods` VALUES ('31', 'Popcorn', '2', 'Popcorn.jpg', '28.4', '106', '1.2', '0', '0.002', '0.078', '21', '3.1');
INSERT INTO `foods` VALUES ('32', 'Cereal Flakes', '2', 'CerealFlakes.jpg', '50', '175', '1', '0', '0.152', '0.16', '41', '6');
INSERT INTO `foods` VALUES ('33', 'Rolled Oats', '2', 'RolledOats.jpg', '100', '379', '6.52', '0', '0.006', '0.362', '67.7', '13.15');
INSERT INTO `foods` VALUES ('34', 'Rye', '2', 'Rye.jpg', '169', '571', '2.8', '0', '0.003', '0.862', '128', '17');
INSERT INTO `foods` VALUES ('35', 'Whole Wheat Bread', '2', 'WholeWheatBread.jpg', '100', '247', '3.4', '0', '0.4', '0.248', '41', '13');
INSERT INTO `foods` VALUES ('36', 'White Rice', '2', 'WhiteRice.jpg', '158', '206', '0.4', '0', '0.002', '0.055', '45', '4.3');
INSERT INTO `foods` VALUES ('37', 'Oat Cereal', '2', 'NatureValley_BoxedCereal_BakedOatBites.png', '', '24', '210', '6', '0', '0.16', '0.105', '34');
INSERT INTO `foods` VALUES ('38', 'Oatmeal Maple', '2', 'NatureValley_OatmealCups_MaplePecanCrunch.png', '', '48', '290', '8', '0', '0.15', '0.21', '47');
INSERT INTO `foods` VALUES ('39', 'Granola Bars', '2', 'NatureValley_CrunchyBar_OatsnHoney.png', '', '16', '190', '7', '0', '0.18', '0', '29');
INSERT INTO `foods` VALUES ('40', 'Granola Rasin', '2', 'ErinBakers-Granola-Oatmeal-Raisin.jpg', '', '55', '250', '9', '0', '0.01', '0', '38');
INSERT INTO `foods` VALUES ('41', 'Reduced Fat 2% Milk', '3', '2percentmilk.jpg', '', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('42', 'Low Fat 1% Milk', '3', '1percentmilk.jpg', '', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('43', 'Whole Milk', '3', 'wholemilk.jpg', '', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('44', 'Almondmilk', '3', 'almondmilk.jpg', '', '240', '30', '2.5', '0', '0.15', '0.16', '1');
INSERT INTO `foods` VALUES ('45', 'Brand Milk', '3', 'condensedmilk.jpg', '', '39', '130', '3', '0.01', '0.04', '0', '23');
INSERT INTO `foods` VALUES ('46', 'Silk Vanilla Soymilk', '3', 'silksoymilk.jpg', '', '240', '30', '3.5', '0', '0.1', '0.3', '9');
INSERT INTO `foods` VALUES ('47', 'Chocolate Soy Milk', '3', 'chocolatesoymilk.jpg', '', '240', '70', '3', '0', '0.125', '0.29', '5');
INSERT INTO `foods` VALUES ('48', 'Yogurt', '3', 'vanillayogurt.jpg', '', '240', '110', '0', '0.005', '0.105', '0.32', '20');
INSERT INTO `foods` VALUES ('49', 'Strawberry Yogurt', '3', 'strawberryyogurt.jpg', '', '225', '200', '1.5', '0.01', '0.1', '0.3', '39');
INSERT INTO `foods` VALUES ('50', 'Non-Fat Greek Yogurt', '3', 'chobaniblueberry_greekyogurt.jpg', '', '150', '120', '0', '0.005', '0.06', '0.22', '18');
INSERT INTO `foods` VALUES ('51', 'Nonfat Yogurt', '3', 'plainyogurt.jpg', '', '225', '120', '0', '0.005', '0.15', '0.51', '18');
INSERT INTO `foods` VALUES ('52', 'Lowfat Yogurt', '3', 'probioticbananayogurt.jpg', '', '240', '240', '2.5', '0.01', '0.13', '0.42', '45');
INSERT INTO `foods` VALUES ('53', 'Non-Fat Greek Yogurt', '3', 'chobanivanillayogurt.jpg', '', '170', '0', '0.01', '0.095', '0.36', '23', '20');
INSERT INTO `foods` VALUES ('54', 'Banana Yogurt', '3', 'bananacreampie_yogurt.jpg', '', '170', '90', '0', '0.005', '0.08', '0', '16');
INSERT INTO `foods` VALUES ('55', 'Cheese', '3', 'velveetacheese.jpg', '', '21', '40', '2', '0.001', '0.32', '0', '3');
INSERT INTO `foods` VALUES ('56', 'Parmesan Grated Cheese', '3', 'parmesangratedcheese.jpg', '', '30', '20', '1.5', '0.005', '0.085', '0', '0');
INSERT INTO `foods` VALUES ('57', 'American Cheese', '3', 'americancheese.jpg', '', '21', '70', '5', '0.02', '0.27', '0', '2');
INSERT INTO `foods` VALUES ('58', 'Low Fat American Cheese', '3', 'delideluxe_americancheese.jpg', '', '19', '30', '4.5', '0.015', '0.3', '0', '1');
INSERT INTO `foods` VALUES ('59', 'Mozzarella Cheese', '3', 'mozzarellacheese.jpg', '', '28', '80', '5', '0.015', '0.2', '0.025', '1');
INSERT INTO `foods` VALUES ('60', 'Borden Cheese', '3', 'bordencheese.jpg', '', '21', '45', '5', '0.015', '0.29', '0', '3');
INSERT INTO `foods` VALUES ('61', 'Ground Beef', '4', 'ground_beefroll.jpg', '', '112', '340', '30', '0.085', '0.075', '0', '0');
INSERT INTO `foods` VALUES ('62', 'Ground Turkey', '4', 'ground_turkey.jpg', '', '112', '150', '8', '0.08', '0.095', '0', '0');
INSERT INTO `foods` VALUES ('63', 'Beef Burgers', '4', 'beef_burger.jpg', '', '113', '290', '23', '0.09', '0.085', '0.31', '0');
INSERT INTO `foods` VALUES ('64', 'Vienna Sausage', '4', 'spam.jpg', '', '56', '180', '16', '0.04', '0.79', '0', '1');
INSERT INTO `foods` VALUES ('65', 'Chicken Drumsticks', '4', 'chicken_drumsticks.jpg', '', '112', '90', '10', '0.1', '0.16', '0', '0');
INSERT INTO `foods` VALUES ('66', 'Chicken Breasts', '4', 'chicken_breast.jpg', '', '112', '20', '2.5', '0.065', '0.18', '0', '0');
INSERT INTO `foods` VALUES ('67', 'Chicken Wings', '4', 'chicken_wing.jpg', '', '112', '220', '17', '0.105', '0.19', '0', '0');
INSERT INTO `foods` VALUES ('68', 'LowFat Chicken Breast', '4', 'chicken_breastinwater.jpg', '', '56', '45', '1', '0.025', '0.26', '0.14', '0');
INSERT INTO `foods` VALUES ('69', 'Light Tuna', '4', 'light_tuna.jpg', '', '56', '45', '0.5', '0.02', '0.18', '0.11', '0');
INSERT INTO `foods` VALUES ('70', 'Tilpia Filets', '4', 'tilapia_fillet.jpg', '', '113', '100', '1.5', '0.05', '0.025', '0', '0');
INSERT INTO `foods` VALUES ('71', 'Raw Shrimp', '4', 'shrimp_raw.jpg', '', '85', '50', '0.5', '0.125', '0.64', '0.22', '0');
INSERT INTO `foods` VALUES ('72', 'White Eggs', '4', 'greatvalue_largeeggs.jpg', '', '56', '70', '5', '0.185', '0.07', '0', '0');
INSERT INTO `foods` VALUES ('73', 'Brown Eggs', '4', 'farmhouse_browneggs.jpg', '', '50', '70', '5', '0.185', '0.07', '0', '0');
INSERT INTO `foods` VALUES ('74', 'Liquid Egg Whites', '4', 'liquid_eggwhite.jpg', '', '46', '25', '0', '0', '0.075', '0.06', '1');
INSERT INTO `foods` VALUES ('75', 'Pinto Beans', '4', 'pinto_beans.jpg', '', '35', '90', '0', '0', '0.005', '0.49', '20');
INSERT INTO `foods` VALUES ('76', 'Black Beans', '4', 'black_beans.jpg', '', '35', '100', '0.5', '0', '0', '0.49', '22');
INSERT INTO `foods` VALUES ('77', 'Red Kidney Beans', '4', 'kidney_beans.jpg', '', '35', '100', '0', '0', '0.005', '0.48', '21');
INSERT INTO `foods` VALUES ('78', 'Pecans Halves', '4', 'fisher_pecanhalves.jpg', '', '28', '190', '20', '0', '0', '0', '4');
INSERT INTO `foods` VALUES ('79', 'Almonds', '4', 'wholenatural_almonds.jpg', '', '28', '160', '14', '0', '0', '0.21', '6');
INSERT INTO `foods` VALUES ('80', 'Pistachios', '4', 'pistachios.jpg', '', '30', '160', '14', '0', '0.16', '0.31', '8');
INSERT INTO `foods` VALUES ('81', 'Butter', '5', 'SmartBalancebutter.png', '', '33', '60', '7', '0', '70', '0', '0');
INSERT INTO `foods` VALUES ('82', 'Peanutbutter', '5', 'wowbutter.jpg', '', '16', '200', '15', '0', '100', '300', '8');
INSERT INTO `foods` VALUES ('83', 'AlmondButter', '5', 'barneyandcoalmond.jpg', '', '14', '180', '15', '0', '100', '0', '8');
INSERT INTO `foods` VALUES ('84', 'Butter', '5', 'butterspray.jpg', '', '1700', '0', '0', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('85', 'Butter', '5', 'canolabutter.jpg', '', '30', '100', '11', '15', '85', '0', '0');
INSERT INTO `foods` VALUES ('86', 'Butter', '5', 'canolaolivebutter.jpg', '', '30', '100', '11', '15', '85', '0', '0');
INSERT INTO `foods` VALUES ('87', 'Creamcheese', '5', 'creamcheese.jpg', '', '7', '80', '7', '20', '125', '0', '2');
INSERT INTO `foods` VALUES ('88', 'Hummus', '5', 'hummus.jpg', '', '10', '70', '5', '0', '130', '0', '4');
INSERT INTO `foods` VALUES ('89', 'AlmondButter', '5', 'justin\'salmond.jpg', '', '12', '190', '18', '0', '0', '3500', '6');
INSERT INTO `foods` VALUES ('90', 'Butter', '5', 'lightspreadbutter.jpg', '', '30', '40', '4', '0', '80', '3500', '0');
INSERT INTO `foods` VALUES ('91', 'AlmondButter', '5', 'maranathaalmond.jpg', '', '11', '190', '16', '0', '0', '3500', '7');
INSERT INTO `foods` VALUES ('92', 'AlmondButter', '5', 'nutsnmorealmond.jpg', '', '14', '207', '15', '1', '56', '3500', '6');
INSERT INTO `foods` VALUES ('93', 'Butter', '5', 'omegabutter.jpg', '', '32', '70', '8', '0', '80', '3500', '0');
INSERT INTO `foods` VALUES ('94', 'PeanutButter', '5', 'omegapeanutbutter.jpg', '', '30', '100', '11', '15', '85', '3500', '0');
INSERT INTO `foods` VALUES ('95', 'AlmondButter', '5', 'onceagainalmond.jpg', '', '15', '190', '17', '0', '0', '3500', '6');
INSERT INTO `foods` VALUES ('96', 'Oil', '5', 'bertolli.jpg', '', '102', '120', '14', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('97', 'Ricotta', '5', 'ricotta.jpg', '', '30', '100', '11', '15', '85', '3500', '0');
INSERT INTO `foods` VALUES ('98', 'AlmondButter', '5', 'Sam\'sAlmondButter.jpg', '', '11', '190', '16', '0', '60', '65', '7');
INSERT INTO `foods` VALUES ('99', 'Butter', '5', 'wildfriendsalmond.jpg', '', '1', '190', '17', '0', '90', '3500', '7');
INSERT INTO `foods` VALUES ('100', 'Oil', '5', 'canolaoil.jpg', '', '48', '120', '14', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('101', 'Potato Chips', '6', 'chips.png', '', '28', '160', '10', '0', '170', '350', '15');
INSERT INTO `foods` VALUES ('102', 'Crackers', '6', 'crackers.png', '', '33', '90', '5', '0', '130', '0', '9');
INSERT INTO `foods` VALUES ('103', 'Cookies', '6', 'cookie.jpg', '', '30', '130', '5', '0', '65', '0', '20');
INSERT INTO `foods` VALUES ('104', 'Popcorn', '6', 'popcorn.jpg', '', '39', '130', '2', '0', '190', '230', '27');
INSERT INTO `foods` VALUES ('105', 'Coke', '6', 'coke.jpg', '', '35', '140', '0', '0', '45', '0', '39');
INSERT INTO `foods` VALUES ('106', 'Cheerios', '6', 'cheerios.png', '', '30', '120', '2', '0', '270', '170', '20');
INSERT INTO `foods` VALUES ('107', 'Ketchup', '6', 'ketchup.jpg', '', '15', '25', '0', '0', '200', '0', '6');
INSERT INTO `foods` VALUES ('108', 'Chicken Soup', '6', 'chickenSoup.jpg', '', '18.9', '70', '1', '15', '750', '0', '10');
INSERT INTO `foods` VALUES ('109', 'Bread', '6', 'bread.jpg', '', '40', '100', '1', '0', '180', '0', '20');
INSERT INTO `foods` VALUES ('110', 'Tortilla', '6', 'tortilla.jpg', '', '49', '140', '3.5', '0', '420', '0', '24');
INSERT INTO `foods` VALUES ('111', 'Cheetos', '6', 'hotCheetos.png', '', '28', '160', '11', '0', '250', '0', '13');
INSERT INTO `foods` VALUES ('112', 'Pizza', '6', 'pizza.png', '', '175', '410', '19', '35', '660', '0', '48');
INSERT INTO `foods` VALUES ('113', 'Margarine', '6', 'margarine.jpg', '', '85', '250', '11', '5', '350', '0', '33');
INSERT INTO `foods` VALUES ('114', 'French Fry', '6', 'frenchFry.jpg', '', '114', '350', '18', '0', '220', '0', '45');
INSERT INTO `foods` VALUES ('115', 'Ice Cream', '6', 'iceCream.jpg', '', '65', '150', '9', '80', '45', '0', '15');
INSERT INTO `foods` VALUES ('116', 'Candy Bar', '6', 'candyBar.jpg', '', '78', '320', '17', '15', '220', '0', '40');
INSERT INTO `foods` VALUES ('117', 'Cheese', '6', 'cheese.jpg', '', '28.35', '100', '10', '30', '230', '0', '0');
INSERT INTO `foods` VALUES ('118', 'Soy Sauce', '6', 'soySauce.jpg', '', '6', '15', '0', '0', '125', '0', '3');
INSERT INTO `foods` VALUES ('119', 'Cake', '6', 'poundCake.jpg', '', '65', '230', '10', '55', '135', '0', '34');
INSERT INTO `foods` VALUES ('120', 'Bacon', '6', 'bacon.png', '', '32', '170', '17', '25', '220', '0', '0');

-- ----------------------------
-- Table structure for food_groups
-- ----------------------------
DROP TABLE IF EXISTS `food_groups`;
CREATE TABLE `food_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cssid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of food_groups
-- ----------------------------
INSERT INTO `food_groups` VALUES ('1', 'Vegetables, salads, fruits', 'vegetables_category');
INSERT INTO `food_groups` VALUES ('2', 'Wholemeal cereals and breads', 'wholemeal_category');
INSERT INTO `food_groups` VALUES ('3', 'Milk, yogurt and cheese', 'dairy_category');
INSERT INTO `food_groups` VALUES ('4', 'Meat, poultry, fish, eggs', 'meat_category');
INSERT INTO `food_groups` VALUES ('5', 'Fats, spreads and oils', 'oils_category');
INSERT INTO `food_groups` VALUES ('6', 'Foods and drinks high in fat', 'junk_category');

-- ----------------------------
-- Table structure for goodexercisetypefordisease
-- ----------------------------
DROP TABLE IF EXISTS `goodexercisetypefordisease`;
CREATE TABLE `goodexercisetypefordisease` (
  `diseaseID` int(11) NOT NULL,
  `exerciseType` int(11) DEFAULT NULL,
  PRIMARY KEY (`diseaseID`),
  KEY `gefdType_idx` (`exerciseType`),
  CONSTRAINT `gefdDiseaseID` FOREIGN KEY (`diseaseID`) REFERENCES `disease` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `gefdType` FOREIGN KEY (`exerciseType`) REFERENCES `exercisetype` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodexercisetypefordisease
-- ----------------------------
INSERT INTO `goodexercisetypefordisease` VALUES ('1', '1');

-- ----------------------------
-- Table structure for goodfoodfordisease
-- ----------------------------
DROP TABLE IF EXISTS `goodfoodfordisease`;
CREATE TABLE `goodfoodfordisease` (
  `diseaseID` int(11) NOT NULL,
  `foodCatID` int(11) DEFAULT NULL,
  PRIMARY KEY (`diseaseID`),
  KEY `foodCatID1_idx` (`foodCatID`),
  CONSTRAINT `diseaseID1` FOREIGN KEY (`diseaseID`) REFERENCES `disease` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foodCatID1` FOREIGN KEY (`foodCatID`) REFERENCES `foodcat` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodfoodfordisease
-- ----------------------------

-- ----------------------------
-- Table structure for medical
-- ----------------------------
DROP TABLE IF EXISTS `medical`;
CREATE TABLE `medical` (
  `userID` int(11) NOT NULL,
  `heightFt` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `heightInches` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medical
-- ----------------------------
INSERT INTO `medical` VALUES ('1', '1', '1', '1');
INSERT INTO `medical` VALUES ('2', null, null, null);
INSERT INTO `medical` VALUES ('3', null, null, null);

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `userID` int(11) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`userID`),
  CONSTRAINT `ID` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('1', 'Rodolfo', 'Contreras', 'Male', '2450 Shidler', 'Alabama', 'Brownsville', '12313', null, '1996-12-12');
INSERT INTO `personal` VALUES ('2', 'Raymundo', 'Vilano', 'Male', '516487', 'Texas', 'Brownsville', '78521', null, '1996-07-09');
INSERT INTO `personal` VALUES ('3', 'Gus', 'Fring', 'Male', 'Los Pollos Hermanos', 'New Mexico', 'Albuquerque', '78521', null, '1996-12-31');

-- ----------------------------
-- Table structure for profilepicture
-- ----------------------------
DROP TABLE IF EXISTS `profilepicture`;
CREATE TABLE `profilepicture` (
  `userID` int(11) NOT NULL,
  `image` blob,
  PRIMARY KEY (`userID`),
  CONSTRAINT `ppUSERFK` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profilepicture
-- ----------------------------
INSERT INTO `profilepicture` VALUES ('1', 0xFFD8FFE000104A46494600010101004800480000FFDB00430002020202020202020202020202020203020202020303030303030303040303030303030404040405040404050506060505070707070707070707070707070707FFDB00430102020203030305040405070605060708080808080808070707070707070707070707070707070707070707070707070707070707070707070707070707070707FFC00011080258032003011100021101031101FFC4001E0001000006030100000000000000000000000203040506070108090AFFC4005810000103030203050406050805080807010001020304051106120721310813224161143251710915234281915262A1B1F01624337282C1D1E1171834436365738394A2B2D2F119252635455392A35567747593B4C2D4FFC4001B01010002030101000000000000000000000001020304050607FFC4003411010002020202010203060603000300000001020311041205213113412251F032426171A1E10614155281912333C162B1D1FFDA000C03010002110311003F00F7F000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000380385763F8FF00106D26A2AA9E92192A6AA68A9E9E26EF96799C8C8DAD4EAE73DDC908DA6236D4553DA0B83D4933A1975B50BB639CC927829ABE7A666C72B1EAFAA829DF035AC545DCE73D1ADC2E550C7F5ABB5FE95BF26D3B55E2D77CB7D25DACD70A1BADAEBE1F68A2B95B678AA6967897A4914F0B9CC7B7D5AAA8648B44B1CC4C2E28B9247200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000040E7A372ABC9AD4CAB9792227CD4236EBD6B2ED21A0F4E55C96BB4CDFCA7BAB1FB1ECB7393D919CF0BFCF30AC9153F532DF257A2E4D6B72621B14E3DA560A7E265E75842970A4B9B6DB6491DDC3D9498A599936D5EF29A693BCF68A7A98F08F6776F92296376E4735515A60B722D2DAAE0AC47B5826A1A88AA9D716D7545D5F955EFEB6796AA64F4DD3BDF8FC31E8629BDA59231D618ADDB4BE9CBAEFB8D352D3DA6EEE766A2A2085A8C964C7275553F851CEC2226EF0BD1111325575B386577B970835A5BE0AAA7A4A2D07C42D4B49A72AE9A8EA964A3A7D4372DF0D05D60A356312896BEA1ACA79D18E56C923FBC54DEAAE76CE1BB573E3DBD016F4379A28800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001C00C91B0C9283213B719F408DC1BBD024DC361B908ED08F7F9244D574D4E9BA7A88216A7DE9646B53FED2A0ED0B456D3F6959E6D59A5E99552A351D86054EA935C2918BF1E8E90C56E463AFCDA219230649FDD9FF00A62578E2F686B422A36ECDBB4DF761B362A917FE9DAA907FF70D4CDE538F8FF79B587C672727EEE9D74E2AF1565D6D61AAD3B4ADADD3B6CAB7352BE6A4AC4656D553FDEA7595B1FD8B24FBE8DDDB9396EDAAA8BC4E5F9FACFAA47FCEFF00B3B3C6F0535F779FE9FDDD4CBBD268FB65CF40C56CA596D54D79BFFD4F799EAAB6A6A55CAD6EF472CB54F77BC8898C2275E792FC4E47D5839783E9CE9B43885AC29686865B858A9E245D1B1C17C82DF1272AC86D2BED3534EED89E259697BF6B7AF8950E8434261975E754C9356D3DD6D9768A1A7ACA586BED5511C6AB03E8AA236CB4FDFC71AFDBC4F8DC8BBA3DB247D511E9E024D2645A9FEB164915444B47510B58F9E254EF639124E4C9E8EB23448EA61763AF85EDF7648D8F456924C359F197532D0E80BD5CA06EE5B0C747A9E9AA1136B22ABB3DC29EE7492C6E775724D4ECC63CBE664C7F2C597E1EA9A3BA7EF3A6E5ED83DE389FC3CD3F55250DEF5A699B5D5C0B8A982B6E14D1BA9FCFF9D65D883979CBB50ACDE16EB2CC69EAE9EAE086AA9268AAA96A626CD4D534CF6C914B1BD373648E4665AE6B9151515179A1313B5661528B94C92390000000000000000000000000000000000000000000000000000000000000000000000038C80C846D67AFD4362B52EDB9DE2D742FFF00E5D555431BFE3EEBDC8BD0C56CD4AFCCC32571DADF112B7DB75AE95BBD4FB1DBAFB6DAAA9FBB0B266A39DFD5476377F672457918ED3EACB5B064AC6F4C9F77A19989C81C800000000000000000000000000000000000000000000000000021CF5E5D08D8B7DCAF16BB353BEAEED5F476EA66759AB25644DF922BD532BE8856F96B48DCCAD4A5EFF10D397CE3FE8DB76F8ED30DC7514EDF77D923EE29F3FAD3D46D5FC5B1B8E5723CDF1F17DF6E9E0F119F27F06A9BA7687D5D54AAB66B259AD51BBA2D6F7D5B2A72FD245A667FD838D97FC4D699FC15F5FAFE0EAE3FF0ED23F6EDED84D671878A732AAA6A6F676BBFDD52505BDA89F272C2E7FE6E342FFE21E4CCFA96E53C171BF263B3F1478A3E2476AFBAA73CF83B867AFDD890C16F3FCADFCB34784E347D96C93899C447A223F596A145CF3D956F67FDCC14FF005FE57E6C91E1B8FF00924AEB7D7D33D5FF00CB6D5A9C93936EB5AC4FC992A27EC305BCDF277FB72C91E238DFED84876A7D5AE5574FAB7543F77BDBEED5EECFCF74CA61B799E54FEFCFFDB2478CE3C7EEC2867BA574F95ABBBDC6A1AEEBDFD5D43FF3DCF531CF93CF3F369658E061FF006C2D32545146E573911EE5F372AB97F3530DB99927E59238B8E3F7616E9751525322A37BB6AF92E13F7949CF927EECF5C155926D7AB1E5BDEB979F4452B392CC918A16497594D573A31A8AA984F797FBB0822649A2F751658757E8CB9C757E09E2B9BDF40F4F7A2923A789C8F62E530B9F81EC3C34EEAF2DE57F6DABF475DAEF47734B55C9EF95D1D6C14B23E55DFB98F9D91BD1FBBAE5AE3B159722CD834FA833A46C8E6236365AA6B8E9B6C70AE56386DF50FF00616272F2A47429E8864EC85EB49EA99FD8EE30BE64744DA96F7292BFC2C55E7267F451DFE7CC9AD89852D45AB567106F966A55B5CB70D0D4FA82D53EACA86D6C7252A5AA9AE30D4DD1AE9EAFD9A9B74D0C4E81B1EFE4AFF8273CD5F9DB0E4FC9E876ABE29D5BE9BEAFB7D9EE36E7CEDDB51513BE3491B1BBCA2581CE6F34FBCC7FC97CCCF6CFB6BD38D1F2EB36B8E13D1EA57AEA4D2D2BE3BABA26B2EB619563EEEB92266D6BE977AB523991BC958F5EEA4FD572F3C3F51B1D218BF04388B59C16D5B4DA7EE1593A709F53DEA3B1DD6D9528E6B344EA4AE7A328EBE364AA8EA0A1B9D4B929EB29DC9DD413C915546B1C524EA9B18B2357363FBBD434E86D351100000000000000000000000000000000000000000000000000000000000000000000719038577A01A8759718B4EE98924A1A1CDFAF0DCB7D9289E9DCC6EC7FBEA84472263CD133F0E4A73B97E471E1FE32DEE3703265FE10EBC5EB88FAE751C8F59EE735AE864F7686D6AB4EC46E31B5EF6E2493D772FCB9723CCF27CC64C933AF50F47C5F118A91EFDCB136D2A4ABB9CF572BB9F8B9F3F35CAAAF53937CF69F997629C7A447C207D3C74B8735C88E6AEEDDC9AB9F9B71D05324D7DC6D1931575EE1B8382FC4BBBD5EB07E87B8D44B71A49AD9257D0544EE749253BE2F7A3DEB95562B7A22AF2F23D4F85E5E4BCF59794F2FC5AD23BC3B6A9D0F48E13900000000000000000000000000000000000000000000000010E4236B0DFF005458F4C522D6DF2E10504385D8D91732CAA9F76185B99245FEAA29833F2298A376965C38AF967558758F5671FEEF5EF9A93485125AA9B2AC4BA57B5B2D5BBCB31C0BF6517F6B7AFCBA2799E77F88F5B8C71FF3BFECF45C3F01BD4E49FF00868DAEABB95E6A56BAF55D5B72AA55CF7B5B2BE554F2C311EB8627A35110F2F9BC967CBFB52F4B87C7E1C51A884091C4889B738F82FA7CD0D29BB63AC42373A3E6DD89E9B513973C7914ECC910A65446A2734F3E9F993B5BAADB3BD11772ECE9CD148DA7AACCF959E24F027E262994E96D7D7A43E15772F2C10B442DD25D9AE45CBFDDE89FC2108E8B3D5DFA1811D97272F255274B451855C7562A2F291AD6F4F78B754E984D5EA5491CA8D991CB9E99F8968AA3B2182A167735CE7A267D7D49EA766576BA7677BDE48EE89F77D7A17A57DAB96FAAB73472C74169A1B6C6BF692356A646F9EF9511F85F2CA331E67B3F158A6B5791F216EF66A5AF9A829752C751BBED5F70A49246263FF98DEBF0CED553A73A89739AFA9B574515AAF54EE99B143FCA08678267E36A7B5DB69E17BBAE1177B13CFAFE19A5AEBC699EE89D6FA27C16CA196CD5F71A86E1CDAE919533AC8BCD558C95CAC8BFB2D4FC57996AD913EDDA7D0FA9ABE27C16BAAACAA8ECD2ABD6DF708A26CF2582A9CC56B2A7BB44CD45BEA9DF635B492E637B1DB9BB1C995D8A5BECC17AB31B771578517CADD41A4AC97CF1E8EBECDA4EE33496EBC50D9E9AE94AAA9536DA0BDD740DB74A94EFCC69136AB7B11119B70885E54895FBDA64A27B1D0491CADF0BB6EE46BF639776763972EF0AE72DCE7E58312ED05C74A3B0491D55E2F73B6286E767AEB45E69925740B70B77B2BD7D9EA1BCDB36C76C48D15BB9BB970A66A7CB1DDDABEC57C4FB8F13780F629EFB5AFB9EA3D1972ADD037CB8CAE57CD56FB4EC75055D42BB2E74B3DB66A47CAE555DD22B9D9E674293E9CECBEA5DB32CA00000000000000000000000000000000000000000000000000000000000000021CFA014B5B5F476DA59EBAE3574D41434B13A6AAADAD9638608636A65CF965915AD62279AAAE08D8EA2DDFB79F65EB7EA58348D1F13ACF78BCD654250535650B6ABEA05AB7BB643049A9561FAADA923D76A48D9DCC45E4AE43066E4463899F967C3C7B5E7F257EA9E23EAAD411D45B1B1B74ED239562A98291EAB52E4C616396A3C3E15E9E06A67CD550F29CDF3992DBAEBAFEBF93D3F0BC362AEAD33DA5AD21A0A7A74F0B5A8A9E4E44381932CD9DFAE3AC7D96FB8D5C54ED77C539E73E86285A618CC7A8A3F178BDDF813D92C5EF5A99CAD73607E55792617A72325258EF3E99DF65AA892A78B35D2D4B95F2AE9E9DB1EE5F770ACCE13F153D2F83FFDAF35E6BFF54BD2443D6BCC4390000000000000000000000000000000000000000000000087211BF6D21C40E2CC7657CB69D32DA7B85DD1364F58F557D2D22AF9783FA59133EEA3B09F7B3D0E1F91F2F5C3BAD7DD9D9E0F8AB66D4CFA87586E335CAF5572DC2F15B3DC6B9CBF693D43D176E3EEC689E16353A235A889E8789E573B2E6B4F697B1E370A98E3510B63E2863E6E6B531E69E873267DBA115F4A674F1E179FCB263ECB2864999EF6E442BB26AB7CB708A3F16E4F98DA34B3545F58DE5B93927C798DACC6AB75031C8A9BDACEB8E7F02769D318A9D48C4CA6E6A2A7AA73216E8C7EAF53C6E55447A7F57F852620F863770D6505344B9722397CF77EE2D18E651B6B0BCEBF6F8F3372E489CFCF1E6BE46DE3E2DA7D431DB2C4311B7D66ABD5F54EA3D3164BF6A1A955C3A96C543575F36579237BBA58E45CAF97C4E963F17927F75AB7E6E38F9B447FCB624DC10E3E51DA9D7EABE17EB2A2A08DAB24925751FB3CAD6B539B9F4B3B993B3A7DE6219ADE272563DD5AD1E4F05ADA8B7B6A58B555C6299D4FB2A5678DEB1BA2DBE347B576AB5C9D73934ED822B3A96E52FB8DB7B682FADEA2586E179A6AE9919F6B4160A58DEF96A5E9EEC9572B7C1044C54CED765CFE5EEA197163C713BDB5F3DE7E1B9E5A1D655704D2515B9DF5A5522ABAAEBF6C14B06FE68D62397C5B73E49D7D0EBFFA8D291A8722DC2BDA58AD2F052FD3BDD537AD5D456D9A455925929627D754EE5DDCF323A062633CB19C7435A7CB5BECBC78E8FBB24B3707387160ACA6B954B6F3ABAE14350B5B4CDBE3A1F60655A44B14553F56C5177523E267F47DEB9E8DCE71930CF95CB32D9A78FA4436857DCED1AA747DEA91D68B4C175D233C51CF4D4F6FA4A5566589350D6C4CA78D889DF3773555A889BDAFE475F85C99C95F7F2E5F2F8FD2D3A659A16FD62B4E8696F5BA9E7ADBB24B4B1B5DB72C6AB9D1A46A88B96EE5445764E9D6CE75BDB59F0D3553D24E26E9292B27893EB9A1E222B2964EEBBC8353432DB2ECF56222B1ED75DACD50F7E51515D518722A72764ECC7D7DAEEB76ACB5BDD0DBEB29A189F2621A59D163B64EECA6D63A38BC76C957EEBA977533DDEF5235555C536BF563BC63B64BACF4D7D5F2545BA8E6A2C56D3D4D7C8C8E38256317BF7CF36511B1B2047ABF963E089C90CB4962BB7DFD1C566ACB570AB884FA944EE6AB8AF5BEC92C7BBBBA88E0B15A225A88D5C8D55472A6DE69C95B83A18E3D39D9A773A7A1A64637200000000000000000000000000000000000000000000000000000000000815D85C6157F8FF302DB74BDD9EC74725C2F774B6D9ADF1355F2D75D6A61A48188899557CD50E631A889CF2AA0742789DF49A765BD02EABA3B26A2BB7146F14CE7C2947C3FA4EFE93BD6F87FF7C57BE928658B77BD252493E39E115536959B274F0AFB42F6ACE23768FD495175D6B779E8F4EC352F769CD016F924658ED3022FD935214544ADA9DBCE5AAA9473DEAAA8C48A2DB0B31CC6D9ABF0EB6C95892A48C7ED921963746F63B9B55AE4DAEDCD765172DE444C4EB4BD2752F5BBB0F7688ACD6764A8E0E6B2B8495BA9345DA3EB2D0D78A9915F5372D33039B0D4DA6A1EFCBA59ECDBA2744E5739CEA4F793EC32EF29E6B83AFC70F49E2B93F697782B6FF0B73F688D4C6EE6BCF9F33CCE9E876D41AB35AC54D0489DEB79E76F32D15526ED5B4FAD130ECC8A8AEF2EBE782D3447657437E649E359115BEBCB99929563B59BDFB33DE61838C5676EE4D972A4ADA2DC8BD1CEA57C91A74E79730F41E16DFF009A1C2F2D5DE197A9C87B07958720000000000010E7AFA010F78D44572AA35A9CDCAE5444444EAAA0696D5FDA47809A0E5969B55F17740DAABA05C4B6BFAE292AAE0DE59C2DBA8DF3556553A2775952BD96E92D1771FA45BB26506FEEF88176B8B98B8DB43A5B547897A2ED5A9B742DE5F323BA7A4B5C5DBE94DECEB432491DB6C1C54D408CC627A0B3DAE962767E0975BAD1CDCBA7F45FB398EE9FA72B17FE95DE07A3D1AEE1D718319F17774BA5DCEC7C51BF5F222FE64F63E94B61E90FA4BBB326A7A98E92E75DACB413E695228A5D69676369F9F247495565AABA410B7F5A67B107647D39776B4D6B5D25ACA89970D2BA8ECBA868E46A3995168AC86A58A8E4CB57EC9CABCD3D0B2B30C9B70419039C81C657E1FC7E00377F09FE205B2A6F966A35DB5976B5D23BA2B6A6AA18D7E3D1EE423709D4A5B350D864E71DEED0F4F8B2B29D7F73C6CEB2AB6DCEDCF445657D13D17A6D9E35CFE4A4ECD4AA5B347226E8E48DEDE996B9153975E6811ED16F4FEFFC3E23628AA6EB6DA2CAD65751D263AFB44D1B3FEF298ED9A95F995EB8AF6F8861776E27697B6A2A4150FBACDCF6C76F4DEDCFACAEC33F25534391E5B062FBEE5BB83C666C9F6D34AEA8E255F6FEC7D2D366CB6F9130F8A99FBA7913A6249D11ABCFE0D44F82E4F37CEF377CBEA9EA1E8F85E131E2F77F72D5CE66CF161AD445F87EDF9A9E76F6999DCFCBBB5A6BE168AB7EC6BB1CBE09F3F91AF696786395159CF1273CFF001D4D79B32B16AEBDB21556F78D4C144E98757EAB6B7AC8DC27964326988576B054F0B15513F4B3F896D0C664D4534D261AB2B9EF5F0A35155573CBA21085DE934D6AABCED5A7A296089DD26AC5EED31E8DE6A12C961E15543D9BAE378951DF79948C4FCB73973FB089369EBC21B2ED4EF2B2E6F5F8A4AD6AFF00DD5262559F6B7D5F0374C5637124B76C3BAE2A1BFF0080CD5C930C76864FA4F86BA4348BDB2D1693D3B76AD8D555971D51410DE9E9CF722B60B8F7D4AD56F4456429F9F35E971FC95F147A8873B91C3AE4F9996ED66BCE202D232829B52CD6AA08915B0D0D828EDF698D8DCF3467D5D042ADFC14DC9F39C998FB47FC34E3C2F1F7BD4CFF003F6C4AE94D557C7B64BE5D6EF78723B724974AC9EA5C8BF1CCAE5FE3A60D4C9E4735FE6CDCC5E3F0D3E21668B4ED8E8E45920B55AA295DD666D1D3F7AAABE6B22B77FED342F96D32DD8A2E49DCC49B1153667DD4C2274EBCBCCA7D4B2DD210C95AD672472AF92BB3FC27EC2DD98E71C6D49ED312E77A72E89E7D7D09ADD1F4E13A0ACA289D872C48DFD172A27EF3352DB474D1036C8FBE25535D89AE16E9ACB5D0C7D2A295F99A2DFB7CE07A395AABD32BF13B7E3ED35B399CEC5F85D69D5505D3435E9F3DBAB259AC95171591D4D2AF818F72F9379A7355C9E91E726136CD5F5141C63D27736B9B1DA356685D43A1EE31B5709DF55DCE96ED647F4E7B6E31BA34F59BAF3C2E48F8639F965357A8B3510C2F7F8DD54C63339F791D9E4635DAAF8F37A7D6D4D929F35D333DA7B89E8A818E9A5AB8EA7BB6C30474EC56F7F2CB508C646DEAAE7745E867C50D7CB3A7B67C01E1D3F85DC22D17A3EAD88CBBD35B9D74D448D5DC9F5CDD677DD2E8C6BFEF322AAA89228FFE1B5A89C90E9D2350E6DE772DCA5950000000000000000000000000000000000000000000000000000000000815D8CFA01E5976B9FA49748708EA2EFC3FE0EBECFADB893452496EBBDFA75F69D3FA72A9996C903FB87B56E75B0BBC2E82291B142FCA4D22BE39202B365E28F9F7E25712B5C716F53556ABE22EAABBEB4BED4BD5C95D7A99D2A44D72EFEEA8E9D9B69E8A145E6D869638E36AF36B50AEB69D69814B512FDF47B913A23D5CEC639B76BBAF2CF9E7D7E25BA897EDAF7B76C995C79E17F12CBC216D42A79AE08D259AE80D7B77E1D6B4D33AEEC6F5FACB4ADDA3B9C7122ED4A8811161AEA193AF82AE9259607725F7D391ADC9C317A6A5B1832CD6D0F646E7C50B5D75152DCED758935B6E9450DCED8F554CBA9AB226D553E57E3DDBB9FAA1E0F2F16696987AFC5C98B5625A2EF3AC67BC562C31C8AE8D8EC2FC0AC625E6E92CB9A41178A55DDE9FE64F453B2D926BA6B6A9B47048AF9DEBCD1ABD13D705FE923BBB17C0BD435747C4FE1D4ACCEFA9D5F68A691377DC9EB238A4E78FD072A1D2F171D72C4B9DE42778A61EEB274FDA7B28792720000002057633C9570073BBF767F2EA0625ADF5EE8EE1BE9DAED59AEF51DA74B69DB7227B4DD2EF3B618BBC77F470448BE29A6957C31C51A3A47AF858D72F203C93E35FD293325455D9B813A5A9D6999BA36EB5D6B0CCF59153C2AEA1B1C5240B1FE931F5333B9637D3A2E5A639B32D71BCC8E22F1FF8C5C559EA9DC40E24EAAD454756BF696496B5F4D676E13088DB2D17716F4C6319EE33E6B972AAAD7DCAFAD34D2D536267771B5123C7BADE4D5E6BCB6E30349DA95F52F5C26EFC3FCCB7536A5EF95579ABB3FA4AA648A2372832AE77C3E38E444D4DCA7A2EC6F3774F755392E7D4AE93B50C378AFB2D7455B69ACADB65445377CC96DB34B4AF649D7BC6C94EE639AEF545C93A43B51C3EEDD9DA77872F8296D5C55BDDFEDD1267EAAD768CD4B0BD3AA356AAE8925C636B7384482B23444E5D109D2BD5B86A3E943ED4554DDACAFD0D6F7AAE775BF4FB513F06D5D454AF3F57293A9474863B71FA47BB5ADC98D6D3711A86CC899DCFB669BD34E73BAF9D6DBEA71FD9C11A93A43566A0ED8DDA7351A396E7C6FD7ECDEBFF00C16E2EB1227A236C29429E444D53D61A86F1C54E226A2456EA2D77AD2FCD5F2BE5FEED70CFCFDB2A25CFE257ACA74C225AF5979CCD64CBFF0015AD7FEF423AA5032B9CC4C47F669FA31F87F7168A8A84BBD6B5367B5546DFD1595EADFCB381D421AF7432A54C2A8CA84E7DF469B64CF4F7FAF42B31298D32CB471135958EBADB76B1EA3BC5B6EF63AC65C2CD55154CDF613C2FEF5A9DDB9CAC7472AF8258DC9B246AB9AE45453065ACF56C61BC6DF421C3CD5F43AFF4368ED71451451D3EAED35417F4A68117653CB550B5D554CDDDCF14F51DE43F1F0F3C743C673BBC649F6F4FC38ACD219C3913089B111396ECF3C67D17E1939D6B7D9BF4A7DD42F457B719CAF4CAF918DB30B74DCB28E5E860B7A5D875DAB59023B9E4C175E1A8EF9A91B023D77F34E995E5F99AF30CFA69CBCEB36F89125472E57385E9F8751155BE188D25CAEFA86A928AC9415974A873B6AA52B7735BEAF7FBADC7AA97D447DD312DCB60E10DCA66B27D495EB4CAEC2AD0D1F37222F93E5772FC9A577EC6E2B5692B159226B68286047A7274F2B5257AF3F8B8AD8640D4647BB29954F34F34221094E7459EF159CDDD3E04ED297C955328CC735C103873D88CDA889942766A14AB52D6B79E3F852F12C56AFB532D6B23CBB7217EC696CA9BCB1BF7F18F523B1A58EAB5031133B93F31A469609B51A23972F4F8F5FF0022DD0DE98FDC35B53D331CF7489CBCB24F5565ADEEBC50AE95EB15BD1636F4EF557A72F917AD6749ED0B0D36B0ADDCB51532492391DCDEF72A6573D1117967A6110DAC38A6654B65AC36DE9DAFB8D2C4EB8D7C7336E15107776EA27AAB1D04723BC7513A7566E6A61ADC655173CBA1E8785C6D7B7139FCA89F4A3D474B2DEA2A5A25CB9EFA96D45439DD111AB95EA765C199DB03D655CDB65CEC5530F4B651C35902C5EF2494BABF4ECCD727CDB0CADF99786394FB85EE92D35FABF57D6B1F3E9CD0ECAD9A6753A656A27A68D66929E99DD1CAD5D912B93288F76DEAD5262AACCBD20ECDBD9C74E4945A2F8E3ACAAE0D53A9EF960B6EAAD2B6B63116CDA71971A48EB695F48D913755D5C2D97954C8D6223955D1C2C7223CE862C5A873F2E5DCBBD2898E46C3039000000000000000000000000000000000000000000000000000000000254B34703249657B228A262C92CB2B918C631A9973DCE5E48889D40F023B73FD2235FABAAEEFC1FE025F27B7E918965B76ADD7B689563AABE2A7D94F4367AB8D51D4F429E249268D77D4746B92155EF29B5E21E40C34A88C6B1913638DA9E16B5BC939FEB6509D2F12B846CA48B92A248EFD044FE109885954B13654C3628A162FC70AE255D25FB0D1A27346FAE42547353DAD328EDAD5F30959AAA2B6372ACABEE9FE498DC9945CA721F71B634B7185964D356ED3B59255D4FD58D7D3D34B0B51714EB2BA46339AFDC6B95A9E872393C28B5A65D3C1CBD559EDAB8E1A5E2F7A8AF7B9DD664A76393A79AEF69A9FE9B2D9FF003EAABC71B34F4D4B2FB1CD51DFBBDD8E48F0ADE5E8AA847FA6C9FE7E162D3FC51D376E9166AB8EE33CF23B74B3253E729D709CFC88B78DB696FF003F576D3811C6EE1A3B89BC3DABBDEA9A2D336FA0D5F6BACADB86A24928E9A18A9EA5B33BBCA87B5616A619D5CF44E7E84F1B856C776BF239517AE9F45960D67A4354D0C172D33AA34FEA0B7D4377D3D659AE149590C8DCE32D92091CD5F8753D0F6870BACB25DC8A4ED0E37122CDA8352E9FD2768ACD41A9EF769D3D61B731B2D7DE6F7570D15153B5CF6C6C59AA6A5CC899B9EE46A65DCD551139A815D4372A1BA51D25C2DB574D5F415D4F1D5D1D651C8C9A19E09988F8A58658D55AF6B9AA8A8A8B8C73069E7A76D6EDBF62E09699B868FE16DF2C77EE34DCA6FAB228E258EE149A562F1A555D2ECD6EEA759E9B66D8A92476E5915AE919DD2391D8E6EBC55E5D69EFA4C3B525BEC955A7AAB54699BC56ACB2BE0D4F7BD3D48FBB42C913C2D8FD91D4B6F7774BCD8B251BD7C9CAE410BF587587887C5EE227166EB1DF388DACB506B1B8D2EF650BAF350AEA7A46C9FD27B050C291D251EFE5BBB889BBB099C8EB29D35CF7D22F57AAEDF25F3E89FDC5A2A94B73D5DCD54212DCBC84254FCFCF25F6185F527B06E7732040E7613C4A5842AD8E66F4EA56463EABDD56AB51F946A2A731A153ED1CDC9F97A857685932A2FA2F5E641D9CBEA3A7C02527BE5F8A846CEF5DD7E6A11B46DEF5DCD1171EBC82769C8C7F9BB09E9CC25548E6C69E0E6BFA4A128BBC554E6E5E5FBBE056D5DC113A7A61D8DBB51697B0596CFC16E20BA0D38D82B6A21D11AE669B65AE4F6FAB7D5B6C57B593FD85EB3CCE4A6A8DCB0AE5AC93B95C39DE77C9702D6DDA1DDE072F5A897A88FAC8A3DCC77864476C7B245C391C9D5151DFB7A9E4EF4989F6F4949ED1E966ACBD430EE57BDADC273CE139A261728619967AB05B8EB2A4623BEDD8D5F34CA7EE30CFB646A6D4BACB746BDC6F7E517184FEE315A17AB4ED4DBB5C6AC9BB9B2592BE662AF3AA9D8B05337D5D2CBB5BF914D326D9BE9BECEEE91F1D76B7BC4956CDE8E5B2DA15D1C2EF49AAD7C6A9E8C46A7AF984BB176AD3966D3F4D1D2D9EDD4D6DA762619152B76A2FF5BCDCBEAE55531E975C1ED5DDB95551BB7053EE950BE6DBC939A79AA816A96B58D57B7D3C4EC9481432DDD8D6ED6B9392F22C281D74CAFBC99F20254B74E5CDF8F8996B1E94958EB2F8D6E3C6DE7E7CBC8690C6EB752358D5447B729FB49EA862F51A915F9F12732D154AC9517A45CABE5444F864BEBDB1F6D312B8EA8466E64326579A2F332D715A58E72C307A9B9FB43FED5EE91179A23726D5304B5EFC88DAD726A2B1D34A94F55554944F4C6F5AC91B03532994739F261110DBA70ED2D6BF2A21B3F87FFC9DAE926B85A24AAD535D0B5A9ED54745572D0D06EEA94CBDDEC964FF0088B9C7921D6E370BAC46DCCCFCC999986CE8EBB74CEA7A2A0A8A9AC5CBDF25435D1A46E4EAF7B1C9DE3B18E7C91A9CCE9D6B10D0B4CCAD978BDC36FA756ACAD7562FFB4BD9EEB531FD13139FEFE459867D3453EAAF3A8F50C715BA866ABEFBD874FDAA34C667AB7D74F71DC9F06311A923F7630C89EF5F0B55532D63D29BDB6DEB5D1FEDBC2AD6FA4ADAAAB27F25AE5053CA9CBBCAB48A4AA7CFE2F166A2A1372E7F4BA64B47CAB3F77B11D99AB7DBFB3BF03EA3746E5FF457A669DCB17BB9A7B453D3AE3F18CE963FD973327ED3789750000000000000000000000000000000000000000000000000000000010AB9100F103E93CED7F5F4F515BD99B8677492924969E2FF004B77EA17E1E8CA98992C3A6219539B7BC82464B5BB79AB1EC81551BDFB1D4FBAD0F10D894D48DEEDB992455545C73E6A89E1554E7E5EAA5E2899956C315454472CFB654A6A7EED2A5D0B1CAD83BDE51B26913C11ABBCB7B933E464FA56D7C23BC39DEC627D9B76FEB2F35FDA6364EC96EA97746E5CABD57A036A67C8AEE5248BF24076487411BB29E9D49D1D9492368A1C77A8C55F82F352DA46D03677CA88DA4A66C69CFC4E4429685A2554CA36B951F5752F933D63672F4F229F4E17ECBD43ECD123520A48DB8FBCF4455FC7915EB53B4AB7DA157E09E9842DD2A7693BC45456AAE5ABCB9FC93C9305A2B0899451A42C572408B4DB972F5A4924837397AAAA46E42BD10BFDBF50DFED4E72DAF53EABB639FEFF00D5D7BB9D367FFE09D84690CB2CBC5EE26D82AD2BECDC49E225AEB69E46BDB5147A9EF91C996E1CD72AFB561DFDA45FCB913D53E9B038C7DAEB8D5C6FD27A5347712B534179B46949A5A86494146CB7CB76A9737BBA7AFBEB29D7D9EA6A6963DCC89F1431313739CB1ABDCAE1D51A859344F6A5E3E70FF87F53C24D23C50D45A7B4454D4C959454340E892AE8527CAD4525AAE92B1F59434D2BDCE9561A795AD47AB9CCDBB9DBA7A9A68BF6B9373955EF73BBD73DD248AAF7BF7BD5D22C8F765CF5739CE55555CAAAE7392BD11B53D4F291B346B8C2E1CBF142F11A3B2ED4B2AC91B5CAB856AE1D9F8791294D74BB51DFA49FB89D2531AECA7E0566A39F08574E72DF8A0DA4DC9F141B4A0F07CFD49121ED6AAAF9978146EFB17A39117691A44CB14AEEF59727C8D6B9CC5C3955A9E8489B132A277B123472E7ABBA04AEECB6C898495FCF19C27AF3EA4691A4D750330BB9EF1D5289B474ED4CAAB9DF891A11B23819D130B9CA2AF32046FEED79EE5CAFC3A7E404944679382BB176A2F5E61641BD13D409A8F639AE8DE88E648DD923151151CD54C2B553A2F5F322DEE135B4C4BBEFD99FB55FD41359B86DC5EBFD4C7A39523B3E96D7B50E74B3E9F572ECA5A0BF48FCACD6E45548D954E5592993635E9242998FCE792F17DB73577F83E4A6BEA5EAC2E98A28A4736B1B3CD26D6B977C9B98F4737731F1AC7E0731EDC2B1CD5C2A2A2A2AA733C865C56A5B52F4583345C4D3B6662AF776BA46BBF4DEC47AFED35E634D9995432D74D1A7862633CF0C6B589F934AE95DA3F6744544545C73E9D17FB3D08EAB45F494F46471E171C979E7F3E8566ABC64DAD13D544D44545E49D0C56AB2C5D60ABBB237773E5E86195BE58BD45E73BB126D44F8F990B31CA8BBA2AAB77F5E7E122212B7BAE0E5E4ABCBCB2BF0FF00C8B0A596EED467BE89E5C97F0262A8DAC15D7ED8DC364F2E4866AC7A639B30CB8EA07789125557FA2978A4CA9F51894F7672AB9D24CA9CBE267AE2FB31DF24FD97ED2DA3F887AFDFDC687D23A8350B5B2775255D0D33969229179ED9EB9DB6962FEDCA8743078BCB93E21CFCFE4B1E2F996CDD67D98F895A1742D5EB8E205D2C9A7A929EAA8E8D968A69DF70AF7495750D87C5ECCCF67446315D2786672AED54C2753AF5F077A53B59C9B79AA5EFAAB5343A299411BDD75A575652CEDEF686F348AB51415517563E19E2CAA2AA7BCC7B51CD722A2FC498E1C42D6E56D411E9786AE7EF29ED5511D2C6F4FF00D697491D6EA1F0FBA924EF7472BD157A36363B77433D78F0C16CF332B66B5D0B6A863A3928E5B84F7859924EF2A6158E81F0B5151EDA4825DD2C787630AEF7BA997E95618A724AF5A635EEADD2B6D9A1B65CDB6EA68E148AB2DF550B219E35CAAC7222A7BFDEB7C4C54F9791967D7C31B2AD15A86A2A5B535EF9A4A9AE9B7CD512D439D2EFFC55ADE89CBF0432422565BB32D972AEBD40B50CB451582086A755DF6B5C894D469534ACAFEE68A2FBEF6C32C6AF9247611D235AD8DEEE6978863B2C950EA28214A2A54FAA5D76A99744FB040E91B71D2D4F73B54D76A475C1E8996DD6FC94AF9AA7C4AB4B1C5151AE1EE9D172FD98A25BC344DE65D4F66924BDD14943A860A98ACDAA29163DB4D5156C6A356E1412736494F708B6D426D5CB1CF589C9B98A4C0F4B3B2244EA7ECDDC26A77676D3E9D929E155E59823AFA9653AE3D62469D0C5FB2E664FDA9763CC8A0000000000000000000000000000000000000000000000000000000034F71F78A943C12E0E711B8A95D1C53FF2374C555CADF473B9591D65CE444A5B45039E88AAD4ABAF96085570B8DF9C281F21F6BB571038B3AB2E7EC4CADD51AC2F35555A9B575F2A5CC8E36CB5B3BEA6BEE772AC7FD953B65A892477354DCEF0B13C8D8C3C7B5FE14BDE2ACB7849C19BD711AEB59377B25BF4758AA6483506A8836ED9DF0AEE92DF697CAA91C932B137BE573BBBA78D7748AAEDAD5E863E14EFDB5AF9F7F0BBF13759E8A86CF3E85D09141F5052D5C7DCBADCAAB452CB03955F50E9DEBBEBE593EF4EFF00797DD546E189B7C9CF8229D63E55C75BCCFB686473932AAABB57E3C94F3D698997461C24CAABC915305522CC91A6797AE40A096B11FC91EF54FD4452F024C68E72E594EAABE4E7F3245C6282A5F8DEFDB9E5844C7EE292B6F4B944C8A244E8AB8C67D483B22EFB3D1718F815EA7673BD7AE54B2A83BFC2FDE09D2624ABF1EA13BD2A59BF9BB2B823497134E91CED6679CB1F245F4252912E5EDDB8EBD5102BB4995B2771C91565A6777D1AFC53CDA0ECE29EAE2A96EE6BBED133DE44BC953E3FB42A9DDE6E85EDE7BBFC09D09F41339F98F7735663E4BE45B42B37BD71B9DCFA2AFC894ED56D7A6DF7885B68525E7D489362CDF2C11B4A0EFF00E3827D0E3BF5F41E81B278B2E2770209A4639158995F51B5256C95FDDBB2BCD1539E48D1B4E82A53AC786FEAA20DE93D9226AE91B3A2397DEE69CFA12AAA19588A9E646D6DE91BAA5ABE846CEC92E972841D92D5C9FAC1543DE2A263213108565C84F54B597993A3A9DF639A13D4EA9AB36F6E1DE3639AAC7C4EC61ED5CA2A391539A735E5E663BC2F49D3D83EC23C70A8D5FA2AE1C25D4D5AB577EE1B5132AF48D654BD5F515BA46495215A27B9EAAB23ECB552471339FF00B349127248973E4FCBF13F7A1E93C772BEDFAFD7F6FCDDF1755C6DE48E6E338CFF001D4F33F4E5E827224CB708D1171CF1F031DAAB44AC1557E6C0BD79AF918D6D31CABBF778D5E6B855F78AECEAC56BAFBC95A8E544315BDB2D587576A246E5339E5E6619AB35588D4EA057BBFA4444F82A8EABED6C5BE2267C48BF0F42D1536B7CF7FEBF68BCBA27C0BC558E6CB1D56A156E5C8AAA9FE5F919628C36BB1CABBEBA65F0BB3EBE5F81B34C3B60B64D331D05C28E25714EA7BAD1BA6EBEE70249DDCF75913D9EDB02F9F7D5F36D8729FA2D557FC1AA7538BE37264F88F4E6F27C8E3C7F32F40385BD8534D5A5F4D75E295DBF9555CC5497F93B6B5929ED51BD3CAA27CA5455227A774D5E8AD7275F4BC4F0B4A6A6FEE5E7795E66F7F54F50EF8DA6CF6BB15BE96D565B7D15A6D9471F75496FB7C2C82089BD70C8E3446A73E7C93AF33B75A456350E35A66D3B9F9692ED2DC23BD71B3845A8F41E98D4AED23A9EA66A3BA69EBF7DA775057D04EDA88D95291F8FBA99AD744EC6EC6EDCAC7A26D5AE5A76AEA57C593A4BC53A28B895C07BCDCB4E7684B0DDF43DC92A98DB4EB2A274D4FA4F51EEE5DEC372A767D5295688D6EE63BBA57A3B2E6C726E69CDBE0EB3E9D3A678B47CFB67F4FAE34FAB2AAE3430596ED533B1CF8AED72BDDBE786091A9E19D3F9E4ED8D1BC97ECDAC55C7329D256FA8D636FD4D6CAFAC9E5A3BBC5AA6A23A88DD73BAC4AB534CE574CAC743453C28EA4448D53C4D8DEE7351177E1514C592BA5EB7DAFF00ABED6CABB050D63DB15324550B474F5EF5473BD9A64FB3825773DDDCC88FDAABD33CB9186D6668848D136BAC86ADD4F2F7ED85C893E5B9EEDCD5CB7394CA617CBCBC8B45F68B433FD1DC3EAC4BDDE7516AFAEA27D2CFAB2B2F9A7ACD4E8AFA68DED7320B5DD6E8E95119553D241142B4D0B5BDD42E4EF1DDEC88DEEB661865A069E07C7A7595D54EBA5651C5449A7F88B35A1AEADBE582F562B9AD650EB18E85F87D64D435FDF3EB225CBE7A6A87AB5553ADB6C7D74ECA69792ED55A42D9EC4B65BC5EF515753515B6A34A4D2CD6EB83ABAA5B4D49556F5998C9636D42AEFEE9EDDD0AAEC72AED552F48DAB69D46DED2686D314DA2F46E96D23468C4A7D3760A1B3315898477B253B217498CAFBEE6ABBF13A548D439969DCB2A2CA8000000000000000000000000000000000000000000000000000001C01E5CFD2C3C42B5587B3BD070EDD53FFB41C4CD636B4A2B7B71B96DDA7AAE1BD57564B9FF0077154C54717C55F2B71C914891E53F65D934CD87865C51D45A86EB15B2D097B8E9F54D5D4355E8CA2A7B7B529E28218B32544B52EAD7B5B137AAB53A7354F4FE3A9D30F6971F99336BEA1A8B5CF14F56F18AA69785BC22D2972B5E898636D2D1693B3C31475571858B86D45F1F4DB69E92991E892253AAF748AB99A499FD19725AD3A8F85F1D3AFBFBB06BE70FADBA32C5705BCDEEDB5FAC5AB042CB55BAB22923A572CAD5A88918DE72BE36F572A23739C74E787371715716FEED9C792D366A9EF234E726E7B97EEB79FE783813F2DEDA9A4A8A87F8636B6167E93BDEFC88594E91B1CA8B348F917E0A8B802A91D127245C7EAA260BC0A86C98F37227A122AE3A87FCD3D4AE96D6D337B9CBFD122953AB9C3BFF00949CC1D5352377E820551B58E4FF0076D09DA6A2C49EF336AFC7C895956C58F08ADF1639AA036B3CD0AD45C11FB9118D6F24212AF7B1A89E1E5263F0F425495ABDAA7A6991950BDE46FF000B5FF0F4C13A42DF590B77ACD0FD9C8D5C3B67AF4C8EA2A61A8DDB5CEF3F0BFE6898244DEF7D9EA1AE445DAF4CA79122F523B7B9C89C9246EE4FC10292A264F876D5C85A13FBDE7F87C4A4A5177BF975C10B7643DE65571C81D8DEBF10764B927F2FDB90AA91665CE539FC549D274824937B73CF2D5C9642647EF239ABEFB79A7EC2B22D75322FB5C7E85A05C1AB8C2F92F911A092454F97C4754E9CB1EAEEA3A9A4C455F8953481CE253BD246EF420ECE377C7913B3B21EF113A93B3B21EF79A11B4B73701788CFE17F16B426B3EF5F150525E92D3A89B95C4964BC225B6EB1AFA36191266F2E4F8D14E7737145AB3FAFD7DDBFC3CBD661EFACB3B3BD7B1F2A39637398AA9F7B0B8DC9F343C065DD6D2F618BF1428EA2BA9216E7BCCAE399AF69F4D886175F78A447B97AA7CCC1B6560B71D554B1EFF1F244F73E4552D7F5FAD604739A8F7226739FEE2C6D88D56A88A75739AECF92FF009FF90FA532B7D488585F7E63957C6DE5CB973FDC5E302B3996F96F09EF248E5F8E3C8C91C79FE0C76E44321D33A635BEBA9FD9F49E96BFDFDEAEDAE5B5D15454B199F3925898B1C69EAF721BB83C7E5BFC434F2F3F1D23F14BB4FA27B0DF15750F7551ABAE168D0D46EC2BE295EDBADC51B9F2A5A47FB3A2E3F4AA5153CDB9CA1DBE3F81C93FB7E9C6CFE7B1EFF0C6DDCEE1F7638E0E68BEEAAEE76DA8D737562A3D6AB54B9B35223D3CE3B5B1129953FE792554F27791DCE3F89C38FF008CB8DC8F299B2FF087696968A968A9E2A3A2A6A7A4A481891C14B4B1B628A362746471B30D6A7A221D28AC47C39B3EFE5518E582444042ADCF9814D57454B5F4F2D25753C1594950C58E7A5A98DB2C32B57AB648DF96B917E046A0F6D46BD9C7B3E2DC1D775E0570716ECE7F78EB9AE8BD39ED4AFF00D25A8F62EF15797E911D213DEDF9BCD8ED78FA7AEE32D6D82CF4D051D5E85B15AED76CB2533194F4B596CB85125C9F052247B638AA6295F2B98C56FDA311E888BB551397CB8FC53A875389EEAEAE3EE71B98B6AAAA8F666B1E8EF63B8ED82462F2DC8F865C657D5BBBE3E668756E6D94E9FA4ACA6631D6EA8FE6A9E2735CE59A1C655571D76A2BBF0F42D5A932CDDD534956CEE6E73CEE6B63F0A5BEAE17AA227BCD753BB1347E78C35539E73E465DB1E965ABA34BAEB0A6BF69DA74A0FAD23A7B6EB0A3AB8DD17B4474B1775417BA2AA8F77F3B86244A7923919F6D16CF1EF8F0EC9595674EFA766AE16B2E176A7D795F4FB2C9A6965A5D310B99F673DC511609AA63C2E159449DE4698454599CBCD1D0AE77F063F5B6872327BD3BEADE886DB4D10000000000000000000000000000000000000000000003800000E4000025BDC899CF444555F927303E50BB6F71F3FD3DF1E354EA2A1ACF68D21A6FFF006334223555625B6504CF6BEBE3C2222A5C2ABDA2AF76117BA7C71AAAF768E2D82BDB217F5565F6FA3D3D2F04F8756AD7F3DBF873C3FD51F55C366D3DA6916A7516AABBC8E895D73ABABEE9B0DBE3AA7E6592795659190BE363767833EB31C47D3D387927F1CCB19E3AD4D270CB4552E94E1D5DADDA420A9B8490DFF48693D90DC2B28BD9DEBDFDCEEA8E5BA54BFBD6358E4964633C489B31C8C3CCB5694F52CDC7ED79F70C82A3B0B5DE978132F11E9359A6A4D7D51A46938836BD1DA668D9258E6B23E992E351451DD64724D5D704B739F323A38DB1248C585A926FDEDF3F7E45A7D3A95A455D16A6825958D919ECED85E88E6B9A8BCD15339E78EA6BB26B6AD6D2C698DCAD5FC02C8963A744CE18BF302924A785CBB9AC62E7E04EC523A28DABD1D1FED427B09AC622A785ED70ECBC2A99DE37AAA1546D50D572639A283B23EFB080EC24C8BC97280EC87BDEBCD3F120EC93BB9AEDF0FA12AA53A456CAC7F2CF4509DA359B9A73CA2FEC274852D6337C2F5C736789149DE85AD66572325EBE0D92A7C51397EC2C208E5D92399D515773540AE7CC92C69CBC51BBA81768E5DD4F13FCD9C94292A399DB24CF5CF3440B427AC9E1CAA61550AE9285252A9D0E973D149D27AB8EF97CFAA7993D5553C926553F60DE873F2E5E84A76872BD3A6530B8250E69DFB5EB1AF4C6514AE85BEA1735994F2FF0245722F8517D7A129D20A95F77E213BD228DCE46FAA908DA6EEE9FB8A26252DCFC64225295E1092E932A04BEF3A96D27696B2E39955A255F4B1BEAE48E918C9A69EB1DECF053D331D2CD248E47355B0C516E7BD71F75A99CFE66BE5F866C56D4BDC5D0BADAE75BA2347545EA2A982F6FD2D6B8EED4B56D564F1D543451433F7AC5E68E573372FAA9E0BC8E3E9965ECB837DE3895656EAA7BF3877857D4E6CB7F6C1AE9A99D954EF31C97A298BA2FD98455DD7BD7AEF7F2773E65EB8E4EEB4C495376AB82D769A0ADBADCEB654A7A4A1B7D3CB5351348BD23861891CE91CBF06F336B1716F6F50D5C9C8AD7DCCBB79C3EEC3BC4FD550D3D7EB0ADB6F0FE8666A49ECB3B7EB1BA231DCD3751C3247146ABF07D4239BE6DCE50EFF17C164988ED3A70B91E731D667AFB766AD3D80F84B4F144B77D43ADAEF509FD32C753454703D73CF6C6CA47CCC45FF9F5F99D7A783C11F3EE7FE9CCB79ACD6F8F50DDBA5BB2FF0002B48AC525BB87B66AEA98B9A55EA1496EF26EFD346DC5F346C5FEA31A6DE3F1BC7A7C5236D4C9CFCF7F9B37A53525351411D2D253C14B4D0B76C54F4D1B63898DF83636223513E486E56BAFC9A73B9F7329FB4B1A729C80E40000000001E7B76C9EC9DA9F8B172A2E2AF08EBA8A9B89569B2B2C178D2F7A97BAB3EAEB4534EFACA7A1A97AAA369EAA095CBECF5396BA3554F1B51B85C39314599F166EAF39E5BA5DF4B552D8F88FA775E68FAC895629EC3AEAD5452D3C6F62F8929EE575826A39636FDD920A85639B872725C1CFC98B52E863CB1A56D3DC740D7FDAD05D348A6DE6E6C376B0522725C2A4E96EAF89AEC7C3618BE9CB345D72A3D41A66B2A9D65B4ADB75C5DE446B2DFA47867676DF2F2F95CA987B1F6BEF1E9D72E59646B5A9CD54B570CB1DB2443B95C2EECD3C4AD57576F9F5C5AA2E1AE8663D26AEB63EAE39B56DD614C2FB1B7D85D253DA61970892C893BEAB6E5ACEE5EBBD36F171DA99793F687A516CB65BECF6EA1B55AA929ADF6CB6D2C7454143471B62820A785891C50C513111AC631A88888886EC469A533B57928720000000000000000000000000000000000000000021DDCD7E0068DE28F68AE17F0937D3EA6BD7B45DD8CDEB62B3A36A6B1A98CFDB789B1C394E7891ED5C73C1AD9B974C7F2CF878D7C9F674D6F1F49769986591B63E1B575C2047A232A6B6F51D33953E2B147433E17FB7F89A5FEA9FFE3FD7FB377FD327FDDFD3FBA2B37D257A66AA46B6EBC38AAA467573E82F9154489F1C412D0C1FF7C7FAAD7FDBFD7FB267C5DBED3FD3FBB7D690EDC9C05D532C54F5376BCE959E5F0B7F94740F641BBE1ED546EA98DA9EAF569B34E763B35AFC1CB5768EC1AA74DEAAA34B8E99BEDA2FF42EE5ED766AC82B2245F839F03DC88B9E585E66D572567E25AB6C76AFCC2FBBBFF22EA6DC84BAA7DB678A72F07FB33F14B5550D4FB2DF2B6CADD27A72463F64CCB95FA56DB23A8A754E6B2524534954D4FF0085E49CC8994C43E4DB4EDC6CD4DA9B4DD46A2A2FACB4F437DA396F76E667F9C5032A58EAA8F0D56FF48C4C611C9BBDD4EA6D71662B6DCAB962661DDAED3163E325EB867A6B88D7DE125DF4A70A6DFA8A9E0B355D6B21B75CA286B22F66A197EA463566B6525635894D4F35547E27F72AB1351CD53A7C8F2159A6A21A58F89A9F72F487597674E0CF1BFB2A3FFD1559AD967A0BAE9367143865A9558E9AEEB7CA0A396A53EBCBA4EB255D4CB54ACA9B6D6B66955637ABF622776C6A726F9ED686ED6B15759ACDAD7567670EC2BA7E1D67511D26B8D6F4F77B5F08AC0F57A575BAD9A9A35A983DADFC9CD4B3D15456DC15AD6AA44EA8A7A7761FC930B243C9EDFB70C661AC6785ADF46353972F87F190971B97CD7F00205C2A74C8103A36B9396517D140A67F7EDE4D76E44F27F3029DCE6EEF1C6B1AAE3C4DE9CC2F08DB34A888AC91B2279B579293A565312B13EF2776BE626109E92E7DDF1263AA10B7544AF6E3395FF00AA52B939ED5E81277F8C6EE84E93A40F547734E9FB8B2A85B9CE39AFA89915322F256F93998235B18FC6F48BBC6BBFDDBF9A7A390B0E55131E1FBBCDAEF8A00593A7546BBAFEEFDE05EADDDE3A1A962A6523DAABFABBFC28BF98574826723A24779B39284A24723D8DFC94250AAED5E813B71B939AE42DB43B97F30C769F694F5F329238DFCBA9684690ACB84C12941DE2E729D4254B9DD2AE7E605DE2CF77CD0276A79D738C04272726A64890CFAF52824ABF394F8014CF796D095B8AABA42AA9E5F92FCF1C89DA593E90D1FA8B5D5F21D3FA66816B6E12224B2C93B961A3A3A64761F5B5F54A8AD8216FC579BF1B58D73B91132B43BFBA0F87DA4F83E96F7D132AB536BFBFABAD56DA9A1A55A9BCDDEA9D9475BF4C5A18AB2B18A99491DB911132FA99628D151BAF7F866A3625BB567B4435D354BEDB4AB475F25BE786D358CB851435117F4B450DDE06B292E12D33B314EFA157D3B666BE264D22337AF90F2D827B6DE9BC7E5FC30A1A8D612D5E528E257F54DEFF07E38F5EBFE270FE94BAD193D2D31CD5F552ED92666F7BBFA36AA2AF3F24F8AAFC0C98F05ADFCD4B6688F6ECC70DFB2D715B8912534D1D9A7D2F60995AB26A0D4D13E919B17ABA9A89F8A8A8763DD56B119F17A1D8E2788CB79899F50E672BCB63A6E22772F57F847C0DD09C1DB44549A6ED90CB78962C5D753D631B25C6B5EBCDDF6CEDCB1459F76262ED44EBB9D972FACE370F1E18F5F2F2DC8E55F34FB9F4DC3B7D7E5FF0091B6D744807200000000000000000855B95CE41A5B6E765B4DEE8A4B75EAD96EBBDBE54C4B4373A686AA9DE9F07C33B5EC5FC88D4262661A826ECCDD9F2A2A56AE5E0D70E56757A49B92C540D6EEF8A46C8D189D3C90AF485BEA59B474EE91D2FA468FEAFD2BA76C7A7287AFB258E869A86255F8AB2998C455F99688566D32BFED44E49C9094220390000000000000000000000000000000000000000010E40E9476A5ED5F69E115BEB749E917C376E2356D2BA34D8EDF4F646C8CFF0069A9DA8EEF266A2EE645E5D5EA8986BB9DCDE6D71C6A3E5BFC3E1DB24EE7E1E09EB1D73A86FD77AFA9BAD7CD5D254C8B3D5D45539CF74D33FC5239EB9CB9557CF270A3FF0027E2B3D1E3C71586BEA3BFDAE19B73BBC81CE54472C7B932B9F867E065EB2B4AB2E33CF2D6534F6D966C27BFDEB792FF006BFC847AF48965F4772AE7C6D73FBD4E5B5CD89511BCB92AE11BF8F331F544D23EEC8AC9ABF50695B84177D27A82F9A7EEB0AB552E165AE9E8A6CE7DD73E0737727A3B2864A649AFC4B064E3D27F5FAFD7CBBCDC38FA4478A3A55B0D2EBAA1B66BFB746C48DF2CC8CB75CF08ABD2B6998B13F089CFBDA6555FD237B173EF1F3EDCECBC0ACCFA7A23C30EDA1C0CE25ADBE862D449A5EFB7058E18ACFA976D3EE9E4C2243155B55D4EB955C377B98ABFA2743172EB773F3712F47437E994D6F250683E0B6828A4723351EABBCEAEA848D79634FD041430ABD53C97EB97AA67972F43666582B0F072C95F5F65BADBEEF689FD92EF67B9525DAD75491B24EE6B682A19554CF7324456BD1B2C6DCB5DE17265153996894BEA6B46D6E92ED65D9B69AEB7B81AB61E3570FAA2D3AAE9115275B7DCF32D05CDB13E5F17796BBB53ACF4EAE5454D91A908D3AFFC10D3FAEBB2C70968780372A9B0F1638D1A9B53DFF5170DB445AAA2AA96DB6CD373FB3B2B3536B2AF962492CD6382B193D648BB37CB24DECB4BDF4CE72B6651A545F7B3AE8CBEDC1BA938AD153F1B75F57D0CAB5BA8B57C0915B29A38DCE59E8347693EFBB9B55B295CEDBE16C93BB1DED44EB22BB11ED7793DDAEF8096BE0CEAEB3DE7465355D2F0E75BC33B6DB453CD24FF0052DEA85AC92E5678AAA673E5742F8246D5D32CAEDCD62BE25DDDCE5650EA23654774E995F9F5F30276EDA84E93A40ABF813D53D5255EE4FD62AACFA70F91B2613CFD4B44262CA67C28EF7792F54542C8497778D4DB2351EDF8F99130204C2AFD948E6AA11D56DA67B4491AA24CD5727E934AAAA847B6444563B3E9E6045BF961C992F0BC25AAAA2F2E5F225594D655362EA99292842FABDFC9A8A8BE8362D5361B3A2BBDD99B8767E258710BB1989DEF35555BEA8483BDF56AF45F1300B8DBEA5F148AD5CAB668FD9DED4F34CEE67E4AD4C01365CB55ED5C2779E244EBEA053D3CAABE1F8790150ABD7214942B8C60262106EC95DADA42B95244AF992840BCC282284ED2E34FB5550B2E3DE2F9846929F8763C82512BFCBCC84A5ABB18E5CD08EA84957655557F2244A55CFCC8DA50F5E78FE3FB88197686D137AE20EA1834F5951B1AAB7DA2E97399AF7535B68772324ABA8DA9E2DCABDDC71F595F86A79A913E93A7A2F60B4698E1A587F92DA4A1B6D2BE9E8A0BEEA1BC5F9EF4A5A582597D95BA8F57555231F50F6CD3AF716FB752B1F53592AB6968A25FB495314CAD0975969564170AEAE9EF1411DE297D86F115C1D0D26A2D4347BB294DA8A6A091E966B73D53ECF4EDAE66C0C62A7B7D4564CE931AF7BB629576E385DD8B7889C55D3D6CBEDF2E16DE19E9C7C0C8AC14135B165AB7506C46C52C168864A38696056A7D935CF62AA734623551CBAB9383F5BDCCE9B15E6C61F51EDDBAD1FD80B851638E176A5BE6AAD5F2B513BC81D2C16BA17FFD05133DA133FF00EA5453C3E189DCFB52DE5B34C7AF4ED168FE0EF0C340A46BA474469FB3D4449B5B5F1D3366AEC7AD7D477952BF8C86FE3E2E2A7ECD61A3939192FF00B52D91B57E26C30E9101C8000000000000000000000000000000000000000000000000000000000000000000000010E79E00EA8F6B2E3E3B827A176581F4B26BDD4FDE51E9D8665DC947122236AEEB2C7F792045448DAB84748A9CF08E3479DCAFA54FE2DCE1F1FEA5BF83C1EBBDE2E1717D75E2E3593D75D2E134B53575956F74924B3BD72F91CAABB9555DCFAF53C9E4BCDEFB97A8C78E2B1A8687BC7B4D4D5B9EC7B9EF6BD5EADC737E3E5D3CBC8DEC7F0BDA10C3414158C6BE68F0E45F7D89CD31CB38F3326E545FDD5094691C2F6EE5DBC97E29F12BA9912D97891A9DE536E891D94C3D329CB92A978C6C7DB5FAFD7EBFA50D45E2A5AE57629644FBC8DF0C89CF3D32B927E9A9DD216EF3CCCE8E622F870CCA6ECF25C978A6949B24D5554891B644AA929BAAF26F4723B7A3939FE9272FCFE18D8C548DEDAB96F3F12C338BDC7BE21718E8346D935E5DE3BFC7C36B65658B4E5D248D5B5AFA2A9A88E76C5592AB9526587BA6C6D72A22AB1111D954C9D5C7F0E55E34D4D48E48D91A6573CB9AFCF3D4CCC0F45FB1AF1FFB4BD253AF668E01D0693B956EADBCD6EA6B46A7D594B2CECD090C8C8FEBFBC3155E94AB4EDC366464F0C9FCE1FB58C91F2A300F4D75EEB4E10F614E1957DD754DEEEDC4AE2BF10DFEDF70B85EEA73ABF8977DA762A254D754395EFB5D82DEE548E289BF614D178236CB5122ABC3C1EBAF68EE275EB8C16FE395DB514B76D7969D4505FADF03649996BA6A5A777749A72DB4A8ED94F6E7D26FA2EED132F6B95F22ABDCAE03BB5DA7BB49702B899C20A8D3B60A9B8EA0BE6A86DBB51E9CB3D1D361FA5EE717DB7797AAB9BBB8E37D3B669E8E586147BE762AAF851500F31626AA6EF7B9AF5E7F9FF1FB00A9445444CAA93B5DC2BBF0C16DA3696AA518ED290EE613094B3B98A88EFCC9DADA5422EF6EECE4764244B035C99F75DE84F64242B9F1F864F1371EF11F2941DDA67742E46F2F25FEE27A898CABC61932617C9C48AB4DAE4CA3F912AECEE91DCCAE928366D1D52915312CB1E13DF6F89AA48A14CBDA8F6F291B8CFCFE04898AEEF111CDE4E6FEC50236BB7A2A2B9CC959CD15BC97E298FC53F8C8178B94C950DA5B8362489D5112F7AC8FDCEFA35EEE7544F2473915FF008E3D40B56ED92B557A2FE00576EC857481CAB90BC552B2B95E60973B95021C2F8BCF010A755545508EA2381D539889BB77A05B5E9315FF000021C8107E29CB9FAFE403AFDECF8738F895DA7AA28A27CF2320A78A5A8A895711D3C0C59257AF4C362665EEFC10AEF6756D1B0704B88D7F6B266D85D66A77F4AAD452368531E903B754BBF087F611B5A21B86D3D9968E9E14ACD57AC25746CF149059E9D94D0B7D1D5F7055FCFB84FEF29364B6A698A4D1BA2ED535BF46515C26A0ACABF68AFBCD1D15DAEDEDD3C6DD8C596E9474CE866481BE06C713B6B3C5E1DCAAE5AF64E93E9A6A07D442FB4DD237CF6DAF96F6CB7D64CF91DF5D4ED5896F75D1CC9ED2EAD8A9552969649B2949026CA56C3BA457D2D2B4437FF017881C33D0FACA2D47C6ED2BA83534542E63B4FBAD11B2BEDB45509EFD5D75BDC8C49DCDE4AC5749B59CDDDDB9E8DDB48B6BE57989D7A7B85C35E2A683E2ED8975270FEFF4B7FB5C737B2D52C3BE29E96A11BB960AAA695AC923761796530E4E8AA86CD6D13F0D2BD7ACFB6C842E872000000000000000000000000000000000000000000000000000000000000000000000000000024CB23226BE491ED646C62BE47BD708D6A2655557C86FD1F7D3E72FB497196A38B9C50D45A8BBD7FD514F50EB369A817C4C8ED948F56D33919CB6ACFE299EDF8C8E4CAF53CA73F2CE4C92F51C1C114A4342AD642E8B6B9DCB1B1BD3967F0F539D31EDD08F4C16BE8A7656B9D1B7091AB5CE7F9789B9C1BB8BF6516B2D6E923A1AA9DC8F4EE666A2F74BD637263763E28E43634C536505457F7CFE4EC363F133E29CB973F33245750C537533EB1889CA5C6FCE58EF252D15629BFEBF5FAFEAB1D55623A4E691BFE0F6F27219E28C33745055B329957AB93AE5D8E45BA29DD41A86BF7D248D8BBD6BD917BDB9553922E391931D7DB165B7A695761BCF39DCFCB8E8D23D39D795CA344DA9FB10CBA626F2E0171E752F66CE20B3891A56DD6ABDD73F4DDDB4C54D8EF8E99B47530DC991BE19255A7C3D7D9AAE0827DB9F1A3163CB776E4686BBE2071075A7173595D7885C4CD475BAA755DE953DAEBAA951B1C50B573150D15331122A4A587A47044D46353CB72AB86862DEDF49078594EDE5C918899CF2C26E1D43EB2AA970B1D3430A67939C89FB953E23A8E3DBAB70BF6F1FF6231D441EDB5A89CA56BFE6C1D472B7197A4D0E7D59FF009091362A98E65F0EECFE8AA60AABA542C72E7944FE7E9CBD02DA4973318EF1D1B3BCF712476D55FC1DCFF2C94EF0CB5A4CA5BE19A2F1C7CD8A9B91BE6A9E9E4445E0B51136647379E58EF34775FC90C9B853AB954CF254CAA8ACA26AA57B36E559C9725E65094F56CA88D7B763BC9C053EE969973957309574B953D731FC9DC97CC2559963D3C2EC84A0722B79E3205BA562C5277AC4F03D7C6C50253976B9266265ABC9EDF25023737761ED5C7F701571BD5F4E903D51522739CCF949D7F701412BB0C6AAF356BB0A056C5326D4F5F3026AAF9A05B696ABCD3E0A149B19E5D14AEC4B4CE7FC4764690B915514764A4A676AAFC0765E1511BBC3FB33CBE257BA51E1719CE13E3E5F8AF4427B23AAED6AD3BA82FAE46596C779BBB95DB13EACA2A9A94CFC15F0C6E6A7E6566C8D373699ECE5C40BDB98FBCB68748D12E1CE75DA46CF5AADF3EEA8291CF722FF00CF49111D8D3725AF823C25D373A526A0B9D76A9BBA26FF00AB269A46B9EBE491D9AD1DE563D1797591DFDC4775DB2E896D7A6D8B6ED2FA56D7A5247372C4A9A07D157BDAEFF78969A58E5BDCCD455EB5894B0F9ACC89820582ED799E81BDE5F2F4B6B8DDB95D35CEF16AD38C77AB29A8A96E55CE45F246DCDABEA9D1034EEA4E2D68AB64A8EB7C76ED41718D30C9282DCEADD8B84E6EBBEAE9AF7222E79E69D8DF4DB823A8D6B55C6FB9D754BEA2AF4A586E12BD118951759EBABAA96344DAC6FB4D4BD5511AD4C6D6B5189F758883A276BBD27186C157DD4773B15D68BBBF0B1D4755F58430E572AE8A1AD6ABA1FF00A272159A2CD9F65E205BEBDF132CFA8E0A87226E4A7AADAD9F0DE7B24A4AE96273D3CB75354EE45FF72E30DAAC912F797B0470EEFF00A5785D71D63A969596FB97126BA9EED4944CEFBFF75D1C4F8A82AE45A8869E6DD55DEC92B77C6D5EE963F2C19F0D350D6CF6DCBBDA9D0CCC2E4000000000000000000000000000000000000000000000000000000000000000000000000000075F3B52EAE9B44701B8917AA69561AC9AC8963A291ABB5CD92EF3C76C748C5FD28E39DCF4F9183937EB8E59B8F5ED9221F34378BA32199CDDFE2CE13F2DB9F5E87998A6FDBD5E3988858A1BC39F242D591118DF14BBF972CE31F897FA2BCE4852DC2FD23DB3C31B93DEE79E6BC8CD4C4D7BE4F6C7679FBD93BD91D97B636E515792FC53F23375619BED4DEDD1C6DD9EF6530D722FC3FC4BFD3DABDF4B7D55C625472E5CD765113A7E0668C6C36B28DAFEF373DCE457632A4E98FB29DB33BBCE6E4C2745098525D6A5569E4CF57C6AD5C27EAE0C9463BCB5539EAD91ECF5F337E9F0D1BABA2A9C227C706560DA1748AAEEF5DCD13A05B7B42D5967761BC9BE7802E4C8A1A74E7B73F17FF701CAB98E4CE155A9F79DCBFEC81027759E48BCBD7046C4CCB111170A9BFDD4C91B15712267C78DBD718FEF161716BA367B8D637F042A2AD2A7BB6BE455F0C6CEF1C889FA1CD7F34297964A46ECF72B803D9F34568BE185868B5268FD3D79D5D7DA18EF7ABEE57EB7D2DCA65AAAD624ACB7C7EDAC9121868A27329F6B1111CE639EA99760F11E43C8DFEA4EBE1EBF83C0AC53DB28D45D963803A9D92FD61C2FD374924CBB9D51A7D93D9E547631B98B6D960627FF00429A54F29961B96F198ED0EB16BCFA3AF87F728E49B416AFD4BA4AB7DE8E9EFAD8AFB42BCBDD5733D96AE36E7EF2BA45F99D5E379CBC7CB9D9FC2D27E1D25E21763FE3A70E9B3554BA63F95F64A662CAB7CD1722DC1AC891372C95342AD656C289FF0032E4F53B587CB62C93EFD4B919BC5E4C7F1F0EB139985722F2563D627B79EE6C8D5C398F6E3735517C9532756B922CE65F1CD67DA4491A3B927E665863D291DBE2CA727279E4B092AC63FC4C5DAAA070D9E68308B9F98156DB92A754C8112D6C72261C9D7AA0121F8DAED8B96AFDD02435EA8DCA2E153961C05441326FC2F25726008E54CAC9CBAA6E4CF24F87F0A57625B5CEC3553DDF8AE113F693B178B751D7DDAAE9ED76CA4A9B85C6ADDB29A8286374F3C8B8CF85916E5C26172AB844293296E5A4ECFDAEE785B254D4E9BB5C8E4CA52D756CCE95BFF39EC74D511B57FB6A566CAF54C6F677E252AAF834ABA2CF86A1B7B8B62FC176F75DE27E2C2BDD6EABB43D9B757B98AEACD41A428153EEC73DC2A97D39B289ADFDA4F75B43BB366B0CE29F50691A962FFBC74D7385533FA8B40EFD8A3B234C86CDD976A646B96F9ABE18E554F0D369CB7C9598F86E9AAE4A45FCA351DD310B9FFAAF50EFD8CD67756A35DE364B67815F8CF3DAACACC27E2566C965BA7B847C2ED255AC6D5C755AD751C0CF6A8ED5569EDD2B18995EFBEA8A556C51B1139ACB592772D4E6F7B509EE3603B5257C8C8996A8A821A34CB63A3B4D2555F9B1A2746EFA192D965663CFD9AE53B51796ECA2A2526762C77AD5B05BE91EED477B75B29D728B0DDEA69EC703D33D1B6BD3D5570BAD567AEDFAE606AFDE6AF42069BBD71F2C36EA75B769EA5BEDD29B38F67A59BF933657F9FDA50599B0AD5267ABAABBC95DCD5D22AAAA968AEC696BD716B585D639A9692B29F4C5B6672BA4B5E9685B6F8DEABC91F34F17DBCAEC79B9FEB82FA1AD2495F3C8B2D43DD5132F359AA15D23D57E2AE7AAE57E64C40873EAEE7CF6F5FC73E4581AD5915113CF288BEB8F8F4C6EC228194EA0B450ADF28ADFA6DCB769ABADD6A55A2B623EA9EDBAD45245ED7434E90EE599C951BB1DD6ECAAED44DC98289ECF557B1BFD1A3AF356DFF4FF001178F7679F46688B5D6C176A5D0974662F5A8562549228ABE955DBADB4AAEFE93BD44A87B7C28C622A3C8E8A4E47D10430C50C51C30C71C30C4C48E28A26A358C63536B58D6B70888D4E489E4648614E03900000000000000000000000000000000000000000000000000000000000000000000000000001D16FA43EB5F45D9DAAD59B91B3EAEB5452EDF36A32A64C2FF69886A72FDD34DAE17FECDBE716F156F595CF55F16FE6BFDC72EB4773B3196D63F2AA8AB8F2CAF533C518E7229FDADEAE7FBCB26ECF3FBDCB917EAC7364C75439C9B9DD39FF00813A46D46B2A39BD5531F975085B6A265456F45EA8BCF3CBF22F0A4A57B4AB7974F0AAF5FF0022503155CE45CE131F75792FE2565684FEE65AE67711355D249E16B53AF3708BC41F4ED3EDACABA07D2D74B04C8E63E37AA3D153E1FE58537F0DA2CD1CD498944CE5933B53EEE1AFDEE46E7C2AEE681656B5CB0A2ECC7C10251B15645CB93763EF3BFC02BB54633D4A4A502F9E7DD4F797E242513777BCBFD927427A3FD49B0A863FCB9951B3784FA75357F12740E9896359A9AF5AC6D3495D12FDFA4654A555635533E74D14A873F9F97E9E39B3A5C0C5DAF0FA286D722AEE76374AF57E53A78977613FB8F9C66CDB997D070E1D555F0D5B5DCB9E10D7DB62234A9DA8EC3931CF9A7C53D725E2FA44D6247C7D15AE73244E68F63B6B917E28E4E69EB832572CB1DF144C3AC3C65ECABC2AE31B2B2BAB6DABA4F593A35EEB5BE988A286A5EE56A63EB5A05DB4B718FC977A24D8E92A1D7E1F95B62F5F671B97E2AB7F6F2EB88DD8CB8D9A15F34D6EB3C7AF6D11A2BA3BA68D6C95132C6899474F697FF3C8571D51892A27E96399E9F8DE5F1E488FB4BCDE7F159293EBDBA9D5D4B5741512D0DC68EA286BA17399352D646E82666C5C2EF8A546BDB8F54F99D7C59AB78F53B736F86D59F70B639ADE4A8A983330CC24ABD5AA88E4DC9E5925540AD639555170BFA21297954F900455F25023EF2454C2A35D90226BB1CFBB7E5BCF92FEE03B99C2ED25C318B4A5AF513EDE9ACB56D6C5ED95D4573A8A56416CA56BD5923DF0D54D4F4543044ED9BEB2BA6DBB970D545736331CCFB4E999DAAE94334D3D13ADDA2AEED8667B63B750D65B1254639EAAD64306A886D54D5EC4CA224B4324C8EEAD454C29594332A5AB8ECD149496AD2547A52AEBBC2D74F4965A49A747657F9BDB6D93FB65C5F84556B5BB614C2BA59A289AF7A639DAEC52A6A6EAC9648DEB739A56C9F6914BAA61A49D39736AC34961928A3545E8D56CED4E9BDFEF2C7B4AE71D65F9CD492293573589D592DE3486D6A27FC64D3197A63CD6141D462772D4D6B73DF05D3595B28E78551DDCD7DF2AABA5CFC36D99FA7A08FE4B03BE63A89147A8ADCD56252EB2A26C5CD5EEA4D493419F9C7748EF0E4F3F765FF29EB28DAE151A8B494BB9B7CD59A6A77317C0EBA57555F9FB553CA9E49E92D8CE4BE540ABEB92349ECB14BABF85F41DE2C1A8342C8BC91DECDA661CE318C6DB63E8A397FE951FEB91A36B4DCB8E9A62D36E75BACB6A9B53E244A886DD2515069FD38933555CCA8A9B5DA69E16563D8ABC96A1923D179B5ED5E64F546DA4352F15B5F6A67B96E3A86A2969DFC9282D1FCD29DA8BF71158AB33D3D6491CBEA4F54B0057778EEFA573E6971FD2CCE57BFF0017AF8BF68EA246ECAAAFBDE69E7FC7E664AFC212FAF4E7FC74E59251B667A1F871AF7893756D8F87DA3B526B5BA3953751E99B7D5DC1D1B57FDE4CB4F1B9B1313CDEF546A79A836F49B845F44AF1DF58AD357713AF9A7B84D69951249289CF65FEFBB557CA8A866651332DEBBEB91CDCE159B9150226FEDDEBD1DF441F67DB33D951AB358F11F59C8D54CD236A682D141237CDB2454D4D2D5AE7D2AD02BDDDF1E16766BE05F0518C5E1970CF4C69AAD63163FAE9B4EEADBB39AEF79AEBBDC1F3D76D779B7BEDBE815996EFDBCB010880E4000000000000000000000000000000000000000000000000000000000000000000000000000000E947D2016F4AEECD9A96677B96CBDD9EB5F9F849569449CFCB9D41AFC98FC0D9E24FFE47CCFDD57EDA645CF3939FF71CEC70EB5A5606B977ED5E99544CFECFEFFC8CAA2295AE6B557C2AEC633F042DA576A775439AC731DB392724FC131FB084ED4AF5446AAB172DFD1FDFFB49D1B513515EF554445477272617C38F8FCC9F85259258AC1597DAA4A7A48564C2A324562726657F0FE306B66E456AE8F13817CBF6F4DA5FE8A994CD8D2BAB1A8F54F135889945C671B57D31845FC0D0FF0037332EE53C3D623DCFEBFED77B5E85B5599F25446F5A895CCDBE34F779F3C7C73FC648B669966FF4D8AC7A680E2FE9D5B65E63BC431E28AE586B95392366462239BFB32757C7E7FB3CBF96E1CD2D33F6FF00EEBE1AB51FE1F5C73F99D979F8AFB43073722F2456BB2A12A9DDDEAAE7CD79046D706F246A63A2046917CCAE9281177787F31D5298E5DA888BD7E248818BF99128957428BB93A955F4EE57625D3697CE37525CA466F874969CB95F1EAA9C993CE8CB6522E7C97F9C4B8F91E73CF65EB8BF9BD0784A76BBD8F965463708B8DAB8DBD71E5845F453C0CD9EEEA9B0566C6E1557C4FCE7F6154CC2F5056355328EFC076557364DBD3AA7CCBC5D1B46F891D8CA27F992696F9E3747223A2CE55739FF003EBFB445EF1F7F4C57A44B55F16F829C39E325965B76BBD394D5D5A912B6DDA968D22A7BFDB9E89E19286E4AD57E18AB9EEA5DF0BBA39B9E674F85E472619F52E672F814BBC3EED0DD9E752700F5150D3545726A1D23A81277E9AD4EC87B87CCFA644755D057D3A2B9B05553B5CD7AA35CAD92373646632AC67BAF1FE42BC8AC4C7CBC873B853867F83AF1B931B57AFDE6BBE5CF0753B39BA418661579B7E08595409C808B2C5EA98501E1FD2F9005CE13C4ABE69F875F9F22363655A78997EB3E937699B6B190316AA3A88EB2496A5E91AC7277AD923A17BFD8FBD6AE36CCE8DCE8D39B76AAE4ACC42772B7D0EBFD574753254C971FAD3BE91D24F0DDE265743239D9739CF8A64EAB8F2C63A0EB0865BFE99F52D350D551586DDA7B4B4B5D4CB495771B050C51556C77F48B0C8A8A8C72A72476D5C756E170A8EA9DB552D455BA674EE9EA2A645E6B2CB248B267E2B2395CF55F5C8E86D39F78BABA34A792E1737D367FD9A5AA9DD17AFD9ABB696D2932A4DDCB9EC627C931FB3034984B59A9DBE4D7BBD109D4250A77B272444647E7842054A3533CB18026F87FADCFA211E840E4CFED5F82AF3EA880641A73496A9D657382C3A3F4E5F754DE6A9714F6AD3D435570AB7FF529E9639245FC1084BD0CE11FD159DA4388094B5DACD964E11D8A6DAF7BF52CC95F78746BF7A2B2DB5D261CDFD0ABA8A75211DB4F517845F456F66DE1EFB2DC359C57CE2DDF61C3DEFD5132D1D9D2545F7E1B2DB9CD456AF9C7575150D5F86390536F43F4DE91D2FA3AD7058F48E9DB1E97B352A629ED5A7A8696DF491A7EAD3D2C71C7D79E7684320DA072072000000000000000000000000000000000000000000000000000000000000000000000000000000000003AC1DB32D0B7AECCBC5CA44455753E9F82ECDC7FC9B72A6B82FEC817E462CD1BA32E0B75C912F968BBA2B25955CEE6B26E5FF039B48D3B132C6A57B5FEE397C3F0FE3E65D085B23B6E1DCD31E245EA5B6A4A9E44DCBEA9EEA7C4B2114712F25C65ABFE3809885DED7666DCEE56FA19A76D232B6A994B2552A656263D70F7B5179724E89F1E7935F35FAD76DCE2E28BE48DBB5D6AD5D63D1B4D2D9B48688FABE8289AB4CB7AB8C69515358E6E1F2D54B24AAAEC2BB774FD5C6110E35BF17B97B9E3C531C6AB0A1A3D6768D74FA8573595BECEB8963821F63A8A7444C77F04CD739D863F2EDB8D8BCFA744C731A66FA9DBE618BC9513DAEB64A19A6756C7972D2D448DEEB7C4AF556EE4F161CC4E58CF3EBCB3832444B0CDE76B3EA5B7516A9B4D5DA2A9189DE37BCA799517ECE68FFA27FA67CD3E066C569A5B6D2E6F1A33D263EFFF00D74F2E36CACB1D74B6DB8C4B0D444E544477DF6F93D9F1C9E9B8FC88BC3E7FCBE2DF15A6254C89B7727C5326CB49369BA67D542BF75C51F90B38572011317AA81CB9555110085AABD31F895D266AAE89E88A98E7E42DF0BBD11EC1B2D3D1D77132E2E56B6A1F0D8ED6DCF55895F5752FFCDDB3FF00A4F19FE25B7E0AC3D4780A7E27A5295EC9F0E6B98EE48ABF1FE327887B684996B70BCDD9E7E5E446D4B59147786B5719CE7CF2576ACCB20A4BBA2A2235D9F9A9316574C9E9EBD8FC23A667A22AA219EB784AE2E7C6AD4C491FFF00522974285F5103B735B235CA99DC89F1F2E9F0F5292AF56A2E3170C34AF17742DDB45EA672D2C35EACADB65EE9D1AB5569BAD2EE5A2BA5322E32B1B9EAC91994EF227BDAAA9C953A7E339B38324343C870A32E37CF26ADD3375D1DA9EFBA52FB14515E34F5D2A2D5726C59D8B2D3BD5BDF43F18E56E246FEAAA753E91833C64A45A3EEF019F0CD2F359633DCABB9B5D8F4727A7C7A1B3166BCD195697E1E710B5B48F8744E88D5DACA68D51B2C5A56CD71BB39157A786821957F05E7E85B6C6DF9A7FB0DF6BAD4A8C5B7F00B5FD3779D3EBFA48EC5D7F4BEBB928F6FF6B0846CDBB23A33E897ED55A8FBA7EA18F87FC3F8570E95BA82F9EDD52D4CF3D915820B8C4F5F4599A9EA83B1DA1DDBE15FD0E9A06CF514D70E2E7136F5AD1637A4B25834A5132C744EDABCA09ABA59AAEAE78D7AAF76D81DCF08A9D56A8ECF42EC7D8E7B2C69FA065B687805C2CA8A7645DCEFBE58286F352ADC2265D5977655542B971EF7799F508ED2F1F3B7AFD1D974D1977AAE2CF679D23515FA16AE059B55E82D3F1CD5153A7EA1A8DEF6BED949BA49A6A19B1BE48E245F665CAA3520FE8E76B459E3BBA27B1CAC731CD7B5CAD562A2A39153AE7774C7993D99206B5DE59CFA649DAB28F6AB970E6A28DA9D502D344EE4AD5FC146D3A9129E262FF44BF8FF001FB88D9ED362A6A8AA9590C30C92492B919143135CE7B9CBF758D6A2B9CBF242769761744764AED29C42EE9DA5382FAF6AE9AA39C171B8DAE5B4DBE44CE32DB8DDBD969553E521132B6DDC2D11F44AF690D43DD49AB6E9C3FD0148F545A886BEE52DD6BD9EAC82D30CD4AF5F3FF6C4F994D2B377A05C23FA26F80DA3129EBB89178D43C57BB46AD924A49DEEB1D8B7357737141412BAB24DABE72572B5DFA089C8957B3D1ED15C3AD07C37B5B6C9A074769AD1D6A6A2668B4E5BA9681922A7DF9BD9D8D595FF001748AAE55E6AA11B6658087207200000000000000000000000000000000000000000000000000000000000000000000000000000000000000001AD38CB675D41C25E2758DB1F78FBAE80BFD044DFF8B2DAE7643CBD1EAD2B78F4B53F69F229724491F52D54E8F7265570B96784E6EB4EB6F6C3DEDEE65E52E7CB1D3FC4B69689556CEF1B9765179617CB921091B122E3C6EDC9D131E7D4834AD62222651179A734CFE08131098C7ED7B1CDE5854C2A7961739DC63C9A986C638BEE34DD5A335525446DA6AD6C6B352B530E959BE27B13961ED72F99CCBC7B7ABE1649EB1B645514B6BA175CAE1668696D35B72A69299D5346D6B5A8AB9F1471AEE46FAA7CFE263EADFECC424AEAB4B7D2B6E5510D75652F78CF6A8DBB51CD55CA2AE7EF227555C73E485E2159963B35DAAA3DCBBB1B79776A89CB961557F2CF332455AD972F48609A9EA296FF00024557451F7EC4C5354A2A3646AF965579EDCFF79BDC6DC3CAF90BF6B7B47AC7B3DF1234370A34071AAFF6FA18B40713AE1596AD2B5F0D4A3AADD5348EA9CFB5D1ED4742D9D9473CB13B73B731B9E5943B18EDE9E7A67DB4752BBF2CE7F33331D970F88634B476E4F34039648A8AAD5F984ED539F0FF001F10BC4B8CA205F68D8EC2E73852B64BB75D96B55FD4D73D51408FD8EB841455794EAEF675918A89F2479E53FC4387B523F83D47F87724779DBD04B5EBBD88D457E7098773FF0023C05ABEDEC76C919AB7DB32D8F6AAFC777C7E4534864143DECAA8EEF30ABE59F40327A785CC5E72395308A5204E9F53D0D99333D04B558EAF455E5FB0BC0AFB6F1134A5C1CC62B24A493A6D5CA60C9161799EBE8D237D4D2CED731C994DABF8175BECD47A935ACF0EF8D8BD170D4F2CF2F7BF05532E28FC4C769F9FC9AA74BFD1CBAA3B4A6ACB9717F54EAEA1D1DA2756CF04F6E4A162575DAAA2B7D3C76A7CAD81AAD8A3EF1F48E76E926CA67DC7753E97E2F1EB8D48FE7FFEE5F36F299E2793698FD7A87A3BC28FA3CBB2D70ABD9AB61E1F536B7BE53A35DF5D710552F3F68DE7DE476E99A96F8D73CD17D9F727E92F53A8E6CDE5DD4A3A0A2B7D2C3456FA4A6A1A2A767774F4947132186367E8B228D1AC6A7A22051538039C00000718EBCC0D23AF3B35700B89D3D4566BAE11683D4172AB72BEAAF335A69A0BA4AE54C2BA4BA52362AD72E13CE603AD57BFA30BB1FDDA4924A4D0B7DD3CB22EEC59B525EDC8D5E59DA972A9AC44E9FE1CB904ED87CDF44DF657965648D9F89D0B1AADDD0477FA6563F0B9F177B6F7BF9FEAB908D27B2FF41F459F646A356ACFA6F585D36AAAAFB76A5B83777A3BD8D69FA7A6093B4B6469DFA3DFB1F69A7365A3E0BD9EE13B79ACBA8AE57CBC35EBFAD4F72AE9E9FF0004891023B4BB21A3F855C31E1F336684E1E688D1A9B76AAE98B25B6D8F77F5E4A386373BF1508679B40600E40E400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000014F3C31D445353CCD49209E37C33317A39AF6ED7357E68AA247CB2F6BDECF97FE03F152F5639692A5DA52FB34F79D0D79D8BECF5D6F91ED57D3B654DC8B514323FB9999EF7B92ED6B2561A57C5A9743165898753AC7A6AFF00A96F74164B45B6AAE375B957C56DB6DBE8E2966A8A9A99E548E18628E36B95EE7397A37382910CB37D37BEA4ECE9C4EE1DD6FD4FC40D2B74D375E99EE995B12AC3327BDBA9EA62DF0CCDE7EF46F54F5CF230E599AFD9B3C7AC64FBB03B8689AAA473763772792A679AE3961179F34F8E0D5FAEE953816B2E566D1CD7ED92B708DF3679FAFE462BE697438FE37F0C4CB31668DB44ADF0C3B397CFD7998BBCB769C1AAAE974CD050239606AFA956DD38F155BEAE99D0E532ABD79F4F863099E5D4885E6161ADA5EF7739AAA8E46AA2B53CFF00BBE1D50B431DAD30C3AB18FE7D517CF9735E7B7E2B9EBE666AB9DC9BFBFD7EBFFBF929F4CE8BD41AFB55D8345E99A296E57ED4D76A6B25AA8E3E8B515727728F957FDDC4C472BE47AF26B3C4B86B554DDC0F39CC98F9DBE887B5AF65066B5EC5945C1FD174FF00586A2E0F69FB2DE74246D4463EE35DA6681692AA05FF008973A17D531BCF9CD23154EBD6350F3DDBF13E54177453391CD7339E1592261E8BE692313DD735792A7C50B44AFADAE6D5F0E7D0B6D8E61047D511DEB8525049C973F82811324CA6157AF409D0E556BBD3190B27B79F8BCD7FC0ACB2436270DEF4FB1EACB35523D6364B3FB24D95E4AC9B0CC2FE272BC9E1EF8DD2F1B97E9E57A0114CF6A22A3D70A88E4455F8F3F5C1F37CD4D4BE818EDBAED9C69FB96D726E9339E7CD7FFF0046ADEACB12DCF68BDC386337A7AB95739FF0302FA65ECBDD3B63CEE455C73E622A99963975BBC52A393C2B94F3F913A55A9AE172F62A9DCD6AAA2BB28E45F43256A89F4C82DBAE9DECBDC39CF6F54FCCBEB48ECB1DCABBDAD1F26E73933CF3C971D570BEB83361FDA60CF6FC0F66BB35503A87805C228DE8AC7D4685B5DD1ED5FD2B84095EEE98F39FAE0FAAF0EBAC35FE4F97F2A7796DFCDBC4D96072000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000438E790306E20F0D343F1534F4FA57881A72DDA9AC550F49BD92BD8BBA1991AAD49E96A2356CD4F222395BBE27A3B6AAB7385522636989D35970B7B2AF033839769AFDA1B44D351DF24CA4777B8CF5170AAA6456ED54A47D63E44832994DCC4472A2AA2B95170562910B4DE65B9B52E93D39ACAD53D9354D96DB7FB554A2F7945748193C79F27B372658E6F9398A8E4F254516C75B7CA2B7B567712F3538D9F47CC12B6AAFBC1AB82A4FCDEFD1B7D91AA8ECF895B417395531E8CA845F594E7E6E0EFDC3B5C2F33F4E622FFAF8FF00F8EB4681EC27C72D65779A9B50DAE9B86F66A655EFAED7F7C15524CEE88CA3A2A195EE9BE3973E36E13939796756BC0BCCFBF4EAE5FF0011523E236C538F5D947881D9F7D9EF15172A7D67A2EAE46D37F292DB452527B1D4B93953DC291D2CFECFBFA46FEF5CD7FC51CBB4A66E15B1FF0016C78FF334CDEA7D4B4968DD0BAE789D747D9B41E96BAEA0B8C31F7F570DBE2DCD823576124A89DCA90C4DCF2CBDC9E86BFD1B4CFA87432F91C54FDAB2FF0078ECEBC75B5542D2D6709388F3CBDE7768B4363B85642E7355570C9E9239217EEFD57296FF002997F26BC798C13FBF0BD694EC57DA57594B1368F8715FA7A8E472364B8EB39A0B332145E4B23E96A9C95AE4F3548E9DCA67C7C2C92D4E4F9CC51F13B763A2FA27F564D4F43355F18B4F455F337371A78AC9592C14CBBB28DA599D591BAA53099CBE28B9F2C72CAEED7C7FAF9FE9FDDC3CDE63BCFECFF5FECEEE7662EC3DC38ECE15926A96D74FADF887352C942CD5572A56D2C36EA79BFA78ECF6E49674A574CD4DB24AE96491CD5731AE646F7C6BB58B074FBB999B91391DD7DBFBF2A6C303E793E918FA3FEF3A6EF7A878F9C17B24D72D23749E6BE6BCD2169895F3D8AADFF6B5776A1A58BC4FA29DFBE599AC4FB172B9CA9DD736C7C32459E3353CBC9BCF7357A639A7A734F3F4F8F225754BB08ECAFE05A258ED1ED13BA2AE329F01B475532E5BB76F4276B6B49CF457B7299FE3E7CBF691B1321557E589C953973FF1225685D69D5F13E37A3B648D7A3A37AF547357737A7C17061CB5DC3252DAB44BBCDA1759C3A9AC54955DE2256410B69AE302F37C53B136AEEF47E3722E3A29E1BC8F066979FC9EE3C7F322F8E3DFB6671DF5B46E45DCADE59C6729F3F81C6C987DFA752B93F366F69D5F12ED8D92EE7A756A3B2A9E9E1FF1356D8A59AB959847A937311B9C2AF5531F44F716E8E97FDE7227A1DD432AF7DB9CE772C13F06F6C7A476C9576AF855DE45B5B5257DA4937B1AD7615ABEF67CB0BCFF0061B382BF8E1ABC8B7E197BD5C2BA2FAB3861C38B6AA616DFA12C144A9D31DC5AA9E3E9FD93EA786358EBFC9F33CD3BBDBF9B3D32B1800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004380870AC45FF14EBF984ADB77B25A7505B2B6CB7DB750DE2D17181696BED972823A8A6A889DD63961951CD727CD08B445BE489989DC7A5B74BE8BD27A26816D7A434E5934D5BDF277B252D928E0A36492631DECA9035BDE3FF59D9522B4AC7C2D92F6BCFE29647B3D4B29D61CEDF51A4A2C01C8002056A3BAFF001F3F881E7DF1F7E8D8ECE7C6F9AE17CA0B44DC2DD6D5F2495151A9342B228296AEA65F13E5B8D8DFFCCE757BD77BDD0A4133DDCDD2AA90B459E56F113E88AED15A5E59E4D037CD11C4EB63153D9A386A974FDDA4F2557D15D156863C7FFB93B3FB027B43ADF5FD81BB5E5AA59A0AAE086A973A2E6E750496FB846B8FD092DF5350C77E0A16ACFA5559FE8FCED777F9E3828F82DA8295CE445EFAF5516DB542D45F374B72AA81A98FCFD0944D9DB2E18FD0FBC5DBE54D354F1535DE95D036BDC8F9A874FA4B7FBCB93A3E34C252D142AA9D1EDA89513CD8EF742BB7A61A5BE8CCEC8160D3D4D64B970EAB357D5C795AAD47A8AF97A65CAA5EBC95CE75A6AE86089308888D862627C72B9551D933FF00465F639EF6493FD1ADC1637A2E299DA9351BA36E7CD15D5CB27FDB2260EC8A9FE8D8ECB56EA99AAEC9A7F55D8E59A3EE9C96FD4772923DB9CA7D9573EA58B8F54530E4E3D2F1ED9A9CABD3E1ADF57FD19FA4EBEAA9E4D19C4FD4962A4EF5BEDB47A8ADF457873A35F7FD9E6A575B7BBC72C2398EFEB1CFC9E2314FC3A38FCD65AFCFB79ABA9786BAA7835ADF51682D634A905DAD755BE9AB22477B3DCE86472BA96E548E5F7A1959F2DAE4562F8DAE44F37E4F85F4E65E9FC7F3A3352253E19F3B537AF2F538738DD4ECBB32BD5ADC2F34FE3CCC5F4D3DD17D6595C61533C9533FE457E9FB4F74A599BF897AD09BB20B3C5257D5D251D3B77D45654C54D1469E724927771A7E2E71BBC4C7DB2443439B93AD265F4456EA48EDF6FA1A08BFA2A2A486923E58F0C51A46DE5E5C90FA657E21F39B4EE655A5900000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000718F5038DBF101B500E70071803903900042ADCAE7F2F403ABDDA83B3CDB78E7A3F751369A8B881A6A392AB495E1E88DEF5CA9BA4B5563D30BECF52A9C973F67261E9CB735FA5CCE2C66A7F16E7079538327F078515115C2CF70AEB45DE927B7DDAD55B2DBAE743529B64A7AAA793BA9E0913C95AF4543C37278934B4BDE71F3D72562613D9599C63E7D4D29A361316AFCB1D3A0E89DAB22995FD5B8274ACD9BF7B37E9A7EABE3370FAD5B77430DFE3BCD5F2DCDEE6D6C7DC9ED7F3E8F48367CD7D4EAF88C3DB3C391E5B2F4C52F7953A1EF5E1E1C800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000102B72B9CA81E1776FDD3F47A5FB42FB6D032389BAC746DAF52DC628911B9AB4A9AAB4C8FD89CB3232898F55F372AF99E6FCB628EDFCDEA7C2E499A6BF2752E9D5646B5E99F12F3454C7CCF2F77A68F855AAA2735F915D255D4EE5CA657E047DD8AF3A7A55D80B43BAA2EFAC7887530AF73414B1696B5C8F4EB3D4F775956E6FE8AC713624F3CA48BD3CFD5780C1AED69794F39C8F8AC7DDEA227443D2BCF439090000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000043904FC3E7E7B6B6B54D67DA2B58BF08B45A420A3D1146A8BB9523B6EE96BB3C9113170A89FE488797F2993B65D3D6789C5D71C4FE6D074888C8234545F026DF7B3D131C9FF7BE679CBC7B7A38F84CDD95E5D3CB2416F4BA5BA0A8A99E1A6A78DD3CF513369E9E189AAF7BE59576318D6A7557395B82F8E936B7A6966BC443E837819C38670B7861A6349B9AC4B9C347EDF7F91BCFBCB9D62F7F599727BFDDAAA40D779B589D3A1EFB8783E9618ABC372F37D5CB366DE36DACE400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000873CF00755B8BBDB1B837C1EBB54E9DBAD65DF52EA5A377775D64D234D1D5BE8DFB51DB2B2A67969E962723572E624AE7B53DE61AF97958E9F32D9C5C4C993E21ABAC9F489F06AE350915CF4D710EC303B1FCFEA686DF530313385591B475D24E98E4BE189C6B57C9E19FBB3CF8CCFF00937EE85ED47C07E245E21D3DA478896BACBED4AEDA5B55C29EE3699EA1F8CF754C976A5A549DFF00AB12B9792E3A1B54E4E3BFC4B56FC6CB4F9AB79565653D0525557564B1D352D1D3BEAAA6A255DAC8A289BBDEF7B970986A22AA992D3A8996188999887CC75E6ED26AAD4DA8F535637ED751DFEE37F955F955DF5F572D5391738CA7DA63D4F0BCCCDBCD32FA0F130EB1D50B70D6A313DD44C353E46837BEC94BEF7CBA217AC3064BFCBBCBD88B842FD73C4176B9BA532BB4D680963AB89646F86AAF4EF150C0CCF254A6DBED0FEBCD234FBDCBD0787E2EED179F879BF2DCBD53AC7CBD9E6FBA87A979B440000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E99F6D8E31EACE11F0CE95DA4A1ACA2ADD597092C951AB618F747658121EF1FDDC994EEEAEAB3B6073B08DDAF722A3DAD3539792D5AFA86E70B0C64C9EE5E34D8387FC4ED5FA5F53F116C1A1F50DE748E95A0A8BD5FB5454B1B1B258E0CCD572D3CB58F89F719624474923699B239B8E78CA6EF3F970DF257B3D6E3CF838FAA6E37FC3DB0A6DE1D596F6BB6B29D25626D4C6D7A2393A2FC391C6B6F1CBA36AD6CC2274A9A4AA8AE145575105C29276D4D256D24AF64F0CB1AEE6CB0CAC5DD1BDAE445473151517A1B58F97356BDF8B5B7CB38AEE2BF19352DAFEA6D45C54E235F6CD227733DA6E9A82ED53492B15C8BB2A21A8A856CADFBBE2CE13967066BF94BCC6986BE33144ED70A587EC51889FD1A2350E45ADB974AB1A8D27772F675C111ED36F8647A2F475FF005F6A7B3E90D3342FADBCDEEB5B4B4B1F46B328AE7CF2C9CF6470B1AE91EEC785AD5537B89C79C9934E5F379114ACCBE843847C33B3709741D8F455970F8EDD077970ADDBB5F5B5F2F8AAEAE4E6ABE37F44555DAC46B72B8CAFB7E3E18C548AC3C4E7CB392D332D988984C19D89C8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000873E8042E95AC4739EA8D6B53739CEE48889CD72AA44C8E9D7187B5CE85D1CDAFB0E91A28788FA911AEA79E0A691A962A57F472575C1CD7326562A738A06BBCDAE7B14E5F2FCA62C5F1EE5D4E1F8CCB9663ED0F3078A1C45E27718AA1F26B7D595AB6B4FF0067D316791F4163A744F135196E85FB6456F2DB24EB249844F19E5F93E5F2DFD7DBF27AEE2789C3863E3F17E6D38DD2349131589B9F9E6EDCAAE38D6E46FECDF8A6BD2DF2E98833B58D8FFAAE6E30648CDB42856C2B1A3A26EC4577B8A98C6ECE5117E044E4178B4B3BD62B1DE19A15EEE785D9DCD7279AFA3BAE477525729689255C311729D3D57E08A867C51B6BE5BEA1EC17639E003786BA6175CEA3A3566B4D5B48D741054336C96AB53DDDE434DB5DCD92D4E192CDD153C31E3C0AAEF73E3389F4A9133F32F19E4B97396FA8F87769A98444F81D373510000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000815D8F2C81A278B7DA0F4270919EC97496A2F1A9256E69B4D59958EA9E6996BAAA672A474CC5E5CDCBBF1CDAC71A5CAE7E2C11F8A7DB738DC1CB9FE23D3CC5E35F696D71AFB75B6E9736D8EC155FD068CD36E7A2D4B3AE2BE64449AB7FAAEC47FF0F3CCF27CEF33972CCC57F0D5EA781E231E2889B7B975C5B49AE75037BBB7D041A76DB9F0D65778E55F5652B7967E6E4F54C724E5768D3BB58D323B6D8A968218ADF57745ADAC54FB599EE6EE91DE6AAC62AE3D319E46BDD96257E4B4D23111A8D55774CA735359293269E865455EE7089C95EA4B15A7DACF3E978D55DDDB3D308594995B24D3D87F7AB135658D36AC8D5D8E544C2F897CF97C797A96AFE4C56B3B7DD95B80155AD35350EB8BF50775A1F4F54FB4C4956CE578B840BF674D1B1D8CC34F261F3395151D8EEB6AE5CADF57E17C7DAD317B47A879BF31CE888EB57AE089C8F5EF308900E400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000059EFB705B5DA2ED724EEF36EB654D6A77CE4647986174ADDCE5F7532DEA63CB6EB4995B1D7B5E23F8BC07D4D59AA75DDF6B6BBDB5B0555DABA4A9AFBEDD51D23BC6F5573E28F96E54E8D4CA22743C172B3DAD69ECFA7F130571E2AC47E4B55C2874270F69FBDFAC25B95F2ADCD6545DAE7324F5B552AFBB142C67851BD1AC8A1667A75764E7EA7EEBCFCAE2D8F50DD6089D797D5698A49D11F150468D8EB9D1E393AA37F385CE4E7B36EE4CF8B0A566348F6A86C9A5F4CC352FB6D1D4575653514F71AD9B6C95B50DA6A6896A2AAA65EED1EB1B618915EF55C223532AB8CE3263C36C9F10D7BE78A4FE2F4AFD29A9A0D5B4CB5F6B8125A55CB597162B1D13B6AE1C8DDBD71D0C1930F5F9658BED7BACAB6EE6D3B1511A8B84765373D579AF5C18B489B2B2DB6CBA5EAB22B4E9CB55C6FF00769532CA1B4412554DCD7DE736245DAD4F373B089E6A89CCDBE3F0F2659D561A79F934C7EED2EE070A7B1F5C2BE7A7BE7161F1D1D0F29DBA42DD323EA265CF85B72AD81DB236E139C70B9CBFF11BCDA7A8F1FE03A6AD97E7F2FEEF39CDF33DB75C7FF6F41EDF6DA1B4D0D25B6D74B4F416FA08594D474748C6C70C31469B58C8D8CC2351110F4D5AC56351F0F3F699B4EE55C8984C7C0B0E400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000EB6F697A2D7F7BD2147A6B43D92BEEB1DF6B5D0DFA5B7B988F8A9A1623E389FBDCDC3257E72B9C26DC2F255CE873EB7B53558747C5DF0D3345B24FA8790FAF748F146CDA9EBF46D4D045A56B2D9DCB6E15B5724350907B5534758C6D3329E47C72BBBA99BFEF719F3C9E473E0B639EB68F6FA260E4E2CD489C73B85DF871C35B75BAFD14BA7ACD78E21F106A635486ED5512D75653E7C2F75053B13D9E819E4B2E11C89EFC89D1356983365B75AC35B939E987DDEDA776B47763ABFEA595975E2ADE9963A37AA49FC96D36E8E6AE7A75DB597476E860F86D85B27A4AD5E9DEE1F8088F795E6397E777B8C50CC389F70E16F0AF47EA4E15F0E749D9D2B2FF0063AAB16ADA981BBDD0D157D3BA19DB70AE915D5155532C33B918D9255EEF28ABC9118BB3CCE4E0E1E3E94AFB6AF0F066E5E4ED799D3A5DC3CD077AD6B5543C3FE195869A8A8ED71B22A996063A1B5DAA9D5CB9A8AD991179B972EE799647670D72E4F3BC7E2E5E564DCFC3D0F2B938F8B4F73B97A0FA2FB1EF0BEC31C155A996EBADEEFB1AEA87DD2A64A7B724C9EF2C16FA358D15BE93C92FF727AAE3786C18E2371B9798E4F96CD927D7A8765EC9A6B4FE9AA4F61D3B64B4D8E8FAFB2DA6920A58D57F49CD81AD472F9AAAF3F53A95C54AFC43996C96B7CCAF5B7D7FC4BA910889480000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000815995CE40D69ACB839C39D7D54DAED55A6E9EE15AD6B18B5714D55472B919C9BDE3E8E587BCC37C28AFCE130898C1AD97898F24EED1EDB7C7E767C11AC76D323D29A234AE87B725AF4A58E82C947C9644A48FED66727247D4D448AE9A772272DD2BDCEC79993160A638D56187367C9967779DBABFDA0F8E575D2B73ACD0F627FD552454F4EEBADF5157DA7F9D46D99B050370BB17BB7265E9B97AE11319399E479B38A26B0EE787F155CF1DED3F0EBBF0CF851ABF8CD5AEAF596AEC5A1FBEFE7BA8AA7ED2A2E0E4E53476EEF557BE7AF89AE957C2C5EB9726C4E2713C664E45FB5FE1D4F23CFC3C5A74A7ED3D25D1BA1F4CE83B2535874BDB20B65BE0F1BD23F14B512B9111F51533BBC7348EC7373973E4984E47ADC38298ABAABC766CD6CD3BB4B2D3331B900000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000186DEF879A1B52DCA3BBEA0D27A7EF3718A2481B5773A1A7A893BB4F758F595ABBD13CB7671E463BE1A5BE619699F252262B3A6534D494D470434B490414B4D4F1360829E9A36451471B530D8E38D888D6B5139222260BC4698E677F2A84E44A1C8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005B2BEEF6AB535AFBA5CEDF6D6BF935D5F530D3A2FF005565737204A86FB68AB4FE6372A1B83BF428278AA17FFB4E5C7CD40AF8E78E5556A65AF44CAB1DC9D8F25F901520000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000314D6DAC2CBA0349EA1D67A8EA7D96C9A6AD53DD6E12B5373D6389B948E367DE92576238DBE6E544F303CFF00BE71035C6A68EC97BE2B712F897C3BA9D7946B7DE1CF67FECF16E8EBF5A36CCA88EA6B95E6E09455952B24CCC39EC7B62891728DDAF49628C2E7A3F8DDAD7867351DF7525F7883ACF82B3EA9A5D13A9AA38B3A6DFA775C684BA5C1913ADF55709521860BADBE4591126931DE44AF6E3EE3650F459551115557089CD5540E94F681ED33FC99BA52F0DB8655D6FACD65728525BAEA16BA3AAA5B1D3499C6C44DD1C954E6A2BF0ECA46DC65AE73D3686AED1CCA17CFEDF73AFABBE5EAA57756DF6F52BAAEB6772AEE555965576C6E5570C661100DC315F25D297AFACD937FEA5B8DA60A75A862F8292A696599F2A547E83668E46B9AE5E5963915793721B1B496BFAFBBDE3DA686CB77BD5ADB4CFA792EB0B129E92391FB5ECDB3D5F751CCDF0E1DDD2AE328A9B97901BF21999344C9635CB1E99402701A2AE1C4ABB52D457451FB22FB34B3B188E8FAF76AE4445F17A01B3A7D49494360A2BDDCBEC7DAA929E6EE19CD5D34D1249DCC79EBE7F8730358D47146BDD22AD3C547045F758E457BB1EAE554CFE4804A4E265DD7A7B2AFCA2FF3033DA3D614B45A36AB57EA4ABA6A2A0A18EAAAEB2A588A8D6C10CCE63136F3557BB08D46A7373970899503A8B7FED8B2CB552B34DDA68A8E85AEC4135CF7CF52F6A7DE73637B23667F47C58FD25031CFF5BBD55FF23FFD557FF181B47853DA12FF00AEAEFA8ADF58DB6BA3B4E8CB96A18D69E1562B26A37C291EFF0012EE6B9245CA01ABD9DAF35536481520B2D566AA9A35A6581D1F7AD92A6389ECDCD7E5AAAD72E17C940ABB8F6B2D514970AEA567D50B1D3564D0315D4AB9DB1C8AD4CF8FD00A3FF5BBD57FF237FD557FF180FF005BAD59FF0023FF00D557FF00181DCDE10EB2ACD7FC3DB06ADAE8E18AAAE8FB8B246D3A2A46A94575AAA063DA8AAB8DEC811CBEAA06CD000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003AAFDB46D171BCF66FE21C56EA796B92DE968BEDCEDF0A65D536CB55EE8AE17262FC123A685F32FA300D57A6B897A17447697D7BACF5B5EEDD67D23C6AE1D68BBAF0735E5E1CCA5B32DAADB6E56DD6D0CB9CB88299F354C8CAA7472BD9D1BBB9BA2DC17EED3BC58E19EB4ECEFC51B7691D57A7F5B55DC2A2D7A22DD49A7AAA1B8A54DFAE75D04B6EA4A67C0AF8A791118EA84EEDCBCA372E72D03B23A9296F36BE145C28DB51DF5E6DDA35B4D5755B91BBDF4F44D656CC8E55EAAC6C8E4E7D40F302C9AD740EA8731D68D4BA5EE13BB08D8E5A9A586A39FDDEEEAFBB93F0C01D92D2D61B632922B856D15A1B44A9BFDAE6A8A4644A89D551FDF22720378690D5BC329EED0699B3EA3D1759A89F4D2552586DB5F43535EB0C288E9A5F6789EF7ED8D1515CBE4064FC53E235BF873A366D4D5542B708E9EAE8EDF0D0432B21748FAB9D224DAE7A2B51236E5EA9F045023E08EB86F12387F43ACE36AC10DDEE774486815AD45A38E92BE5A26D3B9CC55EF157B8EF3779EFE98C01B800E83DEEF49F5E5DA1CFFF0016A98FF3A87340D81C56D44FA6B8D92C5B95B0DAEC148BDDE7977B3468AE763FA8D62018AE84BCE9C75FABEAB58DC1D4769A1A7A74B552363965F6DA8955EB50F956163D5190235AD445C6E5767C940D8172FF0057ABBCBDF55D45C5AFCE7F9956EA6A46F3FD4A49A36FEC034DF6ACBE69DD37D9DAC143A1E7A9FE4EDE75D456E47CF3D74F23BBA4B8575432496E0F7D43BF9D419F12AF44C72C01E6F686ADD2379D6DA7E9388FA8EEBA7B87F12D4D66A3AAB23657D754F7517F34B7C4B03249626CF2AFDA3D8DCA35170A8B8503BC543A9FE8FEB7C2C8A3A4BC4F8EB2D6AEB3A891CB8C2AB9D2542F5F4E5E806E9E1E6AAECD97BB6F10E1E0C53AC17FA1E1F5DA6AEDD05DA172D0F72AD7ED75C5CAD77DAF779C73E807949A7EFB254DFEC34FDE2AF7D7CB7C7F9D6C407B5B73ECA9C08BB5DEBEF959A25E95F72AA7D655FB25EAFF00494CB2C8B97BA3A2A6AF8E9A2DCBCD5238DA99E7803C7AE28CF45A63899AEF4F5A18B496AB26AFBA5AADD4AB2492F754F4B5B243146B24AE73DFB5AD44CB95557CC0F493819D97F82BA8B84FC3AD537AD2D5F5F7CBFE92B75DEEB592EA0D448935554D3B6599FDC32E0D8588E7397C2C62353A22600EE5699D3364D1F64A2D3BA76892DD67B6A48DA2A36C92CBDDF7B33EA24F1CEE7BD7749239DE272F503210000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000029E6862A88A4A7A88E39A19A37432C53351EC7B1E9B5CC7B5D947239170A8BD40E9F57765DBDE9D8EB2D3C23E2352E9ED0D5B552573B85BC43D3745AD74D51D44AF57BDD676DC258AA6DECDCE73FBB47C8D572AF9740C87417665A5B36A7B26B4E22EACFF004857ED2AE924D1B69A3B25B74D694D3B34BB51D556BD396CDD17B52358C6A544D23DFE163BDF631CD0EC95EEDCDBC59AEF697BB632E96CAAB739FF0004A981D0AAFE1B80F9567257692D417AD337CA6EE2E761BA5558EE74B50C45745534550EA795AA8E4FBAF62A019D5BAF36D7B5A9251D0BD3F5E18953F6B40EEC763C9A09B88B78D430C14F05269BD273D339D0C6C8D1D5379AA82289AAAC44CB921A5997E590374F6D3D7ECA3E1AE9DA66CBB5D5FAAD1F13377BCFA4A295D9F933BDE7F303B61D9174E56E98ECF7C39A5B8B248AB6E76EA8D473472A2A39ACBC56CD71A64545E9FCDE68C0EC92AA2265792201E605EEAD25D4176AA8A5DD0BEF3535113D1792B16A5CF6AFE406C9E3643511EA9B757BF7B63BB698B6D646EE78556C3DCBD3E68AC0313D05A2AEDC40B95D6D76DB8DAE82AAD94B4F5CD65CE59D8EA986673E391F0361825CA40F6B5AFCAFDF67C40DA3FEAE3ADFFF00C674D7FD62BBFF00F8C0D13DB82CF70D0BD9BF87366BACF4935651F13B63E6A157AC4E6CB6DBCCF1E1656C6E55DAA99CB7A81E7C702386779E3D6BAFE42D8EF36FB2D4FD4D557975C2E4C9A585194AE89AB1EC83C597779CBE407759BF46F6BEFBFC4ED2A9FD5A0AF5FDEA806E8E13F64FBF70128B89DAAEEBAD2DBA862B8F0BAFB664A2A1A39A0563DD0254A4DDE4AF5CA2242A98C7981E4470FEEDED3AEF45D3EECF7DAAAD6CC7CEB6303EA240F9A5ED0179EE78E1C5D8F77F47C45D40DFCAE7301EFA76774DBC09E11A7FF97D64FF00FA31A81B9800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001E397D209D962B2B351D1718B86D6FABAEBB6A8AB6DB75669AB7C2AF7CF5D0D2B961B9D1EDEB24D0C3DDC91226E7BDA8F6239EE7A01E4C25CAB6DF2CB4F531CD04F4F23A19E195AE6491C8C5DAE8DEC726E6B9AA985454CE40F54F80162B8680D01410D6D34916A2D5150DD437A81FCA587BC8D22B650393C9D053F89C9E524B2275C819DDBB81FAABB4DF17ACB71D4B47576CE0470C15693DB2A91F17F2B6EBDEB65BA476A6BB0E7D2BA78DB4D255278563895B1AABDCAAC0EE6F1BAE1AC6CD5DA769B474B7CA2A2FABA56CD0D8E399224EEE46B626AB606ED6ED6F244F801A12B2EDC58B9C4FA5ACA9D73530CCDEEA4A7DB70D92357AB1CC6A223917E0A05CB47F067586A7B8D24771B556D8AC5DFB1F74AFB946B4F2AD3A3B32434B04A8923E495A9B11DB76373B955708D50ED4714786F16BAB1D3C340B152DE2D08E75A5F278627315111F4922A22ED6BD1ADC2E392A279640E9B4FA37883A56E0C992C7A86DD594AF5EE2BEDD0CEE46AAF2558AAE97737C49F077CC0BCA6A6E31351112E1AE708984CB2B97F6AB40D5BDB3AD5AD7577663E1BB5B6DD53A935027145D51708994557555D1C6DA0BD468B2451C6E91236658D472A63A7C500D2DF476688D6162E37D7DC6FDA5352D96919A42BE16D5DDED95B4716E91F061A925444C6E571D3207B8A0619C428E49F40EB78618DF2CF3690BC451431355EF7BDF6E99AD63189CDCAE5E489E607CDC708F861C455E29F0E7DAB426B3A5A5FE59DA5D51535565B9C50C71A55B15CF9647C08D6B53CD5540FA7A03E67BB4270EF8875DC6FE30D6D0685D67594755C44D43514B554965B9CB0CD13EE53B9924524702B5ED7273456AE153A01F423C17B65459F847C34B4D643241556FD0D65A5A88256AB1F1C8CA0891EC7B1DCD151792A281B400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000187EB7D2D16B0D3B5B6574BECD3BF6D4DBAAD33FCDEB215DF4F2F2E7847727639ED55C01E79EBFE1EDCAE3A8229B5FE87B65F352525645516ED415964A19AB964817ECDD05D69A9DB3553557C78964939F3C2281BA3871C10BC5E2AA1BC6AE826B5DA18F4952827CB6B6B7CD51CDF7A063BA39CEC3D53DD44CEF40EE6C51450451C30471C3142C6C5145122358C6B536B58D6B79351A9C911009E00000000000000000000000001FFD9);
INSERT INTO `profilepicture` VALUES ('2', null);
INSERT INTO `profilepicture` VALUES ('3', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `username` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'B851FCBD2A56C6EEE0D1F86D1B7751DE92EFEF301E417A7F80748843EE1351A5', 'B221D9DBB083A7F33428D7C2A3C3198AE925614D70210E28716CCAA7CD4DDB79');
INSERT INTO `user` VALUES ('2', 'F60FFAE4F71112F0037784FD94419475316490AE188AD503A3FC8092EFB4F299', '52B2E6816D7F65A07ABEC772865D45F49BF3E2291ABDB158486484A151C68839');
INSERT INTO `user` VALUES ('3', '62128BE42907C0866965A87657982A8E0E6EE410AEAB02AF667A05696384CEB5', 'B221D9DBB083A7F33428D7C2A3C3198AE925614D70210E28716CCAA7CD4DDB79');

-- ----------------------------
-- Table structure for userallergies
-- ----------------------------
DROP TABLE IF EXISTS `userallergies`;
CREATE TABLE `userallergies` (
  `userID` int(11) NOT NULL,
  `allergyID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`allergyID`),
  KEY `allergyID_idx` (`allergyID`),
  CONSTRAINT `userID1` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userallergies
-- ----------------------------
INSERT INTO `userallergies` VALUES ('1', '9');
INSERT INTO `userallergies` VALUES ('1', '10');
INSERT INTO `userallergies` VALUES ('1', '11');
INSERT INTO `userallergies` VALUES ('1', '12');

-- ----------------------------
-- Table structure for userdiseases
-- ----------------------------
DROP TABLE IF EXISTS `userdiseases`;
CREATE TABLE `userdiseases` (
  `userID` int(11) NOT NULL,
  `diseaseID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`diseaseID`),
  KEY `ID_idx` (`diseaseID`),
  CONSTRAINT `diseaseID` FOREIGN KEY (`diseaseID`) REFERENCES `disease` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdiseases
-- ----------------------------
INSERT INTO `userdiseases` VALUES ('1', '2');
INSERT INTO `userdiseases` VALUES ('1', '3');

-- ----------------------------
-- Table structure for userequipment
-- ----------------------------
DROP TABLE IF EXISTS `userequipment`;
CREATE TABLE `userequipment` (
  `userID` int(11) NOT NULL,
  `equipmentID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`equipmentID`),
  KEY `ueEqupimentFK_idx` (`equipmentID`),
  CONSTRAINT `ueEquipmentFK` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ueUserFK` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userequipment
-- ----------------------------

-- ----------------------------
-- Table structure for userfoods
-- ----------------------------
DROP TABLE IF EXISTS `userfoods`;
CREATE TABLE `userfoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `foodId` int(11) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userfoods
-- ----------------------------
INSERT INTO `userfoods` VALUES ('1', '1', '4', '1.3');
INSERT INTO `userfoods` VALUES ('2', '1', '9', '1.3');
INSERT INTO `userfoods` VALUES ('3', '3', '81', '1.3');
INSERT INTO `userfoods` VALUES ('4', '3', '98', '1.3');
INSERT INTO `userfoods` VALUES ('5', '1', '21', '1.3');
INSERT INTO `userfoods` VALUES ('6', '1', '103', '1.3');
INSERT INTO `userfoods` VALUES ('7', '3', '102', '1.3');
INSERT INTO `userfoods` VALUES ('8', '1', '105', '1.3');
INSERT INTO `userfoods` VALUES ('9', '3', '103', '1.3');
INSERT INTO `userfoods` VALUES ('10', '3', '105', '1.3');
INSERT INTO `userfoods` VALUES ('11', '3', '112', '1.3');
INSERT INTO `userfoods` VALUES ('12', '3', '115', '1.3');
INSERT INTO `userfoods` VALUES ('13', '3', '3', '1.3');
INSERT INTO `userfoods` VALUES ('14', '3', '101', '1.3');

-- ----------------------------
-- Table structure for userweeklyroutine
-- ----------------------------
DROP TABLE IF EXISTS `userweeklyroutine`;
CREATE TABLE `userweeklyroutine` (
  `userID` int(11) NOT NULL,
  `weeklyRoutineID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `weeklyRoutineFK_idx` (`weeklyRoutineID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userweeklyroutine
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
