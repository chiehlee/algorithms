import java.util.Arrays;

public class QuickSort {
	
	
	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			int[] list1 = new int[userInput];
			for (int i = 0; i < userInput; i++) {
				int random = (int) (Math.random() * 1000000);
				list1[i] = random;
			}
			// System.out.println("generated int arrays");
			// System.out.println(ToS(list1));
			long startTime = System.currentTimeMillis();
			Arrays.sort(list1);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println();
			System.out.println("sorted arrays");
			System.out.println(Arrays.toString(list1));
			System.out.println();
			System.out.println("Time spent: ");
			System.out.println(totalTime);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("pleae input a number");
		}

	}

}
