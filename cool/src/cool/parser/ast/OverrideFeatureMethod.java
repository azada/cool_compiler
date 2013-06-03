/**
* *
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 6/2/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
package cool.parser.ast;
import cool.symbol.Exeption;
import cool.symbol.SymbolNode;

import java.util.ArrayList;



/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/4/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class OverrideFeatureMethod extends FeatureMethod {

    public OverrideFeatureMethod(String id, ArrayList formals, String type, Expr expr ) {
        super(id, formals, type, expr);

    }
    @Override
    public boolean check(SymbolNode pTable) {
        boolean result = true;
        if (Program.typeTableContains(pTable.type))
        {
            if (Program.getInstance().getTableRow(pTable.type).containsKey(id)){
                Program.addError(new Exeption("method "+ this.id + " has duplicate definitions " , this));
                result = false;
            }
            else{
                Program.getInstance().getTableRow(pTable.type).put(id, this);
            }
        }
        else{
            Program.addError(new Exeption("the scope for this class has not been defined",this));
        }

        //we set the parent node to be the pTable
        this.symbolNode.setParent(pTable);
        for (Object formal : formals) {
            boolean fml = ((Formal) formal).check(this.symbolNode);
            result = result && fml;
        }
        boolean express =  expr.check(this.symbolNode);

        ///////////////////////here we check if we return the correct type in methods ///////////////////////////////
//        System.out.println("expression type is" + expr.expType);
        if(!expr.expType.equals(type)){
            Program.addError(new Exeption("the return type of this expression is not " + type ,this));
            result = false;
        }
        ////////////////////////////////////////////////////////////////
        result = result &&  express;
        return result;
    }
}
