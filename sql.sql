


CREATE TABLE `orders` (
  `id` bigint(28) NOT NULL AUTO_INCREMENT,
  `no` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` timestamp NULL DEFAULT current_timestamp() COMMENT '添加时间',
  `gmt_modified` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1561188503877 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;