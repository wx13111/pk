/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-05-28 15:47:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookname
-- ----------------------------
DROP TABLE IF EXISTS `bookname`;
CREATE TABLE `bookname` (
  `BookID` int(8) DEFAULT NULL,
  `BookName` varchar(255) DEFAULT '',
  `Bid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Bid`),
  KEY `BookName` (`BookName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookname
-- ----------------------------
INSERT INTO `bookname` VALUES ('100', '哈哈', '10');
INSERT INTO `bookname` VALUES ('111', '哈哈哈', '11');
INSERT INTO `bookname` VALUES ('1', '0001', '12');

-- ----------------------------
-- Table structure for cusname
-- ----------------------------
DROP TABLE IF EXISTS `cusname`;
CREATE TABLE `cusname` (
  `CusID` int(8) DEFAULT NULL,
  `CusName` varchar(255) DEFAULT NULL,
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cusname
-- ----------------------------

-- ----------------------------
-- Table structure for cusphone
-- ----------------------------
DROP TABLE IF EXISTS `cusphone`;
CREATE TABLE `cusphone` (
  `CusID` int(8) DEFAULT NULL,
  `CusPhone` varchar(11) DEFAULT NULL,
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cusphone
-- ----------------------------
INSERT INTO `cusphone` VALUES ('1001', '15110617855', '8');
INSERT INTO `cusphone` VALUES ('1001', '15110617855', '9');
INSERT INTO `cusphone` VALUES ('1002', '1110000', '10');
INSERT INTO `cusphone` VALUES ('123123', '15110617855', '11');
INSERT INTO `cusphone` VALUES ('1', '11111111111', '12');

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `CusID` int(8) DEFAULT NULL,
  `BookID` int(8) DEFAULT NULL,
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CID`),
  KEY `lend_ibfk_2` (`BookID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------
INSERT INTO `lend` VALUES ('1001', '100', '1');
INSERT INTO `lend` VALUES ('1002', '100', '2');
INSERT INTO `lend` VALUES ('123123', '111', '3');
INSERT INTO `lend` VALUES ('1', '100', '4');

-- ----------------------------
-- Table structure for money
-- ----------------------------
DROP TABLE IF EXISTS `money`;
CREATE TABLE `money` (
  `CusID` int(8) DEFAULT NULL,
  `Money` int(5) DEFAULT NULL,
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money
-- ----------------------------
INSERT INTO `money` VALUES ('1', '100', '8');
INSERT INTO `money` VALUES ('1001', '2520', '13');
INSERT INTO `money` VALUES ('1002', '950', '15');
INSERT INTO `money` VALUES ('123123', '109900', '18');
INSERT INTO `money` VALUES ('1', '1', '19');

-- ----------------------------
-- Table structure for num
-- ----------------------------
DROP TABLE IF EXISTS `num`;
CREATE TABLE `num` (
  `BookID` int(8) DEFAULT NULL,
  `SurNum` int(8) DEFAULT NULL,
  `LendNum` int(8) DEFAULT NULL,
  `BID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`BID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of num
-- ----------------------------
INSERT INTO `num` VALUES ('111', '100', '0', '11');
INSERT INTO `num` VALUES ('1', '1', '0', '12');
INSERT INTO `num` VALUES ('100', '0', '100', '13');

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press` (
  `BookName` varchar(255) DEFAULT NULL,
  `Press` varchar(255) DEFAULT NULL,
  `BNAME` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`BNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES ('哈哈', '哈哈出版社', '9');
INSERT INTO `press` VALUES ('哈哈哈', '哈哈哈粗版设', '10');
INSERT INTO `press` VALUES ('0001', '001', '11');

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `BookName` varchar(255) DEFAULT NULL,
  `Price` int(4) DEFAULT NULL,
  `BNAME` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`BNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES ('哈哈', '100', '8');
INSERT INTO `price` VALUES ('哈哈哈', '123', '9');
INSERT INTO `price` VALUES ('0001', '1', '10');

-- ----------------------------
-- Table structure for time
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time` (
  `CusID` int(8) DEFAULT NULL,
  `LendTime` int(11) DEFAULT NULL,
  `RetTime` int(11) DEFAULT NULL,
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time
-- ----------------------------
INSERT INTO `time` VALUES ('1001', '20150517', null, '1');
INSERT INTO `time` VALUES ('1001', null, '1', '2');
INSERT INTO `time` VALUES ('1001', null, '111', '3');
INSERT INTO `time` VALUES ('1001', null, '10', '4');
INSERT INTO `time` VALUES ('1002', '20150517', null, '5');
INSERT INTO `time` VALUES ('1002', null, '1', '6');
INSERT INTO `time` VALUES ('123123', '20150524', null, '7');
INSERT INTO `time` VALUES ('123123', null, '10', '8');
INSERT INTO `time` VALUES ('1', '20150401', null, '9');
