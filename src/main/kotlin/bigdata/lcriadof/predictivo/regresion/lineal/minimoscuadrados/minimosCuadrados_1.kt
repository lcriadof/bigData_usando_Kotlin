package bigdata.lcriadof.predictivo.regresion.lineal.minimoscuadrados

// Usando KOMA
//    https://github.com/kyonifer/koma/tree/master
//     documentación -> http://koma.kyonifer.com/

import koma.*
import koma.extensions.*
import koma.matrix.Matrix
import koma.matrix.ejml.EJMLMatrixFactory

fun main() {
    // Usar la fábrica de matrices de Ejml
    setDefaultMatrixFactory(EJMLMatrixFactory())

    // Generar el conjunto de datos con valores de entrada y salida que sigan una relación lineal
    val xTrain = ones(1000, 1) hstack randn(1000, 1)
    val yTrain = xTrain * mat[3, 10].T + randn(1000, 1)

    // Resolver el sistema de ecuaciones usando las ecuaciones normales: w = (X^T X)^-1 X^T y
    val w = (xTrain.T * xTrain).inv() * xTrain.T * yTrain

    // Mostrar los coeficientes estimados
    println(w)
}