package com.example.mentoriabank.model

import com.example.mentoriabank.enum.TransactionType
import java.util.UUID

class Transaction(
    val id: UUID,
    val account: Account,
    val amount: Float,
    val type: TransactionType,
) {
}