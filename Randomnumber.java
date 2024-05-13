import java.util.Random;

public class Randomnumber {
	
	/*
	 * I use static here because this class is solely made to be used as a generator and not as an object
	 * of any type, or with other words I don't mean to instantiate it anywhere. Hence I found it fitting to
	 * keep the method static.
	 */
	public static int generator(int start, int finish) {
		Random rand = new Random();
		return rand.nextInt(start, finish);
	}
}
