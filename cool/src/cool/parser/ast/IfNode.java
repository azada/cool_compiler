package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/5/13
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class IfNode extends Expr {

    Expr condition;
    Expr mainExpr;
    Expr elseExpr;


    public IfNode(Expr condition, Expr mainExpr, Expr elseExpr) {
        this.condition = condition;
        this.mainExpr = mainExpr;
        this.elseExpr = elseExpr;
    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
    @Override
    public void accept( ) {
        JSONLogger.openNode("if");
        JSONLogger.openNode("cond");
        condition.accept();
        JSONLogger.closeNode();
        JSONLogger.nextAttribute();
        JSONLogger.openNode("main-expr");
        mainExpr.accept();
        JSONLogger.closeNode();
        JSONLogger.nextAttribute();
        JSONLogger.openNode("else-expr");
        elseExpr.accept();
        JSONLogger.closeNode();

        JSONLogger.closeNode();
        //walker.visit(this);
    }
}
