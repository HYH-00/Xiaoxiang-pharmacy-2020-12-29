/*
Navicat MySQL Data Transfer

Source Server         : Shop
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-12-19 16:16:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for discountgoods
-- ----------------------------
DROP TABLE IF EXISTS `discountgoods`;
CREATE TABLE `discountgoods` (
  `shopid` varchar(255) NOT NULL,
  `discount` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discountgoods
-- ----------------------------
INSERT INTO `discountgoods` VALUES ('H20013410', '15', null);
INSERT INTO `discountgoods` VALUES ('H35021450', '30', '2021-01-08 15:02:53');
INSERT INTO `discountgoods` VALUES ('H42020614', '5', '2020-12-31 18:18:48');
INSERT INTO `discountgoods` VALUES ('Z44020705', '6.4', '2021-01-09 16:08:17');
