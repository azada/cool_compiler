package cool.parser.ast;

import cool.symbol.SymbolTable;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 5/7/13
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureBlock extends Feature {



    Block block;

    public FeatureBlock(Block block) {
        this.block = block;

    }
    @Override
    public boolean check(SymbolTable table) {
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }

    @Override
    public void accept( ) {
        JSONLogger.openNode("feature");
        JSONLogger.attribute("type", "block");
        JSONLogger.nextAttribute();
        //JSONLogger.openBrace();
        block.accept();
        //JSONLogger.closeBrace();
        JSONLogger.closeNode();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
