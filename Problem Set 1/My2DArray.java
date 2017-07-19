
public class My2DArray {

	static long getMillionSum(int[][] l, int n) {
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			int random1 = (int) (Math.random() * n);
			int random2 = (int) (Math.random() * n);
			sum = sum + l[random1][random2];
		}
		return sum;
	}

	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			int[][] list1 = new int[userInput][userInput];
			for (int i = 0; i < userInput; i++) {
				for (int j = 0; j < userInput; j++) {
					int random = (int) (Math.random() * 10);
					list1[i][j] = random;
				}
			}
			long startTime = System.currentTimeMillis();
			System.out.println(getMillionSum(list1, userInput));
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
