# Implementación de microservicios para Clientes

## Context and Problem Statement

Para el microservicio 'Cliente', se necesita gestionar la creación, modificación y eliminación de registros de clientes, así como mantener un historial de actividad para cada cliente.

## Considered Options


* Event Sourcing: manejar un historial de cambios
* Táctica de Validación y Filtrado de Datos: Asegurar que solo los datos autorizados son expuestos mediante la validación de roles o permisos.
* Patrón CQRS (Command Query Responsibility Segregation):Separar las operaciones de lectura (query) de las de escritura (command).

## Decision Outcome

Decisión: Event Sourcing



**Justificación:**

* Historial: Event Sourcing es ideal para mantener un historial completo de todos los cambios realizados en los datos de los clientes. En lugar de sobrescribir registros, cada operación (creación, modificación, eliminación) se registra como un evento, permitiendo reconstruir el estado de un cliente en cualquier momento.

* Auditoría y Trazabilidad: El enfoque es invaluable para auditorías, ya que proporciona una fuente de verdad inmutable y permite analizar cómo y cuándo ocurrieron los cambios.

Resiliencia: Permite restaurar estados ante fallos.

### **Consequences**


Positivo: Ofrece trazabilidad completa y resiliencia. Además, crea un sistema preparado para soportar auditorías y análisis históricos detallados.

Negativo: Aumenta la complejidad y el consumo de almacenamiento. Puede requerir optimizaciones como snapshots para evitar problemas de rendimiento.


