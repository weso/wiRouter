package es.weso.wirouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import es.weso.wirouter.country.CountryExpr;
import es.weso.wirouter.year.SingleYear;
import es.weso.wirouter.year.YearExpr;



/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Trying WIRoute" );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Country Expr:");
        String s = br.readLine();
        List<CountryExpr> ls = new CountryRouteParser().parseRoute(s);
        System.out.println("Items = " + ls.toString());
        
        SingleYear a = new SingleYear(2009);
        System.out.println("Single year =" + a);
        
        System.out.print("Enter Year Expr:");
        s = br.readLine();
        List<YearExpr> ys = new YearRouteParser().parseRoute(s);
        System.out.println("Items = " + ys.toString());
        
    }
}
