package cool.parser.ast;

import beaver.Symbol;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Match extends Expr {
    Expr primary;
    ArrayList cases;
    public Match(Expr primary, ArrayList cases) {
        this.primary = primary;
        this.cases = cases;
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
