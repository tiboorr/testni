import java.io.*;

public class PrviPrimer {
    public static void main(String[] args) throws IOException {
        /*PrintWriter pw = new PrintWriter("c:\\Rac4\\datoteke\\a.txt");
        pw.println("hello");
        pw.close();*/

        //preberi a.txt in zapiši vsebino na zaslon in v datoteko b.txt
        //delaj po bytih - po znakih
        /*FileReader fr = new FileReader("c:\\Rac4\\datoteke\\a.txt");
        FileWriter fw = new FileWriter("c:\\Rac4\\datoteke\\b.txt");
        int c = fr.read();
        while (c != -1){ //ko je c == -1 je konec datoteke
            System.out.println((char)c);
            fw.write(c);
            c = fr.read();
        }
        fr.close();
        fw.close();*/

        //Preberi a.txt po vrsticah in piši na c.txt po vrsticah
        try{
        BufferedReader br = new BufferedReader(new FileReader("c:\\Rac4\\datoteke\\a.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("c:\\Rac4\\datoteke\\c.txt"));
        String vrstica = br.readLine();
        while (vrstica != null){
            System.out.println(vrstica);
            pw.println(vrstica);
            vrstica  = br.readLine();
        }
        br.close();
        pw.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }    
}
