package Lab5;

import java.rmi.*;
public interface ProductRmiSP extends Remote {
    int findProduct(int x,int y) throws RemoteException;
}

