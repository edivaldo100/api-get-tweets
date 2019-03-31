CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_twitter` bigint(20) DEFAULT NULL,
  `name` tinyblob,
  `idioma` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `seguidores` bigint(20) DEFAULT NULL,
  `time_zone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=668 DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_idioma` tinyblob,
  `id_twitter` bigint(50) DEFAULT NULL,
  `idioma` tinyblob,
  `name` tinyblob,
  `pais` tinyblob,
  `seguidores` bigint(50) DEFAULT NULL,
  `time_zone` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1067 DEFAULT CHARSET=utf8;

CREATE TABLE `tweets` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1433 DEFAULT CHARSET=utf8;


CREATE TABLE hastag (
  hashtag_id bigint(20) NOT NULL AUTO_INCREMENT,
  texto varchar(255) DEFAULT NULL,
  PRIMARY KEY (hashtag_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO hastag (texto) values ('#openbanking');
<!--INSERT INTO hastag (texto) values ('#apifirst');
INSERT INTO hastag (texto) values ('#devops');
INSERT INTO hastag (texto) values ('#cloudfirst');
INSERT INTO hastag (texto) values ('#microservices');
INSERT INTO hastag (texto) values ('#apigateway');
INSERT INTO hastag (texto) values ('#oauth');
INSERT INTO hastag (texto) values ('#swagger');
INSERT INTO hastag (texto) values ('#raml');
INSERT INTO hastag (texto) values ('#openapis');-->

CREATE TABLE twitter.idioma (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  codigo_idioma varchar(10) DEFAULT NULL,
  idioma varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE twitter.idioma (
	id BIGINT NOT NULL AUTO_INCREMENT,
	codigo_idioma varchar(10) NULL,
	idioma varchar(255) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;
