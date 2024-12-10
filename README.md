# sintad-backend - Prueba técnica - parte backend
Backend para la prueba técnica de sintad.

Este proyecto es un sistema CRUD que utiliza Spring Boot como backend, Angular como frontend, y Mysql como base de datos relacional. El objetivo del proyecto es gestionar entidades a través de una API RESTful, permitiendo operaciones de creación, lectura y eliminación (CRUD).

El sistema está diseñado para demostrar la aplicación de principios de diseño de software como SOLID, y la implementación de servicios RESTful con validación de datos y manejo de errores. Además, se integra con una base de datos MySql para el almacenamiento persistente de datos.

El desarrollo de este proyecto ha sido un desafío enriquecedor, ya que implicó el aprendizaje y aplicación de conceptos fundamentales de Spring Boot y la arquitectura de aplicaciones web modernas.


## Prerrequisitos

### MySql 8.0.32 

Se debe tener instalado MySql 8.0.32 y haber configurado el path para poder emplear los comandos psql en la terminal. En caso de solo tener instalado el MySql, se debe crear una base de datos en blanco llamada 'sintaddatabase' y ejecutar el script sql adjunto en el correspondiente gestor de base de datos de MySql que uses.

 - Se adjunta un archivo mysql-script en donde se encuentra un cmd para automatizar la creación de la bbdd ejecutando generate-database-mysql.cmd, y en caso que no se pueda. Ejecutar el contenido del archivo sql.

 - Comprobar que se ha creado correctamente la base de datos 'sintaddatabase' y sus tablas.

### Java jdk 17
Se debe tener instalado Java jdk en su versión 17.

##PRUEBAS UNITARIAS
Para ejecutar las pruebas unitarias ejecutar SintadBackendApplicationTest.java

### SWAGGER
Se adiciona un enlace para poder probar las rutas mediantes swagger una vez el proyecto este ejecutandose.
    
    http://localhost:8080/swagger-ui/index.html


### PASOS A SEGUIR
Genere primero la base de datos mediante cmd o utilizando los comandos sql , despues incie el backend y finalmente el frontend.


