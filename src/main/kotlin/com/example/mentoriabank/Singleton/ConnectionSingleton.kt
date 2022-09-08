package com.example.mentoriabank.Singleton

import com.example.mentoriabank.dao.ConnectionFactory
import java.sql.Connection

class ConnectionSingleton private constructor() {
    companion object{
        private var instance: Connection? = null

        fun create(): Connection{
            if (instance == null){
                instance = ConnectionFactory.create()
            }
            return instance!!
        }
    }



//    init{
//        println("Connection established")
//    }
//    private const val LOCAL_HOST = "localhost"
//    private const val LOCAL_PORT = "3303"
//    private const val DATABASE = "mentoria"
//    private const val USER = "mentoria"
//    private const val PASSWORD = "mentoria"
//
//    fun create(host: String? = null, port: String? = null): Connection {
//        val connectionString = "jdbc:mysql://${host?: LOCAL_HOST}:${port?: LOCAL_PORT}/${DATABASE}?user=${USER}&password=${PASSWORD}"
//        val connection = DriverManager.getConnection(connectionString)
////        testConnection(connection)
//        return connection
//    }
//
//    private fun testConnection(connection: Connection){
//        println(connection)
//        val resultSet = connection.createStatement().executeQuery("SELECT 1")
//        if (resultSet.next()) {
//            println("Result: ${resultSet.getString(1)}")
//        }
//    }
}

fun main(){

    println(ConnectionSingleton.create())
    ConnectionSingleton.create().also { println(it) }
    ConnectionSingleton.create().also { println(it) }
    ConnectionSingleton.create().also { println(it) }
}