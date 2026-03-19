# SALA DE CONCIERTOS

Este sistema gestiona integralmente una sala de eventos, administrando la programación de espectáculos (como conciertos o teatro) y el registro de los grupos artísticos que actúan.
Permite la venta y emisión de entradas nominales para los espectadores, controlando el aforo mediante diferentes zonas (VIP, pista, gradas) y asignación de asientos.
A través de la api-rest, centraliza la operativa del recinto, facilitando desde la creación de eventos hasta la validación de tickets y el seguimiento de las compras.

## Tecnologias

| Tecnologia      | Version | Uso                        |
|-----------------|---------|----------------------------|
| Java            | 17      | Lenguaje principal         |
| Spring Boot     | 4.0.x   | Framework backend          |
| JPA/Hibernate   | 6.x     | Persistencia (ORM)         |
| PostgreSQL      | 16      | Base de datos (Docker)     |
| H2              | -       | Base de datos (desarrollo) |
| Docker          | -       | Contenedorizacion          |
| GitHub Actions  | -       | CI/CD                      |
| Swagger/OpenAPI | -       | Documentacion API          |

## Endpoints de la API

- **ENTRADAS**

| Verbo  | URL                                                   | Descripcion                   |
|--------|-------------------------------------------------------|-------------------------------|
| GET    | `/sala-conciertos/entradas`                           | Listar todas las entradas     |
| POST   | `/sala-conciertos/entradas`                           | Crear una nueva entrada       |
| PUT    | `/sala-conciertos/entradas/{id}`                      | Modificar una entrada         |
| DELETE | `/sala-conciertos/entradas/{id}`                      | ELiminar una entrada          |
| GET    | `/sala-conciertos/entradas/{id}`                      | Buscar una entrada por id     |
| GET    | `/sala-conciertos/entradas/zona/{zona}`               | Buscar entradas por zona      |
| GET    | `/sala-conciertos/entradas/tipoEntrada/{tipoEntrada}` | Buscar entradas por su tipo   |
| GET    | `/sala-conciertos/espectador/{id}`                    | Buscar entradas por espectador|
| GET    | `/sala-conciertos/evento/{id}`                        | Buscar entradas por evento    |

- **GRUPOS ARTISTICOS**

| Verbo  | URL                                                                | Descripcion                             |
|--------|--------------------------------------------------------------------|-----------------------------------------|
| GET    | `/sala-conciertos/grupos-artisticos`                               | Listar todos los grupos                 |
| POST   | `/sala-conciertos/grupos-artisticos`                               | Crear un nuevo grupo                    |
| PUT    | `/sala-conciertos/grupos-artisticos/{id}`                          | Modificar un grupo                      |
| DELETE | `/sala-conciertos/grupos-artisticos/{id}`                          | Eliminar un grupo                       |
| GET    | `/sala-conciertos/grupos-artisticos/{id}`                          | Buscar un grupo por id                  |
| GET    | `/sala-conciertos/grupos-artisticos/nombre/{nombre}`               | Buscar un grupo por su nombre           |
| GET    | `/sala-conciertos/grupos-artisticos/genero/{genero}`               | Buscar grupos por genero                |
| GET    | `/sala-conciertos/grupos-artisticos/integrantes/{integrantes}`     | Buscar grupos por numero de integrantes |
| GET    | `/sala-conciertos/grupos-artisticos/aniofundacion/{aniofundacion}` | Buscar grupos por año                   |
| GET    | `/sala-conciertos/grupos-artisticos/pais/{pais}`                   | Buscar grupos por pais                  |
| GET    | `/sala-conciertos/grupos-artisticos/tipo/{tipo}`                   | Buscar grupos por tipo                  |

-**ESPECTADORES**

| Verbo  | URL                                             | Descripcion                     |
|--------|-------------------------------------------------|---------------------------------|
| GET    | `/sala-conciertos/espectadores`                 | Listar todos los espectadores   |
| POST   | `/sala-conciertos/espectadores`                 | Crear un nuevo cliente          |
| PUT    | `/sala-conciertos/espectadores/{id}`            | Modificar un cliente            |
| DELETE | `/sala-conciertos/espectadores/{id}`            | Eliminar un cliente             |
| GET    | `/sala-conciertos/espectadores/{id}`            | Buscar un cliente por id        |
| GET    | `/sala-conciertos/espectadores/nombre/{nombre}` | Buscar un cliente por su nombre |
| GET    | `/sala-conciertos/espectadores/email/{email}`   | Buscar un cliente por su email  |

-**EVENTOS**

| Verbo  | URL                                              | Descripcion                          |
|--------|--------------------------------------------------|--------------------------------------|
| GET    | `/sala-conciertos/eventos`                       | Listar todos los eventos             |
| POST   | `/sala-conciertos/eventos`                       | Crear un nuevo evento                |
| PUT    | `/sala-conciertos/eventos/{id}`                  | Modificar un evento                  |
| DELETE | `/sala-conciertos/eventos/{id}`                  | Eliminar un evento                   |
| GET    | `/sala-conciertos/eventos/{id}`                  | Buscar un evento por id              |
| GET    | `/sala-conciertos/eventos/nombre/{nombre}`       | Buscar un evento por su nombre       |
| GET    | `/sala-conciertos/eventos/precio/{precio}`       | Buscar un evento por su precio       |
| GET    | `/sala-conciertos/eventos/precio-menor/{precio}` | Buscar un evento por su precio menor |





## Como ejecutar

```bash
# Con Docker
docker compose up -d

# Sin Docker (H2)
mvn spring-boot:run

## Autor

Marcos Ardid Herrero — Curso IFCD0014