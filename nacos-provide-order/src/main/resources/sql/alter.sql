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

insert into t_stock(`sn`,`num`) values ("仓库1",200);