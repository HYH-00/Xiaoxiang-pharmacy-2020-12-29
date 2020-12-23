/*
Navicat MySQL Data Transfer

Source Server         : Shop
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-12-21 18:23:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `carid` varchar(50) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
