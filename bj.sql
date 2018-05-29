/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.19 : Database - bj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bj`;

/*Table structure for table `t_apply` */

DROP TABLE IF EXISTS `t_apply`;

CREATE TABLE `t_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(25) DEFAULT NULL COMMENT '项目名称',
  `apply_person` varchar(25) DEFAULT NULL COMMENT '申请人',
  `apply_department` varchar(25) DEFAULT NULL COMMENT '申请部门',
  `apply_time` date DEFAULT NULL COMMENT '申请时间',
  `apply_msg` varchar(100) DEFAULT NULL COMMENT '申请信息',
  `phone` char(11) DEFAULT NULL COMMENT '联系人电话',
  `images` varchar(500) DEFAULT NULL COMMENT '材料图片信息',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态1草稿2专家处理中3正在办结中4完成',
  `result` varchar(100) DEFAULT '会议筹备中...' COMMENT '处理结果',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='申请文件';

/*Data for the table `t_apply` */

insert  into `t_apply`(`id`,`project_name`,`apply_person`,`apply_department`,`apply_time`,`apply_msg`,`phone`,`images`,`status`,`result`,`created_time`) values (39,'“19456”工程——通津坊片区规划设计方案','王东','毕节市天河城建开发投资有限公司','2018-05-07',NULL,'18786540452','452bbe987d014ce29e3bab3c4b646c2a.jpg,2c025a42d7c44e819640005d1521dae8.jpg,21dbee3fecf34b3b91b3be3ed5965c39.jpg',2,'会议筹备中','2018-05-08 16:05:14'),(40,'金沙县城市总体规划(2011—2030)','祝家顺','金沙县政府','2018-05-08',NULL,'18508511590','5d1c0585399b48df83e1b54cc0b45b7a.jpg,0f6e6d33dc22471fb7192b42ead5d81f.jpg,5bb7012564604c668b9e947364c3c675.jpg',2,'会议筹备中','2018-05-08 16:08:04'),(41,'南部新区六合安置房建设工程规划设计方案','古金龙','毕节市七星关区新宇建设投资有限公司','2018-05-04',NULL,'15685740678','cbb9caec5a03412e85244e413e33744d.jpg,d7f164aaa8e54aef991c99c52a4a6fe5.jpg,4832b4de93aa4c5c8ef1c5362d44ff5e.jpg,9842da84f0a6444e9593f614730c4d6e.jpg',2,'会议筹备中','2018-05-08 16:11:49'),(42,'金海湖新区文渊大道南段B段方案设计','王思红','毕节双山建投','2018-05-09',NULL,'18798316656','b202fd8825cf4eaca28c556bad704f2d.jpg,59e920ec7e2a4417bfae7a2b1bae99cd.jpg,1bb30b92108c4d8bb66a1ebacb5c38a2.jpg,a46ca308667645dea18024d3e86dce76.jpg',2,'会议筹备中','2018-05-09 10:47:51'),(44,'七星关区雍豪府商住楼项目规划方案','李钰','毕节市华垠房地产开发有限公司','2018-05-14',NULL,'13985356236','c779f62a1bd849779590675cd25fa8db.jpg,4c36ad1f4563478e9e7f3beba176ee03.jpg,59067aa69acf413b8b14946a28cbd028.jpg,7afddc83849e4ae98c9160f35b7d1327.jpg',2,'会议筹备中','2018-05-14 09:24:13'),(45,'金融守护押运毕节基地建设项目','朱工','贵州威振护运有限公司毕节分公司','2018-05-14',NULL,'18185080703','4e285eb0fc464d2fa4c0be290f214007.jpg,33ba75b760eb45a693c25d0ffdcf9d54.jpg,24faabbb053a444589c3aa6c5dc1a0fc.jpg,33b62a6b6ef04664b4e6d1708d68bd35.jpg',2,'专题会','2018-05-14 09:47:15'),(46,'毕节十五小迁建建设项目建筑规划设计方案','成校长','七星关区大新桥办事处教育管理中心','2018-05-14',NULL,'13339671639','d91651d9718c46dcb704db0cb329b8e5.jpg,e6e16a68f7104a70a86f6649397d71dc.jpg,6e18fec4e93e4ba7884f6b3a50547e75.jpg,0fc4e122c71b4e2783f657edb3d2a08b.jpg',2,'专题会','2018-05-14 09:49:52'),(47,'毕节市城市变电站站址用地及线路走廊控制规划','文茂聪','贵州电网有限责任公司毕节供电局','2018-05-14',NULL,'15885228026','1f3bbb4e50e54ef6998a6540ba79e2b7.jpg,990052101ad74618b29da849cb4a908e.jpg,3f062ca0c99b4b39a1ca536d999b7d56.jpg',2,'会议筹备中','2018-05-14 16:30:43'),(48,'毕节九小迁建项目规划方案','李远德','毕节市七星关区教育局','2018-05-15',NULL,'15885868933','84defc9b3ae048d89d60a5ba7e06a375.jpg,1e9f357cb2a44ce5827150e8e8cee09b.jpg,abea7a1f37e040eaa83e450b88116c45.jpg,f1877a4082544085bc364147c54ca3bc.jpg',2,'会议筹备中','2018-05-15 08:42:29'),(49,'毕节城市饱和网架规划','文茂聪','毕节市郊供电局','2018-05-15',NULL,'15885228026','a3c280b9f289412eb31d607ff1acaa71.jpg,2fa256b67a764545980d2eca6e341b23.jpg',2,'会议筹备中','2018-05-15 10:14:36'),(50,'碧海阳光小学规划设计方案','张宇辰','七星关区碧海街道教育管理中心','2018-05-17',NULL,'13867298743','c3d854e6b83847018a835a97bce2938a.jpg,88293aad9c6e45ce81d4a6a0e675684a.jpg,2f02a0c02d094054a0a43da25d2673db.jpg,82ec436a72f648aaaab91673d47ade72.jpg',2,'会议筹备中','2018-05-17 17:04:49'),(51,'万晟阳光城C地块规划方案设计','钟工','毕节万晟置业有限公司','2018-05-21',NULL,'15605753668','26e3536cb6b24c2c82cb6d752da581d9.jpg,29c81abfa07c4834b8b29742257a50d3.jpg,513afc9eab35477e936a3a0c23a96b4d.jpg',2,'会议筹备中','2018-05-21 15:43:51'),(52,'七星关柏秧林城棚改房源房建设项目规划方案','夏跃','七星关区益民住房建设投资有限公司','2018-05-21',NULL,'15117561537','9c023373318742e5acbf271ee4d9137f.jpg,f4d1e72cbc294cf9ad1b85a6ad33cc79.jpg,ce8cce7861f049669ad73a19f70e6f59.jpg',2,'会议筹备中','2018-05-21 15:48:41'),(53,'七星关区碧海加油站方案设计','徐启东','贵州京泰安能源有限公司','2018-05-21',NULL,'15823268279','d686b15b56cf4d7286493aea42823456.jpg,30a15d6390e6411583a4e64babec4733.jpg,229151a652864d7395c94575fe8df9be.jpg',2,'会议筹备中','2018-05-21 15:52:31'),(54,'金海湖新区双山片区SSc-09-02号地块','刘显奇','毕节市第一中学','2018-05-21',NULL,'13765887338','665e828138e34a9fa11a9b06913422f1.jpg,3fb1dd3d6f6745698ba65887bd24cb01.jpg,d8d386c508974dd087c0b3a582d7382d.jpg',2,'会议筹备中','2018-05-21 15:55:12');

/*Table structure for table `t_apply_record` */

DROP TABLE IF EXISTS `t_apply_record`;

CREATE TABLE `t_apply_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_id` int(11) DEFAULT NULL COMMENT '申请id',
  `user_id` int(11) DEFAULT NULL COMMENT '安排会议的人id',
  `meeting_id` int(11) DEFAULT NULL COMMENT '会议id',
  `personnel_id` int(11) DEFAULT NULL COMMENT '计划开会人',
  `planned_date` date DEFAULT NULL COMMENT '计划开会日期',
  `planned_time` char(5) DEFAULT NULL COMMENT '计划开会时间',
  `actual_date` date DEFAULT NULL COMMENT '实际开会日期',
  `actual_time` char(5) DEFAULT NULL COMMENT '实际开会时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '是否处理状态0未 1处理',
  `result` varchar(100) DEFAULT NULL COMMENT '会议结果',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='申请记录,,主要记录会议过程';

/*Data for the table `t_apply_record` */

insert  into `t_apply_record`(`id`,`apply_id`,`user_id`,`meeting_id`,`personnel_id`,`planned_date`,`planned_time`,`actual_date`,`actual_time`,`status`,`result`,`created_time`) values (33,39,21,16,19,'2018-05-10','08:30','2018-05-10','08:30',1,'','2018-05-08'),(34,40,21,16,19,'2018-05-10','08:30','2018-05-10','08:30',1,'','2018-05-08'),(35,41,15,16,19,'2018-05-10','08:30','2018-05-10','08:30',1,'','2018-05-08'),(40,44,21,16,16,'2018-05-16','08:30','2018-05-16','08:30',1,'不是狠完美告白气球','2018-05-15'),(41,45,15,17,16,'2018-05-16','10:00','2018-05-16','10:00',0,NULL,'2018-05-15'),(42,46,15,17,16,'2018-05-16','11:00','2018-05-16','11:00',0,NULL,'2018-05-15');

/*Table structure for table `t_meeting` */

DROP TABLE IF EXISTS `t_meeting`;

CREATE TABLE `t_meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(25) NOT NULL COMMENT '会议名称',
  `remarks` varchar(200) DEFAULT NULL COMMENT '会议内容说明',
  `order_by` tinyint(1) DEFAULT NULL COMMENT '排序',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='会议表';

/*Data for the table `t_meeting` */

insert  into `t_meeting`(`id`,`name`,`remarks`,`order_by`,`created_time`) values (16,'专家会','很多专家',1,'2018-04-11 21:36:00'),(17,'专题会','交流技术',2,'2018-04-11 21:36:15'),(18,'副主任会','',1,'2018-04-11 21:36:26'),(19,'副主任签定','',NULL,'2018-04-11 21:36:53'),(20,'主任会','',5,'2018-04-11 21:37:14'),(21,'主任签定',NULL,NULL,'2018-04-12 09:16:44');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) DEFAULT NULL COMMENT '角色名',
  `role_key` varchar(25) DEFAULT NULL COMMENT '角色标识',
  `level` tinyint(1) DEFAULT NULL COMMENT '角色等级',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `order_by` tinyint(1) DEFAULT NULL COMMENT '排序',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_name`,`role_key`,`level`,`remarks`,`order_by`,`created_time`) values (28,'授件人','',NULL,'',1,'2018-04-09'),(29,'处理专家','',NULL,'',2,'2018-04-09'),(30,'会议参与人员','select',NULL,'负责开会并汇报会议结果',3,'2018-04-09'),(31,'办结人员','',NULL,'文件办结处理人',4,'2018-04-09');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL COMMENT '用户名',
  `account` varchar(25) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `level` tinyint(1) DEFAULT NULL COMMENT '用户等级1申请人2专家3办结人4开会人',
  `status` tinyint(1) DEFAULT '1' COMMENT '可用状态1可用 0不可用',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `order_by` tinyint(1) DEFAULT NULL COMMENT '排序编号',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`account`,`password`,`phone`,`level`,`status`,`role_id`,`order_by`,`remarks`,`created_time`) values (14,'收件','收件','123','15085493115',1,1,28,NULL,'','2018-04-11'),(15,'会议中心1','会议1','123','123123131',2,1,28,NULL,'','2018-04-11'),(16,'开会1','开会1','123','1235',4,1,28,NULL,'',NULL),(17,'办结','办结','123',NULL,3,1,28,NULL,NULL,'2018-04-11'),(18,'领导','领导','123','3',0,1,NULL,NULL,NULL,NULL),(19,'开会2','开会2','123','1111',4,1,NULL,NULL,'',NULL),(20,'黄健','hj','123','15055555555',1,1,28,8,'','2018-05-08'),(21,'黄建或郑磊','hy','123','15000515405',2,1,29,4,'','2018-05-08'),(22,'开会人','kh','123','15051112313',4,1,30,2,'','2018-05-08'),(23,'办结','bj','123','1561312313',3,1,31,44,'','2018-05-08'),(24,'领导','ld','123','15085469333',0,1,NULL,8,'','2018-05-08');

/*Table structure for table `tbyw_customer` */

DROP TABLE IF EXISTS `tbyw_customer`;

CREATE TABLE `tbyw_customer` (
  `yhxm` varchar(50) NOT NULL,
  `djbh` varchar(100) NOT NULL,
  `yhdh` varchar(20) DEFAULT NULL,
  `jsxbh` varchar(100) DEFAULT NULL,
  `dtlb` varchar(100) DEFAULT NULL,
  `gtyt` varchar(100) DEFAULT NULL,
  `lsh` int(11) DEFAULT NULL,
  `ywc` varchar(100) DEFAULT NULL,
  `dwmc` varchar(100) DEFAULT NULL,
  `sshy` varchar(100) DEFAULT NULL,
  `dwdh` varchar(100) DEFAULT NULL,
  `dwlx` varchar(100) DEFAULT NULL,
  `yzbm` varchar(100) DEFAULT NULL,
  `dzyx` varchar(100) DEFAULT NULL,
  `bz` varchar(100) DEFAULT NULL,
  `djrq` varchar(50) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `dwdz` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbyw_customer` */

/*Table structure for table `tbyw_customerinfo` */

DROP TABLE IF EXISTS `tbyw_customerinfo`;

CREATE TABLE `tbyw_customerinfo` (
  `id` int(12) NOT NULL,
  `no` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `namejp` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `letterno` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `companyno` varchar(50) DEFAULT NULL,
  `companytype` varchar(50) DEFAULT NULL,
  `companytel` varchar(20) DEFAULT NULL,
  `companyindustryno` varchar(20) DEFAULT NULL,
  `companyaddress` varchar(200) DEFAULT NULL,
  `companypostalcode` varchar(20) DEFAULT NULL,
  `maptypeno` varchar(20) DEFAULT NULL,
  `mapuseno` varchar(20) DEFAULT NULL,
  `flowint` int(22) DEFAULT NULL,
  `iscommonweal` int(1) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `addtime` date DEFAULT NULL,
  `isaudit` int(1) DEFAULT NULL,
  `customerfrom` varchar(20) DEFAULT NULL,
  `companyname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbyw_customerinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
