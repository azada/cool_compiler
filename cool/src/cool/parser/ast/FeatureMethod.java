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

        if ( Program.typeTableContains(pTable.type))
        {
            if (Program.getTableRow(pTable.type).containsKey(this.id)){
                Program.addError(new Exeption("method "+ this.id + " has duplicate definitions " , this));
                result = false;
            }
        }
        //we set the parent node to be the pTable
        this.symbolNode.setParent(pTable);
        Program.getInstance().getTableRow(pTable.type).put(id, type);
        for (int i = 0 ; i< formals.size() ; i++){
            boolean fml = ((Formal)formals.get(i)).check(this.symbolNode);
            result = result &&fml;
        }
        boolean express =  expr.check(this.symbolNode);

        ///////////////////////here we check if we return the correct type in methods ///////////////////////////////
//        System.out.println("expression type is" + expr.expType);
        if(!expr.expType.equals(type)){
            Program.addError(new Exeption("the type of this expression is not " + type ,this));
            result = false;
        }
        ////////////////////////////////////////////////////////////////
        result = result &&  express;
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
