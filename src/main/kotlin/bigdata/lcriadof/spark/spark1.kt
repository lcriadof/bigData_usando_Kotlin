package bigdata.lcriadof.spark

import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.SparkConf

// El código se conectará al contenedor Docker de Spark y ejecutará la operación sencilla para sumar los elementos de la lista.

fun main() {
    // Configurar el SparkContext
    val sparkConf = SparkConf().setAppName("SimpleSparkApp").setMaster("spark://192.168.68.61:7077")
    val sc = JavaSparkContext(sparkConf)

    // Operación sencilla para probar la conexión con Spark
    val data = listOf(1, 2, 3, 4, 5)
    val rdd = sc.parallelize(data)
    val sum = rdd.reduce { a, b -> a + b }
    println("Suma: $sum")

    // Detener el SparkContext
    sc.stop()
}
