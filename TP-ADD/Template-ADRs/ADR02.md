# Arquitectura de referencia para la migración del monolito
## Context and Problem Statement

Se planea realizar una migración de tipo Brownfield, manteniendo la página operativa mientras se lleva a cabo una transición progresiva de los servicios del monolito a microservicios, sin interrumpir la experiencia de los clientes


## Considered Options

### contenedorización de microservicios en el sistema

* Docker
* Kubernetes (para la orquestación de contenedores)
* Entornos virtualizados tradicionales (por ejemplo, con máquinas virtuales).


## Decision Outcome


Decisión: Usar **Docker** como tecnología de contenedorización en el sistema.



**Justificación:**

•	Docker permite empaquetar cada microservicio con sus dependencias en un contenedor independiente, garantizando consistencia entre entornos.

•	Los contenedores son más ligeros que las máquinas virtuales, lo que reduce el consumo de recursos del sistema.

•	Existe un amplio soporte de herramientas de orquestación (como Kubernetes y Docker Compose) para gestionar los contenedores.

•	Docker tiene una curva de aprendizaje moderada, y parte del equipo ya tiene experiencia con esta tecnología.

•	Es una solución ampliamente adoptada, lo que garantiza soporte a largo plazo y compatibilidad con herramientas del ecosistema DevOps.

### **Consequences**

•	Se introduce Docker como una nueva tecnología para el empaquetado y despliegue, lo que requiere capacitación para miembros sin experiencia previa.

•	Se simplificará el proceso de CI/CD  (Integración Continua/Despliegue Continuo) al tener entornos consistentes.

•	Las imágenes de los contenedores pueden aumentar el tamaño del almacenamiento requerido si no se manejan adecuadamente.