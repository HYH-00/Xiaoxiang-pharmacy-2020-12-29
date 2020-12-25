/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-25 18:16:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for drugstype
-- ----------------------------
DROP TABLE IF EXISTS `drugstype`;
CREATE TABLE `drugstype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of drugstype
-- ----------------------------
INSERT INTO `drugstype` VALUES ('1', '胃炎');
INSERT INTO `drugstype` VALUES ('2', '维生素');
INSERT INTO `drugstype` VALUES ('3', '感冒');
INSERT INTO `drugstype` VALUES ('4', '气管炎');
INSERT INTO `drugstype` VALUES ('5', '皮炎');
