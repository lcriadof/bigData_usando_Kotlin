package bigdata.lcriadof.hadoop
/*
Hace algo como:hdfs dfs -rm -r hdfs:/pruebas

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

    if (fs.exists(dirPath)) { // Verificar si el directorio existe
        // Si existe, eliminarlo
        fs.delete(dirPath, true)
        println("Directorio eliminado en HDFS: $dirPath")
    } else {
        println("El directorio no existe en HDFS: $dirPath")
    }

    fs.close()
}