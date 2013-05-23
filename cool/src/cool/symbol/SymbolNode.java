package cool.symbol;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolNode {
    SymbolNode parent = null;
    ArrayList<SymbolNode> childList ;
    public SymbolTable table;

    public SymbolNode(SymbolNode parent) {
        this.parent = parent;
        table = new SymbolTable();
    }

    public SymbolNode() {
        table = new SymbolTable();
    }

    public SymbolItem lookup(String id){
        if (this.table.symbolTable.containsKey(id)){
            //now we return the symbolItem object
            return this.table.symbolTable.get(id);
        }
        else{
            if (this.parent == null){
                return null;
            }
            return parent.lookup(id);
        }
    }

    public void insert(SymbolItem symbolItem){
        table.symbolTable.put(symbolItem.id, symbolItem);
    }



}
