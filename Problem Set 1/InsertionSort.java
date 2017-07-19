import java.util.Arrays;

public class InsertionSort {

	public static void IS(int[] num) {
		int key;
		int i;
		int j;
		

		for (i = 1; i < num.length; i++) {
			key = num[i];
			for (j = i - 1; j >= 0 && key < num[j]; j--) {
				num[j + 1] = num[j];
			}
			num[j + 1] = key;

		}
	}
	
	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);
			int[] list1 = new int[userInput];
			for (int i = 0; i < userInput; i++) {
				int random = (int) (Math.random() * 1000000);
				list1[i] = random;
			}
			long startTime = System.currentTimeMillis();
			IS(list1);
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
