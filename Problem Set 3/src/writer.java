import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;



public class writer {
	
	public static void main(String[] arg) throws FileNotFoundException, UnsupportedEncodingException {
		int n = 1000000;
		PrintWriter writer = new PrintWriter("C:\\Users\\leejaypiqq\\Desktop\\N\\" + String.valueOf(n) + ".txt", "ASCII");
		for (int i = 0; i < n; i++) {
			writer.print("foo");
		}
		writer.close();
	}

}
