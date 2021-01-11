docker run -d -p 2012:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=spring_app_db -e MYSQL_USER=app_user -e MYSQL_PASSWORD=test123 mysql:8.0

docker build -t doctor-app-jpa .

docker run -t --name doctor-app-container --link mysql-docker-container:mysql -p 8080:8080 doctor-app-jpa
