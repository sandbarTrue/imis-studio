/*
SQLyog v10.2 
MySQL - 5.1.68-community : Database - imis_studio
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`imis_studio` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `imis_studio`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL COMMENT '菜单名称',
  `link` varchar(20) DEFAULT NULL COMMENT '菜单地址',
  `parents` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `childs` int(11) DEFAULT NULL COMMENT '子菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL COMMENT '项目名称',
  `link` varchar(20) DEFAULT NULL COMMENT '项目地址',
  `info` varchar(50) DEFAULT NULL COMMENT '简介',
  `contributor` varchar(15) DEFAULT NULL COMMENT '贡献者',
  `img` varchar(20) DEFAULT NULL COMMENT '项目图像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL COMMENT '姓名',
  `main_station` varchar(100) DEFAULT NULL COMMENT '主站地址',
  `img` varchar(100) DEFAULT NULL COMMENT '头像',
  `info` varchar(255) DEFAULT NULL COMMENT '简介',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `resume` varchar(100) DEFAULT NULL COMMENT '简历',
  `grade` varchar(8) DEFAULT NULL COMMENT '年纪',
  `student_id` varchar(20) DEFAULT NULL COMMENT '学号',
  `github_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`main_station`,`img`,`info`,`email`,`password`,`resume`,`grade`,`student_id`,`github_address`) values (2,'ewew','','http://otdtwjwx2.bkt.clouddn.com/DSCF8470-1寸.jpg','','24234@qq.com','24324','','2010级','24324',NULL),(3,'周军','http://baidu.com','http://otdtwjwx2.bkt.clouddn.com/5.jpg','我超级厉害哈哈哈哈','1253641040@qq.com','2014210884','http://otdtwjwx2.bkt.clouddn.com/11731951388e07cfb0o.jpg','2014级','2014210884',NULL),(4,'test302','','http://otdtwjwx2.bkt.clouddn.com/11731951388e07cfb0o.jpg','','2321@q.cm','2323','','2014级','2323',NULL),(5,'yangqing','','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','121324@qq.com','2104210886','','2014级','2104210886',NULL),(6,'yangqing','','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','eweqw@qq.com','3434','','2014级','3434',NULL),(7,'yangqing','','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','231@qqq.com','1132','','2019级','1132',NULL),(8,'dsda','dasd','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','333@qq.com','23233','','2018级','23233','http://dsds.com'),(9,'问问','we','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','23432@qq.com','323432','','2018级','323432','eqwe'),(10,'eweq','','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','eq','24324@qq.com','2324','','2019级','2324','eq'),(11,'sewe','','http://otdtwjwx2.bkt.clouddn.com/shilan3.jpg','','3423@qq.com','232','','2014级','232','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
