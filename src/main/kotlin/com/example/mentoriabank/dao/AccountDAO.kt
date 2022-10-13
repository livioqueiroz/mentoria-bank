package com.example.mentoriabank.dao

import com.example.mentoriabank.common.RandomCommon.Companion.getRandomNumber
import com.example.mentoriabank.model.Account

class AccountDAO(
    private val executor: ExecutorDAO,
    private val customer: CustomerDAO,
) {

    fun create() {
        executor.execute("CREATE TABLE IF NOT EXISTS ACCOUNT(id int AUTO_INCREMENT, number varchar(8), balance float, customer_id int, FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id), primary key (id))")
        println("Table ACCOUNT created sucessfully")
    }

    fun insert(customerId: Int, balance: String? = null): Account? {
        val number = getRandomNumber(8)
        executor.execute("INSERT INTO ACCOUNT(number, balance, customer_id) VALUES('$number', '${balance ?: 0}', '${customerId}')")
        return findByNumber(number)
    }

    fun findByNumber(number: String): Account? {
        val rs = executor.executeQuery("SELECT * FROM ACCOUNT WHERE number = $number")
        println("FIND number= $number IN ACCOUNT TABLE")

        var account: Account? = null

        if (rs.next()) {
            account = Account(
                id = rs.getInt(1),
                number = rs.getString(2).toInt(),
                balance = rs.getString(3).toFloat(),
                customer = customer.findById(rs.getString(4).toInt())!!)
            //TODO resolver esse nullpointer
            println("""
                $account
                """)
        }
        rs.close()
        return account
    }

    fun findById(id: Int): Account? {
        val rs = executor.executeQuery("SELECT * FROM ACCOUNT WHERE id = $id")
        println("FIND id = $id IN ACCOUNT TABLE")

        var account: Account? = null

        if (rs.next()) {
            account = Account(
                id = rs.getInt(1),
                number = rs.getString(2).toInt(),
                balance = rs.getString(3).toFloat(),
                customer = customer.findById(rs.getString(4).toInt())!!)
            //TODO resolver esse nullpointer
            println("""
                $account
                """)
        }
        rs.close()
        return account
    }

    fun findAll(): MutableList<Account> {
        val rs = executor.executeQuery("SELECT * FROM ACCOUNT")
        println("ACCOUNT TABLE:")
        val accounts = mutableListOf<Account>()
        while (rs.next()) {
            val account = Account(id = (rs.getInt(1)),
                number = rs.getInt(2),
                balance = rs.getFloat(3),
                customer = customer.findById(rs.getInt(4))!!)
            accounts.add(account)
        }
        rs.close()
        return accounts.also { println(it) }
    }

}