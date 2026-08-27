# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
package com.pragma.statusprogressiontest.domain.model;

public enum TestStatus {
    PENDING,
    RUNNING,
    COMPLETED,
    FAILED
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/application/port/out/TestStatusRepository.java ===
package com.pragma.statusprogressiontest.application.port.out;

import com.pragma.statusprogressiontest.domain.model.TestStatus;

public interface TestStatusRepository {
    void saveStatus(String testId, TestStatus status);
    TestStatus getStatus(String testId);
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/application/service/TestStatusService.java ===
package com.pragma.statusprogressiontest.application.service;

import com.pragma.statusprogressiontest.application.port.out.TestStatusRepository;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.stereotype.Service;

@Service
public class TestStatusService {
    private final TestStatusRepository testStatusRepository;

    public TestStatusService(TestStatusRepository testStatusRepository) {
        this.testStatusRepository = testStatusRepository;
    }

    public void saveStatus(String testId, TestStatus status) {
        testStatusRepository.saveStatus(testId, status);
    }

    public TestStatus getStatus(String testId) {
        return testStatusRepository.getStatus(testId);
    }
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/infrastructure/adapter/out/TestStatusRepositoryImpl.java ===
package com.pragma.statusprogressiontest.infrastructure.adapter.out;

import com.pragma.statusprogressiontest.application.port.out.TestStatusRepository;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TestStatusRepositoryImpl implements TestStatusRepository {
    private final ConcurrentHashMap<String, TestStatus> statusMap = new ConcurrentHashMap<>();

    @Override
    public void saveStatus(String testId, TestStatus status) {
        statusMap.put(testId, status);
    }

    @Override
    public TestStatus getStatus(String testId) {
        return statusMap.get(testId);
    }
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/infrastructure/adapter/in/TestStatusController.java ===
package com.pragma.statusprogressiontest.infrastructure.adapter.in;

import com.pragma.statusprogressiontest.application.service.TestStatusService;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-status")
public class TestStatusController {
    private final TestStatusService testStatusService;

    @Autowired
    public TestStatusController(TestStatusService testStatusService) {
        this.testStatusService = testStatusService;
    }

    @PostMapping("/save")
    public void saveStatus(@RequestParam String testId, @RequestParam TestStatus status) {
        testStatusService.saveStatus(testId, status);
    }

    @GetMapping("/get/{testId}")
    public TestStatus getStatus(@PathVariable String testId) {
        return testStatusService.getStatus(testId);
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
server.port=8080

// === ARCHIVO: src/test/java/com/pragma/statusprogressiontest/TestStatusServiceTest.java ===
package com.pragma.statusprogressiontest;

import com.pragma.statusprogressiontest.application.service.TestStatusService;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import com.pragma.statusprogressiontest.infrastructure.adapter.out.TestStatusRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestStatusServiceTest {

    @Autowired
    private TestStatusService testStatusService;

    @BeforeEach
    void setUp() {
        // Ensure the repository is clear before each test
        TestStatusRepositoryImpl repository = new TestStatusRepositoryImpl();
        testStatusService = new TestStatusService(repository);
    }

    @Test
    void testSaveAndGetStatus() {
        String testId = "test1";
        TestStatus status = TestStatus.RUNNING;
        testStatusService.saveStatus(testId, status);
        Assertions.assertEquals(status, testStatusService.getStatus(testId));
    }

    @Test
    void testGetStatusNotFound() {
        String testId = "nonexistent";
        Assertions.assertNull(testStatusService.getStatus(testId));
    }

    @Test
    void testUpdateStatus() {
        String testId = "test2";
        TestStatus initialStatus = TestStatus.PENDING;
        TestStatus updatedStatus = TestStatus.COMPLETED;
        testStatusService.saveStatus(testId, initialStatus);
        testStatusService.saveStatus(testId, updatedStatus);
        Assertions.assertEquals(updatedStatus, testStatusService.getStatus(testId));
    }
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/StatusProgressionTestApplication.java ===
package com.pragma.statusprogressiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatusProgressionTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatusProgressionTestApplication.class, args);
    }
}

// === ARCHIVO: src/main/java/com/pragma/statusprogressiontest/pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>status-progression-test</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>Status Progression Test</name>
    <description>Demo project for Status Progression Test</description>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <properties>
        <java.version>21</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
