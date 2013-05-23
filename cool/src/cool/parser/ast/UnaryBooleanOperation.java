package cool.parser.ast;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnaryBooleanOperation extends UnaryOperation {
    public UnaryBooleanOperation(ArrayList operands) {
        super(operands);
    }

    @Override
    public void accept() {
        JSONLogger.openNode("expr");
        JSONLogger.closeNode();
    }
}
