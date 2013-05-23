package cool.parser.ast;

import beaver.Symbol;

/**
 * Created with IntelliJ IDEA.
 * User: pedram
 * Date: 4/16/13
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Expr extends Node {
    public static final int BOOLEAN_TYPE = 1;
    public static final int INTEGER_TYPE = 2;
    public static final int STRING_TYPE = 3;

    int expType;

}

