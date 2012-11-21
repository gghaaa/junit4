package gingi.junit4.mock;

public interface AccountManger {
	Account findAccountForUser(String userId);
	void updateAccount(Account account);
}
