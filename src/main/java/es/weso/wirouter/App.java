package es.weso.wirouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



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
        System.out.print("Enter String:");
        String s = br.readLine();
        List<ComparableItem> ls = new WIRouter().parseRoute(s);
        System.out.println("Items = " + ls.toString());
    }
}
