package Lab5;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
public class RMIserver extends UnicastRemoteObject implements DiscountRmiSP {
    public RMIserver() throws RemoteException{}
    @Override
    public int findSP(int Cp,int discount){
        return Cp-discount;
    }
    public static void main(String[] args) {
        try{
        Registry reg=LocateRegistry.createRegistry(9999);
        reg.rebind("lab5", new RMIserver());
        }catch(RemoteException ex){
            System.out.println(ex);
        }
    }
}
