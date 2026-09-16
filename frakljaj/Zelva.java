import java.awt.Color;

public class Zelva{
    //poz, 
    double x, y;
    //smer
    int fi;

    public Zelva(double x1, double y1, int a) {
        x = x1;
        y = y1;
        fi = a;
    }

    public void zavijLevo(int kot){
        fi = fi + kot;
    }

    public void naprej(double d){
        double stariX = x;
        double stariY = y;
        x = stariX + d * Math.cos(Math.toRadians(fi));
        y = stariY + d * Math.sin(Math.toRadians(fi));
        //nariši črtro
        StdDraw.line(stariX, stariY, x, y);
    }

    public static void koch(int n, double korak, Zelva z){
        if (n == 0){
            z.naprej(korak);
            return;
        }
        koch(n-1, korak, z);
        z.zavijLevo(60);
        koch(n-1, korak, z);
        z.zavijLevo(-120);
        koch(n-1, korak, z);
        z.zavijLevo(60);
        koch(n-1, korak, z);
    }

    public static void drevo(int n, Zelva z, double korak, int medVejami){
        StdDraw.setPenRadius(0.001*Math.pow(n, 1.2));
        int blue = (n*50) % 256;
        Color barva = new Color(0, 255, blue);
        StdDraw.setPenColor(barva);
        z.naprej(korak);
        if(n == 0)
            return;
        Zelva leva = new Zelva(z.x, z.y, z.fi-medVejami);
        Zelva desna = new Zelva(z.x, z.y, z.fi+medVejami);
        Zelva srednja = new Zelva(z.x, z.y, z.fi);
        
        drevo(n-1, leva, korak*0.3, medVejami);
        drevo(n-1, desna, korak*0.3, medVejami);        
        drevo(n-1, srednja, korak*(1-0.3), medVejami);
        
    }
    public static void main(String[] args) {
        /* ŠESTKONTNIK
        Zelva z = new Zelva(0.5, 0, 180/3);
        for (int k = 0; k<360; k++){
            z.naprej(0.2);
            z.zavijLevo(360/360);
        }*/

        /*PIJANA POT
        Zelva z = new Zelva(0.5, 0.5, 0);
        for (int k = 0; k<10000;k++){
        z.naprej(0.01);
        int kot = (int)(Math.random()*360);
        z.zavijLevo(kot);
        }*/

        /*Zelva z = new Zelva(0, 0, 0);
        int n = 7;
        double korak = 1 / Math.pow(3,n);
        koch(n, korak, z);
        z.zavijLevo(120);
        koch(n, korak, z);
        z.zavijLevo(120);
        koch(n, korak, z);*/

        Zelva z = new Zelva(0.5, 0, 90);
        int n = 8;
        double korak = 0.3;
        drevo(n, z, korak, 40);
        
    }

}