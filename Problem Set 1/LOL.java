import java.util.ArrayList;

public class LOL {

	static long getMillionSum(ArrayList<ArrayList<Integer>> a, int n) {
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			int random1 = (int) (Math.random() * n);
			int random2 = (int) (Math.random() * n);
			sum = sum + a.get(random1).get(random2);
		}
		return sum;
	}

	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			ArrayList<ArrayList<Integer>> list1 = 
					new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < userInput; i++) {
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				for (int j = 0; j < userInput; j++) {
					int random = (int) (Math.random() * 10);
					list1.add(i, list2);
					list2.add(j, random);
				}
			}
			System.out.println("done");
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
