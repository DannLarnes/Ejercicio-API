# Ejercicio-API
Ejercicio de creacion de API

## Consignas
Desarrollar una API exponiendo 2 endpoints:

a) El primero tiene que simular un login (parametrizar un único usuario válido) y retornar
en cualquier caso una estructura con el resultado.

b) El segundo tiene que retornar lat y long de una provincia por nombre, consumiendo la
API pública https://apis.datos.gob.ar/georef/api/provincias
(https://datosgobar.github.io/georef-ar-api/)

## Suposiciones y consideraciones

a) 

- Se valida un unico usuario y contraseña hardcodeado en properties y solo se devuelve que el login es valido cuando el usuario y contraseña coinciden con este

- La Api devuelve la misma estrucutura con el mensaje de status del intento de login y el estado HTTP tambien indica si el intento de logue fue coorecto, con estado 200 OK si se logro iniciar sesion correctamente y 401 UNAUTHORIZED en caso contrario

- Se crea un servicio mock para el usuario y contraseña configurados que puede ser reemplazado por uno que implemente la misma interfaz y funcione sin hardcodeo

b)

- Se asume que la provincia nunca puede ser vacia ya que resulta en bad request el intentar buscar una provincia sin nombre al consumir el api de https://apis.datos.gob.ar/georef/api/provincias
(https://datosgobar.github.io/georef-ar-api/) 

- En casos que la provincia no se haya podido encontrar por el API se devolvera un mensaje y el codigo de error HTTP 404 NOT FOUND 

## Uso del Api

El api fue desarrollado utilizando spring boot y puede ser iniciado localmente ejecutando el siguiente comando en la carpeta raiz del proyecto rest-service

```
./mvnw spring-boot:run
```

## Documentacion
La documentacion del funcionamiento del api se puede encontrar en el archivo DocumentacionApi.html tambien se encuentra en el repositorio el archivo DocumentacionApi.yml para ver en el editor de OpenApi que desee