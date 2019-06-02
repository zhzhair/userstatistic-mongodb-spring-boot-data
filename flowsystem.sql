/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : flowsystem

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-30 08:43:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appstart_record0`
-- ----------------------------
DROP TABLE IF EXISTS `appstart_record0`;
CREATE TABLE `appstart_record0` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `APP_CHANNEL` varchar(20) NOT NULL,
  `DEVICE_ID` varchar(50) NOT NULL,
  `DEVICE_HASHCODE` int(20) NOT NULL,
  `DEVICE_HASHCODE_IDX` int(6) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_device` (`DEVICE_HASHCODE_IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appstart_record0
-- ----------------------------

-- ----------------------------
-- Table structure for `appstart_record1`
-- ----------------------------
DROP TABLE IF EXISTS `appstart_record1`;
CREATE TABLE `appstart_record1` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `APP_CHANNEL` varchar(20) NOT NULL,
  `DEVICE_ID` varchar(50) NOT NULL,
  `DEVICE_HASHCODE` int(20) NOT NULL,
  `DEVICE_HASHCODE_IDX` int(6) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_device` (`DEVICE_HASHCODE_IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appstart_record1
-- ----------------------------

-- ----------------------------
-- Table structure for `appstart_record2`
-- ----------------------------
DROP TABLE IF EXISTS `appstart_record2`;
CREATE TABLE `appstart_record2` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `APP_CHANNEL` varchar(20) NOT NULL,
  `DEVICE_ID` varchar(50) NOT NULL,
  `DEVICE_HASHCODE` int(20) NOT NULL,
  `DEVICE_HASHCODE_IDX` int(6) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_device` (`DEVICE_HASHCODE_IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appstart_record2
-- ----------------------------

-- ----------------------------
-- Table structure for `appstart_record3`
-- ----------------------------
DROP TABLE IF EXISTS `appstart_record3`;
CREATE TABLE `appstart_record3` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `APP_CHANNEL` varchar(20) NOT NULL,
  `DEVICE_ID` varchar(50) NOT NULL,
  `DEVICE_HASHCODE` int(20) NOT NULL,
  `DEVICE_HASHCODE_IDX` int(6) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_device` (`DEVICE_HASHCODE_IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appstart_record3
-- ----------------------------
