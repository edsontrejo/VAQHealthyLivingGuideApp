/*
Navicat MySQL Data Transfer

Source Server         : phpmyadmin
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : vaqnutri

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-12-12 13:04:42
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
INSERT INTO `foods` VALUES ('1', 'Apple', '1', 'apple.jpg', '198', '0.3', '0', '0.002', '0.1915', '24.7', '191.5');
INSERT INTO `foods` VALUES ('2', 'Avocado', '1', 'avocado.jpg', '145', '234', '21.4', '0', '0.01', '0.708', '12.5');
INSERT INTO `foods` VALUES ('3', 'Banana', '1', 'banana.jpg', '108', '105', '0.2', '0', '0.001', '0.194', '12.4');
INSERT INTO `foods` VALUES ('4', 'Broccoli', '1', 'broccoli.jpg', '88', '30', '0.3', '0', '0.029', '0.278', '5.8');
INSERT INTO `foods` VALUES ('5', 'Cabbage', '1', 'cabbage.jpg', '71', '17', '0', '0', '0', '0.013', '0.172');
INSERT INTO `foods` VALUES ('6', 'Carrot', '1', 'carrot.jpg', '110', '45', '0.3', '0', '0.076', '0.352', '10.5');
INSERT INTO `foods` VALUES ('7', 'Cucumber', '1', 'cucumber.png', '104', '16', '0', '0', '0.002', '0.152', '3.8');
INSERT INTO `foods` VALUES ('8', 'Eggplant', '1', 'eggplant.jpg', '82', '20', '0.2', '0', '0.002', '0.188', '4.7');
INSERT INTO `foods` VALUES ('9', 'Grapefruit', '1', 'grapefruit.jpg', '400', '64', '0.2', '0', '0', '0.278', '16.2');
INSERT INTO `foods` VALUES ('10', 'Grapes', '1', 'grapes.jpg', '150', '104', '0.2', '0', '3', '0.288', '27.3');
INSERT INTO `foods` VALUES ('11', 'Lettuce', '1', 'lettuce.jpg', '54', '8', '0', '0', '0.006', '0.0776', '1.6');
INSERT INTO `foods` VALUES ('12', 'Mango', '1', 'mango.jpg', '107', '57', '0.2', '0', '0.001', '0.117', '15.1');
INSERT INTO `foods` VALUES ('13', 'Orange', '1', 'orange.jpg', '178', '62', '0.2', '0', '0', '0.2371', '15.4');
INSERT INTO `foods` VALUES ('14', 'Papaya', '1', 'papaya.jpg', '138', '55', '0.2', '0', '0.004', '0.4', '13.7');
INSERT INTO `foods` VALUES ('15', 'Pineapple', '1', 'pineapple.jpg', '57', '28', '0.1', '0', '0.001', '0.061', '7.3');
INSERT INTO `foods` VALUES ('16', 'potato', '1', 'potato.png', '150', '116', '0.1', '0', '0.009', '0.009', '0.631');
INSERT INTO `foods` VALUES ('17', 'spinach', '1', 'spinach.jpg', '31', '7', '0.1', '0', '0.024', '0.167', '1.1');
INSERT INTO `foods` VALUES ('18', 'strawberry', '1', 'strawberry.jpg', '153', '49', '0.5', '0', '0.002', '0.232', '11.7');
INSERT INTO `foods` VALUES ('19', 'tomato', '1', 'tomato.jpg', '150', '27', '0.3', '0', '0.007', '0.353', '5.8');
INSERT INTO `foods` VALUES ('20', 'watermelon', '1', 'watermelon.jpg', '153', '46', '0.2', '0', '0.002', '170.2', '11.5');
INSERT INTO `foods` VALUES ('21', 'Cheerios', '2', 'cheerios.png', '28', '100', '2', '0', '0.14', '0.18', '20');
INSERT INTO `foods` VALUES ('22', 'Fiber One Cereal Original', '2', 'FiberOne_Cereal_Original.png', '30', '60', '1', '0', '0.11', '0.11', '25');
INSERT INTO `foods` VALUES ('23', 'Fiber One 100% Whole Wheat Bread', '2', 'fiberone-bread-wholewheat.png', '48', '15', '1.5', '0', '0.17', '0', '23');
INSERT INTO `foods` VALUES ('24', 'Fiber One Multigrain Bread', '2', 'FiberOne_Bread_Multigrain-1.png', '48', '110', '1.5', '0', '0.135', '0', '25');
INSERT INTO `foods` VALUES ('25', 'Fiber One 9 Grain Bread', '2', 'FiberOne_Bread_9Grain.png', '48', '110', '1.5', '0', '0.135', '0', '25');
INSERT INTO `foods` VALUES ('26', 'Honey Bunches of Oats Honey Roasted', '2', 'HBO-Honey-Roasted.png', '30', '120', '1.5', '0', '0.135', '0.055', '25');
INSERT INTO `foods` VALUES ('27', 'Riceland Extral Long Grain Brown Rice', '2', 'riceland-brown-rice.jpg', '42', '150', '1', '0', '0', '0.1', '32');
INSERT INTO `foods` VALUES ('28', 'Great Value Brown Rice', '2', 'Great_Value_Brown_Rice.jpg', '45', '160', '1.5', '0', '0', '0.1', '35');
INSERT INTO `foods` VALUES ('29', 'Great Value 100% Whole Wheat Bread', '2', 'Great_Value_100-Whole-Wheat-Bread.jpg', '28', '60', '1', '0', '0.12', '0.06', '12');
INSERT INTO `foods` VALUES ('30', 'Great Value Multi-Grain Bread', '2', 'Great_Value_Multi-Grain-Bread.jpg', '45', '120', '1.5', '0', '0.19', '0.095', '24');
INSERT INTO `foods` VALUES ('31', 'HEB 100% Whole Grain Brown Rice', '2', 'h-e-b_brown_rice.jpg', '42', '150', '1', '0', '0', '0', '32');
INSERT INTO `foods` VALUES ('32', 'HEB Bake Shop 100% Whole Wheat Bread', '2', 'h-e-b-bake-shop-100-whole-wheat-bread.jpg', '28', '60', '1', '0', '0.085', '0.09', '11');
INSERT INTO `foods` VALUES ('33', 'HEB Essential Grains 12 Grain Bread', '2', 'h-e-b-essential-grains-12-grain-bread.jpg', '45', '120', '2', '0', '0.19', '0', '22');
INSERT INTO `foods` VALUES ('34', 'Skinny Pop Original Popped Popcorn', '2', 'SkinnyPop_Popcorn.jpg', '28', '150', '10', '0', '0.075', '0', '15');
INSERT INTO `foods` VALUES ('35', 'Orville Redenbacher\'s Naturals Simply Salted', '2', 'OrvilleRedenbachers-naturals-simply-salted.png', '35', '170', '11', '0', '0.4', '0.065', '17');
INSERT INTO `foods` VALUES ('36', 'Honey Bunches of Oats Protein Granola with Dark Chocolate', '2', 'HBO-Granola-Dark-Chocolate.png', '50', '220', '7', '0', '0.095', '0.16', '32');
INSERT INTO `foods` VALUES ('37', 'Natural Valley Baked Oat Bites Cereal', '2', 'NatureValley_BoxedCereal_BakedOatBites.png', '24', '210', '6', '0', '0.16', '0.105', '34');
INSERT INTO `foods` VALUES ('38', 'Natural Valley Protein Oatmeal Maple Pecan Crunch', '2', 'NatureValley_OatmealCups_MaplePecanCrunch.png', '48', '290', '8', '0', '0.15', '0.21', '47');
INSERT INTO `foods` VALUES ('39', 'Natural Valley Oats \'N Honey Crunchy Granola Bars', '2', 'NatureValley_CrunchyBar_OatsnHoney.png', '16', '190', '7', '0', '0.18', '0', '29');
INSERT INTO `foods` VALUES ('40', 'Erin Baker\'s Granola Oatmeal Rasin', '2', 'ErinBakers-Granola-Oatmeal-Raisin.jpg', '55', '250', '9', '0', '0.01', '0', '38');
INSERT INTO `foods` VALUES ('41', 'Great Value Reduced Fat 2% Milk', '3', '2percentmilk.jpg', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('42', 'Great Value Low Fat 1% Milk', '3', '1percentmilk.jpg', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('43', 'Oak Farms Vitamin D Whole Milk', '3', 'wholemilk.jpg', '240', '150', '8', '0.035', '0.12', '0.38', '12');
INSERT INTO `foods` VALUES ('44', 'Blue Diamond Almonds Almond Breeze Unsweetened Original Almondmilk', '3', 'almondmilk.jpg', '240', '30', '2.5', '0', '0.15', '0.16', '1');
INSERT INTO `foods` VALUES ('45', 'Borden Sweetened Condensed Eagle Brand Milk', '3', 'condensedmilk.jpg', '39', '130', '3', '0.01', '0.04', '0', '23');
INSERT INTO `foods` VALUES ('46', 'Silk Vanilla Soymilk', '3', 'silksoymilk.jpg', '240', '30', '3.5', '0', '0.1', '0.3', '9');
INSERT INTO `foods` VALUES ('47', 'Soy Slender Chocolate Soy Milk', '3', 'chocolatesoymilk.jpg', '240', '70', '3', '0', '0.125', '0.29', '5');
INSERT INTO `foods` VALUES ('48', 'Great Value Vanilla Light Nonfat Yogurt', '3', 'vanillayogurt.jpg', '240', '110', '0', '0.005', '0.105', '0.32', '20');
INSERT INTO `foods` VALUES ('49', 'Yoplait Creamy Strawberry Grande Yogurt', '3', 'strawberryyogurt.jpg', '225', '200', '1.5', '0.01', '0.1', '0.3', '39');
INSERT INTO `foods` VALUES ('50', 'Chobani Blueberry on the Bottom Non-Fat Greek Yogurt', '3', 'chobaniblueberry_greekyogurt.jpg', '150', '120', '0', '0.005', '0.06', '0.22', '18');
INSERT INTO `foods` VALUES ('51', 'Dannon Plain All Natural Nonfat Yogurt', '3', 'plainyogurt.jpg', '225', '120', '0', '0.005', '0.15', '0.51', '18');
INSERT INTO `foods` VALUES ('52', 'La Yogurt Probiotic Banana Blended Lowfat Yogurt', '3', 'probioticbananayogurt.jpg', '240', '240', '2.5', '0.01', '0.13', '0.42', '45');
INSERT INTO `foods` VALUES ('53', 'Chobani Vanilla Blended Non-Fat Greek Yogurt', '3', 'chobanivanillayogurt.jpg', '170', '0', '0.01', '0.095', '0.36', '23', '20');
INSERT INTO `foods` VALUES ('54', 'Yoplait Light Banana Cream Pie Yogurt', '3', 'bananacreampie_yogurt.jpg', '170', '90', '0', '0.005', '0.08', '0', '16');
INSERT INTO `foods` VALUES ('55', 'Kraft Velveeta Slices 16 ct Cheese', '3', 'velveetacheese.jpg', '21', '40', '2', '0.001', '0.32', '0', '3');
INSERT INTO `foods` VALUES ('56', 'Kraft 100% Real Parmesan Grated Cheese', '3', 'parmesangratedcheese.jpg', '30', '20', '1.5', '0.005', '0.085', '0', '0');
INSERT INTO `foods` VALUES ('57', 'Kraft Singles American Slices 16 ct Cheese', '3', 'americancheese.jpg', '21', '70', '5', '0.02', '0.27', '0', '2');
INSERT INTO `foods` VALUES ('58', 'Kraft Deli Deluxe American Cheese Slices', '3', 'delideluxe_americancheese.jpg', '19', '60', '4.5', '0.015', '0.3', '0', '1');
INSERT INTO `foods` VALUES ('59', 'Great Value Shredded Mozzarella Cheese', '3', 'mozzarellacheese.jpg', '28', '80', '5', '0.015', '0.2', '0.025', '1');
INSERT INTO `foods` VALUES ('60', 'Borden American Singles Cheese', '3', 'bordencheese.jpg', '21', '45', '5', '0.015', '0.29', '0', '3');
INSERT INTO `foods` VALUES ('61', 'Lean/27 Fat, Ground Beef Roll, 5', '4', 'ground_beefroll.jpg', '112', '340', '30', '0.085', '0.075', '0', '0');
INSERT INTO `foods` VALUES ('62', 'Butterball Ground Turkey 93%Lean, 3lbs.', '4', 'ground_turkey.jpg', '112', '150', '8', '0.08', '0.095', '0', '0');
INSERT INTO `foods` VALUES ('63', '80Lean/20 Fat Great Value Beef Burgers, 3 Lbs', '4', 'beef_burger.jpg', '113', '290', '23', '0.09', '0.085', '0.31', '0');
INSERT INTO `foods` VALUES ('64', 'SPAM Classic 12 oz. Can', '4', 'spam.jpg', '56', '180', '16', '0.04', '0.79', '0', '1');
INSERT INTO `foods` VALUES ('65', 'Chicken Drumsticks, 5 lbs.', '4', 'chicken_drumsticks.jpg', '112', '90', '10', '0.1', '0.16', '0', '0');
INSERT INTO `foods` VALUES ('66', 'Tyson Boneless Skinless Fresh Chicken Breasts, 1.5-2.0 lbs', '4', 'chicken_breast.jpg', '112', '20', '2.5', '0.065', '0.18', '0', '0');
INSERT INTO `foods` VALUES ('67', 'Tyson Fresh Chicken Wings, 4.0 lbs.', '4', 'chicken_wing.jpg', '112', '220', '17', '0.105', '0.19', '0', '0');
INSERT INTO `foods` VALUES ('68', 'Great Value Chunk Chicken Breast in Water, 12.5 oz, 2 Count', '4', 'chicken_breastinwater.jpg', '56', '45', '1', '0.025', '0.26', '0.14', '0');
INSERT INTO `foods` VALUES ('69', 'Great Value Chunk Light Tuna in Water, 5 oz, 4 Count', '4', 'light_tuna.jpg', '56', '45', '0.5', '0.02', '0.18', '0.11', '0');
INSERT INTO `foods` VALUES ('70', 'Frozen Tilpia Filets, 7 lbs', '4', 'tilapia_fillet.jpg', '113', '100', '1.5', '0.05', '0.025', '0', '0');
INSERT INTO `foods` VALUES ('71', 'Medium Raw Shrimp 12 oz', '4', 'shrimp_raw.jpg', '85', '50', '0.5', '0.125', '0.64', '0.22', '0');
INSERT INTO `foods` VALUES ('72', 'Great Value Large Grade A Eggs, 18 ct', '4', 'greatvalue_largeeggs.jpg', '56', '70', '5', '0.185', '0.07', '0', '0');
INSERT INTO `foods` VALUES ('73', 'Farmhouse Cage Free Grade A Large Brown Eggs, 18 ct', '4', 'farmhouse_browneggs.jpg', '50', '70', '5', '0.185', '0.07', '0', '0');
INSERT INTO `foods` VALUES ('74', 'Great Value 100% Liquid Egg Whites, 32 oz', '4', 'liquid_eggwhite.jpg', '46', '25', '0', '0', '0.075', '0.06', '1');
INSERT INTO `foods` VALUES ('75', 'Great Value Pinto Beans, 64 oz', '4', 'pinto_beans.jpg', '35', '90', '0', '0', '0.005', '0.49', '20');
INSERT INTO `foods` VALUES ('76', 'Great Value Black Beans, 32 oz', '4', 'black_beans.jpg', '35', '100', '0.5', '0', '0', '0.49', '22');
INSERT INTO `foods` VALUES ('77', 'Great Value Light Red Kidney Beans, 16 oz', '4', 'kidney_beans.jpg', '35', '100', '0', '0', '0.005', '0.48', '21');
INSERT INTO `foods` VALUES ('78', 'Fisher Chef\'s Naturals Pecans Halves, 24 oz', '4', 'fisher_pecanhalves.jpg', '28', '190', '20', '0', '0', '0', '4');
INSERT INTO `foods` VALUES ('79', 'Great Value Whole Natural Almonds, 14 oz', '4', 'wholenatural_almonds.jpg', '28', '160', '14', '0', '0', '0.21', '6');
INSERT INTO `foods` VALUES ('80', 'Wonderful® Roasted & Salted Pistachios 24 oz. Bag', '4', 'pistachios.jpg', '30', '160', '14', '0', '0.16', '0.31', '8');
INSERT INTO `foods` VALUES ('81', 'Butter', '5', 'SmartBalancebutter.png', '33', '60', '7', '0', '70', '0', '0');
INSERT INTO `foods` VALUES ('82', 'Peanutbutter', '5', 'wowbutter.jpg', '16', '200', '15', '0', '100', '300', '8');
INSERT INTO `foods` VALUES ('83', 'AlmondButter', '5', 'barneyandcoalmond.jpg', '14', '180', '15', '0', '100', '0', '8');
INSERT INTO `foods` VALUES ('84', 'Butter', '5', 'butterspray.jpg', '1700', '0', '0', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('85', 'Butter', '5', 'canolabutter.jpg', '30', '100', '11', '15', '85', '0', '0');
INSERT INTO `foods` VALUES ('86', 'Butter', '5', 'canolaolivebutter.jpg', '30', '100', '11', '15', '85', '0', '0');
INSERT INTO `foods` VALUES ('87', 'Creamcheese', '5', 'creamcheese.jpg', '7', '80', '7', '20', '125', '0', '2');
INSERT INTO `foods` VALUES ('88', 'hummus', '5', 'hummus.jpg', '10', '70', '5', '0', '130', '0', '4');
INSERT INTO `foods` VALUES ('89', 'AlmondButter', '5', 'justin\'salmond.jpg', '12', '190', '18', '0', '0', '3500', '6');
INSERT INTO `foods` VALUES ('90', 'Butter', '5', 'lightspreadbutter.jpg', '30', '40', '4', '0', '80', '3500', '0');
INSERT INTO `foods` VALUES ('91', 'AlmondButter', '5', 'maranathaalmond.jpg', '11', '190', '16', '0', '0', '3500', '7');
INSERT INTO `foods` VALUES ('92', 'AlmondButter', '5', 'nutsnmorealmond.jpg', '14', '207', '15', '1', '56', '3500', '6');
INSERT INTO `foods` VALUES ('93', 'Butter', '5', 'omegabutter.jpg', '32', '70', '8', '0', '80', '3500', '0');
INSERT INTO `foods` VALUES ('94', 'PeanutButter', '5', 'omegapeanutbutter.jpg', '30', '100', '11', '15', '85', '3500', '0');
INSERT INTO `foods` VALUES ('95', 'AlmondButter', '5', 'onceagainalmond.jpg', '15', '190', '17', '0', '0', '3500', '6');
INSERT INTO `foods` VALUES ('96', 'Oil', '5', 'bertolli.jpg', '102', '120', '14', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('97', 'ricotta', '5', 'ricotta.jpg', '30', '100', '11', '15', '85', '3500', '0');
INSERT INTO `foods` VALUES ('98', 'AlmondButter', '5', 'Sam\'sAlmondButter.jpg', '11', '190', '16', '0', '60', '65', '7');
INSERT INTO `foods` VALUES ('99', 'Butter', '5', 'wildfriendsalmond.jpg', '1', '190', '17', '0', '90', '3500', '7');
INSERT INTO `foods` VALUES ('100', 'Oil', '5', 'canolaoil.jpg', '48', '120', '14', '0', '0', '0', '0');
INSERT INTO `foods` VALUES ('101', 'laysChips', '6', 'chips.png', '28', '160', '10', '0', '170', '350', '15');
INSERT INTO `foods` VALUES ('102', 'crackers', '6', 'crackers.png', '33', '90', '5', '0', '130', '0', '9');
INSERT INTO `foods` VALUES ('103', 'cookies', '6', 'cookie.jpg', '30', '130', '5', '0', '65', '0', '20');
INSERT INTO `foods` VALUES ('104', 'popcorn', '6', 'popcorn.jpg', '39', '130', '2', '0', '190', '230', '27');
INSERT INTO `foods` VALUES ('105', 'coke', '6', 'coke.jpg', '35', '140', '0', '0', '45', '0', '39');
INSERT INTO `foods` VALUES ('106', 'cheerios', '6', 'cheerios.png', '30', '120', '2', '0', '270', '170', '20');
INSERT INTO `foods` VALUES ('107', 'ketchup', '6', 'ketchup.jpg', '15', '25', '0', '0', '200', '0', '6');
INSERT INTO `foods` VALUES ('108', 'chickenSoup', '6', 'chickenSoup.jpg', '18.9', '70', '1', '15', '750', '0', '10');
INSERT INTO `foods` VALUES ('109', 'bread', '6', 'bread.jpg', '40', '100', '1', '0', '180', '0', '20');
INSERT INTO `foods` VALUES ('110', 'tortilla', '6', 'tortilla.jpg', '49', '140', '3.5', '0', '420', '0', '24');
INSERT INTO `foods` VALUES ('111', 'hotCheetos', '6', 'hotCheetos.png', '28', '160', '11', '0', '250', '0', '13');
INSERT INTO `foods` VALUES ('112', 'pizza', '6', 'pizza.png', '175', '410', '19', '35', '660', '0', '48');
INSERT INTO `foods` VALUES ('113', 'margarine', '6', 'margarine.jpg', '85', '250', '11', '5', '350', '0', '33');
INSERT INTO `foods` VALUES ('114', 'frenchFry', '6', 'frenchFry.jpg', '114', '350', '18', '0', '220', '0', '45');
INSERT INTO `foods` VALUES ('115', 'iceCream', '6', 'iceCream.jpg', '65', '150', '9', '80', '45', '0', '15');
INSERT INTO `foods` VALUES ('116', 'candyBar', '6', 'candyBar.jpg', '78', '320', '17', '15', '220', '0', '40');
INSERT INTO `foods` VALUES ('117', 'cheese', '6', 'cheese.jpg', '28.35', '100', '10', '30', '230', '0', '0');
INSERT INTO `foods` VALUES ('118', 'soySauce', '6', 'soySauce.jpg', '6', '15', '0', '0', '125', '0', '3');
INSERT INTO `foods` VALUES ('119', 'poundCake', '6', 'poundCake.jpg', '65', '230', '10', '55', '135', '0', '34');
INSERT INTO `foods` VALUES ('120', 'bacon', '6', 'bacon.png', '32', '170', '17', '25', '220', '0', '0');

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
INSERT INTO `medical` VALUES ('1', '12', '12', '12');

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
INSERT INTO `personal` VALUES ('1', 'Rodolfo', 'Contreras', 'Male', '2450 Shidler', 'Arizona', 'Brownsville', '12313', null, '1996-12-12');

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
INSERT INTO `profilepicture` VALUES ('1', null);

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
-- Table structure for userweeklyroutine
-- ----------------------------
DROP TABLE IF EXISTS `userweeklyroutine`;
CREATE TABLE `userweeklyroutine` (
  `userID` int(11) NOT NULL,
  `weeklyRoutineID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  KEY `weeklyRoutineFK_idx` (`weeklyRoutineID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `ID` int(11) NOT NULL,
  `name` mediumtext NOT NULL,
  `description` longtext NOT NULL,
  `difficulty` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `met` double DEFAULT '0',
  `equipmentID` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  `primaryMuscle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Abdominal crunch','Lie on your back and place your feet on a wall so that your knees and hips are bent at 90-degree angles. Tighten your abdominal muscles. Raise your head and shoulders off the floor. To avoid straining your neck, cross your arms on your chest rather than locking them behind your head. Hold for three deep breaths.','easy','STRENGTH',1,NULL,'Abdominal-crunch.jpg','Abs'),(2,'Bridge','Lie on your back with your knees bent (A). Keep your back in a neutral position, not arched and not pressed into the floor. Avoid tilting your hips. Tighten your abdominal muscles. Raise your hips off the floor until your hips are aligned with your knees and shoulders (B). Hold for three deep breaths.','easy','STRENGTH',1,NULL,'bridge.jpg','Abs'),(3,'Single-leg abdominal press','Lie on your back with your knees bent (A). Keep your back in a neutral position, not arched and not pressed into the floor. Avoid tilting your hips. Tighten your abdominal muscles. Raise your right leg off the floor so that your knee and hip are bent at 90-degree angles. Rest your right hand on top of your right knee. Push your hand against your knee while using your abdominal muscles to pull your knee toward your hand. Keep your arm straight. Hold for three deep breaths.','easy','STRENGTH',1,NULL,'Single-leg-abdominal-press-variations.jpg','Chest'),(4,'Single-leg abdominal press variations','Opposite hand on opposite knee. Push your right hand against your left knee while pulling your knee toward your hand (A). You\'ll be pushing and pulling across the center of your body. Hold for three deep breaths. Repeat using your other hand and leg. Hand on outside of knee. Place your left hand along the side of your left knee (B). Use your hand to push your leg inward. At the same time, create resistance by pushing your knee away from the center. Hold for three deep breaths. Repeat using your other hand and leg.','intermediate','STRENGTH',1.3,NULL,'Double-leg-abdominal-press-variations.jpg','Chest'),(5,'Double-leg abdominal press','Lie on your back with your knees bent (A). Keep your back in a neutral position, not arched and not pressed into the floor. Avoid tilting your hips. Tighten your abdominal muscles.Raise your legs off the floor, one at a time, so that your knees and hips are bent at 90-degree angles. Rest your hands on top of your knees. Push your hands against your knees while using your abdominal muscles to pull your knees toward your hands. Keep your arms straight. Hold for three deep breaths.','easy','STRENGTH',1,NULL,'Double-leg-abdominal-press.jpg','Chest'),(6,'Double-leg abdominal press variations','Opposite hands on opposite knees. Place each hand on the opposite knee, toward the inside of the knee (A). Your arms will cross over each other. Push your hands against your knees while pulling your knees toward your hands. Hold for three deep breaths. Repeat. Hands on outside of knees. Place your hands along the sides of your knees. Use your hands to push your knees inward. At the same time, create resistance by pushing your knees away from the center. Hold for three deep breaths. Repeat.','intermediate','STRENGTH',1.3,NULL,'Segmental-rotation.jpg','Chest'),(7,'Segmental rotation','Lie on your back with your knees bent and your back in a neutral position. Tighten your abdominal muscles. Keeping your shoulders on the floor, let your knees fall slowly to the left (A). Go only as far as is comfortable. You should feel a stretch, but not pain. Hold for three deep breaths.','easy','STRENGTH',1,NULL,'Quadruped.jpg','Chest'),(8,'Quadruped','Start on your hands and knees. Place your hands directly below your shoulders, and align your head and neck with your back (A). Tighten your abdominal muscles. Raise your right arm off the floor and reach ahead (B). Hold for three deep breaths. Lower your right arm and repeat with your left arm. Raise your right leg off the floor (C). Tighten your trunk muscles for balance. Hold for three deep breaths. Lower your right leg and repeat with your left leg. For added challenge, raise your left arm and your right leg at the same time (D). Repeat with your right arm and left leg.','intermediate','STRENGTH',1.3,NULL,'Modified-plank.jpg','Chest'),(9,'Modified plank','Lie on your stomach. Raise yourself up so that you\'re resting on your forearms and your knees. Align your head and neck with your back, and place your shoulders directly above your elbows. Tighten your abdominal muscles.','easy','STRENGTH',1,NULL,'Modified-plank-variations.jpg','Chest'),(10,'Modified plank variations','Lie on your stomach. Raise yourself up so that you\'re resting on your forearms and your knees. Align your head and neck with your back, and place your shoulders directly above your elbows. Tighten your abdominal muscles. Raise your right arm off the floor (A). Hold for three deep breaths. Repeat with your left arm. Raise your right leg off the floor (B). Hold for three deep breaths. Repeat with your left leg. For added challenge, raise your left arm and your right leg at the same time. Repeat with your right arm and left leg.','intermediate','STRENGTH',1.3,NULL,'side-planks.jpg','Triceps'),(11,'Side plank','Lie on your left side, raising yourself onto your left forearm (A). Place your left shoulder directly above your left elbow, keeping your shoulders, hips and knees in alignment. Rest your right arm along the side of your body. Tighten your abdominal muscles. Hold for three deep breaths. Repeat on your right side. For added challenge, balance on your left hand. Raise your hips off the floor and extend your right hand toward the ceiling (B). Hold for three deep breaths. Repeat on your right side.','easy','STRENGTH',1,NULL,'superman.jpg','Triceps'),(12,'Superman ','Lie on your stomach with a rolled towel or a small pillow under your hips to support your back. You might also use a folded towel to support your head. Tighten your abdominal muscles. Raise your right arm off the floor (A). Hold for three deep breaths. Lower your right arm and repeat with your left arm. Raise your right leg off the floor (B). Hold for three deep breaths. Lower your right leg and repeat with your left leg.','intermediate','STRENGTH',1.3,NULL,'superman.jpg','Triceps'),(13,'Reverse Crunch','Lie down on the floor with your legs fully extended and arms to the side of your torso with the palms on the floor. Your arms should be stationary for the entire exercise. Move your legs up so that your thighs are perpendicular to the floor and feet are together and parallel to the floor. This is the starting position. While inhaling, move your legs towards the torso as you roll your pelvis backwards and you raise your hips off the floor. At the end of this movement your knees will be touching your chest. Hold the contraction for a second and move your legs back to the starting position while exhaling.','intermediate','STRENGTH',1.5,NULL,'Reverse-Crunch.jpg','Triceps'),(14,'Flat Bench Leg Pull-In','Lie on an exercise mat or a flat bench with your legs off the end. Place your hands either under your glutes with your palms down or by the sides holding on to the bench (or with palms down by the side on an exercise mat). Also extend your legs straight out. This will be your starting position. Bend your knees and pull your upper thighs into your midsection as you breathe out. Continue this movement until your knees are near your chest. Hold the contracted position for a second. As you breathe in, slowly return to the starting position.','easy','STRENGTH',1,NULL,'Flat-Bench-Leg-Pull-In.jpg','Biceps'),(15,'Chest Stretch','Take a pair of dumbbells with the amount of weight you would use for about 12 reps of flies. Lie flat on a bench and lift them in a contracted position. Then slowly lower them where your pecs will be stretched to the maximum possible. Hold this position.','easy','FLEXIBILITY',0.5,NULL,'Chest-Stretch.jpg','Chest'),(16,'Seated Butterfly Abdominals','Sit upright on the ground. Flex your knees and bring your heels together. Gently pull your feet towards your bottom. Place your elbows on the inside of your knees. Gently push your legs to the floor. Hold this position.','easy','FLEXIBILITY',0.5,NULL,'Seated-Butterfly-Stretch.jpg','Biceps'),(17,'Shoulders flex','Find a stationary bar; a smith machine works just fine. Turn facing away from it and grasp it with your palms down. Walk forward slowly until your delts are maximally stretched. Hold this position.','easy','FLEXIBILITY',0.4,NULL,'Shoulder-Stretch.jpg','Biceps'),(18,'Shoulders (Lateral Delt)','Load a moderate amount of weight on a low pulley. Grab the low cable pulley, stand up and allow the pull from the weight stack to stretch your side delt. If you don\'t have a low pulley handy, you are also able to use a wall by simply leaning into the wall for resistance in the stretched position.','easy','FLEXIBILITY',0.5,NULL,'Shoulders-(Lateral-Delt).jpg','Biceps'),(19,'Shoulders (Posterior Delt)','Grab the elbow of one arm with the hand of the other arm; pull your elbow across your chest. Hold this position and repeat for the other side.','easy','FLEXIBILITY',0.6,NULL,'Shoulders-(Anterior-Delt).jpg','Biceps'),(20,'Traps Stretch','Load up the smith machine with a moderate amount of weight. Shrug the weight up and lower it down as much as possible to get the maximal stretch in your traps. Hold this position','easy','FLEXIBILITY',0.8,NULL,'trap.jpg','Biceps'),(21,'Back (Lower) Stretch','Lie on your back with knees bent and your feet flat on the floor. Place your hands on the back of your thighs and pull your legs toward your chest. Pull until a gentle stretch is felt. Hold this position.','easy','FLEXIBILITY',0.9,NULL,'Back-(Lower).jpg','Back'),(22,'Back (Middle) Stretch','Kneel down on the floor in an all four position on your hands and knees. Curl your back up toward the ceiling. Hold this position. Return to starting position. Pull your stomach down to the floor hollowing out your back. Hold this position.','easy','FLEXIBILITY',0.7,NULL,'Back-(Middle).jpg','Back'),(23,'Back (Lats) Stretch','Hang from a bar with your palms facing away from you in a pullup position. Lift your body up then back down. Once in the down position, hang from the bar for 30 seconds. Note if you don\'t have access to a pullup bar or unable to perform this exercise, simply stretching and holding your arms as high as possible is also a great lat stretching exercise.','easy','FLEXIBILITY',1.1,NULL,'Back-(Lats).jpg','Back'),(24,'Biceps Stretch','Position a bench with a 60 degree incline like you did for triceps. Grab a pair of dumbbells and sit on the bench. Curl the dumbbells up and lower slowly until a maximum stretch has been reached in the biceps. Hold this position.','easy','FLEXIBILITY',1,NULL,'forearms.jpg','Back'),(25,'Tricep Stretch','Position a bench with about a 60 degree incline. Grasp a pair of dumbbells, sit and lean back on the bench. Extend both arms straight upward and then lower the dumbbells slowly to either side of your head. Hold until stretch is complete.','easy','FLEXIBILITY',0.7,NULL,'Triceps.jpg','Back'),(26,'Forearms Stretch','Set up a flat bench, grasp a barbell with an underhand grip for the forearm flexors and an overhand for the extensors. Rest your arms the bench so your wrists can hang off the edge. Slowly lower the weight until a maximum stretch has been achieved. Hold this position.','easy','FLEXIBILITY',0.5,NULL,'Quadriceps.jpg','ForeArms'),(27,'Quadriceps Stretch','An easy one for you. Kneel down and separate your feet enough so that you can sit between them. Put your hands on the floor behind you and lean back as far as possible, feeling the stretch in the quadriceps. Hold this position.','easy','FLEXIBILITY',0.5,NULL,'Quadriceps.jpg','Biceps'),(28,'Glutes Stretch','Lie on the ground with your body extended. Bend one leg and slide your heel towards your bottom. Grasp your ankle with one hand and your knee with the other hand. Gently pull your foot to the opposite shoulder. Hold this position.','easy','FLEXIBILITY',0.6,NULL,'glutes.jpg','Glutes'),(29,'Hamstring Stretch','Prop your leg on any raised surface, a chair or bench works fine. Keeping your leg straight in front of you, bend your torso without curling your back forward and try to touch your toes. Hold this position.','easy','FLEXIBILITY',0.5,NULL,'Hamstring-Stretch.jpg','Glutes'),(30,'Running/Jogging','The best thing about running is that you donÃ¢ÂÂt need much equipment or instruction to do it. All you need is a pair of running shoes, and youÃ¢ÂÂre off on your heart-pumping, calf-sculpting, and calorie-burning workout. ','easy','CARDIO',1.2,NULL,'running.jpg','Glutes'),(31,'Swimming','Swimming is the ideal form of cardio if you suffer from back or knee pain, as there is no impact involved, and it engages all the muscles at once, sculpting and toning with every movement through the water. As you move, your body needs to fight the waterÃ¢ÂÂs resistance because it is twelve times as dense as air.  ','intermediate','CARDIO',2.5,NULL,'swimming.jpg','Glutes'),(32,'Cycling','Cycling is a great sport because itÃ¢ÂÂs practical, versatile, and fun. It works for all occasionsÃ¢ÂÂwhether youÃ¢ÂÂre riding socially or solo. If you live close enough to your workplace to travel by bike, you can incorporate your workout into your daily schedule. ','intermediate','CARDIO',2,NULL,'cycling.jpg','Glutes'),(33,'Dancing','Dancing is a fun way to add cardio to an otherwise drab day. Dance alone, dance with a partner or a friend, or join a classÃ¢ÂÂany way you dance, youÃ¢ÂÂre sure to burn a lot of calories doing it.','easy','CARDIO',1.3,NULL,'dancing.jpg','Glutes'),(34,'High Intensity Interval Training (HIIT)','HIIT is known to be one of the most effective weight-loss exercise programs. It involves short bursts of intense physical activity followed by very short rest periods. Studies show that this type of training burns more fat than moderate physical activity for a longer period of time. ','intermediate','CARDIO',3.2,NULL,'HIT.jpg','Glutes'),(35,'Zumba','Zumba is sweeping the cardio nation with fun, repetitive dance routines that anyone can doÃ¢ÂÂeven those with two left feet. Your first Zumba class may be a little confusing, frustrating, or even disheartening, but come back to the same class with the same teacher a few more times, and youÃ¢ÂÂll get the hang of it.  ','easy','CARDIO',1.4,NULL,'zumba.jpg','Glutes'),(36,'Sports','Most sportsÃ¢ÂÂbut not allÃ¢ÂÂare good ways to get in your cardio workout (and not even realize youÃ¢ÂÂre working out). High-intensity sports which involve a lot of running and jumping like basketball, racquetball, soccer, tennis, ultimate frisbee, or volleyball (and the list goes on) will get your heartbeat up, and keep it up as long as you are participating.  ','intermediate','CARDIO',3,NULL,'sports.jpg','Glutes'),(37,'Eliptical','If you suffer from knee or lower back pain and running on a treadmill or climbing a Stairmaster is not for you, try out the elliptical machine during your next visit to the gym.','easy','CARDIO',1.1,'4','elipstic.jpg','LowerLegs'),(38,'Kickboxing','Kickboxing is a high intensity, aerobic form of martial arts. It involves kicking and punching movements and is practiced both as self-defense and as a cardio fitness sport. ','intermediate','CARDIO',4.1,NULL,'crossfit.jpg','LowerLegs'),(39,'Crossfit','CrossFit is a relatively new fitness regimen, created and founded in 2000 by Greg Glassman and Lauren Jenai in California. As the name suggests, CrossFit involves many different forms of exercise including HIIT, weightlifting, plyometrics, gymnastics, calisthenics, and many other exercises.','intermediate','CARDIO',3.7,NULL,'bootcamp.jpg','LowerLegs'),(40,'Bootcamp','Boot camp is called boot camp for a reason. These workouts are intense and difficult, but they are designed to help you lose weight and gain muscle fast. Go all out in every session, and you can burn 500 calories in half an hour.  ','intermediate','CARDIO',5.5,NULL,'yoga.jpg','LowerLegs'),(41,'Yoga','Admittedly, not all forms of yoga are efficient heartbeat-raisers and fat-burners. Certain types of yoga, like hot yoga or HiiYoga (high-intensity interval yoga), are designed to deliver all the benefits of yoga-like strength, flexibility, balance, and mindfulnessÃ¢ÂÂin addition to a healthy cardio workout.  ','easy','CARDIO',1.4,NULL,'yoga.jpg','LowerLegs'),(42,'Pilates','Pilates has many proven benefitsÃ¢ÂÂso many, in fact, that physical therapists use Pilates as a treatment for patients with chronic back pain or a knee injury. It is designed to improve posture, flexibility, and strength.','easy','CARDIO',1.3,NULL,'pilates.jpg','LowerLegs'),(43,'One-Legged Balance','Start with this beginning move, keeping a stable chair or a wall within arms\' reach. With feet together, pick up one footÃ¢ÂÂknee facing forward or to the side. Hold the position with eyes open, then closed. Switch feet and repeat for four reps on each foot. ','easy','BALANCE',1.1,NULL,'one-legged.jpg','LowerLegs'),(44,'Leg Swings','Stand on your right leg and raise the left leg three to six inches off the floor. With arms at your sides, swing your left leg forward and backward, touching the floor for balance, while keeping your torso erect. Now, repeat the moves, but don\'t allow your foot to touch the ground. ','easy','BALANCE',1.3,NULL,'leg-swings.jpg','LowerLegs'),(45,'One-Legged Clock With Arms','Balance on one leg, torso straight, head up, and hands on the hips. Visualize a clock and point your arm straight overhead to 12, then to the side (three), and then circle low and around to nine without losing your balance. ','easy','BALANCE',1,NULL,'one-legged-clock-with-arms.jpg','LowerLegs'),(46,'Clock on an Unstable Surface','Once you master balance moves on solid ground, try them on an unstable surface such as a BOSU platform. Stand near a wall or other support, for safety. Start in the middle of the board on two feet at first.','easy','BALANCE',0.9,NULL,'clock-on-an-unastable-surface.jpg','UpperLegs'),(47,'One-Legged Squat','Stand with your feet hip-width apart. Point your left foot out front, just barely touching the floor for balance and push your hips back and down into this challenging one-legged squat position. ','intermediate','BALANCE',1.1,NULL,'one-legged-squat.jpg','UpperLegs'),(48,'Staggered stance','Also hold on to a chair when trying this exercise for elderly balance problems. Let go of the chair for a few seconds at a time if you feel comfortable.','easy','BALANCE',0.7,NULL,'staggered-stance.jpg','LowerLegs'),(49,'Single limb with arm','Look up from your feet when balancing and pick a spot at eye level in front of you to improve falls in elderly. Lift your chest and bring your shoulders back.','intermediate','BALANCE',1.2,NULL,'single-limb-with-arms.jpg','Shoulders'),(50,'Single limb stance','A great place to begin is with the simplest standing balance exercise. Hold on to a chair and balance on one leg. This is a great place to begin to feel your center of gravity over your ankles. This is your goal, maintaining your center over your ankles.','easy','BALANCE',1,NULL,'single-limb-stance.jpg','Shoulders');
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- ----------------------------
-- Records of userweeklyroutine
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
