# Implementación de microservicios para Clientes

## Context and Problem Statement

Para el microservicio 'Cliente', se necesita gestionar la creación, modificación y eliminación de registros de clientes, así como mantener un historial de actividad para cada cliente.

## Considered Options


* Event Sourcing: manejar un historial de cambios
* Táctica de Validación y Filtrado de Datos: Asegurar que solo los datos autorizados son expuestos mediante la validación de roles o permisos.
* Patrón CQRS (Command Query Responsibility Segregation):Separar las operaciones de lectura (query) de las de escritura (command).

## Decision Outcome

Decisión: Táctica de Validación y Filtrado de Datos



**Justificación:**

* Privacidad de datos: Garantiza que los datos personales de los clientes sean accesibles solo para usuarios o sistemas autorizados, asegurando la privacidad y el cumplimiento normativo (por ejemplo, GDPR o CCPA).

* Seguridad: Protege contra accesos indebidos filtrando datos según roles o permisos, lo que reduce riesgos de violaciones de seguridad o exposiciones accidentales.

* Escalabilidad: Filtrar datos en el microservicio en lugar de delegar esta responsabilidad al cliente o sistema consumidor asegura un control centralizado, fácil de mantener y auditar.

### **Consequences**


Positivo: Refuerza la seguridad mediante control centralizado, asegurando que solo los datos permitidos se exponen. Facilita cumplir con normativas de privacidad y estándares de seguridad.

Negativo: Agrega sobrecarga de procesamiento y complejidad en la gestión de permisos, lo que puede complicar el mantenimiento si no se diseña adecuadamente.
