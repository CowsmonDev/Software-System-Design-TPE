# Arquitectura de referencia para la migración del monolito
## Context and Problem Statement

Se planea realizar una migración de tipo Brownfield, manteniendo la página operativa mientras se lleva a cabo una transición progresiva de los servicios del monolito a microservicios, sin interrumpir la experiencia de los clientes


## Considered Options

### Tecnologias para crear los microservicios
* Spring Boot
* Micronaut
* Quarkus


### contenedorización de microservicios en el sistema

* Docker
* Kubernetes (para la orquestación de contenedores)
* Entornos virtualizados tradicionales (por ejemplo, con máquinas virtuales).
  
### API Gateway para gestionar la comunicación entre clientes y microservicios

* Kong API Gateway
* AWS API Gateway
* NGINX
* Traefik

## Decision Outcome

Decisión: Usar Spring Boot como framework principal para los microservicios

Decisión: Usar Docker como tecnología de contenedorización en el sistema.

Decisión: Se utilizará Kong API Gateway, debido a su flexibilidad, su capacidad de integración con herramientas DevOps (como Docker y Kubernetes) y su soporte para plugins que permiten extender funcionalidades según las necesidades del proyecto.


## Consequences

### Spring Boot

1.	Facilidad de uso: Spring Boot proporciona configuración automática y un ecosistema maduro.
2.	Compatibilidad: Encaja bien con otras herramientas ya usadas en el proyecto.
3.	Escalabilidad: Es adecuado para manejar la carga esperada del sistema.
4.	Equipo: Tu equipo tiene experiencia previa con esta tecnología.






Justificación:

•	Spring Boot tiene un ecosistema robusto y una amplia comunidad, facilitando el soporte técnico y la capacitación del equipo.

•	Permite la integración fluida con herramientas de monitoreo y bases de datos existentes.

•	El equipo ya tiene experiencia previa con Spring Framework, lo que reduce el tiempo de aprendizaje.

### Docker

Justificación:

•	Docker permite empaquetar cada microservicio con sus dependencias en un contenedor independiente, garantizando consistencia entre entornos.

•	Los contenedores son más ligeros que las máquinas virtuales, lo que reduce el consumo de recursos del sistema.

•	Existe un amplio soporte de herramientas de orquestación (como Kubernetes y Docker Compose) para gestionar los contenedores.

•	Docker tiene una curva de aprendizaje moderada, y parte del equipo ya tiene experiencia con esta tecnología.

•	Es una solución ampliamente adoptada, lo que garantiza soporte a largo plazo y compatibilidad con herramientas del ecosistema DevOps.

Impacto:

•	Se introduce Docker como una nueva tecnología para el empaquetado y despliegue, lo que requiere capacitación para miembros sin experiencia previa.

•	Se simplificará el proceso de CI/CD  (Integración Continua/Despliegue Continuo) al tener entornos consistentes.

•	Las imágenes de los contenedores pueden aumentar el tamaño del almacenamiento requerido si no se manejan adecuadamente.


### Kong API Gateway

Justificación:

Facilidad de despliegue:
Las imágenes Docker oficiales de Kong permiten una instalación rápida y consistente entre entornos.

Portabilidad:
Docker facilita mover Kong entre infraestructuras locales, en la nube o híbridas, ideal para una migración Brownfield.

Escalabilidad:
Ejecutar múltiples instancias de Kong en contenedores simplifica el escalado horizontal.

Compatibilidad DevOps:
Kong en Docker se integra fácilmente con pipelines de CI/CD, automatizando despliegues y configuraciones.

Aislamiento:
El contenedor elimina conflictos de dependencias, asegurando un entorno estable y predecible.


________________________________________
Impacto:

•	Introducir un API Gateway añade un nuevo componente que puede ser un único punto de fallo si no se implementa adecuadamente.

•	Requiere monitoreo y mantenimiento continuo, además de configuración inicial.

•	Los equipos deben coordinarse para definir contratos de API claros y evitar inconsistencias.

•	Potencial incremento de latencia debido al paso intermedio, aunque esto puede minimizarse con optimizaciones.


