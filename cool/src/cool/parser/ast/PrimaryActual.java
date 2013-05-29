package cool.parser.ast;

import cool.symbol.Exeption;
import cool.symbol.SymbolNode;
import cool.symbol.SymbolTable;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/19/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimaryActual extends Expr {
    ArrayList actuals;
    Primary primary ;
    String id ;

    public PrimaryActual(ArrayList actuals, Primary primary, String id) {
        this.actuals = actuals;
        this.primary = primary;
        this.id = id;
    }
    @Override
    public boolean check(SymbolNode pTable) {
        // we should check the Type of primary and make sure it has an id with this method.
        boolean result = true;
        if (Program.getInstance().getTableRow(primary.expType)!= null){
            if (!Program.getInstance().getTableRow(primary.expType).containsKey(id)){
                 Program.addError(new Exeption("type " + primary.expType + " doesn't have method " + id ,this));
                result = false;

            }
        }
        else{
            Program.addError(new Exeption("there is no such type "+ primary.expType + " defined",this));
            result = false;
        }

        // now we should check the actuals
        for (int i=0 ; i<actuals.size(); i++){
            boolean ac = ((Expr)this.actuals.get(i)).check(pTable);
            result = result && ac;
        }
        FeatureMethod temp = Program.getInstance().getTableRow(primary.expType).get(id);

        // we should make sure we have the same number of actuals and formals in method declaration
        if (temp.formals.size() != actuals.size()){
            Program.addError(new Exeption(temp.formals.size()+ " number of argmument needed and " + actuals + " are given",this));
            result = false;
        }
        //and make sure we have the same type in actuals as we had in feature methods.
        for (int i = 0 ; i< temp.formals.size() ; i++){
            if (!((Expr)actuals.get(i)).expType.equals(((Formal)(temp.formals.get(i))).type)){
                Program.addError(new Exeption("type of actuals doesn't match argument list defined in the method",this));
                result = false;
            }
        }
        this.expType = temp.type;
        //To change body of implemented methods use File | Settings | File Templates.
        return result;
    }


    @Override
    public void accept() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
