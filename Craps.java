//Peter Nguyen-Truong

import java.util.Scanner;

public class Craps
{
	// enum type with constants that represent the game status
   	private enum Status {CONTINUE, WON, LOST};

   	// constants that represent common rolls of the dice
   	private static final int SNAKE_EYES = 2;
   	private static final int TREY = 3;
   	private static final int SEVEN = 7;
   	private static final int YO_LEVEN = 11;
   	private static final int BOX_CARS = 12;

	Die die1 = new Die();
	Die die2 = new Die();
	Dice diceObject = new Dice();
	Player playerObject = new Player("Peter", 1000);
	Crowd crowdObject = new Crowd();
	Scanner scInput = new Scanner(System.in);

	int wager;
	int balance = playerObject.getBalance();
	int point;

	public void play()
	{

		System.out.println("Your Balance: $" + balance);
		System.out.print("Enter wager: $");
		wager = scInput.nextInt();
		while (!(isValidWager(wager)))
		{
			System.out.println("Invalid wager.");
			System.out.print("Enter wager: $");
			wager = scInput.nextInt();
		}
		rollDice();
		int sum = diceObject.getSumOfFaces();
		Status gameStatus;

		// determine game status and point based on first roll 
      	switch (sum) 
      	{
        	case SEVEN: // win with 7 on first roll
         	case YO_LEVEN: // win with 11 on first roll           
            	gameStatus = Status.WON;
            	break;
         	case SNAKE_EYES: // lose with 2 on first roll
         	case TREY: // lose with 3 on first roll
         	case BOX_CARS: // lose with 12 on first roll
            	gameStatus = Status.LOST;
            	break;
         	default: // did not win or lose, so remember point         
            	gameStatus = Status.CONTINUE; // game is not over
            	point = sum; // remember the point
            	System.out.printf("** Point: %d **%n", point);
            	break;
   		}

   		while (gameStatus == Status.CONTINUE)
   		{
   			rollDice();
   			sum = diceObject.getSumOfFaces();
   			if (sum == point)
   				gameStatus = Status.WON;
   			else if (sum == SEVEN)
   				gameStatus = Status.LOST;
   			else
   				gameStatus = Status.CONTINUE;
   		}

   		if (gameStatus == Status.WON)
   		{
   			playerObject.increaseBalance(wager);
   			System.out.println("You win!");
   			crowdObject.cheer();
   			System.out.println("Your balance: $" + playerObject.getBalance());
   		}
   		else if (gameStatus == Status.LOST)
   		{
   			playerObject.decreaseBalance(wager);
   			System.out.println("You lose!");
   			crowdObject.pity();
   			System.out.println("Your balance: $" + playerObject.getBalance());
   		}	
   	}

	public void rollDice()
	{
		die1.setFace(); // generates random Face value of 1-6
		die2.setFace();
		diceObject.setSumOfFaces(die1.getFace(), die2.getFace()); // sets SumOfFaces to sum of the 2 die
		System.out.println("Die1: " + die1.getFace() + " Die2: " + die2.getFace());
		System.out.println("Sum: " + diceObject.getSumOfFaces());
	}

	public boolean isValidWager(int wager) // returns true if wager is valid
	{
		if(wager <= balance && wager > 0)
		{
			return true;
		}
		return false;
	}
}