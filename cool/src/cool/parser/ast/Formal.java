package cool.parser.ast;

import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/7/13
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Formal extends Node{
    String id;
    String type;

    public Formal(String id, String type) {
        this.id = id;
        this.type = type;
    }
    @Override
    public boolean check(SymbolNode pTable) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }

    @Override
    public void accept( ) {
        JSONLogger.openNode("formal");
        JSONLogger.attribute("id", id);
        JSONLogger.nextAttribute();
        JSONLogger.attribute("type", type);
        JSONLogger.closeNode();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
