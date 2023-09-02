package bigdata.lcriadof.spark

/*


 */
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main() {
    val conf = SparkConf().setAppName("SimpleSparkApp").setMaster("local[*]")
    val sc = JavaSparkContext(conf)

    println("Versión de Spark: ${sc.version()}")

    sc.stop()
}

