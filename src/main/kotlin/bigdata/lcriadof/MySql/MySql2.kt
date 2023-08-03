package bigdata.lcriadof.MySql

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import bigdata.lcriadof.MySQL.Cities

// leemos datos de MySql
fun main() {

    Database.connect("jdbc:mysql://localhost:33060/test", driver = "com.mysql.cj.jdbc.Driver",
        user = "root", password = "secret")


    // leemos datos
    transaction {
        // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
        val citiesList = Cities.selectAll().toList()

        // Imprimir el contenido de la lista de ciudades
        println("Cities:")
        citiesList.forEach { city ->
            println("ID: ${city[Cities.id]}, Name: ${city[Cities.name]}")
        }
    }


}

