package bigdata.lcriadof.MySQL

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


fun main(args: Array<String>) {

    Database.connect("jdbc:mysql://localhost:33060/test", driver = "com.mysql.cj.jdbc.Driver",
        user = "root", password = "secret")

    // insertamos datos
    /*
    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create (Cities)

        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val stPeteId = Cities.insert {
            //it[name] = "St. Petersburg"
            //it[name] = "Madrid"
            it[name] = "Málaga"
        } get Cities.id

    }

     */


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

object Cities: IntIdTable() {
    val name = varchar("name", 50)
}
