package bigdata.lcriadof.predictivo.regresion.lineal.minimoscuadrados


import org.apache.commons.math3.stat.regression.SimpleRegression
import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.rows

fun main() {

    val x by columnOf(1.0, 3.0, 5.0)
    val y by columnOf(2.0, 3.0, 5.0)
    val df = dataFrameOf(x,y)

    // Crear un objeto de regresión simple
    val regression = SimpleRegression()

    // Añadir los datos (x, y) del DataFrame
    // Añadir los datos (x, y) del DataFrame
    df.rows().forEach {
        val x = it["x"] as Double
        val y = it["y"] as Double
        regression.addData(x, y)
    }


    // Obtener los parámetros del modelo
    val slope = regression.slope
    val intercept = regression.intercept

    // Imprimir los resultados
    println("La ecuación de la línea de regresión es: y = $slope x + $intercept")


    val rSquared = regression.rSquare
    println("Coeficiente de determinación (R-cuadrado): $rSquared")
    val stdError = regression.slopeStdErr
    println("Error estándar de la estimación: $stdError")


}