package gingi.junit4.mock;

public class AccountService {
	private AccountManger accountManger;
	
	public void setAccountManager(AccountManger manager) {
		this.accountManger = manager;
	}
	
	public void transfer(String  senderId, String beneficiaryId, long amount){
		Account sender = this.accountManger.findAccountForUser(senderId);
		Account beneficiary  = this.accountManger.findAccountForUser(beneficiaryId);
		sender.debit(amount);
		beneficiary.credit(amount);
		this.accountManger.updateAccount(sender);
		this.accountManger.updateAccount(beneficiary);
		
	}
}
