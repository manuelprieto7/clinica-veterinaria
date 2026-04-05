# 🐾 Peluquería Canina

Sistema de escritorio para gestión de mascotas y sus responsables.
Desarrollado en Java SE con Swing, JPA puro y MySQL.

---

## Stack

![Java](https://img.shields.io/badge/Java-21-orange)
![Maven](https://img.shields.io/badge/Maven-3.x-red)
![JPA](https://img.shields.io/badge/JPA-EclipseLink_4.0-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue)

---

## Qué hace

- Registrar, editar y eliminar mascotas y sus responsables
- Visualizar todos los registros en tabla interactiva
- Persistencia real con JPA y MySQL sin frameworks intermedios

---

## Arquitectura
```
[ Swing — IGU ]  →  [ Controladora — Lógica ]  →  [ JPA — Persistencia ]  →  [ MySQL ]
```

Tres capas con responsabilidades separadas.
La lógica de negocio no toca la UI. La persistencia no toca la lógica.

---

## Cómo ejecutarlo

**Requisitos:** Java 21, Maven 3.x, MySQL 8.x en `localhost:3306`
```bash
git clone https://github.com/manuelprieto7/peluqueria-canina.git
cd peluqueria-canina
```
```sql
CREATE DATABASE peluqueriacanina;
```

Configurar credenciales en `src/main/resources/META-INF/persistence.xml`
```bash
mvn clean package && mvn exec:java
```

---

## Estado

| Hito                          | Estado        |
|-------------------------------|---------------|
| Git Flow y estructura         | ✅ Completo   |
| Refactorización de entidades  | 🔄 En curso   |
| Validaciones y excepciones    | ⏳ Pendiente  |
| Citas y estados de mascota    | ⏳ Pendiente  |
| Documentación final           | ⏳ Pendiente  |

---

## Autor

**Manuel Prieto** — [manuelprieto7](https://github.com/manuelprieto7)