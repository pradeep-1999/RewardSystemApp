package com.example.telusDemo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String customerId;

	    @Column(nullable = false)
	    private Double amount;

	    @Column(nullable = false)
	    private LocalDate transactionDate;

	    private String metaData;

	    public Transaction() {
	    }

	    
		public Transaction(Long id, String customerId, Double amount, LocalDate transactionDate, String metaData) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.amount = amount;
			this.transactionDate = transactionDate;
			this.metaData = metaData;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public LocalDate getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
		}

		public String getMetaData() {
			return metaData;
		}

		public void setMetaData(String metaData) {
			this.metaData = metaData;
		}

		@Override
		public String toString() {
			return "Transaction [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", transactionDate="
					+ transactionDate + ", metaData=" + metaData + "]";
		}
	
	
	
}
