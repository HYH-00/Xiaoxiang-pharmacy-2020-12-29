/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-25 18:16:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for salesnum
-- ----------------------------
DROP TABLE IF EXISTS `salesnum`;
CREATE TABLE `salesnum` (
  `year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` int DEFAULT '0',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `month` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salesnum
-- ----------------------------
INSERT INTO `salesnum` VALUES ('2021', '5', '胃炎', '1');
INSERT INTO `salesnum` VALUES ('2021', '5', '气管炎', '2');
INSERT INTO `salesnum` VALUES ('2020', '2', '胃炎', '3');
INSERT INTO `salesnum` VALUES ('2020', '13', '气管炎', '4');
