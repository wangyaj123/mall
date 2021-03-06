/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.62 : Database - mall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mall`;

/*Table structure for table `oms_order` */

DROP TABLE IF EXISTS `oms_order`;

CREATE TABLE `oms_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '提交时间',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '管理员后台调整订单使用的折扣金额',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `confirm_status` int(1) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `payment_time` bigint(13) DEFAULT NULL COMMENT '支付时间',
  `delivery_time` bigint(13) DEFAULT NULL COMMENT '发货时间',
  `receive_time` bigint(13) DEFAULT NULL COMMENT '确认收货时间',
  `modify_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `oms_order` */

/*Table structure for table `oms_order_return_apply` */

DROP TABLE IF EXISTS `oms_order_return_apply`;

CREATE TABLE `oms_order_return_apply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) NOT NULL COMMENT '订单id',
  `shop_id` int(10) NOT NULL COMMENT '店铺',
  `create_time` bigint(13) DEFAULT NULL COMMENT '申请时间',
  `user_id` int(20) DEFAULT NULL COMMENT '会员用户名',
  `user_name` varchar(100) DEFAULT NULL COMMENT '退货人姓名',
  `reason_id` varchar(200) DEFAULT NULL COMMENT '原因',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
  `admin_name` varchar(100) DEFAULT NULL COMMENT '处理人员',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '处理备注',
  `handle_time` bigint(13) DEFAULT NULL COMMENT '处理时间',
  `admin_id` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`order_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='退货申请表';

/*Data for the table `oms_order_return_apply` */

/*Table structure for table `oms_order_return_reason` */

DROP TABLE IF EXISTS `oms_order_return_reason`;

CREATE TABLE `oms_order_return_reason` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '退货类型',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='退货原因';

/*Data for the table `oms_order_return_reason` */

/*Table structure for table `oms_shop_address` */

DROP TABLE IF EXISTS `oms_shop_address`;

CREATE TABLE `oms_shop_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT NULL COMMENT '默认发货地址：0->否；1->是',
  `phone` varchar(64) DEFAULT NULL COMMENT '收货人电话',
  `province` varchar(64) DEFAULT NULL COMMENT '省/直辖市',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `region` varchar(64) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='店铺发货地址';

/*Data for the table `oms_shop_address` */

/*Table structure for table `pms_brand` */

DROP TABLE IF EXISTS `pms_brand`;

CREATE TABLE `pms_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT '首字母',
  `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='品牌表';

/*Data for the table `pms_brand` */

/*Table structure for table `pms_product` */

DROP TABLE IF EXISTS `pms_product`;

CREATE TABLE `pms_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) NOT NULL COMMENT '所属店铺',
  `brand_id` int(10) NOT NULL COMMENT '品牌',
  `product_category_id` int(10) NOT NULL COMMENT '分类',
  `product_specifications_id` int(10) NOT NULL COMMENT '规格',
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT '货号',
  `publish_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `recommand_status` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `verify_status` int(1) DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `price` decimal(10,2) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL COMMENT '副标题',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '商品重量，默认为克',
  `keywords` varchar(255) DEFAULT NULL,
  `detail_title` varchar(255) DEFAULT NULL,
  `description` text COMMENT '商品描述',
  PRIMARY KEY (`id`,`shop_id`,`brand_id`,`product_category_id`,`product_specifications_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Data for the table `pms_product` */

/*Table structure for table `pms_product_category` */

DROP TABLE IF EXISTS `pms_product_category`;

CREATE TABLE `pms_product_category` (
  `id` int(20) NOT NULL,
  `parent_id` int(20) DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `show_status` int(1) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类表';

/*Data for the table `pms_product_category` */

/*Table structure for table `pms_product_specifications` */

DROP TABLE IF EXISTS `pms_product_specifications`;

CREATE TABLE `pms_product_specifications` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_catagory_id` int(10) NOT NULL,
  `color` varchar(200) DEFAULT NULL COMMENT '可选颜色',
  `specification` varchar(200) DEFAULT NULL COMMENT '可选款式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 COMMENT='商品规格表';

/*Data for the table `pms_product_specifications` */

/*Table structure for table `ums_admin` */

DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `llast_ogin_time` bigint(13) DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*Data for the table `ums_admin` */

/*Table structure for table `ums_cart` */

DROP TABLE IF EXISTS `ums_cart`;

CREATE TABLE `ums_cart` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='璐墿杞﹁〃';

/*Data for the table `ums_cart` */

/*Table structure for table `ums_shop` */

DROP TABLE IF EXISTS `ums_shop`;

CREATE TABLE `ums_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '璐︽埛',
  `password` varchar(64) DEFAULT NULL COMMENT '瀵嗙爜',
  `shop_name` varchar(64) DEFAULT NULL COMMENT '搴楅摵鍚�',
  `company_name` varchar(64) DEFAULT NULL COMMENT '鍏徃鍚嶇О',
  `company_address` varchar(128) DEFAULT NULL COMMENT '鍏徃璇︾粏鍦板潃',
  `linkman_name` varchar(64) DEFAULT NULL COMMENT '鑱旂郴浜哄鍚�',
  `linkman_phone` varchar(32) DEFAULT NULL COMMENT '鑱旂郴浜虹數璇�',
  `license_number` varchar(64) DEFAULT NULL COMMENT '钀ヤ笟鎵х収鍙�',
  `legalman` varchar(64) DEFAULT NULL COMMENT '娉曞畾浠ｈ〃浜�',
  `legalman_id` varchar(64) DEFAULT NULL COMMENT '娉曞畾浠ｈ〃浜鸿韩浠借瘉鍙�',
  `bank_name` varchar(64) DEFAULT NULL COMMENT '寮�鎴疯鍚嶇О',
  `bank_count` varchar(64) NOT NULL COMMENT '閾惰璐︽埛',
  `description` varchar(500) DEFAULT NULL COMMENT '搴楅摵鎻忚堪',
  `create_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搴楅摵琛�';

/*Data for the table `ums_shop` */

/*Table structure for table `ums_user` */

DROP TABLE IF EXISTS `ums_user`;

CREATE TABLE `ums_user` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` bigint(13) DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `last_login_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `ums_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
