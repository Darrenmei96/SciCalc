package src;
//updated

import java.awt.*;
import java.applet.*;
import java.math.*;
import java.text.*;

public class CalculatorBrain {
    /*************
     * PRECISION
     *************/
    public static double PRECISION = 10;

    public static double round(double input) {
        //patented jack you rounding
        //rounds to x decimal places noted by "precision"
        return (Math.round(input * Math.pow(10, PRECISION)) / Math.pow(10, PRECISION));
    }


    public static String Addition(String value1, String value2) {
        //addition by adding the two parsed values together
        double tmp = Double.parseDouble(value1);
        double tmp2 = Double.parseDouble(value2);
        value1 = "" + (tmp + tmp2);
        //returns a string
        return value1;
    }


    public static String Subtraction(String value1, String value2) {
        //substraction by substracting the parsed values
        double tmp = Double.parseDouble(value1);
        double tmp2 = Double.parseDouble(value2);
        value1 = "" + (tmp - tmp2);
        //returns a string
        return value1;
    }


    public static String Multiplication(String value1, String value2) {
        //multiplication by multiplying the parsed values together
        double tmp = Double.parseDouble(value1);
        double tmp2 = Double.parseDouble(value2);
        value1 = "" + round(tmp * tmp2);
        //returns a string
        return value1;
    }


    public static String Division(String value1, String value2) {
        //division by dividing the parsed values together
        double tmp = Double.parseDouble(value1);
        double tmp2 = Double.parseDouble(value2);
        //check for division by zero
        if (tmp2 != 0)
            value1 = "" + round(tmp / tmp2);
        else
            value1 = "Error 1";
        //returns the rounded string
        return value1;
    }


    public static String Power(String value, String power) {
        //does powers using Java's built in Math.pow method
        double tmp = Double.parseDouble(value);
        double tmp2 = Double.parseDouble(power);
        //check for power of 0
        if (tmp2 == 0)
            value = "" + 1;
        else
            value = "" + round(Math.pow(tmp, tmp2));
        //returns the rounded answer
        return value;
    }


    public static String nthRoot(String value, String n) {
        //finds the nth root using java's math.pow method
        double tmp = Double.parseDouble(value);
        double tmp2 = Double.parseDouble(n);
        //check for n = 0
        if (tmp2 == 1)
            value = "" + tmp;
        else if (tmp2 == 0)
            value = "Error 1";
        else
            value = "" + round(Math.pow(tmp, (1 / tmp2)));
        //returns the rounded answer
        return value;
    }


    public static String Factorial(String value) {
        double tmp = Double.parseDouble(value);
        if (tmp % 1 == 0) {
            if (tmp > 100) {
                //because exact values at large factorials aren't necessary
                //yet accurate estimations are required for calculations,
                //we have a comprimise between speed, efficiency and scale
                //because the limits of the 'dumb' algorithm are it's speed
                //and it's limit of unable to do factorials of over 170


                //value = StirlingsApproximation (value);
                //stirling's approximation is a very good approximation for
                //factorials, however it returns a double and not in scientific
                //notation, hitting the double's limit of 2^31-1 fairly quickly

                //Factorial on steroids uses the squared difference product,
                //mathmatically done with logs and returns the exponents
                //and base using java's math.floor feature
                value = FactorialOnSteroids(value);
            } else {
                //'dumb' algorithm for factorial is accurate and slow
                double total = 1;
                for (long i = 2; i <= (long) tmp; i++)
                    total *= i;
                value = "" + total;
            }
        } else
            value = "Error 1";
        return value;
    }


    public static String FactorialOnSteroids(String value) {
        //sweet mother of god, this algorithm works even when factorials
        //are insanely big. Exponent surpasses base's digit count in some cases
        //uses the squared diff product for factorization, done in logs
        //an accurate approximation of factorial up to around 1,000,000,000!
        //then falls off due to inaccuracies in the algorithm
        //A better algorithm would use Steieltjes' continued fractions to
        //produce an approximation with unlimited precision
        long exp = 0;
        double fact = Double.parseDouble(value);
        fact = 2 * fact + 1;
        fact = (Math.log(2 * Math.PI) + (Math.log(fact / 2) * fact) - fact - (1 - 7 / (30 * fact * fact)) / (6 * fact)) / 2;
        fact = fact / Math.log(10);
        exp = (long) Math.floor(fact);
        fact = Math.pow(10, fact - exp);
        return "" + round(fact) + "E" + exp;
    }


    public static long factorial(int base) {
        //works up to around 100 efficiently, errors at 171 due to limits of java
        long result = base;
        for (int i = (base - 1); i >= 2; i--)
            result *= i;
        return result;
    }


    public static String StirlingsApproximation(String value) {
        //An amazing approximation of factorial which if x->infinity,
        //the formula becomes 100% accurate if done with a factorial calculation
        //the limit of this algorithm is java's double limit, which wouldn't be
        //a problem if the approximation was done with logs
        int tmp = Integer.parseInt(value);
        return "" + (Math.sqrt(2 * Math.PI * tmp) * Math.pow((tmp / Math.E), tmp));
    }


    public static String Reciprocal(String value) {
        //calculate the reciprocal of a value by raising it to the exponent -1
        double tmp = Double.parseDouble(value);
        if (tmp != 0)
            value = "" + round(1 / tmp);
        else
            value = "Error 1";
        //returns a rounded value
        return value;
    }


    public static String Sine(String value, byte mode) {
        double tmp = Double.parseDouble(value);
        //check for critical points: 0,pi/2,pi/3,pi/6,pi and such
        boolean criticalpoint = false;
        if (mode == 1) {
            tmp = tmp % 360;
            if (tmp == 0 || tmp == 180 || tmp == 360) {
                criticalpoint = true;
                tmp = 0;
            } else if (tmp == 90) {
                criticalpoint = true;
                tmp = Math.PI / 2;
            } else if (tmp == 270) {
                criticalpoint = true;
                tmp = 3 * Math.PI / 2;
            } else if (tmp == 45 || tmp == 135) {
                criticalpoint = true;
                tmp = Math.PI / 4;
            } else if (tmp == 225 || tmp == 315) {
                criticalpoint = true;
                tmp = 5 * Math.PI / 4;
            } else if (tmp == 30 || tmp == 150) {
                criticalpoint = true;
                tmp = Math.PI / 6;
            } else if (tmp == 210 || tmp == 330) {
                criticalpoint = true;
                tmp = 7 * Math.PI / 6;
            } else if (tmp == 60 || tmp == 120) {
                criticalpoint = true;
                tmp = Math.PI / 3;
            } else if (tmp == 240 || tmp == 300) {
                criticalpoint = true;
                tmp = 4 * Math.PI / 3;
            } else
                tmp *= (Math.PI / 180);
        } else if (mode == 2) {
            tmp = tmp % (2 * Math.PI);
        } else if (mode == 3)
            tmp *= (Math.PI / 200);
        double sinx = 0;
        if (criticalpoint) {
            if (tmp == Math.PI / 2)
                sinx = 1;
            else if (tmp == 0)
                sinx = 0;
            else if (tmp == 3 * Math.PI / 2)
                sinx = -1;
            else if (tmp == Math.PI / 4)
                sinx = Math.sqrt(2) / 2;
            else if (tmp == 5 * Math.PI / 4)
                sinx = -Math.sqrt(2) / 2;
            else if (tmp == Math.PI / 6)
                sinx = 0.5;
            else if (tmp == 7 * Math.PI / 6)
                sinx = -0.5;
            else if (tmp == Math.PI / 3)
                sinx = Math.sqrt(3) / 2;
            else if (tmp == 4 * Math.PI / 3)
                sinx = -Math.sqrt(3) / 2;
            else
                sinx = 0;
        } else {
            //use the sine taylor series to calculate sine
            long factorial = 1;
            sinx = tmp;
            byte lol = 1;
            for (int i = 1; i != 0; i++) {
                factorial *= i;
                if (i != 1 && i % 2 != 0)
                    if (Math.pow(Math.abs(tmp), i) / factorial < 10E-15)
                        break;
                    else {
                        sinx -= lol * (Math.pow(tmp, i) / factorial);
                        lol *= -1;
                    }
            }
        }
        //return the rounded answer
        return "" + round(sinx);
    }


    public static String Cosine(String value, byte mode) {
        double tmp = Double.parseDouble(value);
        //check for critical points: 0,pi/2,pi/3,pi/6,pi and such
        boolean criticalpoint = false;
        if (mode == 1) {
            tmp = tmp % 360;
            if (tmp == 0 || tmp == 360) {
                criticalpoint = true;
                tmp = 0;
            } else if (tmp == 180) {
                criticalpoint = true;
                tmp = Math.PI;
            } else if (tmp == 90 || tmp == 270) {
                criticalpoint = true;
                tmp = Math.PI / 2;
            } else if (tmp == 45 || tmp == 315) {
                criticalpoint = true;
                tmp = Math.PI / 4;
            } else if (tmp == 225 || tmp == 135) {
                criticalpoint = true;
                tmp = 5 * Math.PI / 4;
            } else if (tmp == 30 || tmp == 330) {
                criticalpoint = true;
                tmp = Math.PI / 6;
            } else if (tmp == 210 || tmp == 150) {
                criticalpoint = true;
                tmp = 7 * Math.PI / 6;
            } else if (tmp == 60 || tmp == 300) {
                criticalpoint = true;
                tmp = Math.PI / 3;
            } else if (tmp == 240 || tmp == 120) {
                criticalpoint = true;
                tmp = 4 * Math.PI / 3;
            } else
                tmp *= (Math.PI / 180);
        } else if (mode == 2) {
            tmp = tmp % (2 * Math.PI);
        } else if (mode == 3)
            tmp *= (Math.PI / 200);
        double cosx = 0;
        if (criticalpoint) {
            if (tmp == Math.PI / 2)
                cosx = 0;
            else if (tmp == 0)
                cosx = 1;
            else if (tmp == 3 * Math.PI / 2)
                cosx = -1;
            else if (tmp == Math.PI / 4)
                cosx = Math.sqrt(2) / 2;
            else if (tmp == 5 * Math.PI / 4)
                cosx = -Math.sqrt(2) / 2;
            else if (tmp == Math.PI / 6)
                cosx = Math.sqrt(3) / 2;
            else if (tmp == 7 * Math.PI / 6)
                cosx = -Math.sqrt(3) / 2;
            else if (tmp == Math.PI / 3)
                cosx = 0.5;
            else if (tmp == 4 * Math.PI / 3)
                cosx = -0.5;
            else
                cosx = 0;
        } else {
            //calculate cosine with the taylor series for cosine
            long factorial = 1;
            cosx = 1;
            byte lol = 1;
            for (int i = 1; i != 0; i++) {
                factorial *= i;
                if (i != 1 && i % 2 == 0)
                    if (Math.pow(Math.abs(tmp), i) / factorial < 10E-15)
                        break;
                    else {
                        cosx -= lol * (Math.pow(tmp, i) / factorial);
                        lol *= -1;
                    }
            }
        }
        //return the rounded cosine value
        return "" + round(cosx);
    }


    public String Tangent(String value, byte mode) {
        //simply sine/cosine
        double tmp1 = Double.parseDouble(Sine(value, mode));
        double tmp2 = Double.parseDouble(Cosine(value, mode));
        //check for cosx = 0
        if (tmp2 == 0)
            value = "Error 1";
        else
            value = "" + round((tmp1 / tmp2));
        //return the rounded tangent answer
        return value;
    }


    public static String LogarithmBase10(String value) {
        //calculate logarithms in base 10
        double tmp = Double.parseDouble(value);
        if (tmp == 0)
            value = "Error 1";
        else
            //use change of base formula, logbX = logaX/logaB
            value = "" + round(Math.log(tmp) / Math.log(10));
        //return the rounded value
        return value;
    }


    public static String NaturalLogarithm(String value) {
        //calculate logarithms in base e
        double tmp = Double.parseDouble(value);
        if (tmp == 0)
            value = "Error 1";
        else
            //calculate logeX
            value = "" + round(Math.log(tmp));
        //return the rounded value
        return value;
    }


    public static String LogarithmBasex(String Base, String value) {
        //not in current use, but works
        double tmp = Double.parseDouble(value);
        double tmp2 = Double.parseDouble(Base);
        if (tmp == 0 || tmp2 == 0 || tmp2 == 1)
            value = "Error 1";
        else
            //change of base formula
            value = "" + round(Math.log(tmp) / Math.log(tmp2));
        //return rounded value
        return value;
    }


    public static String Modulo(String value1, String value2) {
        //modulo is the remainer of a division
        double tmp = Double.parseDouble(value1);
        double tmp2 = Double.parseDouble(value2);
        //check for division of 0
        if (tmp2 == 0)
            value1 = "Error 2";
        else if (tmp2 == 1)
            ;
        else
            value1 = "" + round(tmp % tmp2);
        return value1;
    }


    public static String TenToTheX(String value) {
        double tmp = Double.parseDouble(value);
        return "" + round(Math.pow(10, tmp));
    }


    public static String arcSine(String value, byte mode) {
        //we were supposed to use the taylor series for arcsine but
        //the accuracy of the calculation was comprimised by the limits
        //of the significant digits in the double, hit the size limit as well
        double answer = Math.asin(Double.parseDouble(value));
        //defaults to radian mode
        if (mode == 1)
            answer *= 180 / Math.PI;
        else if (mode == 3)
            answer *= 200 / Math.PI;
        return "" + round(answer);
    }


    public static String arcCosine(String value, byte mode) {
        //we were supposed to use the taylor series for arcosine but
        //the accuracy of the calculation was comprimised by the limits
        //of the significant digits in the double, hit the size limit as well
        double answer = Math.acos(Double.parseDouble(value));
        //defaults to radian mode
        if (mode == 1)
            answer *= 180 / Math.PI;
        else if (mode == 3)
            answer *= 200 / Math.PI;
        return "" + round(answer);
    }


    public static String arcTangent(String value, byte mode) {
        //we were supposed to use the taylor series for arctangent but
        //the accuracy of the calculation was comprimised by the limits
        //of the significant digits in the double, hit the size limit as well
        double answer = Math.atan(Double.parseDouble(value));
        //defaults to radian mode
        if (mode == 1)
            answer *= 180 / Math.PI;
        else if (mode == 3)
            answer *= 200 / Math.PI;
        return "" + round(answer);
    }


    public static String ScientificNotation(String input) {
        //uses decimalformat to enable formatting of the string
        //to convert it into scientific notation
        double tmp = Double.parseDouble(input);
        DecimalFormat f = new DecimalFormat("#.##################E0");
        input = f.format(tmp);
        return "" + input;
    }


    public static String FixNotation(String input) {
        //uses decimalformat to enable formatting of the string
        //to convert it into fix notation or opposite of scientific notation
        double tmp = Double.parseDouble(input);
        DecimalFormat f = new DecimalFormat("############################.##################");
        input = f.format(tmp);
        return "" + input;
    }


    public static String FractionalNotation(String input) {
        //doesn't work, broken as of 2013-12-11
        double tmp = Double.parseDouble(input);
        int precision = 0;
        //count number of precision units for calculations
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                precision = input.length() - i;
                break;
            }
        }
        double[] tmp2 = new double[precision];
        for (int i2 = 0; i2 < precision; i2++) {
            if (i2 == 0)
                tmp2[i2] = tmp - (int) tmp;
            else {
                if (tmp2[i2 - 1] % 1 != 0)
                    tmp2[i2] = round(Math.pow(tmp2[i2 - 1] - (int) tmp2[i2 - 1], -1));
                else
                    tmp2[i2] = 1;
            }
        }
        double[] tmp3 = new double[precision];
        int toppart = 0;
        int botpart = 1;
        for (int i3 = precision - 1; i3 >= 0; i3--) {
            tmp3[i3] = 1 / 1; //fix this part
        }
        return "" + round(tmp % 1);
    }


    public static String NaturalNumberToTheX(String input) {
        //e^x using series to calculate e^1 then using math.pow(e^1,x)
        //to find e^x
        double power = Double.parseDouble(input);
        double bot = 0;
        double e = 2;
        for (int i = 2; i != 0; i++) {
            bot = factorial(i);
            if ((1 / bot) / e < 10E-15)
                break;
            else
                e = e + (1 / bot);
        }
        return "" + round(Math.pow(e, power));
    }


    public static String HyperbolicSine(String input) {
        //uses the formula hsinx = (e^x-e^-x)x
        double parta = Double.parseDouble(NaturalNumberToTheX(input));
        double partb = Double.parseDouble(NaturalNumberToTheX("-" + input));
        return "" + round((parta - partb) / 2);
    }


    public static String HyperbolicCosine(String input) {
        //uses the formula hcosx = (e^x+e^-x)x
        double parta = Double.parseDouble(NaturalNumberToTheX(input));
        double partb = Double.parseDouble(NaturalNumberToTheX("-" + input));
        return "" + round((parta + partb) / 2);
    }


    public static String HyperbolicTangent(String input) {
        //hsinx/hcosx = htanx
        double parta = Double.parseDouble(HyperbolicSine(input));
        double partb = Double.parseDouble(HyperbolicCosine(input));
        return "" + round(parta / partb);
    }


    public static String Mean(String[] input) {
        //mean = total/#
        double total = 0;
        for (int i = 0; i < input.length; i++)
            total += Double.parseDouble(input[i]);

        return "The mean is " + round(total / input.length);
    }


    public static String Mode(String[] input) {
        //find the highest count of the same number
        //if loop completes, returns the highest count and the number
        //holding that count
        double key = 0;
        int highestcount = 0;
        for (int i = 0; i < input.length; i++) {
            int counter = 0;
            for (int i2 = 0; i2 < input.length; i2++)
                if (input[i2] == input[i])
                    counter++;
            if (counter > highestcount) {
                highestcount = counter;
                key = Double.parseDouble(input[i]);
            }
        }
        return "The mode is " + key + " with a total of :" + highestcount + " counts";
    }


    public static String Median(String[] input) {
        //too lazy
        return "";
    }


    public static String DerivativeParser(String input) {
        // work in progress, may never be finished
        // too much thinking required
        String output = "";
        return output;
    }


    public static String TheConstantRule(String input) {
        // dy/dx of c = 0
        return "0";
    }


    public static String TheConstantMultipleRule(String input) {
        // dy/dx of a(b) is a * ((dy/dx) b )
        return "";
    }


    public static String TheMultipleRule(String input) {
        // dy/dx of ab is a*((dy/dx) (ab))
        return "";
    }


    public static String TheSumRule(String input) {
        // dy/dx of (f(x)+g(x)) is f'(x)+g'(x)
        return "";
    }


    public static String ThePowerRule(String input) {
        // dy/dx of b^n is nb^(n-1)
        return "";
    }


    public static String TheProductRule(String input) {
        // dy/dx of f(x)g(x) is g(x)f'(x) + g'(x)f(x)
        return "";
    }


    public static String TheQuotientRule(String input) {
        // dy/dx of f(x)/g(x) is (g(x)f'(x) - g'(x)f(x))/(g(x))^2
        return "";
    }


    public static String TheChainRule(String input) {
        // dy/dx of f(g(x)) is f'(x)g(x)*g'(x)
        return "";
    }
}
