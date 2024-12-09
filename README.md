
# Gestión de Candidatos

Este proyecto es una aplicación basada en **Spring Boot** diseñada para gestionar candidatos y proporcionar autenticación con JWT. Implementa una arquitectura hexagonal y está documentada con **OpenAPI**.

## Características

- **Autenticación y Registro**:
  - Autenticación de usuarios mediante JWT.
  - Registro de nuevos usuarios con validación de datos.
- **Gestión de Candidatos**:
  - Crear candidatos.
  - Obtener la lista de todos los candidatos.
  - Obtener candidatos por id
  - Eliminar Candidato logicamente
  - Actualizar Candidato
- **Arquitectura Hexagonal**:
  - Separación clara entre dominio, aplicación, infraestructura e interfaces.
- **Documentación con Swagger**:
  - Acceso a la interfaz Swagger UI en `/swagger-ui/index.html`.
- **Seguridad**:
  - Operaciones protegidas mediante JWT.

## Requisitos Previos

- **Java 17+**
- **Gradle** (para gestionar dependencias)
- **Base de Datos MySQL en la nube**

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Spiritbe4r/gestion_candidatos_api
   ```

2. Configura la base de datos en `application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/human_resources
       username: tu_usuario
       password: tu_contraseña
     jpa:
       hibernate:
         ddl-auto: update
   ```

3. Construye y ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

4. Accede a la interfaz Swagger UI:
   - LOCAL : [http://localhost:8080/swagger-ui/index.html]
   - DESPLEGADO : [https://gestion-candidatos-api.onrender.com/swagger-ui/index.html]
## Endpoints Principales

### Autenticación

- **POST** `/api/auth/v1/register`:
  Registra un nuevo usuario.

  **Request Body**:
  ```json
  {
      "username": "admin",
      "email": "admin@example.com",
      "password": "admin123"
  }
  ```

  **Response**:
  ```json
  {
      "message": "Usuario registrado con éxito"
  }
  ```

- **POST** `/api/auth/v1/login`:
  Autentica un usuario y devuelve un token JWT.

  **Request Body**:
  ```json
  {
      "email": "admin@gmail.com",
      "password": "admin123"
  }
  ```

  **Response**:
  ```json
  {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

### Gestión de Candidatos

- **POST** `/api/v1/candidates`:
  Crea un nuevo candidato.

  **Request Body**:
  ```json
  {
      "name": "John Doe",
      "email": "johndoe@example.com",
      "gender": "Male",
      "salaryExpected": 50000
  }
  ```

  **Response**:
  ```json
  {
      "id": 1,
      "name": "John Doe",
      "email": "johndoe@example.com",
      "gender": "Male",
      "salaryExpected": 50000
  }
  ```

- **GET** `/api/v1/candidates`:
  Obtiene la lista de candidatos.

  **Response**:
  ```json
  [
      {
          "id": 1,
          "name": "John Doe",
          "email": "johndoe@example.com",
          "gender": "Male",
          "salaryExpected": 50000
      }
  ]
  ```

## Arquitectura del Proyecto

- **Domain**: Lógica de negocio y entidades del dominio.
- **Application**: Casos de uso y lógica de aplicación.
- **Infrastructure**: Persistencia (JPA) y seguridad (JWT), Controladores REST y DTOs.

## Configuración de Usuario Inicial

Un usuario administrador predeterminado se crea al iniciar el proyecto:

- **Username**: `admin`
- **Password**: `1234asdf`

## Tecnologías

- **Spring Boot** (Web, Security, Data JPA)
- **MySQL** (Base de datos)
- **Springdoc OpenAPI** (Documentación Swagger)
- **JWT** (Autenticación)
- **Jakarta Validation** (Validación de datos)

## Contacto

Desarrollado por Elvin Ronal Cardenas Calcina - cardenascode7@gmail.com.
