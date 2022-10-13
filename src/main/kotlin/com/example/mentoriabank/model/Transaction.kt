package com.example.mentoriabank.model

data class Transaction(
    val id: Int,
    //TODO Aqui era UUID, mudei pra Int para poder realizar as operações
    val account: Account,
    val amount: Float,
    val type: String, //TODO Mudei para String, pois não sabia como pegar ENUM do banco
)