# System Architecture Document (SAD)

## 1. Introducción

### 1.1 Propósito del documento

El propósito de este documento es detallar la arquitectura del sistema migrado de monolítico a microservicios para una compañía de productos alimenticios. Esta migración busca mejorar la escalabilidad, flexibilidad y resiliencia del sistema, garantizando la continuidad del servicio durante el proceso.

### 1.2 Alcance

La migración abarca los servicios principales relacionados con clientes, pagos, pedidos, reparto y rutas, estadísticas e incidencias.

## 2. Descripción General de la Arquitectura

El Sistema cuenta con microservicios producidos con Spring Boot y contenerizados en Docker. El sistema cuenta con una API Gateway de Kong que se integra bien con Docker. Esta API Gateway comunica los clientes de PC o móvil con el sistema. Además, cuenta con una pasarela de pago con Mercado Libre.

## 3. Decisiones Arquitectónicas

### 3.1 Microservicio Clientes

Se ha decidido utilizar Event Sourcing junto con una táctica de validación y filtrado de datos. El uso de Event Sourcing es fundamental para mantener un historial completo de todos los cambios realizados en los datos de los clientes, lo que permite reconstruir el estado de un cliente en cualquier momento. Esto proporciona una trazabilidad completa, lo cual es esencial para auditorías y análisis de transacciones. Además, al registrar cada cambio como un evento, el sistema es más resiliente ante fallos.

Por otro lado, la táctica de validación y filtrado de datos se implementa para garantizar que los datos personales de los clientes solo sean accesibles por usuarios autorizados. Este enfoque mejora la seguridad del sistema y asegura el cumplimiento con normativas de privacidad, como el GDPR (General Data Protection Regulation). La validación centralizada también facilita el control y la auditoría de los permisos de acceso.

### 3.2 Microservicio Pagos

En cuanto al microservicio de pagos, la decisión tomada es utilizar Event Sourcing y el Adapter Pattern. Event Sourcing en este caso permite gestionar los estados de pago como eventos, lo que facilita el seguimiento detallado de cada transición de estado del pago (pendiente, completado, rechazado). Esto es crucial para mantener una trazabilidad completa de las transacciones y facilita auditorías y el análisis de pagos fallidos o exitosos.

El Adapter Pattern se ha implementado para facilitar la integración con la pasarela de pagos de MercadoLibre. Este patrón ayuda a mantener una interfaz genérica para procesar pagos, lo que ofrece flexibilidad en caso de que en el futuro sea necesario cambiar o integrar múltiples pasarelas de pago. Este enfoque también minimiza el acoplamiento entre la lógica de negocio del microservicio y la API específica de MercadoLibre, mejorando la mantenibilidad y simplificando las pruebas en ambientes de desarrollo.

### 3.3 Microservicio Pedidos

Para el microservicio de pedidos, se ha optado por un pipeline asíncrono para procesar los pedidos. Este enfoque desacopla las fases del procesamiento de pedidos, mejorando la escalabilidad y la tolerancia a fallos. Al utilizar un pipeline asíncrono, los pedidos se procesan en distintas fases que se comunican mediante colas o eventos, lo que permite gestionar de manera eficiente los picos de demanda y garantizar la continuidad del servicio.

Este enfoque facilita la integración con otros microservicios, como los de reparto y optimización de rutas, pero incrementa la complejidad técnica debido a la necesidad de manejar eventos y colas.

### 3.4 Microservicio Reparto y Rutas

En el microservicio de reparto y rutas, se ha elegido un algoritmo dinámico por demanda para optimizar las rutas de reparto en tiempo real. Este algoritmo ajusta las rutas en función de datos como el estado del tráfico, la ubicación de los vehículos y la cantidad de pedidos, lo que mejora la eficiencia y reduce los tiempos de entrega.

El uso de un algoritmo dinámico permite maximizar la utilización de los recursos disponibles y se adapta a cambios en las condiciones en tiempo real, garantizando que las rutas sean las más eficientes posibles en cada momento.

### 3.5 Microservicios de Estadísticas e Incidencias

Para los microservicios de estadísticas e incidencias, la decisión tomada es utilizar una Aggregation Layer junto con el patrón Database per Service. La Aggregation Layer centraliza la lógica de cómo se combinan y presentan los datos de diferentes fuentes (como pedidos, clientes y rutas), optimizando las consultas y mejorando el rendimiento de los informes. Este enfoque simplifica la lógica de acceso a los datos y permite a los microservicios trabajar con datos ya preparados y optimizados.

Por otro lado, el uso del patrón Database per Service implica que cada microservicio tendrá su propia base de datos, lo que les permite optimizar sus consultas y estructuras sin depender de otros servicios. Esto mejora la flexibilidad y el rendimiento.

## 4. Futuros Cambios

El nuevo sistema basado en microservicios va a poder implementar mejor nuevos servicios del sistema, como la escalabilidad individual de cada servicio, ahorrando tener que mejorar todo el sistema si el problema de rendimiento está en un único microservicio.

## Conclusión

En conclusión, la migración a una arquitectura basada en microservicios ha transformado el sistema en una solución modular, escalable y resiliente. Cada servicio ahora opera de manera autónoma, optimizando su desempeño y simplificando la implementación de nuevas funcionalidades. Además, se ha fortalecido la capacidad del sistema para adaptarse a cambios en el negocio, soportar mayores volúmenes de carga y mantener una alta disponibilidad. Aunque esta arquitectura introduce una mayor complejidad operativa, las ventajas en términos de flexibilidad, mantenimiento y alineación con los objetivos estratégicos garantizan que el sistema esté preparado para enfrentar los retos y oportunidades futuras de manera efectiva.




![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/add-generic-view.jpg)