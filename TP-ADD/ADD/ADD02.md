
# Iteración 2: Microservicios de Clientes y Pagos

## Clientes
- **RF-01**: Permitir acceso seguro a los datos personales de clientes.
- **RF-02**: Facilitar la creación, modificación y eliminación de registros de clientes.
- **RF-03**: Gestionar un historial de actividad para cada cliente.

## Pagos
- **RF-5**: Integrar con la pasarela de pagos de MercadoLibre para procesar pagos de manera segura.
- **RF-6**: Gestionar estados de pago (pendiente, completado, rechazado) y asociarlos a los pedidos correspondientes.
- **RF-7**: Notificar al cliente sobre el resultado de su pago y permitir la consulta del estado de transacciones.

## Atributos de calidad

### 1. Seguridad
- **Clientes (RF-01)**: Asegurar autenticación y autorización, encriptación de datos en tránsito y en reposo, cumpliendo normativas como GDPR (General Data Protection Regulation).
- **Pagos (RF-5, RF-6)**: Integrar con la pasarela de pagos cumpliendo protocolos de seguridad como PCI-DSS.

### 2. Disponibilidad
- Ambos servicios deben estar disponibles en todo momento, especialmente el de Pagos.

### 3. Escalabilidad
- Escalar en respuesta al aumento de usuarios o volumen de transacciones.

### 4. Usabilidad y Facilidad de Gestión
- La creación, modificación y eliminación de registros deben ser fáciles de realizar.

## Restricciones
- Ambos microservicios comparten la base de datos.

