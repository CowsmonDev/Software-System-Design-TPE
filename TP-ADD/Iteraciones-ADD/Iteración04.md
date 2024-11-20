# Iteración 4: Microservicios de Estadísticas e Incidencias

## Estadísticas
- **RF-01**: Generar y visualizar informes de estado de pedidos, clientes y rutas.
- **RF-02**: Proporcionar un tablero de control con información en tiempo real.
- **RF-03**: Realizar análisis de rendimiento de pedidos y rutas.

## Incidencias
- **RF-04**: Permitir el reporte de incidencias en tiempo real.
- **RF-05**: Notificar a los gestores sobre incidencias y permitir su seguimiento.
- **RF-06**: Generar reportes automáticos de incidencias frecuentes.

## Atributos de calidad

### Microservicio de Estadísticas
1. **Disponibilidad**: Generar y visualizar informes en todo momento.
2. **Escalabilidad**: Manejar grandes volúmenes de datos históricos y en tiempo real.
3. **Exactitud**: Informes precisos y análisis correctos.
4. **Rendimiento**: Respuesta rápida en el tablero de control.

### Microservicio de Incidencias
1. **Disponibilidad**: Reporte y notificación en tiempo real.
2. **Escalabilidad**: Gestionar un número creciente de incidencias.
3. **Rendimiento**: Tiempo de respuesta rápido para reportes y notificaciones.
4. **Tolerancia a Fallos**: Continuar operando ante fallos.
5. **Seguridad**: Proteger información de incidencias.




## Decisiones tomadas

* [ADR10](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR10.md)
* [ADR11](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR11.md)
* [ADR12](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR12.md)
* [ADR13](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR13.md)


# Estadísticas
![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/estadisticas_agregation_layer.jpg)


# Incidencias
![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/incidencias_agregation_layer.jpg)


