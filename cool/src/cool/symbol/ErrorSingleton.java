package cool.symbol;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/21/13
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorSingleton {
    private static ArrayList<Exeption> errorList;
    private static ErrorSingleton instance = new ErrorSingleton();
    private ErrorSingleton(){

    }
    public static ErrorSingleton getInstance(){
        return instance;
    }
    public static void addError(Exeption error){
        errorList.add(error);

    }
}