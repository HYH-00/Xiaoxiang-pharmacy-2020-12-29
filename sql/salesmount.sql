/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-23 10:06:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for salesmount
-- ----------------------------
DROP TABLE IF EXISTS `salesmount`;
CREATE TABLE `salesmount` (
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `money` double DEFAULT NULL,
  `type_` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salesmount
-- ----------------------------
INSERT INTO `salesmount` VALUES ('胃炎', '1', '肠胃用药', '2020');
INSERT INTO `salesmount` VALUES ('维生素', '2', '营养滋补', '2020');
INSERT INTO `salesmount` VALUES ('感冒', '3', '家庭常用', '2020');
INSERT INTO `salesmount` VALUES ('气管炎', '4', '呼吸系统', '2020');
INSERT INTO `salesmount` VALUES ('皮炎', '5', '皮肤科药', '2020');
