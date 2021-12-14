# gourmet-restaurant

Esta es una API que permite listar y responder una encuesta a sus clientes

### Pre-requisitos 📋

* Instalar JDK,maven, Mysql o instalar docker y docker compose

## Despliegue 📦

Se puede correr la aplicación usando docker o desde el IDE.De la siguiente forma:

* Docker Compose

```
docker-compose build  //construir las imagenes que tiene en el archivo
docker-compose up -d Levantar los contenedores en segundo plano
docker-compose stop //Detener todos los contenedores
```

* IDE

Se debe correr el dump de la base de datos que se encuentra en: docker-mysql/scripts-mysql y configurar las siguientes variables de entorno:

```
host
username
password
```
## Modelo Relacional

Se encuentra en el directorio MR

## Documentación de los servicios

* Correr la aplicación e ingresar
```
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs