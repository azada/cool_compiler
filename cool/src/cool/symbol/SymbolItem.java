package cool.symbol;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/21/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolItem {
    String id;
    String Type;
    boolean init;

    public SymbolItem(String id, String type, boolean init) {
        this.id = id;
        Type = type;
        this.init = init;
    }
}
