package bigdata.lcriadof.MySQL

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Cities: IntIdTable() {
    val name = varchar("name", 50)
}

// escribimos datos en MySql
fun main() {
    Database.connect("jdbc:mysql://localhost:33060/test", driver = "com.mysql.cj.jdbc.Driver",
        user = "root", password = "secret")

    // insertamos datos
    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create (Cities)
        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val stPeteId = Cities.insert {
            //it[name] = "St. Petersburg"
            //it[name] = "Madrid"
            //it[name] = "Málaga"
            //it[name] = "Valencia"
            it[name] = "Almería"
        } get Cities.id
    }
}

