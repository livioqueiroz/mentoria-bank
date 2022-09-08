package com.example.mentoriabank

import com.example.mentoriabank.Singleton.ConnectionSingleton
import com.example.mentoriabank.common.RandomCommon.Companion.getRandomNumber
import com.example.mentoriabank.dao.AccountDAO
import com.example.mentoriabank.dao.CustomerDAO
import com.example.mentoriabank.dao.ExecutorDAO
import com.example.mentoriabank.dao.TransactionDAO
import java.sql.SQLException

//@SpringBootApplication
//class MentoriaBankApplication

fun main(args: Array<String>) {
//    runApplication<MentoriaBankApplication>(*args)

    try {
        val connection = ConnectionSingleton.create()
        val customer = CustomerDAO(ExecutorDAO())
        val account = AccountDAO(ExecutorDAO(), customer)
        val transaction = TransactionDAO(connection)

        customer.create()
        customer.insert(name = "Livio",cpf= getRandomNumber())
        customer.findById(1)

        account.create()
        account.insert(1)

        transaction.create()
        transaction.insert(1, 20)

        connection.close()

    } catch (ex: SQLException) {
        println(ex.message)
        ex.printStackTrace()
    }
}



data class Teste(
    val nome: String,
    val sobrenome: String,
) {

}
// TODO - 1 fazer melhoria nas querys (eliminar código repetido nas funções)

// TODO - 2 CRIAR CLASSES DE REPOSITÓRIO PARA Customer, Account e Transaction - Exemplo: CustomerRepository - Anotar como @Component
