import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VajaDat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:\\rac4\\datoteke\\clanek.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("c:\\Rac4\\datoteke\\ostevilcenClanek.txt"));
        String v = br.readLine();
        int st = 1;
        while (v != null) {
            System.out.println(v);
            pw.println(st + " " + v);
            st++;
            v = br.readLine();

        }
        br.close();
        pw.close();
        System.out.println("Število vrstic je: "+st);

    }
    

}
