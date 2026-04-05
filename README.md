# 🐾 Sistema de Gestión — Peluquería Canina

> Aplicación de escritorio para la gestión integral de mascotas,
> responsables y servicios de una peluquería canina.
> Construida con Java SE, Swing, JPA y MySQL.

---

## 📋 Descripción del Proyecto

Este sistema permite registrar, consultar, modificar y eliminar
mascotas y sus responsables. Fue desarrollado como proyecto de
portafolio aplicando arquitectura en capas, buenas prácticas de
codificación y control de versiones profesional con Git Flow.

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura de **3 capas** estrictamente separadas:
```
[ IGU - Swing ]
      │  Recibe input del usuario y delega
      ▼
[ Lógica - Controladora ]
      │  Valida reglas de negocio y construye entidades
      ▼
[ Persistencia - JPA / EclipseLink ]
      │  Gestiona la comunicación con la base de datos
      ▼
[ MySQL - Base de Datos ]
```

---

## 🛠️ Tecnologías Utilizadas

| Tecnología        | Versión  | Propósito                        |
|-------------------|----------|----------------------------------|
| Java SE           | 21       | Lenguaje principal               |
| Maven             | 3.x      | Gestión de dependencias y build  |
| JPA (EclipseLink) | 4.0.2    | Mapeo objeto-relacional (ORM)    |
| MySQL             | 8.x      | Motor de base de datos           |
| Swing             | (JDK 21) | Interfaz gráfica de escritorio   |

---

## 🚀 Cómo Ejecutar el Proyecto

### Pre-requisitos
- Java 21 instalado
- Maven 3.x instalado
- MySQL 8.x corriendo en localhost:3306

### Pasos

1. Cloná el repositorio:
```bash
   git clone https://github.com/tu-usuario/peluqueria-canina.git
```

2. Creá la base de datos en MySQL:
```sql
   CREATE DATABASE peluqueriacanina;
```

3. Configurá las credenciales en `src/main/resources/META-INF/persistence.xml`

4. Compilá y ejecutá con Maven:
```bash
   mvn clean package
   mvn exec:java
```

---

## 📁 Estructura del Proyecto
```
src/
└── main/
    └── java/
        └── prieto/manuel/maven/peluqueriacanina/
            ├── igu/              # Pantallas Swing (Vista)
            ├── logica/           # Entidades JPA + Controladora (Lógica)
            └── persistencia/     # JPA Controllers + utilidades (Datos)
```


## 👤 Autor

**Manuel Prieto**
- GitHub:  manuelprieto7 (https://github.com/manuelprieto7)