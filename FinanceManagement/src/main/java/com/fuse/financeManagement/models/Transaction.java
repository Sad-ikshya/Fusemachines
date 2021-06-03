package com.fuse.financeManagement.models;

import java.math.BigInteger;
import java.util.Date;

public class Transaction {
	public BigInteger id;
	public BigInteger toAccount;
	public BigInteger fromAccount;
	public double amount;
	public Date date;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getToAccount() {
		return toAccount;
	}

	public void setToAccount(BigInteger toAccount) {
		this.toAccount = toAccount;
	}

	public BigInteger getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(BigInteger fromAccount) {
		this.fromAccount = fromAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
