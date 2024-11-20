# Implementación de microservicios para Estadísticas

## Context and Problem Statement

Se está implementando un microservicio especializado en manejo de datos para devolver respuestas como el estado de los pedidos o la situación en tiempo real de los camiones. Las tecnologias deben brindar Disponibilidad, Escalabilidad, Exactitud y  buen Rendimiento.

## Considered Options


* Táctica de Background Processing: Procesos en segundo plano para tareas intensivas, como cálculos de análisis o generación de informes pesados.

* Táctica de Aggregation Layer: Implementa una capa interna que consolida datos de múltiples orígenes locales (p. ej., datos de pedidos, clientes y rutas) en estructuras listas para consulta.

* Patrón Database per Service: Cada microservicio tiene su propia base de datos que organiza y administra exclusivamente.


## Decision Outcome

Decisión: Aggregation Layer

**Justificación:**

Simplicidad y claridad:
Centraliza la lógica de cómo se relacionan y combinan los datos, actuando como un punto único de acceso a datos ya preparados en lugar de replicar esta lógica en cada consulta.


Flexibilidad:
Permite modificar cómo se combinan o transforman los datos sin impactar la estructura de almacenamiento subyacente. Esto facilita futuros ajustes en informes o tableros.


Optimización para consultas:
Prepara estructuras de datos específicas para los informes más frecuentes, mejorando significativamente los tiempos de respuesta.

### **Consequences**

Sincronización de datos:
Dado que Estadísticas probablemente depende de otros servicios (como Pedidos, Clientes y Rutas), será necesario implementar mecanismos confiables de sincronización, como mensajería por eventos o APIs.
