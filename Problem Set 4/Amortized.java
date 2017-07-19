import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Amortized {

	ArrayList<Long> LL = new ArrayList<Long>();

	public static void main(String[] args) throws FileNotFoundException {
		Amortized a = new Amortized();
		long startTime = System.nanoTime();
		a.LL.add((long) 0);
		long endTime = System.nanoTime();
		long forNext = endTime - startTime;
		for (long i = 1; i < 3000000; i++) {
			startTime = System.nanoTime();
			a.LL.add(forNext);
			endTime = System.nanoTime();
			forNext = endTime - startTime;
		}

		PrintWriter writer = new PrintWriter(
				"C:\\Users\\chiehl\\Dropbox\\Java_8\\4800PS4\\src\\output.txt");

		for (int j = 0; j < a.LL.size(); j++) {
			// System.out.print(j + " ");
			// System.out.println(a.LL.get(j));
			writer.write(a.LL.get(j).toString() + "\n");
		}
		writer.close();

	}

}
