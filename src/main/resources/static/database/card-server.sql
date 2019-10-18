
CREATE TABLE `user_info` (
 `id` varchar(32) NOT NULL,
 `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
 `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
 `sex` varchar(20) DEFAULT NULL COMMENT '性别',
 `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
 `email` varchar(20) DEFAULT NULL COMMENT '邮箱地址',
 `password` varchar(64) DEFAULT NULL COMMENT '登录密码',
 `wechat_number` varchar(20) DEFAULT NULL COMMENT '微信号码',
 `wechat_qr_code` varchar(50) DEFAULT NULL COMMENT '微信二维码ID',
 `qq_number` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
 `qq_qr_code` varchar(50) DEFAULT NULL COMMENT 'QQ二维码ID',
 `head_sculpture` varchar(20) DEFAULT NULL COMMENT '头像url',
 `company_name` varchar(100) DEFAULT NULL COMMENT '公司名称',
 `company_phone` varchar(100) DEFAULT NULL COMMENT '公司电话',
 `company_fax` varchar(100) DEFAULT NULL COMMENT '传真号码',
 `company_address` varchar(100) DEFAULT NULL COMMENT '公司地址',
 `company_job_name` varchar(100) DEFAULT NULL COMMENT '职位',
 `company_internet_address` varchar(100) DEFAULT NULL COMMENT '公司网址',
 `bgsound` varchar(200) DEFAULT NULL COMMENT '背景音乐地址',
 `content` varchar(50) DEFAULT NULL COMMENT '内容',
 `company_business` varchar(100) DEFAULT NULL COMMENT '公司业务',
 `company_supply` varchar(100) DEFAULT NULL COMMENT '公司供给',
 `company_demand` varchar(100) DEFAULT NULL COMMENT '公司需求',
 `company_map_place` varchar(100) DEFAULT NULL COMMENT '公司百度地图坐标',
 `bank_name` varchar(100) DEFAULT NULL COMMENT '银行名称',
 `bank_user_name` varchar(50) DEFAULT NULL COMMENT '银行开户姓名',
 `bank_account` varchar(18) DEFAULT NULL COMMENT '银行账号',
 `account_status` varchar(20) DEFAULT NULL COMMENT '账号状态',
 `page_style` varchar(10) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=100003 DEFAULT CHARSET=utf8mb4 COMMENT='用户详细信息表';




CREATE TABLE `attach` (
  `id` varchar(32) NOT NULL COMMENT '附件表逐渐',
  `attach_name` varchar(100) DEFAULT NULL COMMENT '附件真实名称',
  `attach_url` varchar(200) DEFAULT NULL COMMENT '附件地址',
  `attach_type` varchar(5) DEFAULT NULL COMMENT '附件类型',
  `dominant_id` varchar(32) DEFAULT NULL COMMENT '主表关联ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sequence` (
    `id_name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
    `currval` int(11) DEFAULT NULL COMMENT '当前值',
    `nextval` int(11) DEFAULT NULL COMMENT '下个值',
    PRIMARY KEY (`id_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列生成表';

CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `pass_word` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `account_Status` varchar(5) DEFAULT NULL COMMENT '账号状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户信息表';

CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL COMMENT '角色ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(200) DEFAULT NULL COMMENT '角色说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单Id',
  `parent_id` varchar(32) NOT NULL COMMENT '父级菜单ID',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `menu_level` varchar(32) DEFAULT NULL COMMENT '菜单链接地址',
  `sort` bigint DEFAULT NULL COMMENT '菜单排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `sys_user_role` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='用户角色关联表';

CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单ID',
  KEY `role_id` (`role_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;