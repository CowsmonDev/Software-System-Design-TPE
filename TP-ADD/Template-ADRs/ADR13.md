# Implementación de microservicios para incidencias

## Context and Problem Statement

Se está implementando un microservicio especializado en manejo de las incidencias, puede notificar a los gestores de rutas, por ejemplo, un camión averiado o un reparto no realizado. Las tecnologias deben brindar Disponibilidad, Escalabilidad, Exactitud y  buen Rendimiento.

## Considered Options

* Táctica de Background Processing: Procesos en segundo plano para tareas intensivas, como cálculos de análisis o generación de informes pesados.

* Táctica de Aggregation Layer: Implementa una capa interna que consolida datos de múltiples orígenes locales (p. ej., datos de pedidos, clientes y rutas) en estructuras listas para consulta.

* Patrón Database per Service: Cada microservicio tiene su propia base de datos que organiza y administra exclusivamente.


## Decision Outcome

Decisión: Database per Service

**Justificación:**

Optimización independiente:
Cada microservicio puede diseñar y optimizar sus estructuras y consultas de datos sin depender de otros servicios.


Comparar con casos anteriores: Al tener Base de datos Propia, se puede buscar soluciones de casos similares.


### **Consequences**

Mayor complejidad operativa:
Administrar múltiples bases de datos incrementa la carga operativa del equipo de infraestructura, incluyendo aspectos como monitoreo, mantenimiento y escalabilidad.