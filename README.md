# DevRank

## Arquitectura (Microservicios y Hexagonal)
Cada microservicio se centrará en una funcionalidad específica, lo que facilita el desarrollo y la escalabilidad.
## Base de Datos
Asignar una base de datos específica para cada microservicio (elegir la base de datos adecuada según las necesidades de cada componente)
## API Gateway con Express y Node:
Crear un API Gateway para enrutar las solicitudes a los microservicios
## Seguridad con Tokens JWT:
Implementar autenticación y autorización mediante tokens JWT 
manejar correctamente la seguridad en el API Gateway y en los microservicios.
## Front-end con React:
Aprovechar las ventajas de componentes reutilizables y un flujo de datos unidireccional.
## Despliegue con Docker:
Desplegar cada microservicio de forma independiente utilizando Docker 
Kubernetes para la orquestación.



# BACK-END

## Planificación y diseño

### Ideas y objetivos

DevRank es una aplicación para la busqueda de empleo enfocada especialmente en desarrolladores esta aplicación ayudara a los desarrolladores a poder mejorar y demostrar sus habilidades y capacidades a los demas para poder agilizar y facilitar el proceso de contratacion esto ayudara a evitar la dificultad que hay para encontrar empleo sobretodo cuando eres un principiante y no sabes como demostrar tus habilidades y a las empresas para encontrar con mayor facilidad al mejor cantdidato

### Requisitos funcionales y no funcionales

#### Requisitos Funcionales:
Los requisitos funcionales describen las funcionalidades específicas que el software debe realizar. Estos son los cálculos y procesos que la solución debe llevar a cabo. 

Registro de Usuarios: Permitir que los desarrolladores se registren en la plataforma.
Búsqueda de Empleo: Implementar una función de búsqueda de ofertas de trabajo basada en palabras clave.
Gestión de Retos: Crear, resolver y calificar retos de programación.
Generación de Rankings: Calcular y mostrar rankings en tiempo real según los puntos obtenidos por los usuarios.

#### Requisitos No Funcionales:
Los requisitos no funcionales se centran en atributos de calidad y propiedades generales del proyecto. Estos no están relacionados directamente con las funcionalidades, pero son igualmente importantes. 

Seguridad: Garantizar que la plataforma sea segura mediante autenticación y autorización adecuadas.
Rendimiento: Establecer tiempos de respuesta aceptables para las búsquedas y la carga de páginas.
Escalabilidad: Diseñar la arquitectura para manejar un gran número de usuarios y retos.
Usabilidad: Hacer que la interfaz de usuario sea intuitiva y fácil de usar.
Disponibilidad: Asegurar que la plataforma esté disponible en todo momento.

### Diseño de arquitectura

#### Servidor:
La arquitectura de la aplicacion sera de microservices y hexagonal
el lenguaje que se usara principalmente sera node.js con express y puede variar dependiendo del microservicio.

#### Base de Datos:
relacional (MySQL) y no relacional (si es necesaria MongoDB).

#### API Gateway:
se usara una api gatewat que actúa como intermediario entre el cliente y los microservicios.
Gestiona la autenticación, autorización y enrutamiento.
Distribuyen el tráfico entre múltiples servidores para mejorar la escalabilidad y la disponibilidad.
se almacenaran datos en memoria (cache) para acelerar las respuestas.
se utilizaran contenedores para desplegar y gestionar microservicios.

#### Diagrama de la arquitectura:


## Configuracion del entorno de desarrollo

### Configuracion del entorno local

principalmente para el entorno local la ide que se utiliazara sera visual studio code

### Herramientas necesarias

las herramientas escenciales para la creacion de este proyecto son:
- node.js
- npm
- bun
....

## Creacion de los microservicios

Lo primero en lo que nos centraremos al crear este proyecto es en los microservicios

### Microservicio de usuarios:
Manejara los datos de los usuarios registrados en la aplicación

### Microservicio de busqueda de empleo: 
Manejará las solicitudes de búsqueda de empleo y consultas a la base de datos.

### Microservicio de Retos: 
Gestionará los retos de programación y puntuaciones.

### Microservicio de Autenticación: 
Encargado de la autenticación y generación de tokens JWT.



## Base de datos
para crear la bases de datos debemos ver cual es la mejor opcion para cada microservicio

### Datos del usuario

-informacion del perfil del usuario: para manejar los datos del perfil del usuario como lo son nombre, dirección de correo electrónico, habilidades, etc. lo mas optimo puede ser MongoDB ya que es muy flexible y no requiere un esquema fijo lo que facilita la adicion de campos adicionales segun sea necesario. para esto se crearia una coleccion llamada 'usuarios' con documentos que contengan los campos mancionados anteriormente

-Documentos adjuntos (Fotos, cvs, cartas de presentacion, etc) La mejor alternativa para estos probablemente sea en el sistema de archivos del servidor u guardar la url de estos en la base de datos de la informacion del perfil

### Ofertas de trabajo

- Base de Datos:
MongoDB: Utilizaremos MongoDB para almacenar datos relacionados con las ofertas de trabajo y los candidatos. crearemos una colección llamada “ofertas” para almacenar detalles como título del trabajo, descripción, ubicación, requisitos, etc.

- Estructura de Documentos en MongoDB:
Cada documento podría representar una oferta de trabajo.
Campos relevantes: “título”, “descripción”, “ubicación”, “requisitos”, “empresa”, etc.
También incluira un campo para almacenar el ID del usuario que publicó la oferta.

- Gestión de Ofertas de Trabajo:
    Creación y Edición: Los empleadores pueden agregar nuevas ofertas de trabajo a la base de datos. Esto implica insertar un nuevo documento en la colección “empleos”.
   
    Búsqueda y Filtrado: se implementaran consultas para buscar ofertas de trabajo según criterios como ubicación, habilidades requeridas, etc.
    
    Actualización y Eliminación: Permite a los empleadores editar o eliminar sus ofertas de trabajo existentes.

- Gestión de Candidatos:
    Aplicación a Ofertas: Los candidatos pueden aplicar a ofertas de trabajo específicas. se creara una colección “candidatos” para almacenar sus datos.

    Relación con Ofertas: Crea una referencia entre los documentos de candidatos y las ofertas a las que han aplicado.

- Notificaciones:
se implementaran notificaciones para informar a los candidatos sobre nuevas ofertas de trabajo relevantes.
se puede utilizar servicios como Amazon SNS para enviar notificaciones por correo electrónico o mensajes push.


### Retos 

## API Gateway

Crearemos una api gateway usando express configurando las rutas para enrutar las solicitudes a los microservicios correspondientes y implementaremos la seguridad con jwt en esta apigatewey y para esto nos aseguraremos de que los microservicios validen los tokens correctamente antes de procesar las solicitudes 

## Pruebas unitarias

debemos hacer pruebas exhaustivas a cada microservicios para poder detectar errores y poder garantizar la seguridad del codigo

## Documentación

documentaremos los endpoints de la api usando la herramienta de swagger para poder generar una buena documentacion de nuestra api

## Despliegue 

una vez tengamos una version "final" podriamos intentar desplegarla en un entorno de produccion por ejemplo en la nube