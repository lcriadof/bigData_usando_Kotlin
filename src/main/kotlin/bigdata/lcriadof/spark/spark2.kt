package bigdata.lcriadof.spark
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

fun isSparkClusterAvailable(host: String, port: Int): Boolean {
    return try {
        java.net.Socket(host, port).use { socket ->
            socket.isConnected
        }
    } catch (e: Exception) {
        false
    }
}

fun main() {
    val sparkHost = "192.168.68.61"
    val sparkPort = 7077

    if (isSparkClusterAvailable(sparkHost, sparkPort)) {
        // Configuración para el clúster de Spark en Docker
        val sparkConf = SparkConf()
            .setMaster("spark://${sparkHost}:${sparkPort}")
            .setAppName("MyApp")

        // Crear la sesión de Spark
        val spark = SparkSession.builder()
            .config(sparkConf)
            .orCreate

        // Crear un DataFrame a partir de una lista
        val data = listOf(1, 2, 3, 4, 5)
        val df = spark.createDataFrame(data.map { it.toString() }, String::class.java).toDF("numbers")

        // Mostrar el contenido del DataFrame
        df.show()

        // Detener la sesión de Spark al finalizar
        spark.stop()
    } else {
        println("El clúster de Spark no está disponible. Asegúrate de levantarlo en Docker.")
    }
}
