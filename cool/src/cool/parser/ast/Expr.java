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
    public static final String BOOLEAN_TYPE = "Boolean";
    public static final String INTEGER_TYPE = "Int";
    public static final String STRING_TYPE = "String";
    public static final String OBJECT_TYPE = "Object";

    String expType;

}

