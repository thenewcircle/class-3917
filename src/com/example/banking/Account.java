package com.example.banking;

public class Account {

	/** The database primary key, or null if the Account is not yet in the database. */
	private Long id;
	private String owner;
	private double balance;

	public Account() {
		super();
	}

	public Account(Long id, String owner, double balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}

	/** Returns the database primary key, or null if the Account is not yet in the database. */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String result = String.format("Account[id=%d, owner=\"%s\", balance=$%.2f]", id, owner, balance);
		return result;
	}

	public void subtractFromBalance(double amount)
			throws InsufficientBalanceException {
		double fromBal = getBalance();
		if (amount > fromBal) {
			throw new InsufficientBalanceException(this, amount);
		}
		fromBal -= amount;
		setBalance(fromBal);
	}

	public void addToBalance(double amount) {
		double toBal = getBalance();
		toBal += amount;
		setBalance(toBal);
	}

}
