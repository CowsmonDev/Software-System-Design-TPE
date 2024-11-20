# **Requerimientos Funcionales por Microservicios**



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


---


# **Atributos de Calidad**

## Brownfield y Migración a Microservicios

### Atributos de Calidad

1. **Compatibilidad**
   - El sistema nuevo debe integrarse sin problemas con el sistema monolítico actual, permitiendo que ambos operen en paralelo sin interrumpir las operaciones.
   - Se debe garantizar que los datos y servicios se puedan intercambiar entre el sistema monolítico y los nuevos microservicios.

2. **Escalabilidad Incremental**
   - La arquitectura debe permitir escalar de manera progresiva, permitiendo que los microservicios críticos se expandan en capacidad sin necesidad de escalar el sistema monolítico completo.
   - La selección brownfield permite escalar cada componente migrado independientemente, optimizando recursos y evitando gastos innecesarios en la infraestructura monolítica.

3. **Disponibilidad**
   - El sistema debe ser capaz de seguir funcionando sin interrupciones durante el proceso de migración, ya que una selección brownfield suele ejecutarse en paralelo al sistema en producción.
   - Es crucial establecer redundancia y tolerancia a fallos en los microservicios que se añaden, para asegurar que el sistema general siga operativo aún si ocurren problemas en las fases iniciales de migración.

4. **Mantenibilidad**
   - La nueva arquitectura debe simplificar la implementación de mejoras y actualizaciones sin alterar el sistema original, permitiendo cambios en los microservicios sin impacto en el monolito.
   - Deben implementarse prácticas de documentación y pruebas para asegurar que los desarrolladores puedan entender y modificar el sistema de manera incremental.

5. **Flexibilidad**
   - Un proyecto brownfield permite ir adoptando tecnologías, lenguajes de programación y plataformas nuevas en cada microservicio sin cambiar todo el sistema a la vez.
   - La arquitectura debe ser flexible, permitiendo modificaciones y adaptaciones en componentes específicos a medida que se comprueba su rendimiento en el entorno de producción.

6. **Eficiencia de Costos**
   - Un enfoque brownfield permite reducir costos iniciales de infraestructura al no requerir reemplazos completos, y priorizar mejoras donde se necesiten, lo cual ayuda a maximizar la relación costo-beneficio.
   - La inversión se realiza de forma incremental y controlada, permitiendo evaluar el retorno de inversión en cada fase de migración.




### Microservicios de Clientes y de Pagos


**Atributos de Calidad:**
1. **Seguridad**
   - Clientes : Dado que el acceso a datos personales es sensible, es clave asegurar la autenticación y autorización, encriptación de datos en tránsito y en reposo, y cumplir con normativas como GDPR (General Data Protection Reg.
   - Pagos : La integración con la pasarela de pagos de MercadoLibre debe incluir encriptación de datos y seguir protocolos de seguridad como PCI-DSS para proteger la información de pago.

2. **Disponibilidad**
   - Ambos servicios deben estar disponibles en todo momento, especialmente el de Pagos dado su impacto directo en las ventas y transacciones. Un tiempo de inactividad mínimo es esencial para la experiencia del usuario.

3. **Escalabilidad**
   - Dado el potencial crecimiento de usuarios y transacciones, ambos servicios deben escalar en respuesta al aumento de usuarios o volumen de transacciones, sin degradar el rendimiento.






### Microservicio de Pedidos



**Atributos de Calidad:**
1. **Disponibilidad**
   - El sistema debe estar disponible en todo momento para permitir a los clientes realizar pedidos desde interfaces de PC y móvil  y consultar el estado de sus pedidos en tiempo real , incluso en momentos de alta demanda.

2. **Escalabilidad**
   - La capacidad del sistema para gestionar un gran volumen de pedidos simultáneos debe escalar en función del crecimiento de usuarios, soportando múltiples solicitudes sin degradar el rendimiento ni exceder el límite de intentos de pedido.

3. **Seguridad**
   - El servicio debe garantizar la protección de los datos personales y de pedidos en cada transacción, asegurando la autenticación y encriptación adecuadas en accesos desde PC y dispositivos móviles.

4. **Rendimiento**
   - Para cumplir con la expectativa de respuesta en tiempo real al consultar el estado de pedidos, el sistema debe proporcionar tiempos de respuesta rápidos en cada fase de procesamiento.
   

### Microservicio de Reparto y Rutas

**Atributos de Calidad:**
1. **Disponibilidad**
   - El sistema debe estar disponible continuamente para gestionar el reparto y visibilidad en tiempo real de la flota y permitir la actualización constante de la posición y estado de cada camión sin interrupciones.

2. **Escalabilidad**
   - La capacidad del sistema debe adaptarse al crecimiento en el número de camiones y rutas, gestionando eficazmente múltiples flotas y optimizando rutas sin impactar en el rendimiento.

3. **Rendimiento**
   - Los algoritmos de optimización de rutas deben ser eficientes en el cálculo y seleccionar el algoritmo adecuado en función de la demora del camión para maximizar la eficiencia y minimizar tiempos de entrega.





### Microservicio de Estadísticas


**Atributos de Calidad:**
1. **Disponibilidad**
   - El servicio debe estar disponible en todo momento para generar y visualizar informes de estado de pedidos, clientes y rutas, y para proporcionar a los gestores un tablero de control con información en tiempo real sobre el estado de las entregas, incluso en momentos de alta demanda.

2. **Escalabilidad**
   - Debe ser capaz de manejar grandes volúmenes de datos históricos y en tiempo real, generando informes de pedidos y rutas y realizando análisis de rendimiento de manera eficiente a medida que el volumen de datos crece.

3. **Exactitud**
   - Los informes de estado de pedidos y rutas deben ser precisos y reflejar el estado actual de los procesos, además de que los análisis de rendimiento deben proporcionar datos correctos para identificar áreas de mejora.

4. **Rendimiento**
   - El servicio debe proporcionar tiempos de respuesta rápidos al mostrar el tablero de control en tiempo real, incluso cuando se consultan grandes volúmenes de datos de pedidos y entregas simultáneamente.

### Microservicio de Incidencias

**Atributos de Calidad:**
1. **Disponibilidad**
   - El servicio debe estar disponible para permitir el reporte en tiempo real de incidencias y la notificación inmediata a los gestores sobre nuevas incidencias, permitiendo el seguimiento hasta su resolución.

2. **Escalabilidad**
   - El sistema debe ser capaz de escalar para gestionar un número creciente de incidencias reportadas y para manejar el volumen de notificaciones y seguimiento de múltiples incidencias simultáneamente.

3. **Rendimiento**
   - El tiempo de respuesta debe ser rápido, permitiendo reportar incidencias de manera inmediata y notificar a los gestores en tiempo real, asegurando que los incidentes sean atendidos sin demoras.

4. **Tolerancia a Fallos**
   - El sistema debe ser capaz de funcionar incluso en caso de fallos en la infraestructura, permitiendo seguir reportando incidencias y notificando a los gestores sin interrupciones.

5. **Seguridad**
   - Debe proteger la información sobre las incidencias, asegurando que solo los usuarios autorizados puedan reportarlas o recibir notificaciones.