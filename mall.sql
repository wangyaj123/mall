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
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `user_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '�ύʱ��',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '�����ܽ��',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT 'Ӧ����ʵ��֧����',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '����Ա��̨��������ʹ�õ��ۿ۽��',
  `pay_type` int(1) DEFAULT NULL COMMENT '֧����ʽ��0->δ֧����1->֧������2->΢��',
  `status` int(1) DEFAULT NULL COMMENT '����״̬��0->�����1->��������2->�ѷ�����3->����ɣ�4->�ѹرգ�5->��Ч����',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '������˾(���ͷ�ʽ)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '��������',
  `confirm_status` int(1) DEFAULT NULL COMMENT 'ȷ���ջ�״̬��0->δȷ�ϣ�1->��ȷ��',
  `payment_time` bigint(13) DEFAULT NULL COMMENT '֧��ʱ��',
  `delivery_time` bigint(13) DEFAULT NULL COMMENT '����ʱ��',
  `receive_time` bigint(13) DEFAULT NULL COMMENT 'ȷ���ջ�ʱ��',
  `modify_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='������';

/*Data for the table `oms_order` */

/*Table structure for table `oms_order_return_apply` */

DROP TABLE IF EXISTS `oms_order_return_apply`;

CREATE TABLE `oms_order_return_apply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) NOT NULL COMMENT '����id',
  `shop_id` int(10) NOT NULL COMMENT '����',
  `create_time` bigint(13) DEFAULT NULL COMMENT '����ʱ��',
  `user_id` int(20) DEFAULT NULL COMMENT '��Ա�û���',
  `user_name` varchar(100) DEFAULT NULL COMMENT '�˻�������',
  `reason_id` varchar(200) DEFAULT NULL COMMENT 'ԭ��',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT 'ƾ֤ͼƬ���Զ��Ÿ���',
  `description` varchar(500) DEFAULT NULL COMMENT '����',
  `status` int(1) DEFAULT NULL COMMENT '����״̬��0->������1->�˻��У�2->����ɣ�3->�Ѿܾ�',
  `admin_name` varchar(100) DEFAULT NULL COMMENT '������Ա',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '����ע',
  `handle_time` bigint(13) DEFAULT NULL COMMENT '����ʱ��',
  `admin_id` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`order_id`,`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='�˻������';

/*Data for the table `oms_order_return_apply` */

/*Table structure for table `oms_order_return_reason` */

DROP TABLE IF EXISTS `oms_order_return_reason`;

CREATE TABLE `oms_order_return_reason` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '�˻�����',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '״̬��0->�����ã�1->����',
  `create_time` datetime DEFAULT NULL COMMENT '���ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='�˻�ԭ��';

/*Data for the table `oms_order_return_reason` */

/*Table structure for table `oms_shop_address` */

DROP TABLE IF EXISTS `oms_shop_address`;

CREATE TABLE `oms_shop_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT NULL COMMENT 'Ĭ�Ϸ�����ַ��0->��1->��',
  `phone` varchar(64) DEFAULT NULL COMMENT '�ջ��˵绰',
  `province` varchar(64) DEFAULT NULL COMMENT 'ʡ/ֱϽ��',
  `city` varchar(64) DEFAULT NULL COMMENT '��',
  `region` varchar(64) DEFAULT NULL COMMENT '��',
  `detail_address` varchar(200) DEFAULT NULL COMMENT '��ϸ��ַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='���̷�����ַ';

/*Data for the table `oms_shop_address` */

/*Table structure for table `pms_brand` */

DROP TABLE IF EXISTS `pms_brand`;

CREATE TABLE `pms_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT '����ĸ',
  `logo` varchar(255) DEFAULT NULL COMMENT 'Ʒ��logo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='Ʒ�Ʊ�';

/*Data for the table `pms_brand` */

/*Table structure for table `pms_product` */

DROP TABLE IF EXISTS `pms_product`;

CREATE TABLE `pms_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) NOT NULL COMMENT '��������',
  `brand_id` int(10) NOT NULL COMMENT 'Ʒ��',
  `product_category_id` int(10) NOT NULL COMMENT '����',
  `product_specifications_id` int(10) NOT NULL COMMENT '���',
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT '����',
  `publish_status` int(1) DEFAULT NULL COMMENT 'ɾ��״̬��0->δɾ����1->��ɾ��',
  `recommand_status` int(1) DEFAULT NULL COMMENT '��Ʒ״̬:0->������Ʒ��1->��Ʒ',
  `verify_status` int(1) DEFAULT NULL COMMENT '���״̬��0->δ��ˣ�1->���ͨ��',
  `price` decimal(10,2) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL COMMENT '������',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '�г���',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '��Ʒ������Ĭ��Ϊ��',
  `keywords` varchar(255) DEFAULT NULL,
  `detail_title` varchar(255) DEFAULT NULL,
  `description` text COMMENT '��Ʒ����',
  PRIMARY KEY (`id`,`shop_id`,`brand_id`,`product_category_id`,`product_specifications_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

/*Data for the table `pms_product` */

/*Table structure for table `pms_product_category` */

DROP TABLE IF EXISTS `pms_product_category`;

CREATE TABLE `pms_product_category` (
  `id` int(20) NOT NULL,
  `parent_id` int(20) DEFAULT NULL COMMENT '�ϻ�����ı�ţ�0��ʾһ������',
  `name` varchar(64) DEFAULT NULL,
  `level` int(1) DEFAULT NULL COMMENT '���༶��0->1����1->2��',
  `show_status` int(1) DEFAULT NULL COMMENT '��ʾ״̬��0->����ʾ��1->��ʾ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʒ�����';

/*Data for the table `pms_product_category` */

/*Table structure for table `pms_product_specifications` */

DROP TABLE IF EXISTS `pms_product_specifications`;

CREATE TABLE `pms_product_specifications` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_catagory_id` int(10) NOT NULL,
  `color` varchar(200) DEFAULT NULL COMMENT '��ѡ��ɫ',
  `specification` varchar(200) DEFAULT NULL COMMENT '��ѡ��ʽ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 COMMENT='��Ʒ����';

/*Data for the table `pms_product_specifications` */

/*Table structure for table `ums_admin` */

DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT 'ͷ��',
  `email` varchar(100) DEFAULT NULL COMMENT '����',
  `create_time` bigint(13) DEFAULT NULL COMMENT '����ʱ��',
  `llast_ogin_time` bigint(13) DEFAULT NULL COMMENT '����¼ʱ��',
  `status` int(1) DEFAULT '1' COMMENT '�ʺ�����״̬��0->���ã�1->����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����Ա��';

/*Data for the table `ums_admin` */

/*Table structure for table `ums_cart` */

DROP TABLE IF EXISTS `ums_cart`;

CREATE TABLE `ums_cart` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

/*Data for the table `ums_cart` */

/*Table structure for table `ums_shop` */

DROP TABLE IF EXISTS `ums_shop`;

CREATE TABLE `ums_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '账户',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `shop_name` varchar(64) DEFAULT NULL COMMENT '店铺名',
  `company_name` varchar(64) DEFAULT NULL COMMENT '公司名称',
  `company_address` varchar(128) DEFAULT NULL COMMENT '公司详细地址',
  `linkman_name` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `linkman_phone` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `license_number` varchar(64) DEFAULT NULL COMMENT '营业执照号',
  `legalman` varchar(64) DEFAULT NULL COMMENT '法定代表人',
  `legalman_id` varchar(64) DEFAULT NULL COMMENT '法定代表人身份证号',
  `bank_name` varchar(64) DEFAULT NULL COMMENT '开户行名称',
  `bank_count` varchar(64) NOT NULL COMMENT '银行账户',
  `description` varchar(500) DEFAULT NULL COMMENT '店铺描述',
  `create_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

/*Data for the table `ums_shop` */

/*Table structure for table `ums_user` */

DROP TABLE IF EXISTS `ums_user`;

CREATE TABLE `ums_user` (
  `id` int(10) NOT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '�û���',
  `password` varchar(64) DEFAULT NULL COMMENT '����',
  `phone` varchar(64) DEFAULT NULL COMMENT '�ֻ�����',
  `status` int(1) DEFAULT NULL COMMENT '�ʺ�����״̬:0->���ã�1->����',
  `create_time` bigint(13) DEFAULT NULL COMMENT 'ע��ʱ��',
  `icon` varchar(500) DEFAULT NULL COMMENT 'ͷ��',
  `last_login_time` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

/*Data for the table `ums_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
