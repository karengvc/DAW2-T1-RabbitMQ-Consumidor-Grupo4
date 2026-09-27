# DAW2-T1-RabbitMQ-Consumidor-Grupo4

Proyecto de la Evaluación T1 - Desarrollo de Aplicaciones Web II (Cibertec).

Microservicio consumidor de RabbitMQ que recibe una lista de posiciones y calcula el valor correspondiente en la secuencia de Fibonacci para cada una.

## Descripción

El productor envía una cadena de números separados por `;` (ejemplo: `1;2;15;8`) a través de RabbitMQ. Este servicio escucha la cola, convierte el mensaje en una lista de números, calcula el Fibonacci de cada posición (con cache) y muestra el resultado en consola.

## Tecnologías

- Java 25
- Spring Boot 4.1.1
- Spring AMQP (RabbitMQ)
- Lombok
- Maven

## Configuración de RabbitMQ

| Elemento | Nombre |
|---|---|
| Exchange | `Grupo4Exchange` |
| Queue | `Grupo4Queue` |
| Routing Key | `Grupo4Routing` |

## Cómo ejecutar

1. Tener RabbitMQ corriendo en `localhost:5672` (panel de administración en `localhost:15672`, usuario/clave: `guest`/`guest`).
2. Clonar el repositorio.
3. Ejecutar la clase `AppGrupo4ConsumidorApplication`.
4. El servicio queda escuchando la cola `Grupo4Queue`.

## Estructura del proyecto

\`\`\`
src/main/java/pe/edu/cibertec/appgrupo4consumidor
├── config
│   ├── RabbitMqConfig.java
│   └── RabbitMqMessageConverterConfig.java
├── rabbitmq
│   └── FibonacciConsumidor.java
├── service
│   └── FibonacciService.java
└── AppGrupo4ConsumidorApplication.java
\`\`\`

## Integrantes - Grupo 4

ALONZO DARIO	PERALTA QUISPE
Frans jhunior	Mendoza Muñoz 
JESUS ALBERTO	BETANCOURT BRICEÑO
KAREN GRIMANESA	VENTURA CALLA
Michael	Luna Urbano
