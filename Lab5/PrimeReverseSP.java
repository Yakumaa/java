package Lab5;
import java.rmi.*;
public interface PrimeReverseSP extends Remote{
    String reverseString(String a) throws RemoteException;
    String checkPrime(int x) throws RemoteException;
    }
