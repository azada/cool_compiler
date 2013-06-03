package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolItem;
import cool.symbol.SymbolNode;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/8/13
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class VarExpr extends Expr {

    String id;
    String type;
    Expr expr;

    public VarExpr( String id, String type, Expr expr) {
        this.id = id;
        this.type = type;
        this.expr = expr;
        this.expType = UNIT_TYPE;
    }

    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        if (!Program.typeTableContains(type)){
            Program.addError(new Exeption("Type " + type + " has not been defined",this));
            result = false;
        }
        else {
            SymbolItem temp = new SymbolItem(id, type, false);
            pTable.insert(temp);
        }
        boolean ex = expr.check(pTable);
        if(!Program.getInstance().isConsistant(expr.expType, type)){
            Program.addError(new Exeption("the type of this expression is not " + type ,this));
            result = false;
        }
        return result && ex;
        //To change body of implemented methods use File | Settings | File Templates.

    }
    @Override
    public void accept( ) {
        JSONLogger.openNode("var");
        JSONLogger.attribute("id", id);
        JSONLogger.nextAttribute();
        JSONLogger.attribute("type", type);

        if (expr != null) {
            JSONLogger.nextAttribute();
            expr.accept();
        }

        //System.out.println("id:" + id + " type:" + type);
        JSONLogger.closeNode();
    }
}
