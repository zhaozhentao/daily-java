CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `github_id` int(11) NOT NULL DEFAULT 0,
  `github_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remember_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_banned` enum('yes','no') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'no',
  `image_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic_count` int(11) NOT NULL DEFAULT '0',
  `reply_count` int(11) NOT NULL DEFAULT '0',
  `follower_count` int(11) NOT NULL DEFAULT '0',
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `twitter_account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personal_website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduction` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `certification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notification_count` int(11) NOT NULL DEFAULT '0',
  `github_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `real_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linkedin` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `payment_qrcode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wechat_qrcode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `login_qr` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wechat_openid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wechat_unionid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weibo_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weibo_link` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `verified` tinyint(1) NOT NULL DEFAULT '0',
  `verification_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email_notify_enabled` enum('yes','no') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'yes',
  `register_source` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'github',
  `last_actived_at` timestamp NULL DEFAULT NULL,
  `signature` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_github_id_index` (`github_id`),
  KEY `users_email_index` (`email`),
  KEY `users_name_index` (`name`),
  KEY `users_is_banned_index` (`is_banned`),
  KEY `users_topic_count_index` (`topic_count`),
  KEY `users_reply_count_index` (`reply_count`),
  KEY `users_follower_count_index` (`follower_count`),
  KEY `users_github_name_index` (`github_name`),
  KEY `users_wechat_openid_index` (`wechat_openid`),
  KEY `users_wechat_unionid_index` (`wechat_unionid`),
  KEY `users_verified_index` (`verified`),
  KEY `users_email_notify_enabled_index` (`email_notify_enabled`),
  KEY `users_register_source_index` (`register_source`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;