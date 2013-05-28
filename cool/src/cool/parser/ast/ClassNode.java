package cool.parser.ast;

import java.util.ArrayList;
import java.util.HashMap;

import cool.symbol.*;
/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClassNode extends Node {

    String type;
    Extends ext;
    ArrayList varFormals;
    ArrayList featureList;
    boolean defined = true;
    SymbolNode symbolNode;

    public ClassNode(String type, ArrayList varFormals, Extends ext, ArrayList featureList) {
        this.ext = ext;
        this.type = type;
        this.varFormals = varFormals;
        this.featureList = featureList;
        symbolNode = new SymbolNode() ;
        symbolNode.type  = new String(type);


    }


    public boolean shallowCheck(SymbolNode pTable){
        boolean result = true;
        if (Program.getInstance().typeTableContains(type)){
            Program.addError(new Exeption("Class "+ type + " has already been declared" , this));
            defined = false;
            result = false;
        }
        else {
            Program.getInstance().typeTablePut(type, new HashMap<String, FeatureMethod>());
        }
        return result;
    }
    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        result = result && defined;
        for (int i=0 ; i<varFormals.size(); i++){
            boolean vf = ((Var)this.varFormals.get(i)).check(this.symbolNode);
            result = result && vf;
        }
        this.symbolNode.setParent(null);

        for (int i=0 ; i < this.featureList.size(); i++){
             boolean res = ((Feature)this.featureList.get(i)).check(this.symbolNode);
             result = result && res;
        }
        return result;
        //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public void accept() {
        JSONLogger.openNode("classdecl");
        JSONLogger.attribute("type", type);
        JSONLogger.nextAttribute();
        JSONLogger.openListAttribute("varformals");
        for (int i = 0; i < varFormals.size(); i++) {
            JSONLogger.openBrace();
            Var var = (Var)varFormals.get(i);
            var.accept();
            JSONLogger.closeBrace();
            if (i < (varFormals.size() - 1)) {
                JSONLogger.nextAttribute();
            }
        }
        JSONLogger.closeListAttribute();

        if (ext != null) {
            JSONLogger.nextAttribute();

            ext.accept();
        }
        //JSONLogger.closeListAttribute();
        JSONLogger.nextAttribute();
        JSONLogger.openListAttribute("classbody");
        for (int i=0; i< featureList.size(); i++) {
            Feature f = (Feature) featureList.get(i);
            JSONLogger.openBrace();
            f.accept();
            JSONLogger.closeBrace();
            if ( i < (featureList.size() - 1)) {
                JSONLogger.nextAttribute();
            }
        }
        JSONLogger.closeListAttribute();

        JSONLogger.closeNode();
    }
}
