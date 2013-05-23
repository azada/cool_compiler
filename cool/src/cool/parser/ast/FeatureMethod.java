package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureMethod extends Feature {

    String id;
    ArrayList formals;
    String type;
    Expr expr;

    public FeatureMethod(String id, ArrayList formals, String type, Expr expr ) {
        this.id = id;
        this.formals = formals;
        this.type = type;
        this.expr = expr;
        symbolNode = new SymbolNode();

    }
    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        //first we make sure it hasn't been defined before
        if ( Program.typeTable.containsKey(pTable.type))
        {
            if (Program.typeTable.get(pTable.type).containsKey(this.id)){
                System.out.println("hello");
                Program.addError(new Exeption("method "+ this.id + " has douplicate definitions "));
                result = false;
            }
        }
        Program.getInstance().typeTable.get(pTable.type).put(id, type);
        for (int i = 0 ; i< formals.size() ; i++){
            ((Formal)(formals.get(i))).symbolNode.setParent(this.symbolNode);
            result = result && ((Formal)formals.get(i)).check(this.symbolNode);
        }
        result = result && expr.check(this.symbolNode);
        return result;
    }
    @Override
    public void accept( ) {
        JSONLogger.openNode("feature");

        JSONLogger.attribute("id", id);
        JSONLogger.nextAttribute();
        JSONLogger.attribute("type", type);
        JSONLogger.nextAttribute();
        JSONLogger.openListAttribute("formals");
        for ( int i=0; i < formals.size(); i++ ) {
            Formal f = (Formal) formals.get(i);
            JSONLogger.openBrace();
            f.accept();
            JSONLogger.closeBrace();
            if ( i < (formals.size() - 1)) {
                JSONLogger.nextAttribute();
            }
        }
        JSONLogger.closeListAttribute();
        JSONLogger.nextAttribute();
        expr.accept();
        JSONLogger.closeNode();

        //To change body of implemented methods use File | Settings | File Templates.
    }
}
