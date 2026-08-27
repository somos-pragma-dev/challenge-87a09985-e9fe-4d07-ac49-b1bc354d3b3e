# Evaluación del Ciclo de Vida de Estado en el Pipeline de Pruebas

En un entorno de banca digital, el sistema de pruebas debe registrar y monitorear el estado de las pruebas desde su inicio hasta su finalización. Los actores involucrados son el generador de pruebas, el ejecutor de pruebas y el recolector de resultados. Las pruebas pueden tener estados como 'pendiente', 'en ejecución', 'completada' y 'fallida'. El sistema debe garantizar la consistencia del estado de las pruebas entre el generador y el recolector, con un umbral de latencia de 5 segundos para la actualización del estado. El modo de falla específico es la pérdida de conexión durante la actualización del estado.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Status Progression Test |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Registro de Estado Inicial

**Objetivo:** Crear un registro de estado para cada prueba generada.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Identificar los estados posibles de una prueba.
- Definir cómo se registra el estado inicial de una prueba.
- Establecer criterios de aceptación para el registro del estado inicial.

**Entregable:** Registro de estado inicial para cada prueba.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo se comunican los actores en el dominio.
- Piensa en la consistencia del estado entre diferentes componentes.

</details>

### Fase 2: Actualización del Estado Durante la Ejecución

**Objetivo:** Actualizar el estado de las pruebas durante su ejecución.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Definir cómo se actualiza el estado de una prueba durante su ejecución.
- Establecer criterios de aceptación para la actualización del estado.
- Considerar el modo de falla de pérdida de conexión durante la actualización.

**Entregable:** Mecanismo para actualizar el estado de las pruebas durante su ejecución.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo manejar la latencia en la actualización del estado.
- Considera el impacto de la pérdida de conexión en la actualización del estado.

</details>

### Fase 3: Finalización y Reporte del Estado

**Objetivo:** Finalizar el estado de las pruebas y generar un reporte.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Definir cómo se finaliza el estado de una prueba.
- Establecer criterios de aceptación para la finalización del estado.
- Generar un reporte con los estados finales de las pruebas.

**Entregable:** Reporte con los estados finales de las pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo se comunican los resultados al recolector de resultados.
- Piensa en la presentación del reporte para que sea comprensible y útil.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Cuáles son los estados posibles de una prueba y cómo se registran?
- **paraQueSirve**: ¿Por qué es importante registrar y actualizar el estado de las pruebas?
- **comoSeUsa**: ¿Cómo se actualiza el estado de una prueba durante su ejecución?
- **erroresComunes**: ¿Cuáles son los errores comunes al actualizar el estado de una prueba y cómo se mitigan?
- **queDecisionesImplica**: ¿Qué decisiones tomaste para garantizar la consistencia del estado de las pruebas?

## Criterios de Evaluacion

- Registro de estado inicial para cada prueba.
- Mecanismo para actualizar el estado de las pruebas durante su ejecución.
- Reporte con los estados finales de las pruebas.
- Mitigación de errores comunes en la actualización del estado.
- Justificación de las decisiones tomadas para garantizar la consistencia del estado.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
