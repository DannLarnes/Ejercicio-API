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


## Extra

Como me quedo algo de tiempo antes de que recibir una respuesta del examen cree un mini proyecto en angular que consume la API creada, para iniciar este desde la se debe tener node y ejecutar al menos una vez los comandos 

```
npm install -g @angular/cli
```

y dentro de la carpeta del proyecto:

```
ng update
```

y una vez finalizado la actualizacion e instalacion de dependencias se puede iniciar y abrir en un explorador el mini proyecto ejecutando el siguiente comando

```
ng serve -o
```

La pantalla principal es un login que al iniciar sesion correctamente te lleva a un buscador de provincias, en el cual al buscar correctamente una provincia te abre una pestaña de google maps con las coordenadas de estas

El usuario correcto es Matias y la password correcta es 123Probando estos se pueden cambiar en application.properties del proyecto java

No es algo muy impresionante ni creo que sea el mejor codigo que escribi en angular pero queria tener un caso real de prueba en algo que podria utilizar el api creado y mostrar algo de lo que se de front end