package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/7/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Id extends Primary {
    String name;

    public Id(String name) {
        this.name = name;
    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }

    @Override
    public void accept( ) {

    }
}
