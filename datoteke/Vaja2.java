import java.io.*;


public class Vaja2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:\\Rac4\\datoteke\\clanek.txt"));
        String v = br.readLine(); //preštej koliko je besed 'danes' v vrstici
        int st = 0;

        while (v != null){
            int zac = 0;
            int p = v.indexOf(' ');
            while(p != -1){
                String b = v.substring(zac, p);
                if (b.equalsIgnoreCase("danes"))
                    st++;
                zac = p+1;
                p = v.indexOf(' ', zac);
            }
            v = br.readLine();

        }
        System.out.println("Število besed danes = "+st);
        br.close();
    }
}
