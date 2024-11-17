# Requerimientos Funcionales por Microservicios



## Clientes
- **RF-01**: Permitir acceso seguro a los datos personales de clientes.
- **RF-02**: Facilitar la creación, modificación y eliminación de registros de clientes.
- **RF-03**: Gestionar un historial de actividad para cada cliente.

## Pedidos
- **RF-04**: Permitir a los clientes realizar pedidos de productos a través de interfaces PC y móvil.
- **RF-05**: Limitar los intentos de pedido de un cliente a un máximo de 3.
- **RF-06**: Implementar una cadena de procesamiento de pedidos en tres fases: preprocesado, autorización y aceptación.
- **RF-07**: Permitir a los usuarios consultar el estado de sus pedidos en tiempo real.

## Reparto y Rutas
- **RF-08**: Gestionar el reparto de flotas de transporte de manera eficiente, con visibilidad en tiempo real.
- **RF-09**: Optimizar las rutas de los camiones mediante dos algoritmos de optimización, seleccionados según la demora del camión.
- **RF-10**: Permitir la actualización en tiempo real de la posición y estado de cada camión.

## Estadísticas
- **RF-11**: Generar y visualizar informes de estado de pedidos, clientes y rutas de entrega.
- **RF-12**: Proporcionar a los gestores un tablero de control con información en tiempo real sobre el estado de las entregas.
- **RF-13**: Realizar análisis de rendimiento de pedidos y rutas para identificar áreas de mejora.

## Incidencias
- **RF-14**: Permitir el reporte de incidencias en tiempo real, como averías de camiones o problemas en el reparto.
- **RF-15**: Notificar a los gestores de rutas sobre nuevas incidencias y permitir el seguimiento de cada incidente hasta su resolución.
- **RF-16**: Generar reportes automáticos de incidencias frecuentes para análisis de mantenimiento.

## Pagos
- **RF-17**: Integrar con la pasarela de pagos de MercadoLibre para procesar pagos de manera segura.
- **RF-18**: Gestionar estados de pago (pendiente, completado, rechazado) y asociarlos a los pedidos correspondientes.
- **RF-19**: Notificar al cliente sobre el resultado de su pago y permitir la consulta del estado de transacciones.



---

# Requerimientos Funcionales de la Migración

## Compatibilidad con el Sistema Existente
- **RF-01**: El sistema debe proporcionar una interfaz de integración para comunicarse con el sistema monolítico existente durante el proceso de migración.
- **RF-02**: Cada microservicio debe ser capaz de funcionar en paralelo con el sistema monolítico para facilitar pruebas y migración gradual de componentes.
- **RF-03**: Implementar un sistema de versionado en las APIs REST para que tanto clientes como servicios internos puedan gestionar cambios de manera controlada.

## Migración Incremental de Datos
- **RF-04**: Crear servicios de migración de datos para replicar los datos de las bases de datos monolíticas (Clientes y Pedidos) en los nuevos microservicios, asegurando la consistencia de datos.
- **RF-05**: Mantener una sincronización bidireccional temporal entre el monolito y los microservicios, de forma que ambos puedan operar en paralelo sin pérdida de datos o inconsistencia.
- **RF-06**: Implementar mecanismos de auditoría para verificar la integridad y precisión de los datos migrados y sincronizados.
