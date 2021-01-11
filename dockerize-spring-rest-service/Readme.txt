
Add Final Name in the pom.xml below build 

RunAs Maven Build  choose package Goal  and check skip test check box

docker build --tag doctor-rest-service:1.0 .




docker run -it -p4040:8080 doctor-rest-service:1.0  => -puserdefined:server.port defined in application.properties file



Test by Opening in the Browser : =>  http://localhost:4040/api/v1/doctors

docker tag doctor-rest-service:1.0 vatsank/doctor-rest-service:1.0


docker push vatsank/doctor-rest-service:1.0


kubectl create deployment doctor-rest-demo --image=vatsank/doctor-rest-service:1.0


kubectl expose deployment doctor-rest-demo --type=LoadBalancer --name=doctor --external-ip=7.2.1.1 --port=5050




curl -v http://localhost:8080/api/v1/doctors

============================================

