# 🐰 DAW2-T1-RabbitMQ-Consumidor-Grupo4

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-AMQP-FF6600?logo=rabbitmq&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Estado-Completado-brightgreen)

Proyecto de la **Evaluación T1** — curso *Desarrollo de Aplicaciones Web II* (Cibertec).

Microservicio **consumidor** de RabbitMQ que recibe una lista de posiciones y calcula el valor correspondiente en la **secuencia de Fibonacci** para cada una, usando memoización.

---

## 📌 Descripción

El proyecto **Productor** envía una cadena de números separados por `;` (ejemplo: `1;2;15;8`) a través de RabbitMQ. Este servicio **Consumidor**:

1. Escucha la cola `Grupo4Queue`.
2. Convierte el mensaje recibido en una lista de números.
3. Calcula el Fibonacci de cada posición (con cache para optimizar la recursión).
4. Simula una pausa de procesamiento de 20 segundos.
5. Muestra el resultado en consola.

```
┌─────────────┐         RabbitMQ           ┌──────────────┐
│  Productor  │ ───────────────────────►   │  Consumidor  │
│ (API REST)  │   Grupo4Exchange           │  (este repo) │
│             │   Grupo4Routing            │              │
└─────────────┘                            └──────┬───────┘
                                                    │
                                                    ▼
                                        FibonacciService
                                        (recursivo + cache)
```

---

## 🛠️ Tecnologías

| Herramienta | Versión / Uso |
|---|---|
| ☕ Java | 25 |
| 🌱 Spring Boot | 4.1.1 |
| 🐰 Spring AMQP | Mensajería con RabbitMQ |
| 🧩 Lombok | Reducción de boilerplate |
| 📦 Maven | Gestión de dependencias y build |

---

## ⚙️ Configuración de RabbitMQ

| Elemento | Nombre |
|---|---|
| Exchange | `Grupo4Exchange` |
| Queue | `Grupo4Queue` |
| Routing Key | `Grupo4Routing` |

---

## ▶️ Cómo ejecutar

1. Tener **RabbitMQ** corriendo en `localhost:5672`
   (panel de administración en `localhost:15672`, usuario/clave: `guest` / `guest`).
2. Clonar el repositorio:
   ```bash
   git clone https://github.com/karengvc/DAW2-T1-RabbitMQ-Consumidor-Grupo4.git
   ```
3. Ejecutar la clase `AppGrupo4ConsumidorApplication`.
4. El servicio queda escuchando la cola `Grupo4Queue`, listo para recibir mensajes del Productor.

---

## 📂 Estructura del proyecto

```
src/main/java/pe/edu/cibertec/appgrupo4consumidor
├── config
│   ├── RabbitMqConfig.java                  # Exchange, Queue, Binding
│   └── RabbitMqMessageConverterConfig.java  # Conversor JSON de mensajes
├── rabbitmq
│   └── FibonacciConsumidor.java             # Listener de la cola
├── service
│   └── FibonacciService.java                # Lógica del algoritmo Fibonacci
└── AppGrupo4ConsumidorApplication.java
```

---

## 👥 Integrantes — Grupo 4

| Integrante |
|---|
| ★Alonzo Dario Peralta Quispe |
| ★Frans Jhunior Mendoza Muñoz |
| ★Jesus Alberto Betancourt Briceño |
| ★Karen Grimanesa Ventura Calla |
| ★Michael Luna Urbano |
