package com.example.mentoriabank.dao

import java.sql.Connection
import java.sql.DriverManager

class ConnectionFactory {

    companion object{
        private const val LOCAL_HOST = "localhost"
        private const val LOCAL_PORT = "3303"
        private const val DATABASE = "mentoria"
        private const val USER = "mentoria"
        private const val PASSWORD = "mentoria"

        fun create(host: String? = null, port: String? = null): Connection{
            val connectionString = "jdbc:mysql://${host?:LOCAL_HOST}:${port?: LOCAL_PORT}/$DATABASE?user=$USER&password=$PASSWORD"
            val connection = DriverManager.getConnection(connectionString)
            testConnection(connection)
            return connection
        }

        private fun testConnection(connection: Connection){
            println(connection)
            val resultSet = connection.createStatement().executeQuery("SELECT 1")
            if (resultSet.next()) {
                println("Result: ${resultSet.getString(1)}")
            }
        }
    }

}