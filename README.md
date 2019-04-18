# api-get-tweets

Para executar localmente basta add. as variaveis de ambiente como arqgumentos
-DDATABASE_HOST=localhost 
-DDATABASE_PORT=3306 
-DDATABASE_USER=twitter 
-DDATABASE_PASSWORD=twitter 
-DDATABASE_NAME=twitter

# Criando a image do docker
mvn clean install package docker:build -DskipTests


#  docker-compose
RUN : docker-compose up

cria a base de dados Mysql
cria as tabelas
inseri valores predefinidos como as #tags e tb idiomas 