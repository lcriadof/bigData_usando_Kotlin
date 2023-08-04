package bigdata.lcriadof.predictivo.regresion.lineal.minimoscuadrados

//import org.jetbrains.kotlinx.dataframe.io.readCSV
import org.apache.commons.math3.stat.regression.SimpleRegression




fun main() {
    // Leer los datos desde un archivo CSV
    //val df = DataFrame.readCSV("data.csv")

       // Crear un objeto de regresión simple
        val regression = SimpleRegression()
        // Añadir los datos (x, y)
        regression.addData(1.0, 2.0)
        regression.addData(3.0, 3.0)
        regression.addData(5.0, 5.0)
        // Obtener los parámetros del modelo
        val slope = regression.slope
        val intercept = regression.intercept
        // Imprimir los resultados
        println("La ecuación de la línea de regresión es: y = $slope x + $intercept")
  }