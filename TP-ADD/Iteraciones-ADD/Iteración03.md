# Iteración 3: Microservicios de Pedidos y de Reparto y rutas

## Pedidos
- **RF-01**: Permitir a los clientes realizar pedidos de productos.
- **RF-02**: Limitar los intentos de pedido de un cliente a un máximo de 3.
- **RF-03**: Implementar una cadena de procesamiento de pedidos en tres fases.
- **RF-04**: Permitir a los usuarios consultar el estado de sus pedidos en tiempo real.

## Reparto y rutas
- **RF-05**: Gestionar el reparto de flotas de transporte de manera eficiente.
- **RF-06**: Optimizar las rutas mediante algoritmos según la demora del camión.
- **RF-07**: Permitir la actualización en tiempo real de la posición y estado de cada camión.

## Atributos de calidad

### Microservicio de Pedidos
1. **Disponibilidad**: El sistema debe estar disponible en todo momento para pedidos y consultas en tiempo real.
2. **Escalabilidad**: Gestionar un gran volumen de pedidos simultáneos.
3. **Seguridad**: Proteger datos personales y de pedidos.
4. **Rendimiento**: Respuesta rápida al consultar el estado de pedidos.

### Microservicio de Reparto y Rutas
1. **Disponibilidad**: Gestión continua del reparto y visibilidad en tiempo real.
2. **Escalabilidad**: Adaptarse al crecimiento de flotas y rutas.
3. **Rendimiento**: Eficiencia en los algoritmos de optimización de rutas.

## Restricciones
- Las rutas deben construirse con los pedidos pendientes, sin reutilización de rutas.


## Decisiones tomadas

* [ADR08](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR08.md)
* [ADR09](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR09.md)


# Pedidos
![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/pedidos_pipeline.jpg)

# Reparto y Rutas
![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/repartos_rutas_pipeline.jpg)


