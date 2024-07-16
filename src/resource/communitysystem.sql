/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : communitysystem

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 16/07/2024 15:17:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `floor_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `floor_manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `floor_host` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `floor_sum` int NOT NULL,
  `floor_housenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `floor_index` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`floor_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES ('1', '黄四', '王五', 200, '1-1-01', 1);
INSERT INTO `floor` VALUES ('1', '王七', '刘二', 200, '1-1-02', 2);
INSERT INTO `floor` VALUES ('1', '大胖', '李四', 200, '1-1-03', 3);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_post` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_index` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`manager_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('王刚', '2266-301', '楼管', '男', 1);
INSERT INTO `manager` VALUES ('大红', '1122-2246', '楼管', '女', 2);
INSERT INTO `manager` VALUES ('大山', '5654-123', '安保队长', '男', 3);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_info` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `message_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `message_date` date NOT NULL,
  `message_index` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`message_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('多读书，书到用时方恨少', 'Sunshine', '2022-11-29', 1);
INSERT INTO `message` VALUES ('多留心，留心处处皆学问', 'Sunshine', '2022-12-02', 2);
INSERT INTO `message` VALUES ('多思考，行成于思毁于随', 'Sunshine', '2022-12-15', 3);
INSERT INTO `message` VALUES ('多积累，厚积薄发生威力', 'Sunshine', '2022-12-15', 4);
INSERT INTO `message` VALUES ('一寸光阴一寸金，寸金难买寸光阴', '小学生', '2022-12-20', 5);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_index` int NOT NULL AUTO_INCREMENT,
  `notice_info` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `notice_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `notice_date` date NOT NULL,
  PRIMARY KEY (`notice_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '非必要不要外出，外出戴口罩，做好防疫保护', '老李', '2022-12-08');
INSERT INTO `notice` VALUES (2, '请勿乱扔垃圾，爱护社区卫生', '老张', '2022-12-08');
INSERT INTO `notice` VALUES (3, '尊法守法，争做社区好公民', '老刘', '2022-12-12');

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident`  (
  `resident_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resident_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resident_housenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resident_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resident_index` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`resident_index`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('大壮', '4567-896', '5-4-06', '男', 5);
INSERT INTO `resident` VALUES ('大雄', '1111-101', '8-6-03', '男', 6);
INSERT INTO `resident` VALUES ('小乐', '1234-567', '5-6-07', '女', 7);
INSERT INTO `resident` VALUES ('小娜', '5649-101', '2-3-05', '女', 8);
INSERT INTO `resident` VALUES ('小方', '3434-302', '3-3-12', '女', 9);
INSERT INTO `resident` VALUES ('小菜', '5436-303', '3-8-12', '男', 10);
INSERT INTO `resident` VALUES ('小雨', '4531-123', '4-5-01', '女', 11);
INSERT INTO `resident` VALUES ('李四', '0858-102', '1-1-03', '男', 12);
INSERT INTO `resident` VALUES ('狗蛋', '0858-300', '7-8-09', '男', 13);
INSERT INTO `resident` VALUES ('王五', '0858-100', '1-1-01', '男', 14);
INSERT INTO `resident` VALUES ('二状', '2222-201', '1-8-06', '女', 19);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_password` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_ident` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_name`, `user_password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('小刘', '333333', 'resident');
INSERT INTO `user` VALUES ('小强', '654321', 'resident');
INSERT INTO `user` VALUES ('小高', '456789', 'resident');
INSERT INTO `user` VALUES ('张三', '111111', 'resident');
INSERT INTO `user` VALUES ('李四', '222222', 'manager');
INSERT INTO `user` VALUES ('老刘', '987654', 'resident');
INSERT INTO `user` VALUES ('老张', '123456', 'manager');

SET FOREIGN_KEY_CHECKS = 1;
