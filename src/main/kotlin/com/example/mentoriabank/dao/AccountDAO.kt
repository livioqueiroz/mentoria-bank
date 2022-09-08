package com.example.mentoriabank.dao

import com.example.mentoriabank.model.Account
import com.example.mentoriabank.model.Customer
import java.sql.Connection
import java.util.UUID

class AccountDAO(
    private val executor: ExecutorDAO,
    private val customer: CustomerDAO
) {

    fun create(){
        executor.execute("CREATE TABLE IF NOT EXISTS ACCOUNT(id int AUTO_INCREMENT, number varchar(8), balance float, customer_id int, FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id), primary key (id))")
        println("Table ACCOUNT created sucessfully")
    }

    fun insert(customerId: Int, balance: String? = null){
        executor.execute("INSERT INTO ACCOUNT(number, balance, customer_id) VALUES('${getRandomNumber(8)}', '${balance?:0}', '${customerId}')")
        findAll()
    }

    fun findAll(): MutableList<Account> {
        var rs = executor.executeQuery("SELECT * FROM ACCOUNT")
        println("ACCOUNT TABLE:")
        val accounts = mutableListOf<Account>()
        while (rs.next()) {
            val account = Account(id = (rs.getInt(1)), number = rs.getInt(2), balance = rs.getFloat(3), customer = customer.findById(rs.getInt(4))!!)
            accounts.add(account)
        }
        rs.close()
        return accounts.also{ println(it)}
        //Aqui precisa fechar o statement?
    }

    fun getRandomNumber(length: Int): String {
        val charset = "0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}