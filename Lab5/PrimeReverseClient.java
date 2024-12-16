package Lab5;
import java.rmi.registry.*;
import java.util.Scanner;
public class PrimeReverseClient{
    public static void main(String[] args) throws Exception {
        Registry creg=LocateRegistry.getRegistry(2222);
        PrimeReverseSP sp=(PrimeReverseSP)creg.lookup("primereverse");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str=sc.nextLine();
        String res=sp.reverseString(str);
        System.out.println("Reverse of String: "+res);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();
        String res1=sp.checkPrime(num);
        System.out.println("The number is: "+res1);
    }
}
