package bigdata.lcriadof.mongodb.local

import com.mongodb.ConnectionString
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.Document

// Ejemplo de leer datos de MongoDb (instancia local)
fun main() {
    // conectamos a mongoDB
    val mongoClient = connectToMongoDB()

    // accedemos a la colección
    val database = mongoClient.getDatabase("tfmLCF")
    val collection: MongoCollection<Document> = database.getCollection("provincias")


    // leemos los datos de la colección
    val cursor = collection.find()

    // iteramos sobre el cursor para obtener los documentos
    cursor.iterator().forEach {
        println("Nombre: ${it["nombre"]}, Poblacion: ${it["poblacion"]}, Superficie (en Km cuaadrados): ${it["superficie_km2"]}")
    }

    // No es necesario cerrar el cursor, se cierra automáticamente cuando termina la iteración

    // cerramos el cliente de MongoDB y liberamos recursos
    mongoClient.close()
}
