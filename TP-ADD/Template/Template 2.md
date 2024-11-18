# Decisiones de arquitectura de Clientes y Pagos

## Context and Problem Statement

Sequiere crear Dos microservicios:

Clientes: Permite a acceder los datos de personales de los
clientes


Pagos: Se apoya en una pasarela de pago externa que
proporciona la empresa MercadoLibre para garantizar la seguridad de los pagos y la
compatibilidad con otros clientes.



## Considered Options
### Clientes
* Event Sourcing: manejar un historial de cambios
* Táctica de Validación y Filtrado de Datos: Asegurar que solo los datos autorizados son expuestos mediante la validación de roles o permisos.
* Patrón CQRS (Command Query Responsibility Segregation):Separar las operaciones de lectura (query) de las de escritura (command).


### Pagos
* Event Sourcing: Gestionar estados de pago en forma de eventos actualizando su estado
* Adapter Pattern: Facilitar la integración con la pasarela de pagos de MercadoLibre
* Saga Pattern: Gestionar estados de pago y garantizar consistencia entre pedidos y pagos (coordinar acciones en múltiples microservicios)



## Decision Outcome

### Microservicio Clientes:

Decisión: Event Sourcing y Táctica de Validación y Filtrado de Datos

1. Event Sourcing: 

Justificación:

* Historial: Event Sourcing es ideal para mantener un historial completo de todos los cambios realizados en los datos de los clientes. En lugar de sobrescribir registros, cada operación (creación, modificación, eliminación) se registra como un evento, permitiendo reconstruir el estado de un cliente en cualquier momento.

* Auditoría y Trazabilidad: El enfoque es invaluable para auditorías, ya que proporciona una fuente de verdad inmutable y permite analizar cómo y cuándo ocurrieron los cambios.

Resiliencia: Permite restaurar estados ante fallos.reconstruir el sistema.

2. Táctica de Validación y Filtrado de Datos

Justificación:

* Privacidad de datos: Garantiza que los datos personales de los clientes sean accesibles solo para usuarios o sistemas autorizados, asegurando la privacidad y el cumplimiento normativo (por ejemplo, GDPR o CCPA).

* Seguridad: Protege contra accesos indebidos filtrando datos según roles o permisos, lo que reduce riesgos de violaciones de seguridad o exposiciones accidentales.

* Escalabilidad: Filtrar datos en el microservicio en lugar de delegar esta responsabilidad al cliente o sistema consumidor asegura un control centralizado, fácil de mantener y auditar.

### Consequences

1. Event Sourcing:

Positivo: Cumple con RF-03 al ofrecer trazabilidad completa y resiliencia. Además, crea un sistema preparado para soportar auditorías y análisis históricos detallados.

Negativo: Aumenta la complejidad y el consumo de almacenamiento. Puede requerir optimizaciones como snapshots para evitar problemas de rendimiento.

2. Validación y Filtrado de Datos:

Positivo: Refuerza la seguridad de RF-01 mediante control centralizado, asegurando que solo los datos permitidos se exponen. Facilita cumplir con normativas de privacidad y estándares de seguridad.

Negativo: Agrega sobrecarga de procesamiento y complejidad en la gestión de permisos, lo que puede complicar el mantenimiento si no se diseña adecuadamente.

---
### Microservicio Pagos: 

Decisión: Event Sourcing y Adapter Pattern

1. Event Sourcing: Gestionar estados de pago en forma de eventos

Justificación:

* Cumplimiento de RF-06: Al modelar los cambios de estado del pago (pendiente, completado, rechazado) como eventos, Event Sourcing permite un historial completo de transiciones. Esto es fundamental para auditorías y análisis de transacciones fallidas o exitosas.

* Trazabilidad: Ofrece un registro inmutable de cómo se gestionaron los pagos, permitiendo identificar la causa de errores o inconsistencias en el flujo de transacciones.
Resiliencia: En caso de fallos, el estado del pago se puede reconstruir completamente a partir de los eventos registrados.

* Flexibilidad: Simplifica la extensión del sistema, por ejemplo, al integrar nuevas reglas de negocio relacionadas con pagos.


2. Adapter Pattern: Facilitar la integración con la pasarela de pagos de MercadoLibre.

Justificación:

* Cumplimiento de RF-05: El patrón Adapter abstrae las interacciones específicas con la pasarela de MercadoLibre, permitiendo que el microservicio de Pagos mantenga una interfaz genérica para procesar pagos.

* Flexibilidad: Si en el futuro se necesita cambiar la pasarela de pagos (o integrar múltiples pasarelas), el Adapter actúa como un intermediario, minimizando los cambios necesarios en el microservicio.

* Reducción de acoplamiento: La lógica de negocio del microservicio queda desacoplada de los detalles específicos de la API de MercadoLibre, lo que mejora la mantenibilidad del sistema.

* Pruebas más sencillas: El Adapter permite simular la pasarela en ambientes de desarrollo o pruebas, sin necesidad de realizar llamadas reales.


### Consequences


1. Event Sourcing:

Positivo:

* Cumple RF-06 al garantizar trazabilidad y un registro detallado de todos los cambios de estado de pago.

* Permite reconstruir el historial de pagos, facilitando auditorías y análisis.

Negativo:

* Incrementa los costos de almacenamiento.

* Requiere mecanismos adicionales como snapshots para mejorar el rendimiento en consultas frecuentes.

2. Adapter Pattern:

Positivo:

* Simplifica la integración con MercadoLibre y otras pasarelas futuras, reduciendo el acoplamiento y mejorando la flexibilidad del sistema.

* Mejora la mantenibilidad y facilita pruebas.

Negativo:

* Aumenta la carga inicial de desarrollo y mantenimiento.
* Depende de la disponibilidad y la estabilidad de la API externa.