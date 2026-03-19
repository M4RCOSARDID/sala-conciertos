# Blueprint: Sistema de Gestión de Sala de Conciertos

## 1. Resumen Tecnológico

-   **Framework Principal**: Spring Boot
-   **Lenguaje**: Java 21
-   **Acceso a Datos**: Spring Data JPA con Hibernate
-   **Base de Datos**: H2 (para desarrollo), PostgreSQL (para producción)
-   **API**: RESTful (Spring Web MVC)
-   **Validación**: Spring Validation
-   **Documentación API**: SpringDoc (OpenAPI)
-   **Build Tool**: Maven
-   **Utilitarios**: Lombok

## 2. Arquitectura de la Aplicación

El proyecto sigue una arquitectura en capas clásica, separando las responsabilidades:

-   **Controladores (`com.sala_conciertos.controlador`)**: Exponen los endpoints REST, gestionan las peticiones HTTP y la validación de entrada.
-   **Servicios (`com.sala_conciertos.servicio`)**: Contienen la lógica de negocio principal.
-   **Repositorios (`com.sala_conciertos.repositorio`)**: Interfaces de Spring Data JPA para la interacción con la base de datos.
-   **Modelos/Entidades (`com.sala_conciertos.modelo`)**: Clases de dominio que representan las tablas de la base de datos.

## 3. Modelo de Datos (Entidades y Relaciones)

### Entidades Principales

-   **`GrupoArtistico`**
    -   `id`: Long (PK)
    -   `nombre`: String
    -   `genero`: String
    -   `numeroIntegrantes`: int
    -   `anioFundacion`: int
    -   `pais`: String
    -   `tipoGrupo`: Enum (TipoGrupoArtistico)

-   **`Evento`**
    -   `id`: Long (PK)
    -   `nombre`: String
    -   `fechaHoraEvento`: LocalDateTime
    -   `tipoEvento`: Enum (TipoEvento)
    -   `precioTaquilla`: double

-   **`Espectador`**
    -   `id`: Long (PK)
    -   `dni`: String (Unique)
    -   `nombre`: String
    -   `email`: String (Unique)

-   **`Entrada`**
    -   `id`: Long (PK)
    -   `zona`: Enum (TipoZona)
    -   `fechaHoraCompra`: LocalDateTime
    -   `fila`: Long
    -   `asiento`: Long
    -   `tipoEntrada`: Enum (TipoEntrada)
    -   `precioTotal`: double
    -   `validada`: boolean

### Relaciones

-   **`GrupoArtistico` - `Evento` (ManyToMany)**
    -   Un grupo puede participar en múltiples eventos.
    -   Un evento (como un festival) puede tener múltiples grupos.
    -   Se gestiona a través de una tabla intermedia `BandaEvento`.

-   **`Evento` - `Entrada` (OneToMany)**
    -   Un evento tiene muchas entradas.

-   **`Espectador` - `Entrada` (OneToMany)**
    -   Un espectador puede tener múltiples entradas.

-   **`Entrada` - `Evento` (ManyToOne)**
    -   Cada entrada pertenece a un único evento.

-   **`Entrada` - `Espectador` (ManyToOne)**
    -   Cada entrada está asociada a un único espectador.

## 4. API Endpoints (REST)

### GrupoArtisticoController

-   `GET /api/grupos`: Obtiene todos los grupos artísticos.
-   `GET /api/grupos/{id}`: Obtiene un grupo por su ID.
-   `POST /api/grupos`: Crea un nuevo grupo artístico.
-   `PUT /api/grupos/{id}`: Actualiza un grupo existente.
-   `DELETE /api/grupos/{id}`: Elimina un grupo.

### EventoController

-   `GET /api/eventos`: Obtiene todos los eventos.
-   `GET /api/eventos/{id}`: Obtiene un evento por su ID.
-   `POST /api/eventos`: Crea un nuevo evento.
-   `PUT /api/eventos/{id}`: Actualiza un evento existente.
-   `DELETE /api/eventos/{id}`: Elimina un evento.

### EspectadorController

-   `GET /api/espectadores`: Obtiene todos los espectadores.
-   `GET /api/espectadores/{id}`: Obtiene un espectador por su ID.
-   `POST /api/espectadores`: Crea un nuevo espectador.
-   `PUT /api/espectadores/{id}`: Actualiza un espectador existente.
-   `DELETE /api/espectadores/{id}`: Elimina un espectador.

### EntradaController

-   `GET /api/entradas`: Obtiene todas las entradas.
-   `GET /api/entradas/{id}`: Obtiene una entrada por su ID.
-   `POST /api/entradas`: Crea una nueva entrada (simula una compra).
-   `PUT /api/entradas/{id}`: Actualiza una entrada (ej. para validarla).
-   `DELETE /api/entradas/{id}`: Elimina una entrada.

## 5. Manejo de Errores

-   **`GlobalExceptionHandler`**: Centraliza el manejo de excepciones.
    -   `MethodArgumentNotValidException`: Para errores de validación (400 Bad Request).
    -   `RuntimeException`: Para entidades no encontradas (404 Not Found).
    -   `Exception`: Para errores inesperados del servidor (500 Internal Server Error).
-   **`ErrorResponse`**: DTO estándar para formatear las respuestas de error en JSON.
