# WMS y TMS para e-Commerce

Prototipo en Java (Maven) de un sistema de gestión de almacén (WMS) y de transporte (TMS) para e-commerce.
Se utiliza como base para el TP Integrador de Sistemas de Gestión de la Configuración (Git + GitHub + Gitflow).

## Requisitos
- JDK 17+
- Maven 3.8+

## Cómo ejecutar
```bash
mvn clean verify          # compila y corre tests
mvn exec:java -Dexec.mainClass=ar.edu.wmstms.Main
```

## Estructura
```
src/main/java/ar/edu/wmstms/
  modelo/     Producto, Pedido
  servicio/   InventarioService (WMS), EnvioService (TMS)
.github/      CODEOWNERS, workflow de CI, template de PR
```

## Integrantes
- Nombre Apellido (@usuario1)
- ...

## Flujo de trabajo (Gitflow)
- `main`: código en producción (solo recibe merges de `release/*` y `hotfix/*`, con tag de versión).
- `develop`: integración de desarrollo.
- `feature/*`: nuevas funcionalidades, salen de `develop` y vuelven a `develop`.
- `release/*`: preparación de versión, sale de `develop` y se mergea a `main` y `develop`.
- `hotfix/*`: correcciones urgentes, salen de `main` y se mergean a `main` y `develop`.

## ¿Qué documentaríamos en el README? (punto 8.1)
<!-- COMPLETAR: qué es el proyecto, requisitos, instalación, ejecución, estructura, flujo de ramas,
     convenciones de commits, cómo contribuir, integrantes, licencia. Justificar por qué. -->

## Pull Requests de externos (punto 8.2)
<!-- COMPLETAR: datos a pedir (descripción, motivo, issue relacionado, cómo se probó, impacto/breaking changes,
     capturas) y qué ofrece GitHub: PULL_REQUEST_TEMPLATE, CODEOWNERS, checks de CI, code review con comentarios
     y sugerencias, branch protection, Issues vinculados, Projects/labels. -->
