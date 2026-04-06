# 🐾 Sistema de Gestión — Clínica Veterinaria

> Aplicación de escritorio para la gestión de pacientes,
> responsables e historial de consultas de una clínica veterinaria.
> Construida con Java SE, Swing, JPA puro y MySQL.

## Stack

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)
![JPA](https://img.shields.io/badge/JPA-EclipseLink_4.0-blue.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue.svg)

---

## Qué hace

- Registrar, editar y eliminar pacientes y sus responsables
- Historial clínico por paciente — consultas con fecha, diagnóstico y tratamiento
- Visualización de datos en tablas interactivas
- Persistencia real con JPA y MySQL sin frameworks intermedios
- Navegación entre ventanas sin solapamiento ni cierres inesperados

---

## Arquitectura

```
[ Swing — IGU ]  →  [ Controladora — Lógica ]  →  [ JPA — Persistencia ]  →  [ MySQL ]
```

Tres capas con responsabilidades estrictamente separadas.
La IGU no conoce JPA. La persistencia no conoce Swing.
Cada capa tiene una única razón para cambiar.

---

## Modelo de datos

```
Responsable (1)
      │
      │ @ManyToOne
      ▼
  Paciente (N) ←── muchos pacientes por responsable
      │
      │ @ManyToOne
      ▼
  Consulta (N) ←── muchas consultas por paciente
   fecha, motivo, diagnóstico, tratamiento, veterinario
```

## Cómo ejecutarlo

**Requisitos:** Java 21, Maven 3.x, MySQL 8.x en `localhost:3308`

```bash
git clone https://github.com/manuelprieto7/clinica-veterinaria.git
cd clinica-veterinaria
```

```sql
CREATE DATABASE clinica_veterinaria;
```

Configurar credenciales en `src/main/resources/META-INF/persistence.xml`

```bash
mvn clean package && mvn exec:java
```

---

## Por qué este proyecto

Venía haciendo ejercicios sueltos de Java y necesitaba algo que integrara todo:
una UI real, una base de datos real y lógica de negocio con sentido.

Elegí JPA puro (sin Spring Data) porque quería entender qué hace un
`EntityManager` antes de delegárselo a un framework. Si no sé qué es
`begin()`, `persist()` y `commit()`, usar Spring Data es solo magia
que no puedo debuggear.

---

## Estado

| Hito                          | Estado      |
| ----------------------------- | ----------- |
| Git Flow y estructura         | ✅ Completo |
| Entidades JPA + CRUD completo | ✅ Completo |
| Interfaz gráfica Swing        | ✅ Completo |
| Historial de consultas        | ✅ Completo |

---

## Autor

**Manuel Prieto** — [manuelprieto7](https://github.com/manuelprieto7)
