# TaskManager

Esta API Rest ha sido desarrollada con Spring Framework, con el fin de gestionar tareas. El proyecto maneja una arquitectura limpia, al igual que el manejo global de excepciones y validaciones de integridad de datos directamente de las entidades JPA.

---

## Características

- **CRUD Completo:** Operaciones de creación, lectura, actualización y eliminación de tareas.
- **Validación con Bean Validation:** Reglas de integridad de datos aplicadas directamente en las entidades JPA (`@NotBlank`, `@Size`, `@NotNull`).
- **Manejo Global de Excepciones:** Uso de `@RestControllerAdvice` para centralizar los errores y devolver respuestas JSON consistentes.
- **Persistencia Inteligente:** Configuración optimizada para fechas de creación automáticas (`CreationDate`) respetando los valores por defecto de la base de datos.

---

## Tecnologías Utilizadas

- **Java 17**
- **Spring Framework 4.0.6** (Spring Data JPA, Spring Web, Spring Validation)
- **Oracle SQL 19c** (Base de datos)
- **Maven** (Gestión de dependencias)

---

## Instalación y Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/dilanaraizac18/TaskManager.git
   ```
2. **Configurar el entorno**
   - Edita el archivo `src/main/java/TaskManager/YaGanaste/Configuration/DataSourceConfig.java` con tus credenciales de base de datos:
   ```java
      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
      dataSource.setUsername("nombreDeUsuario");
      dataSource.setPassword("tuContraseña");
     ```
   > **Nota:** La ruta al script de creación de base de datos se encuentra en `src/main/resources/db/migration/TaskManager.sql`.

3. **Ejecutar la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

## Documentación de la API

| Funcionalidad | Ruta |
| :--- | :--- |
| Ver tareas | `GET /api/tasks` |
| Guardar | `POST /api/tasks` |
| Ver tarea por ID | `GET /api/tasks/{ID}` |
| Eliminar | `DELETE /api/tasks/{ID}` |
| Actualizar tarea existente | `PUT /api/tasks/{ID}` |

**Ejemplo petición POST:**
```json
{
  "IdTask": 0,
  "Tittle": "Ejemplo de petición POST",
  "Description": "Se debe implementar tanto el ID = 0 de la tarea, titulo, descripción e ID del estatus, la fecha se asigna automáticamente",
    "Status": {
      "IdStatus": 3
   }      
}
```

**Ejemplo petición PUT:**
```json
{
  "IdTask": 2,
  "Tittle": "Ejemplo de petición PUT",
  "Description": "Se debe implementar el ID de la tarea existente, titulo, descripción e ID del estatus, la fecha se asigna automáticamente",
    "Status": {
      "IdStatus": 3
   }      
}
```



   
