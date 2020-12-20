# Sale

Este repo contiene un micro servicio usando Java con Spring Boot 2.

Para poder ejecutar el proyecto se debe ejecutar el comando ./gradlew clean build y luego ejecutar el comando
./gradlew bootRun

El micro servicio cuenta con autenticacion por JWT, para lo cual se debe autenticar con el endpoint api/login POST
con las credenciales username: admin, password: Ajwr,8329.fhdhg#.

Se provee dentro del proyecto una coleccion de Postman con los endpoints para poder autenticarse y para poder hacer uso de la API de ventas

La url con la documentacion OPen Api se encuentra en http://localhost:8080/swagger-ui.html
La url con la base de datos se encuentra en http://localhost:8080/h2-console