package Lab5;

import java.rmi.*;

public interface DiscountRmiSP extends Remote{
    int findSP(int Cp,int discount) throws Exception;
}
