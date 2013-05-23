package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Var extends Node {
    String id;
    String type;

    Expr expr;

    public Var( String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Var( String id, String type, Expr expr) {
        this.id = id;
        this.type = type;
        this.expr = expr;
    }
    @Override
    public boolean check(SymbolTable table) {
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
            expr.accept();
        }

        //System.out.println("id:" + id + " type:" + type);
        JSONLogger.closeNode();
    }
}
