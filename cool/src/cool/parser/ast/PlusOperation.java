package cool.parser.ast;

import cool.symbol.SymbolNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOperation extends RealOperation {
    public PlusOperation(ArrayList operands) {

        this.expType = INTEGER_TYPE;
    }
    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean check(SymbolNode pTable) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
