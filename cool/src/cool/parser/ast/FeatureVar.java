package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureVar extends Feature {
    String id;
    Boolean isNative = false;
    String type;
    Expr expr;

    public FeatureVar(String id) {
        this.id = id;
        isNative = true;

    }


    public  FeatureVar(String id, String type, Expr expr) {
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
    public void accept() {
        JSONLogger.openNode("feature");
        JSONLogger.attribute("id", id);
        JSONLogger.nextAttribute();
        if (isNative) {
            JSONLogger.attribute("native", "true");
        } else {
            JSONLogger.attribute("type", type);
            JSONLogger.nextAttribute();
            expr.accept();
        }
        JSONLogger.closeNode();
        //walker.visit(this);
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
