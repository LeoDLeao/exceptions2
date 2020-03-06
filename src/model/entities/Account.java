package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawnLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amouth) {
		balance += amouth;
	}

	public void withdraw(double amouth) throws DomainException {
		if (amouth > withdrawLimit) {
			throw new DomainException("The amouth exceeds withdraw limit");
		}
		if (amouth > balance) {
			throw new DomainException("Not enough balance");
		}
		this.balance -= amouth;
	}

}
