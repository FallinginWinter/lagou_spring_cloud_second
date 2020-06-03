CREATE TABLE `lagou_auth_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 ',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱地址',
  `code` varchar(6) DEFAULT NULL COMMENT '验证码',
  `createtime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `expiretime` bigint(20) DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `lagou_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 ',
  `email` varchar(64) NOT NULL COMMENT '邮箱地址',
  `token` varchar(255) NOT NULL COMMENT '令牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lagou_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
