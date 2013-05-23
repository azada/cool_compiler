package cool.parser.ast;

import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Case extends Node {
    String id;
    String type;
    Block block;

    public Case(String id, String type, Block block) {
        this.id = id;
        this.type = type;
        this.block = block;
    }

    public Case(Block block) {
        this.block = block;
    }

    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
