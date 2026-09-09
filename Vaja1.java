public class Vaja1{
    public static void main(String[] args) {
        System.out.println("2 na 10 = "+potenca(10));
        System.out.println("7 fibb št je "+fib(7));
    }

    public static int potenca(int n){
        //izračuna 2 na n rekurzivno
        if (n == 0)
            return 1;
        return 2*potenca(n-1);
    }

    public static int fib(int n){
        //izračunam nto figunacijevo st.
        if (n == 1 || n == 2)
            return 1;
        return fib(n-1) + fib(n-2);
    }
}