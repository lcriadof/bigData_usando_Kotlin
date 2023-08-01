package bigdata.lcriadof.mongodb.local

// nos conectamos a mongoDB

import com.mongodb.ConnectionString
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.bson.Document
fun connectToMongoDB(): MongoClient {
  val connectionString = ConnectionString("mongodb://localhost:27117")
  return MongoClients.create(connectionString)
}



fun main(){
    val mongoClient = connectToMongoDB()
    val database = mongoClient.getDatabase("mydb") // Cambiar por el nombre de tu base de datos
    val collection: MongoCollection<Document> = database.getCollection("mycollection") // Cambiar por el nombre de tu colección

    val document = Document("name", "John Doe")
        .append("age", 30)
        .append("email", "john.doe@example.com")

    collection.insertOne(document)
}
