package cool.parser.ast;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOperation extends RealOperation {
    public PlusOperation(ArrayList operands) {
        super(operands);
        this.expType = INTEGER_TYPE;
    }
}
