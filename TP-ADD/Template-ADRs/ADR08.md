# Implementacion de Microservicios para Pedidos 

## Context and Problem Statement

**Pedidos y Repartos con Rutas** deben integrarse y garantizar la continuidad del servicio en tiempo real. El objetivo es optimizar el manejo de pedidos y logistica de reparto, implementando tecnologicas que permitan escalabilidad, disponibilidad y rendimiento.

## Considered Options


1. **Pipeline sincrono:** Procesar los pedidos en tiempo real y en cadena.
2. **Pipeline Asincrono:** Uso de colas para desacoplar las fases del procesamiento
3. **Procesamiento hibrido:** Mezcla de procesamiento sincrono y eventos Asincronos

## Decision Outcome

#### ***Chosen Option***
*Pipeline Asincrono*, porque permite desacoplar las fases de procesamiento y lo que mejora la escalabilidad y tolerancia a fallos. este pipeline se implementara en 3 fases para gestionar los estados en tiempo real.

**Justification:**
- La estructura en fases permite manejar los pedidos de manera ordenada y eficiente, facilitando la escalabilidad
- La consulta en tiempo real mejora la experiencia del cliente al brindar informacion actualizada sobre el estado de sus pedidos.
- El pipeline centralizado simplifica la integracion con las funcionalidades de reparto y optimizacion de rutas.



#### **Consequences**

- **Good:** Mayor escalabilidad y flexibilidad. Permite gestionar picos de demanda sin comrpometer la disponibilidad
- **Bad:** Mayor complejidad tecnica debido a la necesidad de manejar colas y eventos. lo que puede reducir la eficiencia y tiempo de respuesta