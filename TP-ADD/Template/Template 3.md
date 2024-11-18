# Implementacion de Microservicios para Pedidos y Reparto de con Rutas

## Context and Problem Statement

El sistema requiere dos microservicios principales: **Pedidos y Repartos con Rutas**, que deben integrarse y garantizar la continuidad del servicio en tiempo real. El objetivo es optimizar el manejo de pedidos y logistica de reparto, implementando tecnologicas que permitan escalabilidad, disponibilidad y rendimiento.

## Considered Options

### Microservicio de Pedidos:

1. **Pipeline sincrono:** Procesar los pedidos en tiempo real y en cadena.
2. **Pipeline Asincrono:** Uso de colas para desacoplar las fases del procesamiento
3. **Procesamiento hibrido:** Mezcla de procesamiento sincrono y eventos Asincronos

### Microservicio de Reparto y Rutas
1. **Algoritmo de rutas estaticas:** Calculo previo de rutas y asignacion fija.
2. **Algoritmo de rutas dinamica:** Optimizacion en tiempo real basada en el estado de los pedidos y camiones
3. **Algoritmo hibrido:** Precalculo con ajustes dinamicos

## Decision Outcome

### Microservicios de Pedidos

#### ***Chosen Option***
*Pipeline Asincrono*, porque permite desacoplar las fases de procesamiento y lo que mejora la escalabilidad y tolerancia a fallos. este pipeline se implementara en 3 fases para gestionar los estados en tiempo real.

**Justification:**
- La estructura en fases permite manejar los pedidos de manera ordenada y eficiente, facilitando la escalabilidad
- La consulta en tiempo real mejora la experiencia del cliente al brindar informacion actualizada sobre el estado de sus pedidos.
- El pipeline centralizado simplifica la integracion con las funcionalidades de reparto y optimizacion de rutas.


<!-- This is an optional element. Feel free to remove. -->
#### ***Consequences***

- **Good:** Mayor escalabilidad y flexibilidad. Permite gestionar picos de demanda sin comrpometer la disponibilidad
- **Bad:** Mayor complejidad tecnica debido a la necesidad de manejar colas y eventos. lo que puede reducir la eficiencia y tiempo de respuesta

### Microservicio de Reparto y Rutas
#### ***Chosen Option***
*Algoritmo Dinamico por demanda*, proque maximiza la eficiencia en el uso de recursos y ajusta las rutas segun las condiciones actuales.

**Justification:**
- El uso de un algoritmo dinamico permite ajustar las rutas en funcion de los datos en tiempo real, como el estado del trafico, la ubicacion de los vehiculos y los pedidos, lo que mejora la eficiencia del sistema
- este enfoque optimiza el uso de los recuersos disponibles y reduce los tiempo de entrega, al considerar variables cambiantes de manera continua.
- Ademas, este algoritmo es escalable, ya que puede adaptarse a un numero creciente de pedidos y repartos sin perder precision en los calculos

#### ***Consequences***
- **Good:** Rutas mas eficientes y adaptadas en tiempo real, lo que mejora el rendimiento general del sistema.
- **Bad:** Mayor complejidad tecnica debido a la necesidad de manejar colas y eventos, lo que puede reducir la eficiencia y el tiempo de 

