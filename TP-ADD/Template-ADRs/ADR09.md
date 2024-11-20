# Implementacion de Microservicios para Reparto de con Rutas

## Context and Problem Statement

**Pedidos y Repartos con Rutas** deben integrarse y garantizar la continuidad del servicio en tiempo real. El objetivo es optimizar el manejo de pedidos y logistica de reparto, implementando tecnologicas que permitan escalabilidad, disponibilidad y rendimiento.



## Considered Options

### Microservicio de Reparto y Rutas
1. **Algoritmo de rutas estaticas:** Calculo previo de rutas y asignacion fija.
2. **Algoritmo de rutas dinamica:** Optimizacion en tiempo real basada en el estado de los pedidos y camiones
3. **Algoritmo hibrido:** Precalculo con ajustes dinamicos

## Decision Outcome

#### ***Chosen Option***
*Algoritmo Dinamico por demanda*, proque maximiza la eficiencia en el uso de recursos y ajusta las rutas segun las condiciones actuales.

**Justification:**
- El uso de un algoritmo dinamico permite ajustar las rutas en funcion de los datos en tiempo real, como el estado del trafico, la ubicacion de los vehiculos y los pedidos, lo que mejora la eficiencia del sistema
- este enfoque optimiza el uso de los recuersos disponibles y reduce los tiempo de entrega, al considerar variables cambiantes de manera continua.
- Ademas, este algoritmo es escalable, ya que puede adaptarse a un numero creciente de pedidos y repartos sin perder precision en los calculos

#### **Consequences**
- **Good:** Rutas mas eficientes y adaptadas en tiempo real, lo que mejora el rendimiento general del sistema.
- **Bad:** Mayor complejidad tecnica debido a la necesidad de manejar colas y eventos, lo que puede reducir la eficiencia y el tiempo de respuesta