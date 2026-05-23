# Microservicio de Catálogo

Microservicio encargado de la gestión de categorías y productos del sistema de supermercado. Permite crear, consultar, actualizar y eliminar tanto categorías como productos, con validaciones de negocio como nombres únicos, precios válidos y categorías existentes.

---

## Configuración

**Puerto:** `8082`  
**Base de datos:** `db_catalogo` 

**OpenAPI**
```
http://localhost:8082/swagger-ui.html
```

**Eureka**
```
http://localhost:8761/
```

---

## Base de datos

Las tablas son creadas automáticamente por Flyway al iniciar la aplicación.

### `category`
| Campo | Tipo         | Descripción              |
|-------|--------------|--------------------------|
| id    | BIGINT (PK)  | Identificador único      |
| name  | VARCHAR(100) | Nombre único de categoría |

### `product`
| Campo       | Tipo         | Descripción                          |
|-------------|--------------|--------------------------------------|
| id          | BIGINT (PK)  | Identificador único                  |
| name        | VARCHAR(100) | Nombre único del producto            |
| description | VARCHAR(280) | Descripción del producto             |
| price       | INT          | Precio (entre 1 y 1.000.000)         |
| category_id | BIGINT (FK)  | Referencia a la categoría            |

---

## URL base

```
http://localhost:8082
```

---

## Endpoints

### Categorías — `/api/v1/categories`

| Método | Ruta   | Descripción                  |
|--------|--------|------------------------------|
| GET    | `/`    | Obtener todas las categorías |
| GET    | `/{id}`| Obtener categoría por ID     |
| POST   | `/`    | Crear nueva categoría        |
| PUT    | `/{id}`| Actualizar categoría         |
| DELETE | `/{id}`| Eliminar categoría           |

### Productos — `/api/v1/products`

| Método | Ruta                            | Descripción                                        |
|--------|---------------------------------|----------------------------------------------------|
| GET    | `/`                             | Obtener todos los productos                        |
| GET    | `/{id}`                         | Obtener producto por ID                            |
| GET    | `/search?name={nombre}`         | Buscar productos por nombre                        |
| GET    | `/category/{categoryId}`        | Obtener productos por categoría                    |
| GET    | `/category/{categoryId}/price?minPrice={min}&maxPrice={max}` | Filtrar por categoría y rango de precio |
| POST   | `/`                             | Crear nuevo producto                               |
| PUT    | `/{id}`                         | Actualizar producto                                |
| DELETE | `/{id}`                         | Eliminar producto                                  |

---

## Reglas de negocio

- No se permiten categorías con nombre duplicado (insensible a mayúsculas).
- No se permiten productos con nombre duplicado (insensible a mayúsculas).
- Todo producto debe pertenecer a una categoría existente.
- El precio de un producto debe ser mayor a 0 y menor o igual a 1.000.000.

---

### Integrantes

**- Isidora Gómez**

**- Rayen Bettancourt**
