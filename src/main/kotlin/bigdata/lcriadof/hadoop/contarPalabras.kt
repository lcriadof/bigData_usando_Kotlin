package bigdata.lcriadof.hadoop

// probando Hadoop 2.8.5 desde Kotlin
// programa ed2c13p2
/*
Ejemplo básico que utiliza la API de Hadoop para leer un archivo de texto y
contar el número de palabras.

Este código utiliza la clase FileSystem de Hadoop para conectarse a HDFS y leer el archivo de texto,
 y luego procesa el contenido del archivo con código Kotlin estándar para contar el número de palabras.

Este ejemplo no usa MapReduce

 */

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

fun main(args: Array<String>) {

    val conf = Configuration()
    val hdfs = FileSystem.get(conf)

    // Ruta del archivo de entrada
    val inputPath = Path("C:/tmp/kotlin/f6.txt")




    // Ruta del directorio de salida
    val outputPath = Path("output")

    // Comprobar si el archivo de entrada existe
    if (!hdfs.exists(inputPath)) {
        println("El archivo de entrada no existe")
        return
    }

    // Eliminar el directorio de salida si ya existe
    if (hdfs.exists(outputPath)) {
        hdfs.delete(outputPath, true)
    }

    // Crear un stream de entrada para leer el archivo
    val inputStream = hdfs.open(inputPath)

    // Leer el contenido del archivo
    val inputContent = inputStream.bufferedReader().use { it.readText() }

    // Contar las palabras del archivo
    val wordCount = inputContent.split("\\W+".toRegex()).filter { it.isNotEmpty() }.groupingBy { it }.eachCount()

    // Mostrar el resultado por consola
    wordCount.forEach { (word, count) ->
        println("$word: $count")
    }

    // Crear un stream de salida para escribir los resultados
    val outputStream = hdfs.create(Path(outputPath, "result.txt"))

    // Escribir los resultados en el stream de salida
    wordCount.forEach { (word, count) ->
        outputStream.write("$word: $count\n".toByteArray())
    }

    // Cerrar los streams
    inputStream.close()
    outputStream.close()
    hdfs.close()
}
