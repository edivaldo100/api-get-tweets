SET default_storage_engine=InnoDB;
USE twitter;

SET SQL_SAFE_UPDATES=0;

DELETE FROM hastag;

INSERT INTO twitter.hastag (texto) values ('#openbanking');
INSERT INTO twitter.hastag (texto) values ('#apifirst');
INSERT INTO twitter.hastag (texto) values ('#devops');
INSERT INTO twitter.hastag (texto) values ('#cloudfirst');
INSERT INTO twitter.hastag (texto) values ('#microservices');
INSERT INTO twitter.hastag (texto) values ('#apigateway');
INSERT INTO twitter.hastag (texto) values ('#oauth');
INSERT INTO twitter.hastag (texto) values ('#swagger');
INSERT INTO twitter.hastag (texto) values ('#raml');
INSERT INTO twitter.hastag (texto) values ('#openapis');