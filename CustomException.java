//cutoms exception regers to creating own exception (error)
//to create own exception we have to inherit Exception class.

//WAP that throw error if the age give by user is less tha 16
//
class AgeError extends Exception{
    @Override
    public String toString(){
        return "error: Age cannot be less than 16";
    }
}
class CutomExceptionEg{
    public void sendAge(int age)throws AgeError{
        if(age<16){
            throw new AgeError();
        }else{
            System.out.println("Congratulations");
        }
    }
}
public class CustomException{
    public static void main(String[] args) {
        CutomExceptionEg c=new CutomExceptionEg();
        try {
            c.sendAge(22);
        } catch (AgeError e) {
            System.out.println(e);
        }
    }
}