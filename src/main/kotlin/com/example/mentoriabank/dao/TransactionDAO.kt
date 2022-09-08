package com.example.mentoriabank.dao

import java.sql.Connection
import java.util.UUID

class TransactionDAO(connection: Connection) {
    private val connection = connection

    fun create(){
        val statement = connection.createStatement()
        statement.execute("CREATE TABLE IF NOT EXISTS `TRANSACTION`(id int AUTO_INCREMENT, account_id int, amount float, transaction_type varchar(255), FOREIGN KEY (account_id) REFERENCES ACCOUNT(id), primary key (id))")
        println("Table TRANSACTION created sucessfully")
        statement.close()
    }

    fun insert(accountId: Int, amount: Int){
        val statement = connection.createStatement()
        statement.execute("INSERT INTO `TRANSACTION`(account_id, amount, transaction_type) VALUES('$accountId', '$amount', 'DEPOSIT')")
        //a mudança no balance do account faz aqui?
        findAll()
        statement.close()
    }

    fun findAll(){
        var rs = connection.createStatement().executeQuery("SELECT * FROM `TRANSACTION`")
        println("TRANSACTION TABLE:")
        while (rs.next()) {
            println("id: ${rs.getString(1)}, account_id: ${rs.getString(2)}, amount: ${rs.getString(3)}, transaction_type: ${rs.getString(4)}")
        }
        rs.close()
        //Aqui precisa fechar o statement?
    }


}