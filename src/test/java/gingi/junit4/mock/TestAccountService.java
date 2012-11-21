package gingi.junit4.mock;

import junit.framework.Assert;

import org.junit.Test;

public class TestAccountService {

	@Test
	public void testTransferOk() {
		MockAccountManager manager = new MockAccountManager();
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);
		manager.addAccount("1", senderAccount);
		manager.addAccount("2", beneficiaryAccount);
		
		AccountService accountService = new AccountService();
		accountService.setAccountManager(manager);
		accountService.transfer("1", "2", 50);
		
		Assert.assertEquals(150, senderAccount.getBalance());
		Assert.assertEquals(150, beneficiaryAccount.getBalance());
	
	}
}
