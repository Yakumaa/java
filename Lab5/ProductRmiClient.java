package Lab5;

import java.rmi.registry.*;
import java.util.Scanner;
public class ProductRmiClient {
    public static void main(String[] args) throws Exception{
        Registry creg=LocateRegistry.getRegistry(1111);
        ProductRmiSP sp=(ProductRmiSP)creg.lookup("product");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number");
        int num1=sc.nextInt();
        System.out.println("Enter second number");
        int num2=sc.nextInt();
        int res=sp.findProduct(num1,num2);
        System.out.println("The product is: "+res);
    }
}
