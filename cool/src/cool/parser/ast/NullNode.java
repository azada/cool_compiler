package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/8/13
 * Time: 12:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class NullNode extends Primary {
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
    @Override
    public void accept( ) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
