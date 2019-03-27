CREATE TABLE tweets (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	hash_tag VARCHAR(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tweets (hash_tag) values ('#JAVA');
INSERT INTO tweets (hash_tag) values ('#SPRING');
INSERT INTO tweets (hash_tag) values ('#Supermercado');
INSERT INTO tweets (hash_tag) values ('#Farmácia');
INSERT INTO tweets (hash_tag) values ('#Outros');