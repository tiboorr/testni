public class Vaja1{
    public static void main(String[] args) {
        System.out.println("2 na 10 = "+potenca(10));
        System.out.println("7 fibb št je "+fib(7));
        System.out.println("šesti člen naloge ena je "+naloga1(6));
        System.out.println("peti člen naloge dva je "+naloga2(5));
        System.out.println("peti člen naloge tri je "+naloga3(5));
        System.out.println("sedmi člen naloge štiri je "+naloga4(7));
    }

    public static int naloga1(int n){
     //      */   a1 = 2 a2 = 2
               // an = a n-2*a n-1 – 1/* */
        if (n == 1)
            return 2;
        if (n == 2)
            return 2;
        return naloga1(n-2)*naloga1(n-1) -1;
    }

    public static int naloga2(int n){
           //         a1 = 2
                   // a n = 3 * a n-1 + 2 
        if (n == 1)
            return 2;
        return 3 * naloga2(n-1) + 2;
    }

    public static int naloga3(int n){
        // a1 = 1 a2 = 2
        // an = a n-1*2 + a n-2
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return naloga3(n-1) * 2 + naloga3(n-2);
    }

    public static int naloga4(int n){
        // a1 = 1 a2 = 4
        // an= a n-1+2 
        if (n == 1)
            return 1;
        if (n == 2)
            return 4;
        return naloga4(n-1) +2;
    }



    public static int potenca(int n){
        //izračuna 2 na n rekurzivno
        if (n == 0)
            return 1;
        return 2*potenca(n-1);
    }

    public static int fib(int n){
        //izračunam nto figunacccijevo st.
        if (n == 1 || n == 2)
            return 1;
        return fib(n-1) + fib(n-2);
    }
}