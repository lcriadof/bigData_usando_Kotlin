package bigdata.lcriadof.mongodb.local



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

    // conectamos a mongoDB
    val mongoClient = connectToMongoDB()

    // creamos BBDD, colección
    val database = mongoClient.getDatabase("tfmLCF")
    val collection: MongoCollection<Document> = database.getCollection("provincias")


      // creamos documento
    /*
    val document = Document("nombre", "Madrid")
        .append("poblacion", 6666747)
        .append("superficie_km2", 8027)
     */

    val document = Document("nombre", "Barcelona")
        .append("poblacion", 5664579)
        .append("superficie_km2", 7720)

    // insertamos documento en coleección
    collection.insertOne(document)
}
