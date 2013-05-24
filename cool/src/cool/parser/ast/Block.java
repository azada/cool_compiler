package cool.parser.ast;

import cool.symbol.SymbolNode;
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
    SymbolNode symbolNode ;

    public Block(ArrayList exprList, Expr end) {
        this.exprList = exprList;
        this.exprList.add(end);
        this.expType = end.expType;
        symbolNode = new SymbolNode();
    }


    @Override
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        boolean result = true;
        this.symbolNode.setParent(pTable);
        for (int i = 0; i < exprList.size(); i++) {
            boolean el = ((Expr)(exprList.get(i))).check(symbolNode);
            result = result && el;
        }
        return result;
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

}
