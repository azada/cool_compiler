package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/22/13
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Program {

    public static ArrayList classes = new ArrayList();
    public static HashSet<String> typeTable = new HashSet<String>() ;
    public static SymbolNode programSymbolNode = new SymbolNode();
    public static ArrayList<Exeption> errorList = new ArrayList<Exeption>();
    private static Program instance = new Program();

    private Program() {

    }
    public static Program getInstance(){
        return instance;
    }
    public static ArrayList getClasses(){
        return classes;
    }
    public static void setClasses(ArrayList cls){
        classes = cls;
    }
    public static SymbolNode getSymbolNode(){
        return programSymbolNode;
    }
    public static void addError(Exeption error){
        errorList.add(error);
    }
    public static void printErrors(){
        if (errorList.size() == 0){
            System.out.println("TYPE CHECKING HAS BEEN DONE SUCCESSFULLY");
            return;
        }
        for (int i = 0 ; i< errorList.size() ;i++){
            errorList.get(i).pritnError();
        }
    }

}
