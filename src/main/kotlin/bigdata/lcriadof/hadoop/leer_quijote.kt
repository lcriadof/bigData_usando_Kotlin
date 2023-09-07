package bigdata.lcriadof.hadoop

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    // Configura la configuración de Hadoop
    val conf = Configuration()
    // Ajusta la URL del NameNode de Hadoop
    conf.set("fs.defaultFS", "hdfs://localhost:9000") // Cambia esto según la configuración de tu clúster Hadoop

    // Crea una instancia del sistema de archivos HDFS
    val fs = FileSystem.get(conf)

    // Ruta del archivo en HDFS que deseas leer
    val filePath = "/pruebas/quijote-es.txt"

    try {
        // Abre el archivo desde HDFS
        val inputStream = fs.open(Path(filePath))
        val reader = BufferedReader(InputStreamReader(inputStream))

        // Lee y muestra el contenido del archivo por la consola
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            println(line)
        }

        // Cierra el archivo y el sistema de archivos HDFS
        reader.close()
        fs.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
