package es.weso.wirouter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import es.weso.wirouter.year.RangeYear;
import es.weso.wirouter.year.SingleYear;
import es.weso.wirouter.year.YearExpr;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class YearExprTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public YearExprTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( YearExprTest.class );
    }

    public void testSingleYear() throws Exception
    {
		List<YearExpr> list = new ArrayList<YearExpr>();
		list.add(new SingleYear(2009));

		String test = "2009" ;
		
        assertEquals(list.toString(),new YearRouteParser().parseRoute(test).toString());
    }

    public void testTwoYears() throws Exception
    {
		List<YearExpr> list = new ArrayList<YearExpr>();
		list.add(new SingleYear(2009));
		list.add(new SingleYear(2011));

		String test = "2009,2011" ;
		
        assertEquals(list.toString(),new YearRouteParser().parseRoute(test).toString());
    }

    public void testSingleRange() throws Exception
    {
		List<YearExpr> list = new ArrayList<YearExpr>();
		list.add(new RangeYear(2009,2011));

		String test = "range(2009-2011)" ;
		
        assertEquals(list.toString(),new YearRouteParser().parseRoute(test).toString());
    }

    public void testYearAndSingleRange() throws Exception
    {
		List<YearExpr> list = new ArrayList<YearExpr>();
		list.add(new SingleYear(2008));
		list.add(new RangeYear(2009,2011));

		String test = "2008,range(2009-2011)" ;
		
        assertEquals(list.toString(),new YearRouteParser().parseRoute(test).toString());
    }

    public void testTwoRanges() throws Exception
    {
		List<YearExpr> list = new ArrayList<YearExpr>();
		list.add(new RangeYear(2005,2007));
		list.add(new RangeYear(2011,2013));

		String test = "range(2005-2007),range(2011-2013)" ;
		
        assertEquals(list.toString(),new YearRouteParser().parseRoute(test).toString());
    }

    public void testBadRange() throws Exception
    {
		String test = "range(2011-2007)" ;
		try {
        String parsed = new YearRouteParser().parseRoute(test).toString();
		} catch (Exception e) {
		 assertEquals("Start year 2011 must be before 2007",e.getMessage());
		}
    }

    public void testFailGroup() throws Exception
    {
		String test = "a" ;
		try {
        String parsed = new YearRouteParser().parseRoute(test).toString();
		} catch (Exception e) {
		 assertEquals("Cannot parse year expression: a",e.getMessage());
		}
    }
    

}
