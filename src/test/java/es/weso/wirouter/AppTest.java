package es.weso.wirouter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testSingleCountry() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new CountryCode("es"));

		String test = "es" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testTwoCountries() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new CountryCode("es"));
		list.add(new CountryCode("fr"));

		String test = "es,fr" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testThreeCountries() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new CountryCode("es"));
		list.add(new CountryCode("fr"));
		list.add(new CountryCode("cn"));

		String test = "es,fr,cn" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testSingleRegion() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new NamedRegion("europe"));

		String test = "region(europe)" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testTwoRegions() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new NamedRegion("europe"));
		list.add(new NamedRegion("america"));

		String test = "region(europe),region(america)" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testCountryRegions() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		list.add(new NamedRegion("europe"));
		list.add(new NamedRegion("america"));
		list.add(new CountryCode("es"));

		String test = "region(europe),region(america),es" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testGroup() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		List<CountryCode> cs = new ArrayList<CountryCode>();
		cs.add(new CountryCode("cn"));
		cs.add(new CountryCode("ru"));
		list.add(new Grouping(cs));

		String test = "group(cn,ru)" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }

    public void testCombined() throws Exception
    {
		List<ComparableItem> list = new ArrayList<ComparableItem>();
		
		list.add(new CountryCode("es"));
		list.add(new CountryCode("fr"));
		list.add(new NamedRegion("europe"));

		List<CountryCode> cs = new ArrayList<CountryCode>();
		cs.add(new CountryCode("cn"));
		cs.add(new CountryCode("ru"));
		list.add(new Grouping(cs));

		String test = "es,fr,region(europe),group(cn,ru)" ;
		
        assertEquals(list.toString(),new WIRouter().parseRoute(test).toString());
    }


    public void testFailGroup() throws Exception
    {
		String test = "a(b)" ;
		try {
        String parsed = new WIRouter().parseRoute(test).toString();
		} catch (Exception e) {
		 assertEquals("Cannot parse route",e.getMessage());
		}
    }
    

}
