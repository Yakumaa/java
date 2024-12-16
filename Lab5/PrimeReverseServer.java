package Lab5;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
public class PrimeReverseServer extends UnicastRemoteObject implements PrimeReverseSP{
    public PrimeReverseServer() throws RemoteException{};
    @Override
    public String reverseString(String a){
        String rev="";
        char ch;
        for(int i=0;i<a.length();i++){
            ch=a.charAt(i);
            rev=ch+rev;
        }
        return rev;
    }
    @Override
    public String checkPrime(int x){
        int count=0;
        for(int i=1;i<=x;i++){
            if(x%i==0){
                count++;
            }
        }
        if(count==2){
            return "Prime";
        }else{
            return "Not Prime";
        }
    }
    public static void main(String[] args) {
        try{
            Registry reg=LocateRegistry.createRegistry(2222);
            reg.rebind("primereverse",new PrimeReverseServer());
        }catch(RemoteException ex){
            System.out.println(ex);
        }
    }
}
