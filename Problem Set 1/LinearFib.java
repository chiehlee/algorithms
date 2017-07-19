
public class LinearFib {

	static long LT(long N) {
		long f = 0;
		long f1 = 0;
		long f2 = 1;
		for (int i = 2; i <= N; i++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}

	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			long startTime = System.currentTimeMillis();
			System.out.println(LT(userInput));
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println();
			System.out.println("Time spent: ");
			System.out.println(totalTime);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("pleae input a number");
		}

	}

}
