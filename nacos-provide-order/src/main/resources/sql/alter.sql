-- 订单表
create table t_order (
	`id` bigint(20) not null auto_increment,
	`sn` varchar(64) not null comment "订单号",
	`num` decimal(12,2) comment "数量",
	`price` decimal(12,2) comment "单价",
	`create_time` timestamp not null default current_timestamp comment "创建时间",
	primary key(`id`)
)

-- 仓库表

create table t_stock (
	`id` bigint(20) not null auto_increment,
	`sn` varchar(64) not null comment "仓库号",
	`num` decimal(12,2) comment "库存剩余",
	`create_time` timestamp not null default current_timestamp comment "创建时间",
	primary key(`id`)
)


-- 每个关联的服务，都要加回滚表
CREATE TABLE `undo_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(100) NOT NULL,
    `context` varchar(128) NOT NULL,
    `rollback_info` longblob NOT NULL,
    `log_status` int(11) NOT NULL,
    `log_created` datetime NOT NULL,
    `log_modified` datetime NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
)

insert into t_stock(`sn`,`num`) values ("仓库1",200);