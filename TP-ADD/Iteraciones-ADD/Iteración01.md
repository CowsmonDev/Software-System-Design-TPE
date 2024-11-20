
# Iteración 1: Brownfield y Migración a Microservicios


## Enfoque Brownfield

Se planea hacer una migración tipo Brownfield, manteniendo la página en funcionamiento a medida que se hace una migración progresiva de los servicios del monolito a microservicios. 

Se utilizará una **fachada o API Gateway**, que ayuda a abstraer el monolito y a que cualquier sistema, aplicación, o componente que consume los servicios de tu monolito actual no tengan que cambiar sus puntos de conexión. La fachada maneja las solicitudes y las distribuye entre el monolito y los nuevos microservicios, permitiéndote migrar funcionalidades sin interrumpir a los clientes.


## Atributos de Calidad

### 1. Compatibilidad
- El sistema nuevo debe integrarse sin problemas con el sistema monolítico actual, permitiendo que ambos operen en paralelo sin interrumpir las operaciones.
- Se debe garantizar que los datos y servicios se puedan intercambiar entre el sistema monolítico y los nuevos microservicios.

### 2. Escalabilidad Incremental
- La arquitectura debe permitir escalar de manera progresiva, permitiendo que los microservicios críticos se expandan en capacidad sin necesidad de escalar el sistema monolítico completo.
- La selección brownfield permite escalar cada componente migrado independientemente, optimizando recursos y evitando gastos innecesarios en la infraestructura monolítica.

### 3. Disponibilidad
- El sistema debe ser capaz de seguir funcionando sin interrupciones durante el proceso de migración, ya que una selección brownfield suele ejecutarse en paralelo al sistema en producción.
- Es crucial establecer redundancia y tolerancia a fallos en los microservicios que se añaden, para asegurar que el sistema general siga operativo aún si ocurren problemas en las fases iniciales de migración.

### 4. Mantenibilidad
- La nueva arquitectura debe simplificar la implementación de mejoras y actualizaciones sin alterar el sistema original, permitiendo cambios en los microservicios sin impacto en el monolito.
- Deben implementarse prácticas de documentación y pruebas para asegurar que los desarrolladores puedan entender y modificar el sistema de manera incremental.

### 5. Flexibilidad
- Un proyecto brownfield permite ir adoptando tecnologías, lenguajes de programación y plataformas nuevas en cada microservicio sin cambiar todo el sistema a la vez.
- La arquitectura debe ser flexible, permitiendo modificaciones y adaptaciones en componentes específicos a medida que se comprueba su rendimiento en el entorno de producción.

### 6. Eficiencia de Costos
- Un enfoque brownfield permite reducir costos iniciales de infraestructura al no requerir reemplazos completos, y priorizar mejoras donde se necesiten, lo cual ayuda a maximizar la relación costo-beneficio.
- La inversión se realiza de forma incremental y controlada, permitiendo evaluar el retorno de inversión en cada fase de migración.



## Requerimientos Funcionales de la Migración

### 1. Compatibilidad con el Sistema Existente
- **RF-01:** El sistema debe proporcionar una interfaz de integración para comunicarse con el sistema monolítico existente durante el proceso de migración.
- **RF-02:** Cada microservicio debe ser capaz de funcionar en paralelo con el sistema monolítico para facilitar pruebas y migración gradual de componentes.
- **RF-03:** Implementar un sistema de versionado en las APIs REST para que tanto clientes como servicios internos puedan gestionar cambios de manera controlada.

### 2. Migración Incremental de Datos
- **RF-04:** Crear servicios de migración de datos para replicar los datos de las bases de datos monolíticas (Clientes y Pedidos) en los nuevos microservicios, asegurando la consistencia de datos.
- **RF-05:** Mantener una sincronización bidireccional temporal entre el monolito y los microservicios, de forma que ambos puedan operar en paralelo sin pérdida de datos o inconsistencia.
- **RF-06:** Implementar mecanismos de auditoría para verificar la integridad y precisión de los datos migrados y sincronizados.

### 3. Microservicios
- **Clientes:** Gestiona datos personales y de contacto de clientes, acceso crítico.
- **Pedidos:** Controla pedidos de clientes con límites de intentos y procesamiento en tres fases.
- **Reparto y Rutas:** Asigna y optimiza rutas para la entrega de pedidos.
- **Incidencias:** Gestiona y reporta problemas en el reparto y rutas de entrega.
- **Pagos:** Procesa pagos a través de la pasarela de MercadoLibre.
- **Estadísticas:** Proporciona datos analíticos en tiempo real sobre pedidos y rutas.

## Restricciones
- **Compatibilidad con HTTP/REST:** El sistema debe implementar API REST para asegurar compatibilidad de acceso desde clientes PC y móviles.
- **Separación de Datos:** Los datos deben almacenarse en bases de datos separadas por servicio (Clientes y Pedidos).


## Decisiones tomadas

* [ADR01](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR01.md)
* [ADR02](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR02.md)
* [ADR03](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/Template-ADRs/ADR03.md)



![imagen](https://github.com/CowsmonDev/Software-System-Design-TPE/blob/main/TP-ADD/images/Microservicios%20ADD.jpg)


