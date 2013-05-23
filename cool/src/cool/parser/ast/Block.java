package cool.parser.ast;

import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/7/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Block extends Expr {

    ArrayList exprList;

    public Block(ArrayList exprList, Expr end) {
        this.exprList = exprList;
        this.exprList.add(end);
        this.expType = end.expType;
    }


    @Override
    public void accept() {
        JSONLogger.openListAttribute("block");
        for (int i = 0; i < exprList.size(); i++) {
            JSONLogger.openBrace();
            Expr expr = (Expr) exprList.get(i);
            expr.accept();
            JSONLogger.closeBrace();
            if ( i < (exprList.size() - 1)) {
                JSONLogger.nextAttribute();
            }
        }
        JSONLogger.closeListAttribute();
        //To change body of implemented methods use File | Settings | File Templates.
    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}