package cool.parser.ast;

import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuperActual extends Expr {
    ArrayList actuals;

    public SuperActual(ArrayList actuals) {
        this.actuals = actuals;
    }

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
