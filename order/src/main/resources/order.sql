/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80041
 Source Host           : localhost:3306
 Source Schema         : order

 Target Server Type    : MySQL
 Target Server Version : 80041
 File Encoding         : 65001

 Date: 10/03/2025 18:11:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sale_order_00
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_00`;
CREATE TABLE `sale_order_00`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint NULL DEFAULT NULL,
  `order_status` int NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_00
-- ----------------------------
INSERT INTO `sale_order_00` VALUES (2, 2000, 1, 2000, 2000, '2000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (3, 2000, 1, 2000, 2000, '3000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (4, 2000, 1, 2000, 2000, '4000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (5, 2000, 1, 2000, 2000, '5000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (6, 2000, 1, 2000, 2000, '6000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (7, 2000, 1, 2000, 2000, '7000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (8, 2000, 1, 2000, 2000, '8000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (9, 2000, 1, 2000, 2000, '9000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (10, 2000, 1, 2000, 2000, '10000', '2', '2', '2');
INSERT INTO `sale_order_00` VALUES (11, 2000, 1, 2000, 2000, '11000', '2', '2', '2');

-- ----------------------------
-- Table structure for sale_order_01
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_01`;
CREATE TABLE `sale_order_01`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint NULL DEFAULT NULL,
  `order_status` int NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_01
-- ----------------------------
INSERT INTO `sale_order_01` VALUES (2, 2000, 1, 2000, 2000, '1111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (3, 2000, 1, 2000, 2000, '11111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (4, 2000, 1, 2000, 2000, '111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (5, 2000, 1, 2000, 2000, '1111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (6, 2000, 1, 2000, 2000, '11111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (7, 2000, 1, 2000, 2000, '111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (8, 2000, 1, 2000, 2000, '1111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (9, 2000, 1, 2000, 2000, '11111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (10, 2000, 1, 2000, 2000, '111111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (11, 2000, 1, 2000, 2000, '1111111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (12, 2000, 1, 2000, 2000, '11111111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (13, 2000, 1, 2000, 2000, '111111111111111', '2', '2', '2');
INSERT INTO `sale_order_01` VALUES (14, 2000, 1, 2000, 2000, '1111111111111111', '2', '2', '2');

-- ----------------------------
-- Table structure for sale_order_consignee_00
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_consignee_00`;
CREATE TABLE `sale_order_consignee_00`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_no` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_consignee_00
-- ----------------------------

-- ----------------------------
-- Table structure for sale_order_consignee_01
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_consignee_01`;
CREATE TABLE `sale_order_consignee_01`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_no` bigint NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_consignee_01
-- ----------------------------

-- ----------------------------
-- Table structure for sale_order_ware_00
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_ware_00`;
CREATE TABLE `sale_order_ware_00`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` bigint NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `ware_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_no` bigint NULL DEFAULT NULL,
  `store_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_ware_00
-- ----------------------------

-- ----------------------------
-- Table structure for sale_order_ware_01
-- ----------------------------
DROP TABLE IF EXISTS `sale_order_ware_01`;
CREATE TABLE `sale_order_ware_01`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` bigint NULL DEFAULT NULL,
  `order_status` int NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `ware_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_no` bigint NULL DEFAULT NULL,
  `store_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_order_ware_01
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
