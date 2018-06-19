DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `deleteStatus` tinyint(1) DEFAULT NULL,
  `userName` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
