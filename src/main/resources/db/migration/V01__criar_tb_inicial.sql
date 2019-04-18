SET default_storage_engine=InnoDB;

USE twitter;

DROP TABLE IF EXISTS twitter;

CREATE TABLE twitter.hastag (
  `hashtag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `texto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hashtag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE twitter.idioma (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  codigo_idioma varchar(255) DEFAULT NULL,
  idioma varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE twitter.`user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_idioma` tinyblob,
  `id_twitter` bigint(50) DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `name` tinyblob,
  `pais` tinyblob,
  `seguidores` bigint(50) DEFAULT NULL,
  `time_zone` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE twitter.tweets (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_criacao` datetime DEFAULT NULL,
  `hash_tag_text` tinyblob,
  `hash_tag_hashtag_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgsj865ex34wqxvrwdfxbr25k5` (`hash_tag_hashtag_id`),
  KEY `FKsymxo1awyw5wc978n4fngkkrs` (`user_id`),
  CONSTRAINT `FKgsj865ex34wqxvrwdfxbr25k5` FOREIGN KEY (`hash_tag_hashtag_id`) REFERENCES `hastag` (`hashtag_id`),
  CONSTRAINT `FKsymxo1awyw5wc978n4fngkkrs` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;






