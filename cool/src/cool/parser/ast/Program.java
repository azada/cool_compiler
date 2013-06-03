package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/22/13
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Program {

    private static ArrayList classes = new ArrayList();
    ///////////////////////type /////////// function name, it's return type
    private static HashMap<String,HashMap<String,FeatureMethod> > typeTable = new HashMap<String,HashMap<String,FeatureMethod> >() ;
    // in order to store the class's object as a pair to the classe's name, we need another hashmap.
    public static HashMap<String , ClassNode> typeClassTable = new HashMap<String, ClassNode>();
    public static SymbolNode programSymbolNode = new SymbolNode();
    private static ArrayList<Exeption> errorList = new ArrayList<Exeption>();
    private static Program instance = new Program();

    private Program() {

    }
    public static Program getInstance(){
        if (instance.typeTable.isEmpty()){
            instance.typeTable.put("Int", null);
            instance.typeTable.put("String", null);
            instance.typeTable.put("Boolean", null);
        }
        return instance;
    }
    public static ArrayList getClasses(){
        return classes;
    }
    public static boolean typeTableContains(String a){
        return instance.typeTable.containsKey(a);
    }
    public static HashMap<String,FeatureMethod>  getTableRow(String a){
        return instance.typeTable.get(a);
    }
    public static void typeTablePut(String a , HashMap<String,FeatureMethod> b){
        instance.typeTable.put(a, b);
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
    public static void clear(){
        classes.clear();
        typeTable.clear();
        errorList.clear();
    }

}
