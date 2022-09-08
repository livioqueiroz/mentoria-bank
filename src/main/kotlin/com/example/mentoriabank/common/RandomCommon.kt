package com.example.mentoriabank.common

class RandomCommon {

    companion object {
        fun getRandomNumber(length: Int=11): String {
            val charset = "0123456789"
            return (1..length)
                .map { charset.random() }
                .joinToString("")
        }
    }
}