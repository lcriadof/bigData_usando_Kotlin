package bigdata.lcriadof.mongodb.local

// nos conectamos a mongoDB

/*
import com.mongodb.ConnectionString
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient

fun connectToMongoDB(): MongoClient {
    val connectionString = ConnectionString("mongodb://192.168.68.61:27117")

    // Verificar la conexión y obtener información adicional
    val databases = mongoClient.listDatabases()
    for (databaseDocument in databases) {
        println("Nombre de la base de datos: ${databaseDocument.getString("name")}")
    }
    return MongoClients.create(connectionString)
}

val mongoClient = connectToMongoDB()

 */