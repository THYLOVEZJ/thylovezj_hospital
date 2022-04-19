/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : xdu_hospital

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/04/2022 15:31:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xdu_hospital_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `xdu_hospital_evaluate`;
CREATE TABLE `xdu_hospital_evaluate`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '评价表主键',
  `evaluate_id` int(0) NOT NULL COMMENT '评价人id',
  `be_evaluated_id` int(0) NOT NULL COMMENT '被评价人id',
  `score` int(0) NOT NULL COMMENT '得分1-差2-一般3-良好4-优秀',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评语',
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '评价时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xdu_hospital_patient
-- ----------------------------
DROP TABLE IF EXISTS `xdu_hospital_patient`;
CREATE TABLE `xdu_hospital_patient`  (
  `id` bigint(0) NOT NULL COMMENT '患者表主键',
  `user_id` int(0) NOT NULL COMMENT '患者id',
  `doctor_id` int(0) NOT NULL COMMENT '主治大夫id',
  `create_time` timestamp(0) NOT NULL COMMENT '入院时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xdu_hospital_problem
-- ----------------------------
DROP TABLE IF EXISTS `xdu_hospital_problem`;
CREATE TABLE `xdu_hospital_problem`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '问题表主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '问题内容',
  `answer` int(0) NOT NULL COMMENT '问题答案1-a 2-b 3-c',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '问题类型',
  `doctor_id` int(0) NOT NULL COMMENT '医生id',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '问题创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '问题更新时间',
  `check` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '问题选项,格式为[a.xxx,b.xxx,c.xxx]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xdu_hospital_score
-- ----------------------------
DROP TABLE IF EXISTS `xdu_hospital_score`;
CREATE TABLE `xdu_hospital_score`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '得分表主键',
  `user_id` int(0) NOT NULL COMMENT '参评人id',
  `score` int(0) NOT NULL COMMENT '得分',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '做题开始时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xdu_hospital_user
-- ----------------------------
DROP TABLE IF EXISTS `xdu_hospital_user`;
CREATE TABLE `xdu_hospital_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `personalized_signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
  `role` int(0) NOT NULL COMMENT '用户角色1.患者2.医生3.管理员',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '用户更新时间',
  `bonus` int(0) NOT NULL COMMENT '积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xdu_hospital_user
-- ----------------------------
INSERT INTO `xdu_hospital_user` VALUES (1, 'thy', '123456', NULL, 3, '2022-04-19 15:05:19', '2022-04-19 15:05:19', 0);

SET FOREIGN_KEY_CHECKS = 1;
