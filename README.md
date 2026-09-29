# WMS y TMS para e-Commerce

Prototipo en Java (Maven) de un sistema de gestión de almacén (WMS) y de transporte (TMS) para e-commerce.
Se utiliza como base para el TP Integrador de Sistemas de Gestión de la Configuración (Git + GitHub + Gitflow).

## Integrantes
- Maglianesi Lucas (@lumaglia)
- Marenoni Facundo (@FacuMarenoni)
- Savogin Maximo (@The-Maxs)
- Zermatten Ignacio (@NachoZer)

## Flujo de trabajo (Gitflow)
- `main`: código en producción (solo recibe merges de `release/*` y `hotfix/*`, con tag de versión).
- `develop`: integración de desarrollo.
- `feature/*`: nuevas funcionalidades, salen de `develop` y vuelven a `develop`.
- `release/*`: preparación de versión, sale de `develop` y se mergea a `main` y `develop`.
- `hotfix/*`: correcciones urgentes, salen de `main` y se mergean a `main` y `develop`.

## Ignorar configuraciones locales (punto 7.b)
Utilizando un archivo `.gitignore`, que permite especificar archivos y carpetas que Git debe ignorar. De esta manera, configuraciones propias de cada computadora, archivos temporales, credenciales, archivos generados por IDEs y otros archivos locales no se incorporan al repositorio.

## Llevar al entorno productivo Release 1 en Gitflow (punto 7.e)
Siguiendo Gitflow, la rama `release` se integra en `main`, que representa el código destinado a producción. Luego se crea un tag para identificar la versión liberada. Finalmente, los cambios de la release se integran también en `develop` para mantener sincronizadas ambas ramas.

## Corregir un error en version productiva (punto 7.f)
Se crea una rama `hotfix` a partir de `main`, ya que el error se encuentra en la versión que está en producción. En esta rama se realiza y prueba la corrección. Una vez solucionado el problema, el `hotfix` se integra tanto en `main` como en `develop`.

## Llevar los cambios de la rama creada en el punto 1 a producción en Gitflow (punto 7.j)
La rama `feature` se integra primero en `develop`. Posteriormente, cuando se prepara una nueva versión, se crea una rama `release` desde `develop`. Esa release se integra en `main` para llevar los cambios a producción y también se integra nuevamente en `develop`.

## ¿Cómo podemos documentar con Git? (punto 8)
Mediante commits descriptivos, ramas, tags, Pull Requests, comentarios, historial de cambios y archivos de documentación versionados dentro del repositorio, especialmente un `README.md`.

## ¿Qué documentarían allí? ¿Por qué versionar el README en el repositorio? (punto 8.1)

En el README se documentaría el objetivo y descripción del software, funcionalidades principales, tecnologías utilizadas, requisitos, instrucciones generales de instalación y ejecución, estructura del proyecto y cualquier información necesaria para comprender y utilizar el sistema.

Versionarlo permite que la documentación forme parte del historial del proyecto y evolucione junto con el código.

## ¿Qué datos le pediría a una persona externa que complete en el PR? ¿Qué nos ofrece GitHub para ayudarnos con esto? (punto 8.2)

Se le pediría que indique:

* Qué cambios realizó.
* Por qué realizó esos cambios.
* Qué problema solucionan o qué funcionalidad incorporan.
* Cómo fueron probados.
* Si existe algún cambio que pueda afectar otras partes del sistema.

GitHub ofrece Pull Requests para centralizar esta información y permite visualizar exactamente qué líneas fueron modificadas, realizar comentarios sobre cambios específicos, proponer sugerencias, solicitar revisiones a otros integrantes, aprobar o solicitar modificaciones y mantener registrado todo el intercambio relacionado con el cambio.