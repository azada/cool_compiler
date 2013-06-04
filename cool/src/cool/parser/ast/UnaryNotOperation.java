package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 6/3/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnaryNotOperation extends UnaryBooleanOperation{
    public UnaryNotOperation(ArrayList operands) {
        this.operandsList = operands;
    }

    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        Expr temp = ((Expr)(operandsList.get(0)));
        temp.check(pTable);
        if(!temp.expType.equals(BOOLEAN_TYPE)){
            result = false;
            Program.addError(new Exeption("the expression type for unary 'not' operation must boolean, it's "+ temp.expType ,this));
        }
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
