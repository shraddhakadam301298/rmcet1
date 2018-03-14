import java.util.LinkedList;


public class ICICIBank {
	
	LinkedList<Account>  accounts = new LinkedList<>();
	
	
	public String createAccount(int accountNumber,int amount)
	{
		Account account = new Account(accountNumber,amount);
		accounts.add(account);
		return "account created successfully";
	}
	
	
	
	
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException
	{
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		
		return account.getAmount();
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		
		throw new InvalidAccountNumberException();
	}
	private Account searchAmount(int accountNo,int ammount)throws InsufficientBalance
	{
		for(Account account : accounts)
		{
			if(accountNo==account.getAccountNumber())
			{
			   if(account.getAmount()>=ammount)
			     {
				return account;
			    }
			}
		}
		 throw new InsufficientBalance();
	}




	public int withdrawAccount(int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientBalance
	{
	{
		Account account = searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>0)
			throw new InsufficientBalance();
		
		
				account.setAmount(account.getAmount()-amount);
	    return account.getAmount();	
       
		
	}
	

	}




	public void transferAmmount(int account1, int account2, int ammount)throws InvalidAccountNumberException,InsufficientBalance
	{
		Account account01= searchAccount(account1);
		Account account02= searchAccount(account2);
		if((account01.getAmount()-ammount)>0)
			throw new InsufficientBalance();
		
		
		account01.setAmount(account01.getAmount()-ammount);
		account02.setAmount(account02.getAmount()+ammount);
		System.out.println("Account balance of:"+account01.getAccountNumber()+" is "+account01.getAmount());
		System.out.println("Account balance of:"+account02.getAccountNumber()+" is "+account02.getAmount());
		
		
		
	}
}
