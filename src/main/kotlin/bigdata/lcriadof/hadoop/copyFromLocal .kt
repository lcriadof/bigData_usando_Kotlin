package bigdata.lcriadof.hadoop

// equivalente a algo así ->   hadoop fs -copyFromLocal f6.txt /pruebas

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.IOException
import java.net.URISyntaxException

fun main() {
    val fichero = "f6.txt"

    val localFilePath = "F:/datos/07 IDEA/bigData_usando_Kotlin/src/main/kotlin/bigdata/lcriadof/hadoop/"
    val hdfsFilePath = "hdfs://localhost:9000/pruebas/"

    val conf = Configuration()
    conf.set("fs.defaultFS", hdfsFilePath) // Configuración del sistema de archivos HDFS


    try {
        val fs = FileSystem.get(conf)
        fs.copyFromLocalFile(Path(localFilePath+fichero), Path(hdfsFilePath+fichero))
        fs.close()
        println("Archivo copiado a HDFS con éxito.")
    } catch (e: IOException) {
        e.printStackTrace()
        println("Error al copiar el archivo a HDFS: " + e.message)
    } catch (e: InterruptedException) {
        e.printStackTrace()
        println("La operación fue interrumpida: " + e.message)
    } catch (e: URISyntaxException) {
        e.printStackTrace()
        println("Error en la URI: " + e.message)
    }
}
