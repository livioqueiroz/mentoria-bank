package com.example.mentoriabank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MentoriaBankApplication

fun main(args: Array<String>) {
    runApplication<MentoriaBankApplication>(*args)
    println("Teste")
}

class Customer{

}

class Account{

}
class Transaction{

}

enum class TransactionType {

}