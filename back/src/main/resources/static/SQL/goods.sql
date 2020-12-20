/*
Navicat MySQL Data Transfer

Source Server         : Shop
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-12-19 16:16:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `shopid` varchar(255) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `trademark` varchar(100) DEFAULT NULL,
  `validPeriod` varchar(20) DEFAULT NULL,
  `Packingspecification` varchar(50) DEFAULT NULL,
  `manufacturer` varchar(150) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('H20013410', '22.50', '达喜 铝碳酸镁咀嚼片', '慢性胃炎。与胃酸有关的胃部不适症状，如胃痛、胃灼热感(烧心)、酸性暖气、饱胀等。', '达喜 铝碳酸镁咀嚼片.jpg', '104', '达喜', '60个月', '0.5g.×10片×2板/盒', '拜耳医药保健有限公司启东分公司', '胃炎');
INSERT INTO `goods` VALUES ('H35021450', '45.00', '维生素D滴剂', '1、预防维生素D缺乏性佝偻病。2、预防骨质疏松症。', '维生素D滴剂.jpg', '500', '星鲨', '24个月', '400Ux10粒x3板/盒', '国药控股星鲨制药(厦门)有限公司', '维生素');
INSERT INTO `goods` VALUES ('H42020614', '1.09', '维福佳 维生素C片', '用于预防坏血病，也可用于各种急慢性传染疾病及紫癜等的辅助治疗。', '维福佳 维生素C片.jpg', '1000', '维福佳', '18个月', '0.1g×100片/瓶', '华中药业股份有限公司', '维生素');
INSERT INTO `goods` VALUES ('Z44020705', '12.70', '999 三九胃泰颗粒', '清热燥湿，行气活血，柔肝止痛。用于湿热内蕴、气滞血瘀所致的胃痛，症见脘腹隐痛、饱胀反酸、恶心呕吐、嘈杂纳减；浅表性胃炎见上述证候者。', '999 三九胃泰颗粒.jpg', '4005', '华润三九医药', '24个月', '2.5g×6袋/盒（颗粒）', '华润三九医药股份有限公司', '胃炎');
