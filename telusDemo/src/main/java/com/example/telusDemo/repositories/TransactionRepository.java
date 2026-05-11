package com.example.telusDemo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.telusDemo.entities.Transaction;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long>{
	
	@Query(value = "SELECT * FROM transactions t WHERE t.customer_id = :customerId AND t.transaction_date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<Transaction> findTransactions(@Param("customerId") String customerId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
}
