# Plan de Migración a Microservicios

## Iteración 1: Brownfield y Migración a Microservicios

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

4. **Usabilidad y Facilidad de Gestión**
   - Clientes: La creación, modificación y eliminación de registros deben ser fáciles de realizar y de comprender, minimizando errores y asegurando la integridad de los datos.




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