package datoteke;
import java.io.*;

public class PrviPrimer {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("c:\\Rac4\\datoteke\\a.txt");
        pw.println("hello");
        pw.close();

    }    
}
