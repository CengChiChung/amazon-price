/*
 Navicat Premium Data Transfer

 Source Server         : Bruce's Mysql 8.0
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:23306
 Source Schema         : amazon_price

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 17/05/2021 23:47:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目录编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目录名称',
  `is_clothes` int(0) NOT NULL COMMENT '是否服装',
  `queue` int(0) NOT NULL COMMENT '显示顺序',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'CG000001', '3D 打印商品', 0, 29);
INSERT INTO `category` VALUES (2, 'CG000002', '亚马逊设备配件', 0, 31);
INSERT INTO `category` VALUES (3, 'CG000003', '汽车用品(轮胎和车轮商品除外)', 0, 23);
INSERT INTO `category` VALUES (5, 'CG000005', '汽车用品(轮胎和车轮商品)', 0, 24);
INSERT INTO `category` VALUES (6, 'CG000006', '母婴(婴儿服装除外)', 0, 11);
INSERT INTO `category` VALUES (7, 'CG000007', '美妆', 0, 4);
INSERT INTO `category` VALUES (8, 'CG000004', '图书', 0, 42);
INSERT INTO `category` VALUES (9, 'CG000008', '摄影摄像', 0, 14);
INSERT INTO `category` VALUES (10, 'CG000009', '手机设备', 0, 5);
INSERT INTO `category` VALUES (11, 'CG000010', '服装与配饰(鞋靴、手提包和太阳镜除外)', 1, 17);
INSERT INTO `category` VALUES (12, 'CG000011', '收藏品 - 图书', 0, 39);
INSERT INTO `category` VALUES (13, 'CG000012', '收藏品 - 硬币', 0, 38);
INSERT INTO `category` VALUES (14, 'CG000013', '收藏品 - 娱乐或体育用品', 0, 37);
INSERT INTO `category` VALUES (15, 'CG000014', '电视/音响', 0, 25);
INSERT INTO `category` VALUES (16, 'CG000015', '电子产品配件', 0, 6);
INSERT INTO `category` VALUES (17, 'CG000016', '艺术品', 0, 26);
INSERT INTO `category` VALUES (18, 'CG000017', '家具和装饰(床垫除外)', 0, 12);
INSERT INTO `category` VALUES (19, 'CG000018', '礼品卡', 0, 36);
INSERT INTO `category` VALUES (20, 'CG000019', '食品杂货和美食', 0, 35);
INSERT INTO `category` VALUES (21, 'CG000020', '健康及个人护理(包括个人护理用具)', 0, 15);
INSERT INTO `category` VALUES (22, 'CG000021', '家居与园艺(包括宠物用品)', 0, 7);
INSERT INTO `category` VALUES (23, 'CG000022', '工业与科学用品(包括餐饮服务和清洁卫生用品)', 0, 18);
INSERT INTO `category` VALUES (24, 'CG000023', '珠宝首饰', 0, 19);
INSERT INTO `category` VALUES (25, 'CG000024', '厨房用品', 0, 8);
INSERT INTO `category` VALUES (26, 'CG000025', '箱包和旅行用品', 0, 20);
INSERT INTO `category` VALUES (27, 'CG000026', '大型家电', 0, 32);
INSERT INTO `category` VALUES (28, 'CG000027', '音乐', 0, 33);
INSERT INTO `category` VALUES (29, 'CG000028', '乐器', 0, 28);
INSERT INTO `category` VALUES (30, 'CG000029', '办公用品', 0, 3);
INSERT INTO `category` VALUES (31, 'CG000030', '户外用品', 0, 2);
INSERT INTO `category` VALUES (32, 'CG000031', '个人电脑', 0, 30);
INSERT INTO `category` VALUES (33, 'CG000032', '服装与配饰(鞋靴、手提包和太阳镜)', 1, 16);
INSERT INTO `category` VALUES (34, 'CG000033', '软件和电脑/视频游戏', 0, 34);
INSERT INTO `category` VALUES (35, 'CG000034', '体育用品(体育收藏品除外)', 0, 9);
INSERT INTO `category` VALUES (36, 'CG000035', '工具和家居装修(基础设备电动工具除外)', 0, 21);
INSERT INTO `category` VALUES (44, 'CG000036', '工具和家居装修(基础设备电动工具)', 0, 22);
INSERT INTO `category` VALUES (45, 'CG000037', '玩具和游戏', 0, 10);
INSERT INTO `category` VALUES (46, 'CG000038', '解锁手机', 0, 40);
INSERT INTO `category` VALUES (47, 'CG000039', '视频和 DVD', 0, 41);
INSERT INTO `category` VALUES (48, 'CG000040', '视频游戏机', 0, 43);
INSERT INTO `category` VALUES (49, 'CG000041', '钟表', 0, 27);
INSERT INTO `category` VALUES (50, 'CG000042', '其他(15%销售佣金)', 0, 1);
INSERT INTO `category` VALUES (51, 'CG000043', '家具和装饰(床垫)', 0, 13);

-- ----------------------------
-- Table structure for commission
-- ----------------------------
DROP TABLE IF EXISTS `commission`;
CREATE TABLE `commission`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目录编码',
  `section` tinyint(0) UNSIGNED NOT NULL COMMENT '第n段收费',
  `begin` decimal(10, 2) NOT NULL COMMENT '征收起点',
  `end` decimal(10, 2) NOT NULL COMMENT '征收终点',
  `commission_percent` decimal(10, 2) UNSIGNED NOT NULL COMMENT '销售佣金百分比',
  `min_commission` decimal(10, 2) UNSIGNED NOT NULL COMMENT '最低销售佣金（只有第一段收费有）',
  `is_split_cost` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否分段收费',
  `addition` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '附加费用（例如：交易手续费）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commission
-- ----------------------------
INSERT INTO `commission` VALUES (1, 'CG000001', 1, 0.00, -1.00, 12.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (2, 'CG000002', 1, 0.00, -1.00, 45.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (3, 'CG000003', 1, 0.00, -1.00, 12.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (4, 'CG000005', 1, 0.00, -1.00, 10.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (5, 'CG000006', 1, 0.00, 10.00, 8.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (6, 'CG000007', 1, 0.00, 10.00, 8.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (7, 'CG000004', 1, 0.00, -1.00, 15.00, 0.00, b'1', 1.80);
INSERT INTO `commission` VALUES (8, 'CG000008', 1, 0.00, -1.00, 8.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (9, 'CG000009', 1, 0.00, -1.00, 8.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (10, 'CG000010', 1, 0.00, -1.00, 17.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (11, 'CG000011', 1, 0.00, -1.00, 15.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (12, 'CG000012', 1, 0.00, 250.00, 15.00, 1.00, b'1', 0.00);
INSERT INTO `commission` VALUES (13, 'CG000013', 1, 0.00, 100.00, 15.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (14, 'CG000014', 1, 0.00, -1.00, 8.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (15, 'CG000015', 1, 0.00, 100.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (16, 'CG000016', 1, 0.00, 100.00, 20.00, 1.00, b'1', 0.00);
INSERT INTO `commission` VALUES (17, 'CG000017', 1, 0.00, 200.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (18, 'CG000018', 1, 0.00, -1.00, 20.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (19, 'CG000019', 1, 0.00, 15.00, 8.00, 0.00, b'0', 0.00);
INSERT INTO `commission` VALUES (20, 'CG000020', 1, 0.00, 10.00, 8.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (21, 'CG000021', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (22, 'CG000022', 1, 0.00, -1.00, 12.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (23, 'CG000023', 1, 0.00, 250.00, 20.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (24, 'CG000024', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (25, 'CG000025', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (26, 'CG000026', 1, 0.00, 300.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (27, 'CG000027', 1, 0.00, -1.00, 15.00, 0.00, b'1', 1.80);
INSERT INTO `commission` VALUES (28, 'CG000028', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (29, 'CG000029', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (30, 'CG000030', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (31, 'CG000031', 1, 0.00, -1.00, 6.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (32, 'CG000032', 1, 0.00, 75.00, 18.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (33, 'CG000033', 1, 0.00, -1.00, 15.00, 0.00, b'1', 1.80);
INSERT INTO `commission` VALUES (34, 'CG000034', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (35, 'CG000035', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (36, 'CG000036', 1, 0.00, -1.00, 12.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (37, 'CG000037', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (38, 'CG000038', 1, 0.00, -1.00, 8.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (39, 'CG000039', 1, 0.00, -1.00, 15.00, 0.00, b'1', 1.80);
INSERT INTO `commission` VALUES (40, 'CG000040', 1, 0.00, -1.00, 8.00, 0.00, b'1', 1.80);
INSERT INTO `commission` VALUES (41, 'CG000041', 1, 0.00, 1500.00, 16.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (42, 'CG000042', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (43, 'CG000006', 1, 10.00, -1.00, 15.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (44, 'CG000007', 1, 10.00, -1.00, 15.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (45, 'CG000012', 2, 250.00, 1000.00, 10.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (46, 'CG000012', 3, 1000.00, -1.00, 6.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (47, 'CG000013', 2, 100.00, 1000.00, 10.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (48, 'CG000013', 3, 1000.00, -1.00, 6.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (49, 'CG000015', 2, 100.00, -1.00, 8.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (50, 'CG000016', 2, 100.00, 1000.00, 15.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (51, 'CG000016', 3, 1000.00, 5000.00, 10.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (52, 'CG000016', 4, 5000.00, -1.00, 5.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (53, 'CG000017', 2, 200.00, -1.00, 10.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (54, 'CG000043', 1, 0.00, -1.00, 15.00, 0.30, b'1', 0.00);
INSERT INTO `commission` VALUES (55, 'CG000019', 1, 15.00, -1.00, 15.00, 0.00, b'0', 0.00);
INSERT INTO `commission` VALUES (56, 'CG000020', 1, 10.00, -1.00, 15.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (57, 'CG000023', 2, 250.00, -1.00, 5.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (58, 'CG000026', 2, 300.00, -1.00, 8.00, 0.00, b'1', 0.00);
INSERT INTO `commission` VALUES (59, 'CG000032', 1, 75.00, -1.00, 15.00, 0.30, b'0', 0.00);
INSERT INTO `commission` VALUES (60, 'CG000041', 2, 1500.00, -1.00, 3.00, 0.00, b'1', 0.00);

-- ----------------------------
-- Table structure for size
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尺寸编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '尺寸名称',
  `max_weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '最大重量',
  `first_long` decimal(10, 2) NULL DEFAULT NULL COMMENT '最长边',
  `second_long` decimal(10, 2) NULL DEFAULT NULL COMMENT '次长边',
  `third_long` decimal(10, 2) NULL DEFAULT NULL COMMENT '最短边',
  `girth` decimal(10, 2) NULL DEFAULT NULL COMMENT '长度+围度',
  `queue` int(0) NOT NULL COMMENT '顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES (1, 'SZ000001', '小号标准尺寸', 340.20, 38.10, 30.48, 1.91, -1.00, 1);
INSERT INTO `size` VALUES (2, 'SZ000002', '大号标准尺寸', 9071.85, 45.72, 35.56, 20.32, -1.00, 2);
INSERT INTO `size` VALUES (3, 'SZ000003', '小号大件', 31751.47, 152.40, 76.20, -1.00, 330.20, 3);
INSERT INTO `size` VALUES (4, 'SZ000004', '中号大件', 68038.86, 274.32, -1.00, -1.00, 330.20, 4);
INSERT INTO `size` VALUES (5, 'SZ000005', '大号大件', 68038.86, 274.32, -1.00, -1.00, 419.10, 5);
INSERT INTO `size` VALUES (6, 'SZ000006', '特殊大件', -1.00, -1.00, -1.00, -1.00, -1.00, 6);

SET FOREIGN_KEY_CHECKS = 1;
