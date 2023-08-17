package bigdata.lcriadof.predictivo.regresion.lineal.minimoscuadrados

// Usando  Smile (Statistical Machine Intelligence and Learning Engine)
import smile.data.DataFrame
import smile.data.formula.Formula
import smile.regression.ridge


fun main(){

    // Create some data.
    var data = Array<DoubleArray>(13){doubleArrayOf(0.0)}
    data[0] = doubleArrayOf(57.3142861,45.0,14.0,164900.0,116910.0,48.7392861,133.930123 )
    data[1] = doubleArrayOf(23.0073691,43.0,12.0,138633.333,116910.0,30.9357145,138.55321)
    data[2] = doubleArrayOf(43.8676314,66.0,21.0,151266.667,120633.333,57.3142861,139.144051)
    data[3] = doubleArrayOf(20.0705358,47.0,10.0,128500.0,120633.333,23.0073691,123.355951)
    data[4] = doubleArrayOf(27.6794644,40.0,9.0,148766.667,122181.667,43.8676314,122.667478)
    data[5] = doubleArrayOf(27.4578573,146.0,66.0,138566.667,126548.333,20.0705358,109.957522)
    data[6] = doubleArrayOf(15.9874061,118.0,71.0,134733.333,128621.667,27.4578573,83.9544647)
    data[7] = doubleArrayOf(14.8142858,138.0,63.0,127533.333,137826.333,15.9874061,43.041923)
    data[8] = doubleArrayOf(15.6678573,150.0,86.0,109466.667,141869.667,14.8142858,35.7447188)
    data[9] = doubleArrayOf(14.3601192,128.0,72.0,96800.0,141120.333,15.6678573,37.8162068)
    data[10] = doubleArrayOf(14.2407408,145.0,81.0,97166.6667,144084.333,14.3601192,45.3637191)
    data[11] = doubleArrayOf(13.6261905,134.0,70.0,98900.0,141082.333,14.2407408,39.4444231)
    data[12] = doubleArrayOf(14.1465714,135.0,72.0,112233.333,127618.0,13.6261905,30.6519913)
    val features = arrayOf("x1","x2","x3","x4","x5","x6")

    // Convert the data into a SMILE DataFrame
    val df = DataFrame.of(data, "y", *features) // The first column is the target value (y), and the other columns are the features.

    // Make a formula
    val frm = Formula.of("y", *features)

    // Regression
    val lm = ridge(frm, df, lambda=1.0)

    // Print some results
    println( "\nIntercept: ${"%.2e".format(lm.intercept())}" )
    println( "Coefficients:" )
    for ( ix in 0 until features.size ){
        println( "\t${features[ix]}: ${"%.2e".format(lm.coefficients()[ix])}")
    }

    // Make predictions
    val predictions = lm.predict(df)
    println("\nActual\tPredicted")
    for ( ix in 0 until data.size ){
        println("${"%.2f".format(data[ix][0])}\t${"%.2f".format(predictions[ix])}")
    }
}