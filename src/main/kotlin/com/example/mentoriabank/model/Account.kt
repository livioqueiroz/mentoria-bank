package com.example.mentoriabank.model

data class Account(
    val id: Int,
    val number: Int,
    val balance: Float,
    val customer: Customer,
)