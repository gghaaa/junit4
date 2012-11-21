package gingi.junit4.mock;

public class Account {
	private String accountId;
	private long balance;

	public Account(String accountId, long balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public void debit(long amount) {
		this.balance -= amount;
	}

	public void credit(long amount) {
		this.balance += amount;
	}

	public long getBalance() {
		return this.balance;
	}

}
