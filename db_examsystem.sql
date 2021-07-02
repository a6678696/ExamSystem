/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - db_examsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_examsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_examsystem`;

/*Table structure for table `t_answer` */

DROP TABLE IF EXISTS `t_answer`;

CREATE TABLE `t_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(300) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `isTrue` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8;

/*Data for the table `t_answer` */

insert  into `t_answer`(`id`,`content`,`questionId`,`isTrue`) values (38,'81',16,1),(39,'83',16,0),(40,'85',16,0),(41,'79',16,0),(42,'104',17,1),(43,'97',18,1),(44,'118',19,0),(45,'128',19,0),(46,'138',19,1),(47,'148',19,0),(48,'133',20,0),(49,'143',20,1),(50,'153',20,0),(51,'163',20,0),(52,'143',21,1),(53,'2',22,0),(54,'4',22,1),(55,'6',22,0),(56,'60',22,0),(57,'20',23,0),(58,'12',23,0),(59,'10',23,1),(60,'2',23,0),(61,'6只鸡',24,0),(62,'5支铅笔',24,0),(63,'2栋楼房',24,0),(64,'第2节课',24,1),(65,'6869',25,0),(66,'9999',25,0),(67,'10000',25,1),(68,'10001',25,0),(69,'12',26,0),(70,'600',26,1),(71,'300',26,0),(72,'无法确定',26,0),(73,'94',27,0),(74,'96',27,0),(75,'98',27,1),(76,'99',27,0),(77,'4',28,0),(78,'5',28,1),(79,'6',28,0),(80,'7',28,0),(81,'4',29,1),(82,'大于',30,1),(83,'小于',30,0),(84,'等于',30,0),(85,'小于或等于',30,0),(86,'酒精的体积是整瓶酒的体积的58%',31,0),(87,'酒精的质量是整瓶酒的质量的58%',31,1),(88,'酒精的体积是整瓶酒的质量的58%',31,0),(89,'酒精的质量是整瓶酒的体积的58%',31,0),(90,'b>c',32,0),(91,'b=c',32,0),(92,'b<c',32,1),(93,'比不清楚',32,0),(102,'62.5%',38,0),(103,'60.5%',38,0),(104,'40%',38,0),(105,'37.5%',38,1),(106,'115%',39,1),(122,'sleep是线程类（Thread）的方法，wait是Object类的方法；',49,0),(123,'sleep不释放对象锁，wait放弃对象锁；',49,0),(124,'sleep暂停线程、但监控状态仍然保持，结束后会自动恢复；',49,0),(125,'wait后进入等待锁定池，只有针对此对象发出notify方法后获得对象锁进入运行状态。',49,1),(126,'setLayout(aLayoutManager);',50,1),(127,'addLayout(aLayoutManager);',50,0),(128,'layout(aLayoutManager);',50,0),(129,'setLayoutManager(aLayoutManager);',50,0),(130,'<applet code=Test.class age=33 width=1 height=1>',51,0),(131,'<param name=age value=33>',51,1),(132,'<applet code=Test.class name=age value=33 width=1 height=1>',51,0),(133,'<applet Test 33>',51,0),(134,'java.sql',52,1),(135,'java.awt',52,0),(136,'java.lang',52,0),(137,'java.swing',52,0),(138,'将private int m改为 protected int m',53,0),(139,'将private int m改为 public int m',53,0),(140,'将private int m改为 static int m',53,1),(141,'将private int m改为int m',53,0),(142,'匿名上网',54,0),(143,'总在晚上上网',54,0),(144,'在网上私闯他人计算机系统',54,1),(145,'不花钱上网',54,0),(146,'防止系统崩溃',55,0),(147,'防病毒',55,0),(148,'保护内部网络安全',55,1),(149,'预防火灾',55,0),(150,'不同CPU的计算机有不同的机器语言和汇编语言',56,0),(151,'回收站是硬盘中的一块区域，而剪贴板是内存中的一块区域',56,0),(152,'在Dos中可以用的文件名在windows 98中一定可用',56,0),(153,'计算机病毒不可能会驻留在BIOS中',56,1),(154,'IP',57,0),(155,'TCP',57,0),(156,'SNMP',57,0),(157,'SMTP',57,1),(158,'server.transfer',58,0),(159,'response.redirect',58,0),(160,'mapping.findForward',58,1),(161,'response.sendRedirect',58,0),(162,'UPDATE',59,0),(163,'FIND',59,0),(164,'SELECT',59,1),(165,'CREATE',59,0),(166,'COUNT',60,0),(167,'MAX',60,0),(168,'AVG',60,0),(169,'MIN',60,1),(170,'DML',61,0),(171,'DDL',61,0),(172,'DQL',61,1),(173,'DCL',61,0),(174,'mysqldump',62,0),(175,'username',62,0),(176,'dbname',62,1),(177,'BackupName.sql',62,0),(178,'用户—角色',63,1),(179,'用户—银行卡',63,0),(180,'用户—手机号',63,0),(181,'学生—语文成绩',63,0),(182,'类属性的个数必须要和表中的字段个数一致',64,0),(183,'类属性的名称必须要和表中的字段的名称一致',64,0),(184,'类属性的数据类型需要和表中的字段的数据类型对应',64,1),(185,'varchar类型的表字段可以对应到java类中的int类型属性',64,0),(186,'主键约束',65,0),(187,'为空约束',65,0),(188,'唯一约束',65,0),(189,'外键约束',65,1),(190,'可变精度浮点值',66,1),(191,'整数值',66,0),(192,'双精度浮点值',66,0),(193,'单精度浮点值',66,0),(194,'包括20岁不包括30岁',67,0),(195,'不包括20岁包括30岁',67,0),(196,'不包括20岁和30岁',67,0),(197,'包括20岁和30岁',67,1),(198,'select',68,0),(199,'group by',68,0),(200,'where',68,1),(201,'from',68,0),(202,'COUNT',69,0),(203,'MAX',69,0),(204,'AVG',69,1),(205,'SUM',69,0),(206,'老师—学生',70,0),(207,'用户—银行卡',70,1),(208,'学科—课程 ',70,0),(209,'学生—语文成绩;',70,0),(210,'JOIN',71,0),(211,'RIGHT JOIN',71,0),(212,'LEFT JOIN',71,0),(213,'INNER JOIN',71,1),(216,'自然数',74,0),(217,'整数',74,0),(218,'分数',74,0),(219,'零',74,1),(220,'DML',75,0),(221,'DDL',75,1),(222,'DQL',75,0),(223,'DCL',75,0),(224,'mysqldump',76,0),(225,'table1',76,0),(226,'root',76,0),(227,'backup.sql',76,1),(228,'是',77,1),(229,'是',78,1),(230,'是',79,1),(231,'是',80,1),(232,'是',81,1);

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `minutes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

insert  into `t_course`(`id`,`name`,`minutes`) values (1,'语文',30),(2,'数学',30),(3,'英语',30),(4,'物理',30),(5,'Java',30),(6,'MySQL',20);

/*Table structure for table `t_paper` */

DROP TABLE IF EXISTS `t_paper`;

CREATE TABLE `t_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseName` varchar(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8;

/*Data for the table `t_paper` */

insert  into `t_paper`(`id`,`userId`,`courseName`,`createDate`,`score`,`userName`) values (274,1,'MySQL','2021-07-03 03:31:38',90,'111');

/*Table structure for table `t_paper_question` */

DROP TABLE IF EXISTS `t_paper_question`;

CREATE TABLE `t_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionId` int(11) DEFAULT NULL,
  `answer` varchar(300) DEFAULT NULL,
  `paperId` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `courseName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_paper_question_ibfk_1` (`paperId`),
  CONSTRAINT `t_paper_question_ibfk_1` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5421 DEFAULT CHARSET=utf8;

/*Data for the table `t_paper_question` */

insert  into `t_paper_question`(`id`,`questionId`,`answer`,`paperId`,`score`,`courseName`) values (5401,62,'3',274,5,'单选题'),(5402,75,'2',274,5,'单选题'),(5403,63,'1',274,5,'单选题'),(5404,68,'3',274,5,'单选题'),(5405,65,'4',274,5,'单选题'),(5406,71,'4',274,5,'单选题'),(5407,66,'1',274,5,'单选题'),(5408,76,'4',274,5,'单选题'),(5409,61,'2',274,0,'单选题'),(5410,67,'4',274,5,'单选题'),(5411,60,'4',274,5,'单选题'),(5412,59,'3',274,5,'单选题'),(5413,69,'3',274,5,'单选题'),(5414,64,'3',274,5,'单选题'),(5415,70,'2',274,5,'单选题'),(5416,77,'是',274,5,'填空题'),(5417,80,'是',274,5,'填空题'),(5418,78,'是',274,5,'填空题'),(5419,79,'是',274,5,'填空题'),(5420,81,'answerIsNull',274,0,'填空题');

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(300) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

/*Data for the table `t_question` */

insert  into `t_question`(`id`,`content`,`courseId`,`addDate`,`type`,`userId`) values (16,'44+37=?',2,'2021-06-28 23:08:23','单选题',2),(17,'37+67=?',2,'2021-06-28 23:08:53','填空题',2),(18,'32+65=?',2,'2021-06-28 23:09:43','填空题',2),(19,'23×6=?',2,'2021-06-28 23:11:14','单选题',2),(20,'11×13=？',2,'2021-06-28 23:18:47','单选题',2),(21,'88+55=?',2,'2021-06-28 23:19:48','填空题',2),(22,'数a分解质因数是a=2×2×3，数b分解质因数是b=2×2×5，数a和数b的最大公因数是',2,'2021-06-28 23:54:04','单选题',2),(23,'已知3个数的和是470，第一个数比第二个数多160，第三个数比第一个数少180，这三个数的最大公因数是',2,'2021-06-29 00:05:47','单选题',2),(24,'下列选项中的数是序数的是',2,'2021-06-29 02:05:26','单选题',2),(25,'某地区的电话号码是一个八位数，已知其前四位数是一个固定数6869，那么该地区最多可安装（）部电话',2,'2021-06-29 02:06:41','单选题',2),(26,'甲每秒跑3米，乙每秒跑2米，丙每秒跑4米，三人沿600米的环形跑道从同一点同时同向跑步，经过（）秒三人又同时从出发点出发',2,'2021-06-29 02:07:29','单选题',2),(27,'一个两位数，个位上的数字和十位上的数字都是合数，并且是互质数，这个数最大是',2,'2021-06-29 02:23:55','单选题',2),(28,'30以内的质数加上2，还是质数的有（）个',2,'2021-06-29 02:28:15','单选题',2),(29,'A、B两只青蛙进行跳跃比赛，A每次跳10厘米，B每次跳15厘米，他们每秒都只跳1次，且一起从起点开始向同一方向跳跃。在比赛途中，每隔12厘米有一陷阱，当它们中第一只掉进陷阱时，另一只距离它最近的陷阱有（）厘米',2,'2021-06-29 02:30:20','填空题',2),(30,'一个大于0的数除以真分数，商（）被除数',2,'2021-06-29 02:32:01','单选题',2),(31,'“太白酒”酒瓶上的商标纸上标有酒精度58%，这里的58%是指（）',2,'2021-06-29 02:35:00','单选题',2),(32,'把分数a的分子扩大到原来的11倍，分母扩大到原来的13倍，得到的一个新分数b；把分数a的分子扩大到原来的8倍，分母扩大到原来的9倍，得到一个新分数c。那么b和c比较（）',2,'2021-06-29 02:49:27','单选题',4),(38,'有两堆砂石，第一堆比第二堆重60%，那么第二堆比第一堆轻（）',2,'2021-06-29 12:45:21','单选题',4),(39,'今年的柑橘产量比去年成长一成半，今年产量是去年的（）',2,'2021-06-29 12:49:37','填空题',4),(49,'关于sleep()和wait()，以下描述错误的一项是（ ）',5,'2021-06-30 04:16:34','单选题',2),(50,'下面哪个可以改变容器的布局？( )',5,'2021-06-30 04:17:06','单选题',2),(51,'下面哪个是applet传递参数的正确方式？（ ）',5,'2021-06-30 04:17:31','单选题',2),(52,'提供Java存取数据库能力的包是（）',5,'2021-06-30 04:17:56','单选题',2),(53,'如何使成员变量m被函数fun()直接访问？（）',5,'2021-06-30 04:19:17','单选题',2),(54,'网上“黑客”是指什么样的用户',5,'2021-06-30 04:21:48','单选题',2),(55,'防火墙系统的主要作用是',5,'2021-06-30 04:22:13','单选题',2),(56,'下列说法中哪项是错误的是',5,'2021-06-30 04:22:39','单选题',2),(57,'用于电子邮件的协议是',5,'2021-06-30 04:23:13','单选题',2),(58,'在Struts中实现页面跳转主要通过什么方法来实现？',5,'2021-06-30 04:38:57','单选题',2),(59,'从数据表中查找记录用以下哪一项(   )',6,'2021-06-30 04:40:25','单选题',2),(60,'以下聚合函数求最小值的是(   )',6,'2021-06-30 04:41:03','单选题',2),(61,'FROM命令属于(   )操作',6,'2021-06-30 04:41:39','单选题',2),(62,'mysqldump -u username -p dbname table1 table2 ...-> C:\\BackupName.sql\n根据上面命令判断出数据库名称是(  )',6,'2021-06-30 04:42:30','单选题',2),(63,'以下双方之间属于多对多关系的是( )',6,'2021-06-30 04:43:05','单选题',2),(64,'以下说法正确的是（ ）',6,'2021-06-30 04:43:38','单选题',2),(65,'以下约束哪个不是单表约束？( )',6,'2021-06-30 04:44:04','单选题',2),(66,'DECIMAL是（ ）数据类型',6,'2021-06-30 04:44:25','单选题',2),(67,'条件“age BETWEEN 20 AND 30”表示年龄在20到30之间，且(   )',6,'2021-06-30 04:44:49','单选题',2),(68,'在select语句中，实现选择操作的子句是(   )',6,'2021-06-30 04:45:10','单选题',2),(69,'以下聚合函数求平均数的是(  )',6,'2021-06-30 04:45:40','单选题',2),(70,'以下双方之间属于一对多关系的是（ ）',6,'2021-06-30 04:46:04','单选题',2),(71,'以下哪项用于显示内连接(   )',6,'2021-06-30 04:48:03','单选题',2),(74,'在除法、分数和比中，除数、分母和比的后项都不能为（）',2,'2021-06-30 14:08:24','单选题',2),(75,'DROP命令属于(   )操作',6,'2021-06-30 14:33:47','单选题',2),(76,'mysql -u root -p < C:\\backup.sql\n根据上面命令哪个是要恢复的文件名称(  )',6,'2021-06-30 14:34:25','单选题',2),(77,'查找表结构是使用DESC命令吗?',6,'2021-06-30 14:34:59','填空题',2),(78,'聚合函数求数据总和的命令是SUM吗?',6,'2021-06-30 14:35:10','填空题',2),(79,'MySQL是关系型数据库吗?',6,'2021-06-30 14:37:03','填空题',2),(80,'SQL语句中的条件是用WHERE来表达吗?',6,'2021-06-30 14:37:39','填空题',2),(81,'UPDATE命令是属于DML操作吗?',6,'2021-06-30 14:39:27','填空题',2);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`type`) values (1,'111','111','学生'),(2,'222','222','教师'),(3,'333','333','管理员'),(4,'444','444','教师'),(6,'123','123','学生'),(7,'321','321','学生');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
