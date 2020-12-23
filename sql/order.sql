/*
Navicat MySQL Data Transfer

Source Server         : MySQL80
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-23 10:06:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `userid` varchar(50) NOT NULL,
  `shopid` varchar(255) NOT NULL,
  `shopnumber` int DEFAULT NULL,
  `discount` double(10,2) DEFAULT NULL,
  `addres` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `allprice` double(10,2) DEFAULT NULL,
  `cancel` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
