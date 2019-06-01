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
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '∂©µ•id',
  `user_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT 'Ã·Ωª ±º‰',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '∂©µ•◊‹Ω∂Ó',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '”¶∏∂Ω∂Ó£® µº ÷ß∏∂Ω∂Ó£©',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT 'π‹¿Ì‘±∫ÛÃ®µ˜’˚∂©µ• π”√µƒ’€ø€Ω∂Ó',
  `pay_type` int(1) DEFAULT NULL COMMENT '÷ß∏∂∑Ω Ω£∫0->Œ¥÷ß∏∂£ª1->÷ß∏∂±¶£ª2->Œ¢–≈',
  `status` int(1) DEFAULT NULL COMMENT '∂©µ•◊¥Ã¨£∫0->¥˝∏∂øÓ£ª1->¥˝∑¢ªı£ª2->“—∑¢ªı£ª3->“—ÕÍ≥…£ª4->“—πÿ±’£ª5->Œﬁ–ß∂©µ•',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT 'ŒÔ¡˜π´Àæ(≈‰ÀÕ∑Ω Ω)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT 'ŒÔ¡˜µ•∫≈',
  `confirm_status` int(1) DEFAULT NULL COMMENT '»∑»œ ’ªı◊¥Ã¨£∫0->Œ¥»∑»œ£ª1->“—»∑»œ',
  `payment_time` bigint(13) DEFAULT NULL COMMENT '÷ß∏∂ ±º‰',
  `delivery_time` bigint(13) DEFAULT NULL COMMENT '∑¢ªı ±º‰',
  `receive_time` bigint(13) DEFAULT NULL COMMENT '»∑»œ ’ªı ±º‰',
  `modify_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='∂©µ•±Ì';

/*Data for the table `oms_order` */

/*Table structure for table `oms_order_return_apply` */

DROP TABLE IF EXISTS `oms_order_return_apply`;

CREATE TABLE `oms_order_return_apply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) NOT NULL COMMENT '∂©µ•id',
  `shop_id` int(10) NOT NULL COMMENT 'µÍ∆Ã',
  `create_time` bigint(13) DEFAULT NULL COMMENT '…Í«Î ±º‰',
  `user_id` int(20) DEFAULT NULL COMMENT 'ª·‘±”√ªß√˚',
  `user_name` varchar(100) DEFAULT NULL COMMENT 'ÕÀªı»À–’√˚',
  `reason_id` varchar(200) DEFAULT NULL COMMENT '‘≠“Ú',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT '∆æ÷§Õº∆¨£¨“‘∂∫∫≈∏Ùø™',
  `description` varchar(500) DEFAULT NULL COMMENT '√Ë ˆ',
  `status` int(1) DEFAULT NULL COMMENT '…Í«Î◊¥Ã¨£∫0->¥˝¥¶¿Ì£ª1->ÕÀªı÷–£ª2->“—ÕÍ≥…£ª3->“—æ‹æ¯',
  `admin_name` varchar(100) DEFAULT NULL COMMENT '¥¶¿Ì»À‘±',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '¥¶¿Ì±∏◊¢',
  `handle_time` bigint(13) DEFAULT NULL COMMENT '¥¶¿Ì ±º‰',
  `admin_id` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`order_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='ÕÀªı…Í«Î±Ì';

/*Data for the table `oms_order_return_apply` */

/*Table structure for table `oms_order_return_reason` */

DROP TABLE IF EXISTS `oms_order_return_reason`;

CREATE TABLE `oms_order_return_reason` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT 'ÕÀªı¿‡–Õ',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '◊¥Ã¨£∫0->≤ª∆Ù”√£ª1->∆Ù”√',
  `create_time` datetime DEFAULT NULL COMMENT 'ÃÌº” ±º‰',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='ÕÀªı‘≠“Ú';

/*Data for the table `oms_order_return_reason` */

/*Table structure for table `oms_shop_address` */

DROP TABLE IF EXISTS `oms_shop_address`;

CREATE TABLE `oms_shop_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT NULL COMMENT 'ƒ¨»œ∑¢ªıµÿ÷∑£∫0->∑Ò£ª1-> «',
  `phone` varchar(64) DEFAULT NULL COMMENT ' ’ªı»ÀµÁª∞',
  `province` varchar(64) DEFAULT NULL COMMENT ' °/÷±œΩ –',
  `city` varchar(64) DEFAULT NULL COMMENT ' –',
  `region` varchar(64) DEFAULT NULL COMMENT '«¯',
  `detail_address` varchar(200) DEFAULT NULL COMMENT 'œÍœ∏µÿ÷∑',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='µÍ∆Ã∑¢ªıµÿ÷∑';

/*Data for the table `oms_shop_address` */

/*Table structure for table `pms_brand` */

DROP TABLE IF EXISTS `pms_brand`;

CREATE TABLE `pms_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT ' ◊◊÷ƒ∏',
  `logo` varchar(255) DEFAULT NULL COMMENT '∆∑≈∆logo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='∆∑≈∆±Ì';

/*Data for the table `pms_brand` */

/*Table structure for table `pms_product` */

DROP TABLE IF EXISTS `pms_product`;

CREATE TABLE `pms_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) NOT NULL COMMENT 'À˘ ÙµÍ∆Ã',
  `brand_id` int(10) NOT NULL COMMENT '∆∑≈∆',
  `product_category_id` int(10) NOT NULL COMMENT '∑÷¿‡',
  `product_specifications_id` int(10) NOT NULL COMMENT 'πÊ∏Ò',
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT 'ªı∫≈',
  `publish_status` int(1) DEFAULT NULL COMMENT '…æ≥˝◊¥Ã¨£∫0->Œ¥…æ≥˝£ª1->“—…æ≥˝',
  `recommand_status` int(1) DEFAULT NULL COMMENT '–¬∆∑◊¥Ã¨:0->≤ª «–¬∆∑£ª1->–¬∆∑',
  `verify_status` int(1) DEFAULT NULL COMMENT '…Û∫À◊¥Ã¨£∫0->Œ¥…Û∫À£ª1->…Û∫ÀÕ®π˝',
  `price` decimal(10,2) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL COMMENT '∏±±ÍÃ‚',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT ' –≥°º€',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '…Ã∆∑÷ÿ¡ø£¨ƒ¨»œŒ™øÀ',
  `keywords` varchar(255) DEFAULT NULL,
  `detail_title` varchar(255) DEFAULT NULL,
  `description` text COMMENT '…Ã∆∑√Ë ˆ',
  PRIMARY KEY (`id`,`shop_id`,`brand_id`,`product_category_id`,`product_specifications_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='…Ã∆∑±Ì';

/*Data for the table `pms_product` */

/*Table structure for table `pms_product_category` */

DROP TABLE IF EXISTS `pms_product_category`;

CREATE TABLE `pms_product_category` (
  `id` int(20) NOT NULL,
  `parent_id` int(20) DEFAULT NULL COMMENT '…œª˙∑÷¿‡µƒ±‡∫≈£∫0±Ì æ“ªº∂∑÷¿‡',
  `name` varchar(64) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT '∑÷¿‡º∂±£∫0->1º∂£ª1->2º∂',
  `show_status` int(1) DEFAULT NULL COMMENT 'œ‘ æ◊¥Ã¨£∫0->≤ªœ‘ æ£ª1->œ‘ æ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='…Ã∆∑∑÷¿‡±Ì';

/*Data for the table `pms_product_category` */

/*Table structure for table `pms_product_specifications` */

DROP TABLE IF EXISTS `pms_product_specifications`;

CREATE TABLE `pms_product_specifications` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_catagory_id` int(10) NOT NULL,
  `color` varchar(200) DEFAULT NULL COMMENT 'ø…—°—’…´',
  `specification` varchar(200) DEFAULT NULL COMMENT 'ø…—°øÓ Ω',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 COMMENT='…Ã∆∑πÊ∏Ò±Ì';

/*Data for the table `pms_product_specifications` */

/*Table structure for table `ums_admin` */

DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'Õ∑œÒ',
  `email` varchar(100) DEFAULT NULL COMMENT '” œ‰',
  `create_time` bigint(13) DEFAULT NULL COMMENT '¥¥Ω® ±º‰',
  `llast_ogin_time` bigint(13) DEFAULT NULL COMMENT '◊Ó∫Ûµ«¬º ±º‰',
  `status` int(1) DEFAULT '1' COMMENT '’ ∫≈∆Ù”√◊¥Ã¨£∫0->Ω˚”√£ª1->∆Ù”√',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='π‹¿Ì‘±±Ì';

/*Data for the table `ums_admin` */

/*Table structure for table `ums_cart` */

DROP TABLE IF EXISTS `ums_cart`;

CREATE TABLE `ums_cart` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ë¥≠Áâ©ËΩ¶Ë°®';

/*Data for the table `ums_cart` */

/*Table structure for table `ums_shop` */

DROP TABLE IF EXISTS `ums_shop`;

CREATE TABLE `ums_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT 'Ë¥¶Êà∑',
  `password` varchar(64) DEFAULT NULL COMMENT 'ÂØÜÁ†Å',
  `shop_name` varchar(64) DEFAULT NULL COMMENT 'Â∫óÈì∫Âêç',
  `company_name` varchar(64) DEFAULT NULL COMMENT 'ÂÖ¨Âè∏ÂêçÁß∞',
  `company_address` varchar(128) DEFAULT NULL COMMENT 'ÂÖ¨Âè∏ËØ¶ÁªÜÂú∞ÂùÄ',
  `linkman_name` varchar(64) DEFAULT NULL COMMENT 'ËÅîÁ≥ª‰∫∫ÂßìÂêç',
  `linkman_phone` varchar(32) DEFAULT NULL COMMENT 'ËÅîÁ≥ª‰∫∫ÁîµËØù',
  `license_number` varchar(64) DEFAULT NULL COMMENT 'Ëê•‰∏öÊâßÁÖßÂè∑',
  `legalman` varchar(64) DEFAULT NULL COMMENT 'Ê≥ïÂÆö‰ª£Ë°®‰∫∫',
  `legalman_id` varchar(64) DEFAULT NULL COMMENT 'Ê≥ïÂÆö‰ª£Ë°®‰∫∫Ë∫´‰ªΩËØÅÂè∑',
  `bank_name` varchar(64) DEFAULT NULL COMMENT 'ÂºÄÊà∑Ë°åÂêçÁß∞',
  `bank_count` varchar(64) NOT NULL COMMENT 'Èì∂Ë°åË¥¶Êà∑',
  `description` varchar(500) DEFAULT NULL COMMENT 'Â∫óÈì∫ÊèèËø∞',
  `create_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Â∫óÈì∫Ë°®';

/*Data for the table `ums_shop` */

/*Table structure for table `ums_user` */

DROP TABLE IF EXISTS `ums_user`;

CREATE TABLE `ums_user` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '”√ªß√˚',
  `password` varchar(64) DEFAULT NULL COMMENT '√‹¬Î',
  `phone` varchar(64) DEFAULT NULL COMMENT ' ÷ª˙∫≈¬Î',
  `status` int(1) DEFAULT NULL COMMENT '’ ∫≈∆Ù”√◊¥Ã¨:0->Ω˚”√£ª1->∆Ù”√',
  `create_time` bigint(13) DEFAULT NULL COMMENT '◊¢≤· ±º‰',
  `icon` varchar(500) DEFAULT NULL COMMENT 'Õ∑œÒ',
  `last_login_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='”√ªß±Ì';

/*Data for the table `ums_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
