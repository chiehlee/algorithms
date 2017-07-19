public class MachineScheduling {

	static double[] jobs;

	static boolean[] optimallySchedule(double[] durations) {
		int n = durations.length;
		double min = Double.POSITIVE_INFINITY; // current minimum difference
		boolean[] opt = new boolean[n];

		for (int i = 0; i < Math.pow(2, n); i++) {
			String bin = Integer.toBinaryString(i);
			while (bin.length() < n) {
				bin = "0" + bin;
			}
			if (Math.min(min, dif2M(bin)) == dif2M(bin)) {
				min = Math.min(min, dif2M(bin));
				opt = lockIn(bin);
			}
		}
		return opt;
	}

	// calculate the absolute distance between two machine
	// lower value = two machine are more balanced
	static double dif2M(String t) {
		double m1TD = 0; // machine 1 total duration
		double m2TD = 0; // machine 2 total duration
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == '1') {
				m1TD += jobs[i];
			} else {
				m2TD += jobs[i];
			}
		}
		return Math.abs(m1TD - m2TD);
	}

	// helper function for lock in the boolean array for
	// minimum (most balanced) two machine set
	static boolean[] lockIn(String t) {
		boolean[] result = new boolean[t.length()];
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == '1') {
				result[i] = true;
			} else {
				result[i] = false;
			}
		}
		return result;
	}

	static boolean[] greedilySchedule(double[] durations) {
		int n = durations.length;
		double m1TD = 0; // machine 1 total/current duration
		double m2TD = 0; // machine 2 total/current duration
		boolean[] opt = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (Math.min(m1TD, m2TD) == m1TD) {
				m1TD = m1TD + jobs[i];
				opt[i] = true;
			} else {
				m2TD = m2TD + jobs[i];
				opt[i] = false;
			}
		}
		return opt;
	}

	private static void printDetail(boolean[] bs) {
		double m1total = 0.0;
		double m2total = 0.0;
		for (int k = 0; k < bs.length; k++) {
			if (bs[k]) {
				m1total = m1total + jobs[k];
			} else {
				m2total = m2total + jobs[k];
			}
			System.out.println(k + 1 + ": " + bs[k]);
		}
		System.out.println("Machine 1 Total: " + m1total);
		System.out.println("Machine 2 Total: " + m2total);
	}

	private static double getLaterTime(boolean[] bs) {
		double m1total = 0.0;
		double m2total = 0.0;
		for (int k = 0; k < bs.length; k++) {
			if (bs[k]) {
				m1total = m1total + jobs[k];
			} else {
				m2total = m2total + jobs[k];
			}
		}
		return Math.max(m1total, m2total);
	}

	public static void main(String[] args) {
		try {
			int userInput = Integer.parseInt(args[0]);

			// initial array contains all (random) durations
			jobs = new double[userInput];
			for (int i = 0; i < userInput; i++) {
				double random = (Math.random() * 100) + 1;
				jobs[i] = random;
			}

			// output all durations
			/*
			 * for (int j = 0; j < 10; j++) { System.out.print(j + ": ");
			 * System.out.println(jobs[j]); }
			 */

			if (args.length > 1) {
				if (args[1].equals("-v")) {
					printDetail(optimallySchedule(jobs));
					System.out.println();
					printDetail(greedilySchedule(jobs));
				}
			}

			long startTime = System.nanoTime();
			optimallySchedule(jobs);
			long endTime = System.nanoTime();
			System.out.print("Optimally Schedule: ");
			System.out.println(endTime - startTime);

			startTime = System.nanoTime();
			greedilySchedule(jobs);
			endTime = System.nanoTime();
			System.out.print("Greedily Schedule: ");
			System.out.println(endTime - startTime);

			double optLT = getLaterTime(optimallySchedule(jobs));
			double grdLT = getLaterTime(greedilySchedule(jobs));

			System.out.println(grdLT / optLT);
			System.out.println();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("pleae input a number");
		}

	}

}
