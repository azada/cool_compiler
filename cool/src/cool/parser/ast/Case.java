package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Case extends Expr {
    String id;
    String type;
    Block block;
    boolean longInit = false;

    public Case(String id, String type, Block block) {
        this.id = id;
        this.type = type;
        this.block = block;
        longInit = true;
    }

    public Case(Block block) {
        this.block = block;
    }

    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        boolean bl = block.check(pTable);
        if (longInit){
            if (pTable.lookup(id) == null){
                Program.addError(new Exeption(id + "has not been defined before",this));
                result = false;
            }
            if (!pTable.lookup(id).getType().equals(type)){
                // if the id's type is not equal to type
                Program.addError(new Exeption("type Of " + id + " is not " + type,this));
                result = false;
            }
        }
        this.expType = block.expType;
        return result && bl;
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
