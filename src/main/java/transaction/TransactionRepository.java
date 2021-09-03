package transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import transaction.Transaction;

interface TransactionRepository extends JpaRepository<Transaction, Long> {

}