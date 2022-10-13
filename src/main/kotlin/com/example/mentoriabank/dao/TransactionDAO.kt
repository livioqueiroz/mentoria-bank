package com.example.mentoriabank.dao

import com.example.mentoriabank.model.Transaction

class TransactionDAO(
    private val executor: ExecutorDAO,
    private val account: AccountDAO,
) {

    fun create() {
        executor.execute("CREATE TABLE IF NOT EXISTS `TRANSACTION`(id int AUTO_INCREMENT, account_id int, amount float, transaction_type varchar(255), FOREIGN KEY (account_id) REFERENCES ACCOUNT(id), primary key (id))")
        println("\nTable TRANSACTION created sucessfully")
    }

    fun insert(accountId: Int, amount: Int) {
        executor.execute("INSERT INTO `TRANSACTION`(account_id, amount, transaction_type) VALUES('$accountId', '$amount', 'DEPOSIT')")
        findAll()
    }

    fun findAll(): MutableList<Transaction> {
        val rs = executor.executeQuery("SELECT * FROM `TRANSACTION`")
        println("\nTRANSACTION TABLE:")
        val transactions = mutableListOf<Transaction>()
        while (rs.next()) {
            val transaction = Transaction(
                id = rs.getInt(1),
                account = account.findById(rs.getInt(2))!!, //TODO Resolver Nullpointer
                amount = rs.getFloat(3), //TODO Tem muita divergência entre os tipos
                type = rs.getString(4) //TODO Como pegar uma String e converter em ENUM?
            )
            transactions.add(transaction)
        }
        rs.close()
        transactions.forEach { println(it) }
        return transactions
    }

}