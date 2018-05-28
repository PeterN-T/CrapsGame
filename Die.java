//Peter Nguyen-Truong

import java.util.Random;
public class Die
{
	public Random random = new Random();
	private int face;

	public void setFace()
	{
		face = 1 + random.nextInt(6);
	}

	public int getFace()
	{
		return face;
	}
}