package cool.parser.ast;

import cool.symbol.SymbolNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyOperation extends RealOperation {
    public MultiplyOperation(ArrayList operands) {
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
