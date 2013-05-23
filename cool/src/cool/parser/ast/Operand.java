package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/18/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Operand extends Expr {
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
