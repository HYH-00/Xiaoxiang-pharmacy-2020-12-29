/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-25 18:16:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for salesmount
-- ----------------------------
DROP TABLE IF EXISTS `salesmount`;
CREATE TABLE `salesmount` (
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `money` double DEFAULT NULL,
  `month` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salesmount
-- ----------------------------
INSERT INTO `salesmount` VALUES ('胃炎', '1', '1', '2020');
INSERT INTO `salesmount` VALUES ('维生素', '10', '2', '2021');
INSERT INTO `salesmount` VALUES ('感冒', '10', '3', '2021');
INSERT INTO `salesmount` VALUES ('气管炎', '10', '4', '2021');
INSERT INTO `salesmount` VALUES ('皮炎', '10', '5', '2021');
INSERT INTO `salesmount` VALUES ('胃炎', '10', '6', '2021');
INSERT INTO `salesmount` VALUES ('维生素', '2', '7', '2020');
INSERT INTO `salesmount` VALUES ('感冒', '3', '8', '2020');
INSERT INTO `salesmount` VALUES ('气管炎', '4', '9', '2020');
INSERT INTO `salesmount` VALUES ('皮炎', '5', '10', '2020');
INSERT INTO `salesmount` VALUES ('胃炎', '1', '2', '2020');
