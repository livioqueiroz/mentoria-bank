package com.example.mentoriabank

import java.util.UUID
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MentoriaBankApplication

fun main(args: Array<String>) {
    runApplication<MentoriaBankApplication>(*args)
    println("Teste")
}

class Customer(
    var id: UUID,
    var name: String,
    var CPF: String,
)

class Account(
    var id: UUID,
    var number: Int,
    var customer: Customer,
    var balance: Float,
)

class Transaction(
    var id: UUID,
    var account: Account,
    var amount: Float,
    var type: TransactionType,
)

enum class TransactionType {
    DEPOSIT,
    WITHDRAW,
    PAYMENT,
    TRANSFER
}