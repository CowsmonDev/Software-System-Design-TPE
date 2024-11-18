# Implementación de microservicios para Estadísticas y incidencias

## Context and Problem Statement

Se estan implementando dos microservicios especializados en manejo de datos para devolver respuestas. Las tecnologias deben brindar isponibilidad, Escalabilidad, Exactitud y Rendimiento

## Considered Options

* Táctica de Background Processing: Procesos en segundo plano para tareas intensivas, como cálculos de análisis o generación de informes pesados.

* Táctica de Aggregation Layer: Implementa una capa interna que consolida datos de múltiples orígenes locales (p. ej., datos de pedidos, clientes y rutas) en estructuras listas para consulta.

* Patrón Database per Service: Cada microservicio tiene su propia base de datos que organiza y administra exclusivamente.


## Decision Outcome

Decisión (ambos microservicios): Aggregation Layer y Database per Service

**Justificación:**

**Simplicidad y claridad:**
Centraliza la lógica de cómo se relacionan y combinan los datos. En lugar de replicar esta lógica en cada consulta, la capa actúa como punto único para acceder a datos ya preparados.

**Flexibilidad:**
Permite modificar cómo se combinan o transforman los datos sin afectar la estructura subyacente de almacenamiento. Esto facilita ajustes futuros en los informes o tableros.

**Optimización para consultas:**
Prepara estructuras de datos específicas para los informes más frecuentes, mejorando el tiempo de respuesta.

**Base de Datos propia:** Tener su propia base permite optimizar las estructuras y consultas sin depender de otros servicios.

### Consequences

**Sincronización de datos:**
Como Estadísticas probablemente depende de datos generados por otros servicios (Pedidos, Clientes, Rutas), será necesario implementar mecanismos de sincronización confiables (mensajería/eventos o APIs).

**Mayor complejidad operativa:**
Administrar múltiples bases de datos puede aumentar la carga operativa para el equipo de infraestructura.

