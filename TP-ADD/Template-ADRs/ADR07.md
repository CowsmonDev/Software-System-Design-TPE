# Implementación de microservicios para Pagos

## Context and Problem Statement
Para el microservicio 'Pagos', se necesita gestionar pagos de clientes, y una pasarela de pagos con Mercado Libre




## Decision Outcome


Decisión: Adapter Pattern: Facilitar la integración con la pasarela de pagos de MercadoLibre.


**Justificación:**

* Pasarela de pago: El patrón Adapter abstrae las interacciones específicas con la pasarela de MercadoLibre, permitiendo que el microservicio de Pagos mantenga una interfaz genérica para procesar pagos.

* Flexibilidad: Si en el futuro se necesita cambiar la pasarela de pagos (o integrar múltiples pasarelas), el Adapter actúa como un intermediario, minimizando los cambios necesarios en el microservicio.

* Reducción de acoplamiento: La lógica de negocio del microservicio queda desacoplada de los detalles específicos de la API de MercadoLibre, lo que mejora la mantenibilidad del sistema.

* Pruebas más sencillas: El Adapter permite simular la pasarela en ambientes de desarrollo o pruebas, sin necesidad de realizar llamadas reales.


### **Consequences**


Positivo:

* Simplifica la integración con MercadoLibre y otras pasarelas futuras, reduciendo el acoplamiento y mejorando la flexibilidad del sistema.

* Mejora la mantenibilidad y facilita pruebas.

Negativo:

* Aumenta la carga inicial de desarrollo y mantenimiento.
* Depende de la disponibilidad y la estabilidad de la API externa.