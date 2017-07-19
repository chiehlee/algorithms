import java.util.ArrayList;

/**
 * class of implementing Quicksort with different user input variation.
 * 
 * no variable = randomly pick a pivot variable "-l" = lazy QuickSort : pick
 * first element as pivot variable "-m" = median-of-three QuickSort : randomly
 * pick 3 elements and use the median as pivot variable "-i" = in-place
 * QuickSort : optimized in-place QuickSort
 * 
 * second argument = integer indicate how many random double element between 0
 * to 1 is going to be generated for QuickSorting.
 * 
 * @author Chieh Lee
 * @version 06/01/2016
 * 
 */
public class QuickSort {

	/**
	 * ArrayList<Double> that we are going to sort
	 */
	ArrayList<Double> input;
	/**
	 * user input variable
	 */
	String var = "";

	/**
	 * generate a random ArrayList<Double> base on args as @s;
	 * 
	 * @param s
	 *            unsorted list size
	 * 
	 */
	private void generateArray(int s) {
		this.input = new ArrayList<Double>();
		for (int i = 0; i < s; i++) {
			this.input.add(Math.random());
		}
	}

	/**
	 * giving a lowerIndex a higherIndex, pick random 3 number from
	 * 
	 * @input and return their median;
	 * 
	 * @param lowerIndex
	 * @param higherIndex
	 * 
	 */

	private double medianOf3(int lowerIndex, int higherIndex) {
		double a = this.input.get((int) (Math.random() * this.input.size()));
		double b = this.input.get((int) (Math.random() * this.input.size()));
		double c = this.input.get((int) (Math.random() * this.input.size()));
		if ((b >= a && a >= c) || (c >= a && a >= b)) {
			return a;
		} else if ((a >= b && b >= c) || (c >= b && b >= a)) {
			return b;
		} else {
			return c;
		}
	}

	/**
	 * 
	 * actual sorting algorithm
	 * 
	 * @param lowerIndex
	 * @param higherIndex
	 */
	public void sort(int lowerIndex, int higherIndex) {
		if (this.input == null || this.input.size() == 0) {
			return;
		}
		int i = lowerIndex;
		int j = higherIndex;
		double pivot = 0.0;
		if (this.var.equals("-l")) {
			pivot = this.input.get(lowerIndex);
		} else if (this.var.equals("-m")) {
			pivot = medianOf3(lowerIndex, higherIndex);
		} else if (this.var.equals("-i")) {
			sortInPlace(i, j);
			return;
		} else {
			int cap = (higherIndex + 1) - lowerIndex;
			pivot = this.input.get((int) (lowerIndex + Math.random() * cap));
		}

		while (i <= j) {
			while (this.input.get(i) < pivot) {
				i++;
			}
			while (this.input.get(j) > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			sort(lowerIndex, j);
		}
		if (i < higherIndex) {
			sort(i, higherIndex);
		}

	}

	/**
	 * 
	 * QuickSort variant, path to this method only by "-i" variant.
	 * 
	 * @param lowerIndex
	 * @param higherIndex
	 */
	private void sortInPlace(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int bg = 0 + lowerIndex;
		int cap = (higherIndex + 1) - lowerIndex;
		int pivotIndex = (int) (lowerIndex + Math.random() * cap);
		double pivot = this.input.get(pivotIndex);
		swap(pivotIndex, higherIndex);

		while (i <= higherIndex) {
			if (this.input.get(i) < pivot) {
				swap(i, bg);
				bg++;
			}
			i++;
		}
		swap(higherIndex, bg);
		bg++;
		if ((bg - 1) > lowerIndex) {
			sortInPlace(lowerIndex, (bg - 1));
		}
		if (bg < higherIndex) {
			sortInPlace(bg, higherIndex);
		}

	}

	/**
	 * 
	 * helping method for swapping two value in a ArrayList<>;
	 * 
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		double temp = this.input.get(i);
		this.input.set(i, this.input.get(j));
		this.input.set(j, temp);
	}

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			QuickSort sorter = new QuickSort();
			int s;
			if (args[0].equals("-l")) {
				sorter.var = "-l";
				s = Integer.parseInt(args[1]);
			} else if (args[0].equals("-m")) {
				sorter.var = "-m";
				s = Integer.parseInt(args[1]);
			} else if (args[0].equals("-i")) {
				sorter.var = "-i";
				s = Integer.parseInt(args[1]);
			} else {
				s = Integer.parseInt(args[0]);
			}
			sorter.generateArray(s);
			// actual sorting part and timing
			long startTime = System.nanoTime();
			sorter.sort(0, s - 1);
			long endTime = System.nanoTime();

			System.out.println(endTime - startTime);

			if (s < 100) {
				for (int i = 0; i < s; i++) {
					System.out.println(sorter.input.get(i));
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("pleae insert a valid input");
		} catch (NumberFormatException e) {
			System.out.println("please input a number");
		}

	}
}
