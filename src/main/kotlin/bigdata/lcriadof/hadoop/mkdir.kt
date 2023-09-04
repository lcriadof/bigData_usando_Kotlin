package bigdata.lcriadof.hadoop


// probando Hadoop 3.2.1 desde Kotlin
// programa ed2c13p2
/*
Ejemplo básico que utiliza la API de Hadoop
para añadir un directorio a HDFS

Hace algo como: hdfs dfs -mkdir /pruebas


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

    val dirPath = Path("/pruebas")
    if (!fs.exists(dirPath)) {
        fs.mkdirs(dirPath)
        println("Directorio creado en HDFS: $dirPath")
    } else {
        println("El directorio ya existe en HDFS: $dirPath")
    }

    fs.close()
}
