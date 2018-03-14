

public class Client {
	
	

	public static void main(String[] args) {
		
		ICICIBank bank = new ICICIBank();
		System.out.println(bank.createAccount(101,5000));
		
		System.out.println(bank.createAccount(102,10000));
		
	   try
		{
			System.out.println("Total balance = "+bank.depositAmount(101, 2000));
			System.out.println("Remaining balance is:"+bank.withdrawAccount(101,1000));
			bank.transferAmmount(101,102,1000);
		}
		
		catch(InvalidAccountNumberException ian)
		{
			System.out.println("invalid account number");
		}
		catch(InsufficientBalance ib)
		{
			System.out.println("Insufficient Balance");
		}
	}

}
