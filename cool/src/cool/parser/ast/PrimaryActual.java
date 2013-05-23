package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimaryActual extends Expr {
    ArrayList actuals;
    public PrimaryActual(ArrayList actuals) {
        this.actuals = actuals;
    }
    @Override
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }

    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
