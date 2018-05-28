//Peter Nguyen-Truong

public class Player
{
	private String playerName;
	private int playerBalance;

	public Player(String name, int balance) // Player constructor
	{
		playerName = name;
		setBalance(balance);
	}

	public void setBalance(int balance) // sets player's Balance
	{ 
		playerBalance = balance;
	}

	public void increaseBalance(int balance) // increases player's Balance
	{
		playerBalance = playerBalance + balance;
	}

	public void decreaseBalance(int balance) // decrease player's balance
	{
		playerBalance = playerBalance - balance;
	}

	public int getBalance() // returns player's Balance
	{
		return playerBalance;
	}

	public String getName() // returns player's Name
	{
		return playerName;
	}

}