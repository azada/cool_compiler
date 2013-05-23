package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Extends extends Node{

    String type;
    ArrayList actuals;

    boolean native_type;


    public Extends(String type, ArrayList actuals) {
        this.type = type;
        this.actuals = actuals;
    }


    public Extends() {
        this.native_type = true;
    }
    @Override
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
    @Override
    public void accept( ) {
        JSONLogger.openNode("extends");
        JSONLogger.attribute("type", type);

        JSONLogger.closeNode();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
