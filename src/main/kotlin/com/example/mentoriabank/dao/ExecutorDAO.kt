package com.example.mentoriabank.dao

import com.example.mentoriabank.Singleton.ConnectionSingleton
import java.sql.ResultSet

class ExecutorDAO {

    fun execute(sql: String): Boolean {
        val statement = ConnectionSingleton
            .create()
            .createStatement()

        val result = statement.execute(sql)
        statement.close()
        return result
    }

    fun executeQuery(sql: String): ResultSet{
        val statement = ConnectionSingleton
            .create()
            .createStatement()

        val resultSet = statement.executeQuery(sql)
        return resultSet
    }

}