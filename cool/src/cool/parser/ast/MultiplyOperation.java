package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/20/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyOperation extends RealOperation {
    public MultiplyOperation(ArrayList operands) {
        this.expType = INTEGER_TYPE;
        operandsList = operands;
    }
    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        for (Object operand : operandsList) {
            boolean fml = ((Expr) operand).check(pTable);
            result = result && fml;
        }

        if (((Expr)(operandsList.get(1))).expType.equals(((Expr)(operandsList.get(0))).expType)){
            if (!((Expr)(operandsList.get(1))).expType.equals(INTEGER_TYPE)){
                Program.addError(new Exeption("one or two sides of the operation is not integer",this));
                result = false;
            }
        }
        else{
            Program.addError(new Exeption("two sides of the operation do not have the same type",this));
            result = false;
        }

        this.expType = INTEGER_TYPE;
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
