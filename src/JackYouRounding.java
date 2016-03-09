package src;
public class JackYouRounding
{
    public static void main (String[] args)
    {
	System.out.print (round (10.999999, 1));
    }


    public static double round (double input, int places)
    {
	double PRECISION = Math.pow (10, places);
	double output = Math.round (input * PRECISION) / PRECISION;
	return output;
    }
}
