DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `id` int(8) NOT NULL,
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `mobile` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `t_userinfo`(`id`,`username`,`password`,`email`,`mobile`) values (1,'u1','p1','e1','b1'),(2,'u1','p1','e1','b1'),(3,'u1','p1','e1','b1'),(4,'u1','p1','e1','b1'),(5,'u1','p1','e1','b1'),(26,'wangzhg','000000','wangzhg@mochasoft.com.cn','13512215790');

