import java.util.ArrayList;
import java.util.List;

public class Edit {

	static double[][] dp;
	String word1; // String is going to be edit
	String word2; // target String
	String word3; // target String
	List<String> sl = new ArrayList<String>();

	public void initialD() {
		int len1 = word1.length();
		int len2 = word2.length();

		dp = new double[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

	}

	void fillD(int i, int j) {
		if (i > word1.length()) {
			return;
		} else if (j > word2.length()) {
			fillD(i + 1, 1);
		} else {
			double addD = dp[i][j - 1];
			double removeD = dp[i - 1][j];
			double changeD = dp[i - 1][j - 1];
			double min = Math.min(Math.min(addD, removeD), changeD);
			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
				dp[i][j] = dp[i - 1][j - 1];
			} else if (min == changeD) {
				dp[i][j] = changeD + 0.5;
			} else {
				dp[i][j] = min + 1.0;
			}
			fillD(i, j + 1);
		}
	}

	void findSequence(int i, int j) {

		if (i == 0 && j == 0) {
			return;
		} else {
			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
				// System.out.println(word1.charAt(i-1) + word2.charAt(j-1));
				findSequence(i - 1, j - 1);
			} else {
				double addD = dp[i][j - 1];
				double removeD = dp[i - 1][j];
				double changeD = dp[i - 1][j - 1];
				double min = Math.min(Math.min(addD, removeD), changeD);
				if (min == addD) {
					addS(word3, word2.charAt(j - 1), i);
					findSequence(i, j - 1);
				} else if (min == removeD) {
					removeS(word3, i);
					findSequence(i - 1, j);
				} else {
					changeS(word3, word2.charAt(j - 1), i);
					findSequence(i - 1, j - 1);
				}
			}
		}
	}

	String addS(String s, char c, int at) {
		String w = "";
		w = s.substring(0, at) + c + s.substring(at, s.length());
		word3 = w;
		sl.add(w);
		return w;
	}

	String removeS(String s, int at) {
		String w = "";
		w = s.substring(0, at - 1) + s.substring(at, s.length());
		word3 = w;
		sl.add(w);
		return w;
	}

	String changeS(String s, char c, int at) {
		String w = "";
		w = s.substring(0, at - 1) + c + s.substring(at, s.length());
		word3 = w;
		sl.add(w);
		return w;
	}

	List<String> bestSequence(String str1, String str2) {
		sl.add(str1);
		word1 = str1;
		word2 = str2;
		word3 = word1;
		initialD();
		fillD(1, 1);
		findSequence(word1.length(), word2.length());
		return sl;

	}

	public static void main(String[] args) {
		try {
			Edit e = new Edit();
			List<String> result = e.bestSequence(args[0], args[1]);
			for (int k = 0; k < result.size(); k++) {
				System.out.println(result.get(k));
			}

			System.out.println();

			// System.out.println(dp[1][2]);
			// System.out.println();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("please insert correct inputs");
		}

	}

}
