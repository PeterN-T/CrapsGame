//Peter Nguyen-Truong

import java.util.Random;

public class Crowd
{
	public Random random = new Random();
	int number;
	private String cheerArray[] = 
	{"Fan: You're on fire!", "Fan: Nice roll!", "Fan: Whoooo! Keep going!", "Fan: Lucky lad!"};
	private String pityArray[] =
	{"Fan: Better luck next time.", "Fan: You win some. You lose some.", "Fan: Slow your roll!", "Fan: Don't blow it all!" };

	public void cheer()
	{
		number = random.nextInt(4); // to Update: set == cheerArray[] length
		System.out.println(cheerArray[number] + ""); // prints random cheer from cheerArray[]
	}

	public void pity()
	{
		number = random.nextInt(4); // to Update: set == pityArray[] length
		System.out.println(pityArray[number] + ""); // prints random pity from pityArray[]
	}
}