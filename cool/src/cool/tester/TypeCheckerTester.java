package cool.tester;

import beaver.Parser;
import cool.MyCoolParser;
import cool.parser.ast.Program;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: azada
 * Date: 5/22/13
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeCheckerTester extends TestCase{
    public void testClassNode() {
        System.out.println("TypeCheckerTester.testClassNode");
        try {
            FileInputStream file = new FileInputStream("testcases/TestClassNode.cool");
            MyCoolParser parser = new MyCoolParser(file);
            parser.parse2();

            if (!parser.checker()){
                Program.printErrors();
            }
            else {
                Program.printErrors();
            }


            Assert.assertTrue(true);

        } catch (FileNotFoundException e) {
            Assert.assertTrue(false);
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Parser.Exception e ) {
            System.out.println("e = " + e);
            Assert.assertTrue(false);
        }
    }
}
