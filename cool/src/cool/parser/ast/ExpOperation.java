package cool.parser.ast;

import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/18/13
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExpOperation extends Expr {
    ArrayList operandsList;

    public ExpOperation(ArrayList operandsList) {
        this.operandsList = operandsList;
    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }

    @Override
    public void accept() {
        JSONLogger.openNode("expr");
        if (value != null)JSONLogger.attribute("value", value.toString());
        JSONLogger.closeNode();
    }
}
