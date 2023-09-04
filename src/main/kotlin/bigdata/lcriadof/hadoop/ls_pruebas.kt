package bigdata.lcriadof.hadoop

// probando Hadoop 3.2.1 desde Kotlin
// programa ed2c13p1
/*
Ejemplo básico que utiliza la API de Hadoop
para listar el contenido del directorio raíz de HDFS

Hace algo como:  hdfs dfs -ls /
Para ver directorios y archivos

IMPORTANTE este código es solo para Hadoop 3.2.1

Teniendo el sistema de docker  y docker compose instalados
Nos situamos en el directorio .\hadoop3_clouster
Y ejecutar en clúster: docker-compose up

 */

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

fun main() {
    val conf = Configuration()
    conf.set("fs.defaultFS", "hdfs://localhost:9000")
    val fs = FileSystem.get(conf)

    val path = Path("/pruebas") // Cambiar la ruta al directorio "pruebas"
    val files = fs.listStatus(path)

    println("Directorio $path:")

    files.forEach {
        val isDirectory = it.isDirectory
        val itemType = if (isDirectory) "Directorio" else "Archivo"
        val itemName = it.path.getName() // Obtener el nombre del archivo o directorio
        println("    ->  $itemType : $itemName")
    }
    fs.close()
}





