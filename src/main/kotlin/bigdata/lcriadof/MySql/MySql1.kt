package bigdata.lcriadof.MySQL

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


fun main(args: Array<String>) {

    Database.connect("jdbc:mysql://localhost:33060/test", driver = "com.mysql.cj.jdbc.Driver",
        user = "root", password = "secret")

    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create (Cities)

        // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
        val stPeteId = Cities.insert {
            it[name] = "St. Petersburg"
        } get Cities.id

        // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
        println("Cities: ${Cities.selectAll()}")
    }
}

object Cities: IntIdTable() {
    val name = varchar("name", 50)
}
