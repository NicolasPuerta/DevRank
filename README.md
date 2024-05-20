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


# FRONT-END

## Planificación y diseño

### Ideas y objetivos

El front-end de DevRank se centrará en proporcionar una interfaz de usuario intuitiva y atractiva para los desarrolladores y empleadores. El objetivo principal es facilitar la búsqueda de empleo y la gestión de retos de programación.

### Requisitos funcionales y no funcionales

#### Requisitos Funcionales:

Registro de Usuarios: Permitir que los desarrolladores se registren en la plataforma.
Búsqueda de Empleo: Implementar una función de búsqueda de ofertas de trabajo basada en palabras clave.
Gestión de Retos: Crear, resolver y calificar retos de programación.
Generación de Rankings: Calcular y mostrar rankings en tiempo real según los puntos obtenidos por los usuarios.

#### Requisitos No Funcionales:

Seguridad: Garantizar que la plataforma sea segura mediante autenticación y autorización adecuadas.
Rendimiento: Establecer tiempos de respuesta aceptables para las búsquedas y la carga de páginas.
Usabilidad: Hacer que la interfaz de usuario sea intuitiva y fácil de usar.

### Diseño de arquitectura

#### Front-end con Next.js y React:
Next.js es un framework de React que facilita la creación de aplicaciones web rápidas y eficientes.
Aprovecharemos las ventajas de componentes reutilizables y un flujo de datos unidireccional.
Implementaremos rutas dinámicas para cargar contenido de forma asincrónica y mejorar el rendimiento.

#### Estilos con Tailwind CSS:
Tailwind CSS es una biblioteca de estilos que nos permite diseñar interfaces de usuario modernas y personalizables.
Utilizaremos clases predefinidas para estilizar los componentes y mantener un diseño coherente en toda la aplicación.

#### Pruebas con Jest y React Testing Library:
Jest es un marco de pruebas de JavaScript que nos permite realizar pruebas unitarias y de integración.
React Testing Library proporciona utilidades para probar componentes de React de forma sencilla y efectiva.

#### Documentación con Storybook:
Storybook es una herramienta que nos permite documentar y probar componentes de forma aislada.
Crearemos historias para cada componente y generaremos una guía de estilo interactiva para el front-end.

## Configuración del entorno de desarrollo

### Configuración del entorno local

Para el entorno local, utilizaremos Visual Studio Code como IDE principal y Node.js como entorno de ejecución de JavaScript.

### Herramientas necesarias

Las herramientas esenciales para el desarrollo del front-end de DevRank son:

Node.js: Entorno de ejecución de JavaScript.
bun: Gestor de paquetes de Node.js.
Next.js: Framework de React para aplicaciones web.
Tailwind CSS: Biblioteca de estilos para diseñar interfaces de usuario.
Jest: Marco de pruebas de JavaScript.
React Testing Library: Utilidades para probar componentes de React.
Storybook: Herramienta para documentar y probar componentes de forma aislada.

## Creación de componentes

Lo primero en lo que nos centraremos al crear el front-end de DevRank es en los componentes.

### Componente de Registro:

Permitirá a los desarrolladores registrarse en la plataforma.
Recopilará información como nombre, dirección de correo electrónico, habilidades, etc.
Validará los datos ingresados por el usuario y enviará una solicitud al servidor para crear una cuenta.

### Componente de Búsqueda de Empleo:

Implementará una función de búsqueda de ofertas de trabajo basada en palabras clave.
Mostrará los resultados de la búsqueda en una lista interactiva.
Permitirá a los usuarios filtrar y ordenar los resultados según sus preferencias.

### Componente de Gestión de Retos:

Permitirá a los usuarios crear, resolver y calificar retos de programación.
Mostrará una lista de retos disponibles y permitirá a los usuarios seleccionar y resolver un reto.
Calificará automáticamente la solución del usuario y actualizará su puntuación en tiempo real.

### Componente de Generación de Rankings:

Calculará y mostrará rankings en tiempo real según los puntos obtenidos por los usuarios.
Mostrará una lista de los mejores desarrolladores y empleadores en la plataforma.
Permitirá a los usuarios ver su posición en el ranking y comparar su puntuación con otros usuarios.

## Estilos y diseño

Utilizaremos Tailwind CSS para estilizar los componentes y mantener un diseño coherente en toda la aplicación.

### Paleta de Colores:

Definiremos una paleta de colores consistente para la aplicación.
Utilizaremos colores llamativos y contrastantes para resaltar elementos importantes.
Mantendremos un equilibrio entre colores claros y oscuros para mejorar la legibilidad y la accesibilidad.

### Tipografía:

Seleccionaremos fuentes legibles y modernas para el texto en la aplicación.
Utilizaremos tamaños de fuente coherentes y jerarquías visuales claras para mejorar la usabilidad.
Aprovecharemos las ventajas de fuentes web para garantizar una carga rápida y una apariencia consistente en todos los dispositivos.

### Diseño Responsivo:

Diseñaremos la aplicación para que sea compatible con una amplia gama de dispositivos y tamaños de pantalla.
Utilizaremos técnicas de diseño responsivo como flexbox y grid para crear diseños adaptables.
Probaremos la aplicación en dispositivos móviles y de escritorio para garantizar una experiencia de usuario óptima en todos los casos.

## Pruebas unitarias

Realizaremos pruebas unitarias a cada componente para garantizar su correcto funcionamiento y detectar posibles errores.

### Pruebas con Jest:

Utilizaremos Jest para escribir y ejecutar pruebas unitarias en los componentes.
Probaremos las funciones y métodos de los componentes para asegurarnos de que se comporten como se espera.
Realizaremos pruebas de integración para comprobar la interacción entre los componentes y su integración en la aplicación.

### Pruebas con React Testing Library:

Utilizaremos React Testing Library para probar los componentes de React de forma efectiva.
Simularemos eventos y acciones del usuario para verificar la interactividad de los componentes.
Realizaremos pruebas de accesibilidad para garantizar que la aplicación sea usable por personas con discapacidades.

## Documentación

Documentaremos los componentes de la aplicación utilizando Storybook para generar una guía de estilo interactiva.

### Creación de Historias:

Escribiremos historias para cada componente de la aplicación.
Mostraremos diferentes estados y variaciones de los componentes para documentar su comportamiento.
Añadiremos comentarios y descripciones detalladas para explicar el propósito y la funcionalidad de cada componente.

### Generación de Guía de Estilo:

Generaremos una guía de estilo interactiva con Storybook.
Permitiremos a los desarrolladores y diseñadores explorar y probar los componentes de forma aislada.
Facilitaremos la colaboración y la revisión del diseño mediante la documentación detallada de los componentes.

## Despliegue

Una vez tengamos una versión "final" del front-end de DevRank, podremos desplegarlo en un entorno de producción, por ejemplo, en la nube.

### Despliegue en Vercel:

Utilizaremos Vercel para desplegar la aplicación en la nube.
Configuraremos la integración continua para automatizar el proceso de despliegue.
Aprovecharemos las ventajas de Vercel, como la escalabilidad y la disponibilidad, para garantizar un rendimiento óptimo de la aplicación.

### Configuración de Dominio Personalizado:

Asignaremos un dominio personalizado a la aplicación para mejorar su accesibilidad y visibilidad.
Configuraremos la redirección de tráfico y la gestión de DNS para dirigir el tráfico al dominio correcto.
Aseguraremos la seguridad y la privacidad del dominio mediante certificados SSL y políticas de privacidad.

### Monitorización y Análisis:

Implementaremos herramientas de monitorización y análisis para supervisar el rendimiento de la aplicación.
Utilizaremos métricas como el tiempo de carga, la tasa de conversión y la retención de usuarios para evaluar el éxito de la aplicación.
Realizaremos pruebas de rendimiento y optimización para mejorar la velocidad y la eficiencia de la aplicación.


# Despliegue con Docker

## Configuración de Docker

### Creación de Contenedores:

Utilizaremos Docker para crear contenedores independientes para cada microservicio.
Definiremos un archivo Dockerfile para cada microservicio con las instrucciones necesarias para construir la imagen.
Configuraremos los contenedores para que se comuniquen entre sí y con la API Gateway.

### Orquestación con Docker Compose:

Utilizaremos Docker Compose para orquestar los contenedores y gestionar su despliegue.
Definiremos un archivo docker-compose.yml con la configuración de los servicios y las redes necesarias.
Ejecutaremos el comando docker-compose up para iniciar los contenedores y desplegar la aplicación.

### Escalabilidad y Disponibilidad:

Aprovecharemos las ventajas de Docker para escalar y distribuir los microservicios según la demanda.
Configuraremos los contenedores para que se autoescalen y se recuperen automáticamente en caso de fallo.
Utilizaremos herramientas de monitorización y análisis para supervisar el rendimiento y la disponibilidad de la aplicación.

## Despliegue en Kubernetes

### Configuración de Kubernetes:

Utilizaremos Kubernetes para orquestar y gestionar los contenedores en un entorno de producción.
Definiremos archivos de configuración YAML para crear los pods, servicios y volúmenes necesarios.
Configuraremos los recursos de Kubernetes para garantizar la escalabilidad y la disponibilidad de la aplicación.

### Despliegue en un Cluster de Kubernetes:

Desplegaremos la aplicación en un clúster de Kubernetes en la nube.
Configuraremos los nodos y los servicios de Kubernetes para distribuir la carga de trabajo y mejorar el rendimiento.
Utilizaremos herramientas de monitorización y análisis para supervisar el clúster y optimizar su rendimiento.

### Escalabilidad Automática:

Configuraremos la escalabilidad automática de Kubernetes para ajustar dinámicamente los recursos según la demanda.
Utilizaremos métricas como el uso de CPU y memoria para escalar los pods y los nodos de forma automática.
Aprovecharemos las ventajas de Kubernetes para garantizar un rendimiento óptimo y una alta disponibilidad de la aplicación.

## Conclusiones


## Referencias

- [Node.js](https://nodejs.org/)
- [Express](https://expressjs.com/)
- [MongoDB](https://www.mongodb.com/)
- [MySQL](https://www.mysql.com/)
- [Docker](https://www.docker.com/)
- [Kubernetes](https://kubernetes.io/)
- [Next.js](https://nextjs.org/)
- [React](https://reactjs.org/)
- [Tailwind CSS](https://tailwindcss.com/)
- [Jest](https://jestjs.io/)
- [React Testing Library](https://testing-library.com/docs/react-testing-library/intro)
- [Storybook](https://storybook.js.org/)
- [Vercel](https://vercel.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)
- [Amazon SNS](https://aws.amazon.com/sns/)

```
