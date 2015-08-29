/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.27 : Database - zhgw_search
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhgw_search` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zhgw_search`;

/*Table structure for table `t_laws` */

DROP TABLE IF EXISTS `t_laws`;

CREATE TABLE `t_laws` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '法规名称',
  `content` varchar(1024) DEFAULT NULL COMMENT '法规内容',
  `isValid` int(11) NOT NULL DEFAULT '1' COMMENT '0 无效 1 有效',
  `parentId` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_laws` */

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_question` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `realName` varchar(64) DEFAULT NULL,
  `sex` int(11) NOT NULL DEFAULT '1' COMMENT '0 女  1 男',
  `age` int(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `isValid` int(11) NOT NULL DEFAULT '1' COMMENT '0 无效 1 有效',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`name`) values (2,'34234'),(5,'546456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
