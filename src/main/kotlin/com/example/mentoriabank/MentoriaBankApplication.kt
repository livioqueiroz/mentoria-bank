package com.example.mentoriabank

import java.util.UUID
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MentoriaBankApplication

fun main(args: Array<String>) {
    runApplication<MentoriaBankApplication>(*args)
    println("Teste")
    val teste = Teste("Lívio", "Queiroz")
    val teste2 = Teste("Lívio", "Queiro")
    println(teste == teste2)
    println(teste)
    println(teste2)
    val teste3 = teste.copy(sobrenome = "Augusto")
    println(teste3)
}

data class Teste(
    val nome: String,
    val sobrenome: String
){

}

class Customer(
    val id: UUID,
    val name: String,
    val CPF: String,
)

class Account(
    val id: UUID,
    val number: Int,
    val customer: Customer,
    val balance: Float,
)

class Transaction(
    val id: UUID,
    val account: Account,
    val amount: Float,
    val type: TransactionType,
)

enum class TransactionType {
    DEPOSIT,
    WITHDRAW,
    PAYMENT,
    TRANSFER
}

// TODO CRIAR CLASSES DE REPOSITÓRIO PARA Customer, Account e Transaction - Exemplo: CustomerRepository - Anotar como @Component
// TODO Tentar organizar em camadas/packages