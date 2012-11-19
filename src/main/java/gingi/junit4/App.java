package gingi.junit4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        double result = calculator.add(20, 30);
        System.out.println(result);
    }
}
