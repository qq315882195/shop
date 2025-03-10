/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 80041
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 80041
 File Encoding         : 65001

 Date: 10/03/2025 18:10:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updated` bigint NULL DEFAULT NULL,
  `created` bigint NULL DEFAULT NULL,
  `mechant_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '测试门店1', '001', '测试地址', '120.213', '30.21312', 1, 1, 1);
INSERT INTO `store` VALUES (2, '测试门店3', '003', '测试地址', '120.213', '30.21312', 1, 1, 1);
INSERT INTO `store` VALUES (3, '测试门店4', '004', '测试地址', '120.213', '30.21312', 1, 1, 1);
INSERT INTO `store` VALUES (4, '测试门店5', '005', '测试地址', '120.213', '30.21312', 1, 1, 1);
INSERT INTO `store` VALUES (5, '测试门店6', '006', '测试地址', '120.213', '30.21312', 1, 1, 1);
INSERT INTO `store` VALUES (6, '门店名称', '', '地址', '经度', '纬度', NULL, NULL, NULL);
INSERT INTO `store` VALUES (7, '2', '1', '3', '4', '5', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
