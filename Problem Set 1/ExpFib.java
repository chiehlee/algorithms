public class ExpFib {

	static long ET(long N) {
		if (N == 0) {
			return 0;
		} else if (N == 1) {
			return 1;
		} else {
			return ET(N - 1) + ET(N - 2);
		}
	}

	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			long startTime = System.currentTimeMillis();
			System.out.println(ET(userInput));
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
