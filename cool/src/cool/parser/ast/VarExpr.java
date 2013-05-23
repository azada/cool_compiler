package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

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
    }

    @Override
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
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
