package gingi.junit4.mock;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManger {

	private Map<String, Account> accounts = new HashMap<String, Account>();
	
	public void addAccount(String userId, Account account) {
		accounts.put(userId, account);
	}
	
	public Account findAccountForUser(String userId) {
		return this.accounts.get(userId);
	}

	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

}
