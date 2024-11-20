# Arquitectura de referencia para la migración del monolito
## Context and Problem Statement

Se planea realizar una migración de tipo Brownfield, manteniendo la página operativa mientras se lleva a cabo una transición progresiva de los servicios del monolito a microservicios, sin interrumpir la experiencia de los clientes


## Considered Options

### Tecnologias para crear los microservicios
* Spring Boot
* Micronaut
* Quarkus

## Decision Outcome

Decisión: Usar **Spring Boot** como framework principal para los microservicios


**Justificación:**


1.	Facilidad de uso: Spring Boot proporciona configuración automática y un ecosistema maduro.
2.	Compatibilidad: Encaja bien con otras herramientas ya usadas en el proyecto.
3.	Escalabilidad: Es adecuado para manejar la carga esperada del sistema.
4.	Equipo: Tu equipo tiene experiencia previa con esta tecnología.


#### ***Consequences***

Ventaja: Spring Boot está diseñado para facilitar el desarrollo de aplicaciones independientes y servicios pequeños, lo que lo hace ideal para una transición de monolito a microservicios.

Ventaja: Su enfoque de "convención sobre configuración" ayuda a reducir el tiempo y la complejidad de configurar servicios.

Desventaja: Adoptar Spring Boot implica depender del ecosistema de Spring, lo cual podría limitar futuras decisiones tecnológicas.