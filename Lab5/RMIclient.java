package Lab5;

import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Scanner;
public class RMIclient {
    public static void main(String[] args) throws Exception {
        Registry creg=LocateRegistry.getRegistry(9999);
        DiscountRmiSP sp=(DiscountRmiSP)creg.lookup("lab5"); 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter CP:");
        int cp=sc.nextInt();
        System.out.println("Enter discount amount");
        int discount=sc.nextInt();
        int SP=sp.findSP(cp, discount);
        System.out.println("Selling prices is: "+SP);
    }
}
