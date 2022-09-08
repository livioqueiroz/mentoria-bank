package com.example.mentoriabank.dao

import com.example.mentoriabank.model.Customer
import java.sql.Connection

class CustomerDAO(
    private val executor: ExecutorDAO
    ) {

    fun create(){
        executor.execute("CREATE TABLE IF NOT EXISTS CUSTOMER(id int AUTO_INCREMENT, name varchar(255), CPF varchar(11), primary key (id))")
        println("Table CUSTOMER created sucessfully")
    }

    fun insert(name: String, cpf: String): Customer? {
        executor.execute("INSERT INTO CUSTOMER(NAME, CPF) VALUES('$name', '$cpf')")
        return findByCPF(cpf)
    }

    fun findAll(): MutableList<Customer> {
        var rs = executor.executeQuery("SELECT * FROM CUSTOMER")
        println("CUSTOMER TABLE:")
        val customers = mutableListOf<Customer>()

        while (rs.next()) {
            val customer = Customer(id = (rs.getInt(1)),name = rs.getString(2), CPF = rs.getString(3))
            customers.add(customer)
        }

        rs.close()

//        return customers.also { println(it) }
        return customers.also(::println)

    }

    fun findById(id: Int): Customer?{
        val rs = executor.executeQuery("SELECT * FROM CUSTOMER WHERE id = $id")
//        val prepareStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE id = ?")
//        prepareStatement.setInt(1,id)
        println("FIND id=$id IN CUSTOMER TABLE:")


        var customer: Customer? = null

//        val rs = prepareStatement.executeQuery()

        if (rs.next()) {
            customer = Customer(id = (rs.getInt(1)),name = rs.getString(2), CPF = rs.getString(3))
            println(customer)
        }
        rs.close()
//        prepareStatement.close()
        return customer
    }

    fun findByCPF(CPF: String): Customer?{
        val rs = executor.executeQuery("SELECT * FROM CUSTOMER WHERE CPF = $CPF")
        println("FIND CPF=$CPF IN CUSTOMER TABLE:")
        var customer: Customer? = null
        if (rs.next()) {
            customer = Customer(id = (rs.getInt(1)),name = rs.getString(2), CPF = rs.getString(3))
            println(customer)
        }
        rs.close()
        return customer
    }

}