package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;
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
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        boolean co = condition.check(pTable);
        boolean ex = elseExpr.check(pTable);
        boolean mx = mainExpr.check(pTable);
        result = result && co && ex && mx;

        // we should check if the main expr and the elseexp are the same type
        if (elseExpr.expType.equals(mainExpr.expType)){
            this.expType = mainExpr.expType;
        }
        else{
            String temp = Program.mutualParent(elseExpr.expType,mainExpr.expType);
            if (temp != null)
                this.expType = temp;
            else {
                Program.addError(new Exeption("the main expression and the else expression do not have a mutual parent" ,this));
                result = false;
            }
        }

        //To change body of implemented methods use File | Settings | File Templates.
        return result;
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
