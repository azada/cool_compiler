package cool.symbol;


import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/21/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeSingleton {
    public HashSet<String> typeTable;
    private static TypeSingleton instance;
    private TypeSingleton() {

    }
    public static TypeSingleton getInstance(){
        if (instance == null) {
            instance = new TypeSingleton();
        }
        return instance;
    }
}
