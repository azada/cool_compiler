package cool.parser.ast;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DivisionOperation extends RealOperation {
    public DivisionOperation(ArrayList operands) {
        super(operands);
        this.expType = INTEGER_TYPE;
    }
}
