# Arquitectura de referencia para la migración del monolito
## Context and Problem Statement

Se planea realizar una migración de tipo Brownfield, manteniendo la página operativa mientras se lleva a cabo una transición progresiva de los servicios del monolito a microservicios, sin interrumpir la experiencia de los clientes


## Considered Options

### API Gateway para gestionar la comunicación entre clientes y microservicios

* Kong API Gateway
* AWS API Gateway
* NGINX
* Traefik

## Decision Outcome


Decisión: Se utilizará **Kong API Gateway**, debido a su flexibilidad, su capacidad de integración con herramientas DevOps (como Docker y Kubernetes) y su soporte para plugins que permiten extender funcionalidades según las necesidades del proyecto.



**Justificación:**

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



### **Consequences**

•	Introducir un API Gateway añade un nuevo componente que puede ser un único punto de fallo si no se implementa adecuadamente.

•	Requiere monitoreo y mantenimiento continuo, además de configuración inicial.

•	Los equipos deben coordinarse para definir contratos de API claros y evitar inconsistencias.

•	Potencial incremento de latencia debido al paso intermedio, aunque esto puede minimizarse con optimizaciones.


