# Desarrollo de aplicación de consola utilizando JPA y Hibernate
- Desarrollado por:
    - @Agustin Crespo
    - @Franco Ces 

## Ejecución:
Para ejecutar la aplicación se debe ejecutar cualquiera de los 4 archivos de Main.

- **MainCarrera**: Este archivo contiene solo las pruebas para la entidad Carrera
- **MainEstudiante**: Este archivo contiene solo las pruebas para la entidad Estudiante
- **MainInscripciones**: Este archivo contiene solo las pruebas para la entidad Inscripciones
- **Main**: Este archivo contiene las pruebas para las 3 entidades

> **Nota**: Para realizar las pruebas en los archivos individuales hay que descomentar la última línea del archivo donde cierra la conexión con la base de datos.

### Base de datos
Para la base de datos se utilizó PostgreSQL, instalado en la computadora de los estudiantes. En esta ocasión no se utilizó Docker para la base de datos. El nombre de la base de datos es `estudiantes_db` y el archivo para modificar esto se encuentra en el archivo `persistence.xml`.


## Elementos:
- **src**: este archivo contiene el código fuente de la aplicación
    - **resources**: Dentro de esta carpeta se encuentra el archivo de configuración de Hibernate
        - **persistence.xml**: archivo de configuración de Hibernate
    - **java**: Dentro de esta carpeta se encuentra el código fuente de la aplicación
        - **Main**: cualquiera de los 3 archivos que inician con la palabra Main son los archivos que contienen las funcionalidades para testear la aplicación
        - **repositories**: Dentro de esta carpeta se encuentran los archivos que configuran las consultas con la base de datos. 
            - **JPARepository**: Esta carpeta contiene la implementacion especifica para la realizacion de las consultas utilizando JPA Hibernate 
- **pom.xml**: archivo de configuración de Maven
- **README.md**: archivo de documentación
- **Diagrama de Clases** y **Diagrama de Entidad Relación**: Estos archivos se encuentran en el directorio raiz y son los diagramas de clases y entidad relación de la aplicación

> **Nota**: Este Proyecto esta subido a GitHub en el siguiente enlace: [https://github.com/CowsmonDev/Software-System-Design-TPE]
