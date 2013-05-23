package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/7/13
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanNode extends Primary {
    public Boolean value;

    public BooleanNode( Boolean value) {
        this.value = value;
    }

    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
        JSONLogger.openNode("expr");
        JSONLogger.closeNode();

    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
