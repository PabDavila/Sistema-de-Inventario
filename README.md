# Sistema de Inventario - Microservicios Spring Boot

Sistema de gestión de inventario desarrollado con arquitectura de microservicios utilizando Spring Boot, PostgreSQL, Angular y Docker.

## Características

* Autenticación JWT.
* Control de acceso por roles.
* Gestión de productos.
* Gestión de categorías.
* Gestión de clientes.
* Gestión de movimientos de inventario.
* Gestión de pedidos.
* Dashboard con indicadores generales.
* Persistencia mediante PostgreSQL.
* Contenedorización con Docker Compose.

## Roles del Sistema

### Administrador (ROLE_ADMIN)

* Gestión de usuarios.
* Gestión de productos.
* Gestión de categorías.
* Gestión de clientes.
* Gestión de movimientos.
* Gestión de pedidos.
* Acceso completo al sistema.

### Operador (ROLE_OPERATOR)

* Gestión de productos.
* Gestión de categorías.
* Gestión de movimientos.
* Gestión de pedidos.

### Delivery (ROLE_DELIVERY)

* Gestión de clientes.
* Consulta de movimientos.
* Consulta de pedidos asignados.

---

## Arquitectura

El sistema está compuesto por los siguientes servicios:

### auth-service

Servicio encargado de:

* Autenticación.
* Generación de JWT.
* Gestión de usuarios y roles.

Puerto:

```text
8081
```

### inventory-service

Servicio encargado de:

* Productos.
* Categorías.
* Clientes.
* Movimientos.
* Pedidos.

Puerto:

```text
8082
```

### bff-gateway

Backend For Frontend encargado de centralizar las solicitudes desde Angular.

Puerto:

```text
8080
```

### PostgreSQL

Base de datos principal del sistema.

Puerto:

```text
5432
```

---

## Tecnologías Utilizadas

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* JWT
* Maven

### Frontend

* Angular
* TypeScript
* HTML
* CSS

### Base de Datos

* PostgreSQL 17

### Infraestructura

* Docker
* Docker Compose

---

## Requisitos

* Java 21
* Maven 3.9+
* Node.js
* Angular CLI
* Docker Desktop
* PostgreSQL (opcional si se utiliza Docker)

---

## Ejecución Local

### 1. Clonar repositorio

```bash
git clone <URL_REPOSITORIO>
```

### 2. Compilar microservicios

Auth Service:

```bash
mvn clean package
```

Inventory Service:

```bash
mvn clean package
```

BFF Gateway:

```bash
mvn clean package
```

### 3. Levantar contenedores

Desde la carpeta docker:

```bash
docker compose up -d
```

Verificar:

```bash
docker ps
```

---

## Acceso al Sistema

Frontend Angular:

```text
http://localhost:4200
```

Gateway:

```text
http://localhost:8080
```

Swagger Auth Service:

```text
http://localhost:8081/swagger-ui.html
```

Swagger Inventory Service:

```text
http://localhost:8082/swagger-ui.html
```

---

## Persistencia

La base de datos utiliza volúmenes Docker para conservar la información incluso después de reiniciar los contenedores.

---

## Estructura General

```text
backend/
├── auth-service
├── inventory-service
├── bff-gateway
├── docker
│   ├── docker-compose.yml
│   └── inventorydb_backup.sql

frontend/
└── angular-app
```

---

## Datos de Prueba

El proyecto incluye:

* Categorías de ejemplo.
* Productos de ejemplo.
* Clientes de ejemplo.
* Movimientos de inventario.
* Pedidos de prueba.
* Usuarios con distintos roles.

---

## Estado del Proyecto

Versión estable previa al despliegue en Azure.

Funcionalidades implementadas:

* Autenticación JWT.
* Control de roles.
* CRUD de Productos.
* CRUD de Categorías.
* CRUD de Clientes.
* CRUD de Movimientos.
* CRUD de Pedidos.
* Dashboard.
* Docker Compose.
* Persistencia validada.
* Backup de base de datos.
* Preparación para despliegue cloud.

## Requisitos de la Máquina Virtual

Para ejecutar correctamente el sistema se requiere una máquina virtual con Ubuntu Server 24.04 LTS (o una distribución Linux compatible) y los siguientes componentes instalados:

### Software requerido

* OpenJDK 21
* Maven
* Docker
* Docker Compose
* Nginx
* Git
* Node.js
* npm
* Angular CLI

### Tecnologías utilizadas

#### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Cloud Gateway
* JWT Authentication
* Maven

#### Base de Datos

* PostgreSQL 17 (ejecutado mediante Docker)

#### Frontend

* Angular
* TypeScript
* HTML5
* CSS3

#### Infraestructura y Despliegue

* Docker
* Docker Compose
* Nginx
* Azure Virtual Machine
* GitHub

### Componentes desplegados

| Componente               | Puerto |
| ------------------------ | ------ |
| Frontend Angular (Nginx) | 80     |
| BFF Gateway              | 8080   |
| Auth Service             | 8081   |
| Inventory Service        | 8082   |
| PostgreSQL               | 5432   |

### Arquitectura

El sistema se encuentra desplegado bajo una arquitectura de microservicios compuesta por:

* Auth Service: gestión de usuarios, autenticación y autorización mediante JWT.
* Inventory Service: gestión de productos, categorías, movimientos, pedidos, clientes, despachos y entregas.
* BFF Gateway: centralización de rutas y comunicación entre frontend y microservicios.
* PostgreSQL: almacenamiento persistente de la información.
* Frontend Angular: interfaz de usuario accesible desde navegador web.
* Nginx: servidor web y reverse proxy para publicación del sistema.

Todos los servicios se encuentran integrados mediante Docker Compose y desplegados en una máquina virtual Azure.

