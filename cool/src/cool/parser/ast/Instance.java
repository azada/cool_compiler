package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Instance extends Primary {
    String Type;
    ArrayList actuals;
    public Instance(String Type, ArrayList actuals) {
        this.Type = Type;
        this.actuals = actuals;

    }

    public Instance(String type) {
        Type = type;
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
