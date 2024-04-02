package com.acciojob.librarymanagementsystems.Repositories;

import com.acciojob.librarymanagementsystems.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
