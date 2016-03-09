package src;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet;
import javax.swing.*;


//WRITTEN BY: JACK YOU AND DARREN MEI
//DATE COMPLETED: 10/12/13
//PROGRAM DETAILS: SCIENTIFIC CALCULATOR IN APPLET

public class mainMethod extends Applet implements ItemListener
{


    public CalculatorBrain calculate = new CalculatorBrain ();
    public JackYouRounding jack = new JackYouRounding ();
    public Colours colours = new Colours ();

    public char[] listofoperators = {'+', '-', '/', '*', '^', '%', (char) 8730};

    public String output = "0.";
    public String operation = "";
    public long outputholder = 0;
    public double outputholderdouble = 0.0;

    public boolean hasOperator = false;
    public boolean hasDecimal = true;
    public boolean hasEqual = false;

    public boolean isNegative = false;
    public boolean zeroFirst = true;
    public boolean evaluated = false;
    public byte anglemode = 1;

    public String pie = "" + (char) 960;

    /***************OPERATORS***************/
    public boolean binaryFormat = false;
    public boolean decimalFormat = true;
    public boolean octalFormat = false;
    public boolean hexadecimalFormat = false;
    public boolean decimalOn = false;

    /****************INPUT******************/
    public JTextField operationLine = new JTextField (operation);
    public JTextField outputLine = new JTextField (output);
    public Button one = new Button ("1");
    public Button two = new Button ("2");
    public Button three = new Button ("3");
    public Button four = new Button ("4");
    public Button five = new Button ("5");
    public Button six = new Button ("6");
    public Button seven = new Button ("7");
    public Button eight = new Button ("8");
    public Button nine = new Button ("9");
    public Button zero = new Button ("0");
    public Button add = new Button ("+");
    public Button subtract = new Button ("-");
    public Button multiply = new Button ("*");
    public Button divide = new Button ("/");
    public Button pow = new Button ("x^y");
    public Button equals = new Button ("=");
    public Button decimalpoint = new Button (".");
    public Button negative = new Button ("" + (char) 177);
    public Button factorial = new Button ("!");
    public Button sine = new Button ("sin");
    public Button cosine = new Button ("cos");
    public Button tangent = new Button ("tan");
    public Button reciprocal = new Button ("1/x");
    public Button root = new Button ("" + (char) 8730);
    public Button mod = new Button ("%");
    public Button ln = new Button ("ln");
    public Button log = new Button ("log");
    public Button logx = new Button ("logx");
    public Button pi = new Button (pie);
    /****************INPUT******************/

    /****************TOOLS******************/
    public CheckboxGroup planes = new CheckboxGroup ();
    Checkbox degrees = new Checkbox ("Deg", planes, true);
    Checkbox radians = new Checkbox ("Rad", planes, false);
    Checkbox gradians = new Checkbox ("Gra", planes, false);
    public Button tenx = new Button ("10^x");
    public Button C = new Button ("C");
    public Button CE = new Button ("CE");
    public Button backspace = new Button ("<--");
    public Button binary = new Button ("bin");
    public Button octal = new Button ("oct");
    public Button hex = new Button ("hex");
    public Button decimal = new Button ("dec");
    public Button sci = new Button ("sci");
    public Button fix = new Button ("fix");
    public Button etox = new Button ("e^x");
    public Button cubedroot = new Button ("" + (char) 179 + (char) 8730);
    public Button squared = new Button ("x" + (char) 178);
    public Button cubed = new Button ("x" + (char) 179);
    public Button arcsine = new Button ("sin^-1");
    public Button arccosine = new Button ("cos^-1");
    public Button arctangent = new Button ("tan^-1");
    public Button hypsine = new Button ("sinh");
    public Button hypcosine = new Button ("cosh");
    public Button hyptangent = new Button ("tanh");
    public Button random = new Button ("rand");
    public Button yroot = new Button ("y" + (char) 8730);
    public Button Exp = new Button ("E");
    public Button Int = new Button ("Int");
    public Button Frac = new Button ("Frac");
    /****************TOOLS******************/

    public void init ()
    {


	setName ("Calculator");
	setSize (275, 275);
	setBackground (Colours.ivory);
	operationLine.setEditable (false);
	operationLine.setBorder (BorderFactory.createMatteBorder (0, 0, 0, 0, Color.white));
	outputLine.setEditable (false);
	outputLine.setBorder (BorderFactory.createMatteBorder (0, 0, 0, 0, Color.white));

	outputLine.setHorizontalAlignment (outputLine.RIGHT);

	degrees.addItemListener (this);
	radians.addItemListener (this);
	gradians.addItemListener (this);

	setLayout (new BorderLayout ());

	setColour ();

	Panel output = new Panel ();
	Panel toolset = new Panel ();
	Panel input = new Panel ();
	Panel Contain = new Panel (new GridLayout (2, 1, 0, 0));

	toolset.setLayout (new GridLayout (4, 7, 1, 1));
	input.setLayout (new GridLayout (4, 7, 1, 1));
	output.setLayout (new BoxLayout (output, BoxLayout.PAGE_AXIS));

	output.add ("North", operationLine);
	output.add ("Center", outputLine);
	/*****FIRST ROW(TOP)*****/
	toolset.add (degrees);
	toolset.add (decimal);
	toolset.add (arcsine);
	toolset.add (hypsine);
	toolset.add (fix);
	toolset.add (CE);
	toolset.add (C);
	/*****SECOND ROW(TOP)*****/
	toolset.add (radians);
	toolset.add (binary);
	toolset.add (arccosine);
	toolset.add (hypcosine);
	toolset.add (sci);
	toolset.add (random);
	toolset.add (backspace);
	/*****THIRD ROW(TOP)*****/
	toolset.add (gradians);
	toolset.add (octal);
	toolset.add (arctangent);
	toolset.add (hyptangent);
	toolset.add (Int);
	toolset.add (Exp);
	toolset.add (yroot);
	/*****FOURTH ROW(TOP)*****/
	toolset.add (etox);
	toolset.add (hex);
	toolset.add (squared);
	toolset.add (cubed);
	toolset.add (Frac);
	toolset.add (tenx);
	toolset.add (cubedroot);
	/*****FIRST ROW(BOT)*****/
	input.add (ln);
	input.add (sine);
	input.add (seven);
	input.add (eight);
	input.add (nine);
	input.add (divide);
	input.add (root);
	/*****SECOND ROW(BOT)*****/
	input.add (log);
	input.add (cosine);
	input.add (four);
	input.add (five);
	input.add (six);
	input.add (multiply);
	input.add (factorial);
	/*****THIRD ROW(BOT)*****/
	input.add (mod);
	input.add (tangent);
	input.add (one);
	input.add (two);
	input.add (three);
	input.add (subtract);
	input.add (pow);
	/*****FOURTH ROW(BOT)*****/
	input.add (pi);
	input.add (reciprocal);
	input.add (zero);
	input.add (negative);
	input.add (decimalpoint);
	input.add (add);
	input.add (equals);

	Contain.add (toolset);
	Contain.add (input);
	add ("North", output);
	add ("Center", Contain);
    }


    //LISTENER TO DETERMINE BUTTON CLICKED
    public boolean action (Event body, Object text)
    {
	try
	{
	    if (output.length () <= 33)
	    {


		if (body.target == one)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "1";
		    operation += "1";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == two)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "2";
		    operation += "2";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == three)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "3";
		    operation += "3";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == four)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "4";
		    operation += "4";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == five)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "5";
		    operation += "5";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == six)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "6";
		    operation += "6";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == seven)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "7";
		    operation += "7";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == eight)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "8";
		    operation += "8";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == nine)
		{
		    inputClear ();
		    checkZeroDecimal (output);
		    output += "9";
		    operation += "9";
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}

		if (body.target == zero)
		{
		    if (output.equals ("0.") && decimalOn == true && output.charAt (0) == '0')
		    {
			inputClear ();
			output += "0";
			operation += "0";
			outputLine.setText (output);
			operationLine.setText (operation);
		    }
		    if (output == "0." || output == "0")
		    {
			inputClear ();
			output = "0";
			operation += "0";
			outputLine.setText (output);
			operationLine.setText (operation);
		    }
		    if (output.equals ("0.") && decimalOn == false)
		    {
			inputClear ();
			output += "0";
			operation += "0";
			outputLine.setText (output);
			operationLine.setText (operation);

		    }
		    if (decimalOn == true)
		    {
			inputClear ();
			output += "0";
			operation += "0";
			outputLine.setText (output);
			operationLine.setText (operation);
		    }
		    if (decimalOn == false && output.charAt (0) != '0')
		    {
			inputClear ();
			output += "0";
			operation += "0";
			outputLine.setText (output);
			operationLine.setText (operation);
		    }
		}
		if (body.target == decimalpoint)
		{

		    if (decimalOn == false && checkDecimal (output) == false && output != "0.")
		    {
			decimalOn = true;
			output += ".";
			operation += ".";
			outputLine.setText (output);
			operationLine.setText (operation);
		    }
		    if (decimalOn == false && output.equals ("0."))
		    {
			decimalOn = true;
		    }
		}
		if (body.target == Exp)
		{
		    hasOperator = true;
		    checkZeroDecimal (output);
		    output += "E";
		    operation += "E";
		    outputLine.setText (output);
		    operationLine.setText (operation);

		}
		if (body.target == negative)
		{
		    if (checkDecimal (output) == false)
			try
			{
			    outputholder = Long.parseLong (output) * -1;
			    if (!isNegative && !hasOperator)
			    {
				output = Long.toString (outputholder);
				operation = Long.toString (outputholder);
				outputLine.setText (output);
				operationLine.setText (operation);
				isNegative = true;
			    }
			    else
			    {
				operation = deleteNumber (operation, output);
				output = Long.toString (outputholder);
				operation += Long.toString (outputholder);
				outputLine.setText (output);
				operationLine.setText (operation);
			    }
			}
		    catch (Exception e)
		    {
			outputLine.setText ("Error 2");
		    }
		    if (checkDecimal (output) == true)
			try
			{
			    outputholderdouble = Double.parseDouble (output) * -1;
			    if (!isNegative && !hasOperator)
			    {
				output = Double.toString (outputholder);
				operation = Double.toString (outputholder);
				outputLine.setText (output);
				operationLine.setText (operation);
				isNegative = true;
			    }
			    else
			    {
				operation = deleteNumber (operation, output);
				output = Double.toString (outputholder);
				operation += Double.toString (outputholder);
				outputLine.setText (output);
				operationLine.setText (operation);
			    }
			}

		    catch (Exception e)
		    {
			outputLine.setText ("Error 1");
		    }
		}


		if (body.target == sine)
		{
		    evaluated = true;
		    if (anglemode == 1)
			operation = "sind(" + output + ")" + " = " + calculate.Sine (output, anglemode);
		    if (anglemode == 2)
			operation = "sinr(" + output + ")" + " = " + calculate.Sine (output, anglemode);
		    if (anglemode == 3)
			operation = "sing(" + output + ")" + " = " + calculate.Sine (output, anglemode);
		    output = calculate.Sine (output, anglemode);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == cosine)
		{
		    evaluated = true;
		    if (anglemode == 1)
			operation = "cosd(" + output + ")" + " = " + calculate.Cosine (output, anglemode);
		    if (anglemode == 2)
			operation = "cosr(" + output + ")" + " = " + calculate.Cosine (output, anglemode);
		    if (anglemode == 3)
			operation = "cosg(" + output + ")" + " = " + calculate.Cosine (output, anglemode);
		    output = calculate.Cosine (output, anglemode);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == tangent)
		{
		    evaluated = true;
		    if (anglemode == 1)
			operation = "tand(" + output + ")" + " = " + calculate.Tangent (output, anglemode);
		    if (anglemode == 2)
			operation = "tanr(" + output + ")" + " = " + calculate.Tangent (output, anglemode);
		    if (anglemode == 3)
			operation = "tang(" + output + ")" + " = " + calculate.Tangent (output, anglemode);
		    output = calculate.Tangent (output, anglemode);
		    outputLine.setText (output);
		}
		if (body.target == pi)
		{
		    checkZeroDecimal (output);
		    output += " " + jack.round (Math.PI, 9);
		    operation += "" + jack.round (Math.PI, 9);
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == add)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " + ";
		    operation += " + ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == subtract)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " - ";
		    operation += " - ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == multiply)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " * ";
		    operation += " * ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == divide)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " / ";
		    operation += " / ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == reciprocal)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output = "1 / " + output;
		    operation = "1 / " + operation;
		    outputLine.setText (output);
		    operationLine.setText (operation);
		}
		if (body.target == pow)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " ^ ";
		    operation += " ^ ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == factorial)
		{
		    evaluated = true;
		    operation = output + "!" + " = " + calculate.Factorial (output);
		    output = calculate.Factorial (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == sci)
		{
		    evaluated = true;
		    output = calculate.ScientificNotation (output);
		    operationLine.setText ("");
		    outputLine.setText (output);
		}
		if (body.target == fix)
		{
		    evaluated = true;
		    output = calculate.FixNotation (output);
		    operationLine.setText ("");
		    outputLine.setText (output);
		}
		if (body.target == mod)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " % ";
		    operation += " % ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == log)
		{
		    evaluated = true;
		    operation = "log(" + output + ")" + " = " + calculate.LogarithmBase10 (output);
		    output = calculate.LogarithmBase10 (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}

		if (body.target == ln)
		{
		    evaluated = true;
		    operation = "ln(" + output + ")" + " = " + calculate.NaturalLogarithm (output);
		    output = calculate.NaturalLogarithm (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == tenx)
		{
		    evaluated = true;
		    operation = "10^(" + output + ")" + " = " + calculate.TenToTheX (output);
		    output = calculate.TenToTheX (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == squared)
		{
		    evaluated = true;
		    operation = "" + output + (char) 178 + " = " + calculate.Power (output, "2");
		    output = calculate.Power (output, "2");
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == cubed)
		{
		    evaluated = true;
		    operation = "" + output + (char) 179 + " = " + calculate.Power (output, "3");
		    output = calculate.Power (output, "3");
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == root)
		{
		    evaluated = true;
		    operation = "" + (char) 8730 + output + " = " + calculate.nthRoot (output, "2");
		    output = calculate.nthRoot (output, "2");
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == cubedroot)
		{
		    evaluated = true;
		    operation = "" + (char) 179 + (char) 8730 + output + " = " + calculate.nthRoot (output, "3");
		    output = calculate.nthRoot (output, "3");
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == yroot)
		{
		    hasOperator = true;
		    if (evaluated)
			operation = output;
		    output += " " + (char) 8730 + " ";
		    operation += " " + (char) 8730 + " ";
		    operationLine.setText (operation);
		    OuClear ();
		}
		if (body.target == arcsine)
		{
		    evaluated = true;
		    operation = "sin^-1(" + output + ")" + " = " + calculate.arcSine (output, anglemode);
		    output = calculate.arcSine (output, anglemode);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == arccosine)
		{
		    evaluated = true;
		    operation = "cos^-1(" + output + ")" + " = " + calculate.arcCosine (output, anglemode);
		    output = calculate.arcCosine (output, anglemode);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == arctangent)
		{
		    evaluated = true;
		    operation = "tan^-1(" + output + ")" + " = " + calculate.arcTangent (output, anglemode);
		    output = calculate.arcTangent (output, anglemode);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == hypsine)
		{
		    evaluated = true;
		    operation = "sinh(" + output + ")" + " = " + calculate.HyperbolicSine (output);
		    output = calculate.HyperbolicSine (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == hypcosine)
		{
		    evaluated = true;
		    operation = "cosh(" + output + ")" + " = " + calculate.HyperbolicCosine (output);
		    output = calculate.HyperbolicCosine (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == hyptangent)
		{
		    evaluated = true;
		    operation = "tanh(" + output + ")" + " = " + calculate.HyperbolicTangent (output);
		    output = calculate.HyperbolicTangent (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == etox)
		{
		    evaluated = true;
		    operation = "e^" + output + " = " + calculate.NaturalNumberToTheX (output);
		    output = calculate.NaturalNumberToTheX (output);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == Int)
		{
		    evaluated = true;
		    operation = "Int(" + output + " ) " + " = " + (int) Math.round (Double.parseDouble (output));
		    output = "" + (int) Math.round (Double.parseDouble (output));
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == decimal)
		{
		    evaluated = true;
		    if (binaryFormat)
		    {
			operation = "" + output + " --> " + "dec" + " = " + Long.parseLong (output, 2);
			output = "" + Long.parseLong (output, 2);
		    }
		    if (octalFormat)
		    {
			operation = "" + output + " --> " + "dec" + " = " + Long.parseLong (output, 8);
			output = "" + Long.parseLong (output, 8);
		    }
		    if (decimalFormat)
		    {
			operation = "" + output + " --> " + "dec" + " = " + Long.parseLong (output, 10);
			output = "" + Long.parseLong (output, 10);
		    }
		    if (hexadecimalFormat)
		    {
			operation = "" + output + " --> " + "dec" + " = " + Long.parseLong (output, 16);
			output = "" + Long.parseLong (output, 16);
		    }
		    outputLine.setText (output);
		    operationLine.setText (operation);
		    decimalFormat = true;
		    binaryFormat = false;
		    octalFormat = false;
		    hexadecimalFormat = false;
		}
		if (body.target == binary)
		{
		    evaluated = true;
		    if (binaryFormat)
		    {
			operation = "" + output + " --> " + "bin" + " = " + Long.toString (Long.parseLong (output, 2), 2);
			output = Long.toString (Long.parseLong (output, 2), 2);
		    }
		    if (octalFormat)
		    {
			operation = "" + output + " --> " + "bin" + " = " + Long.toString (Long.parseLong (output, 8), 2);
			output = "" + Long.toString (Long.parseLong (output, 8), 2);
		    }
		    if (decimalFormat)
		    {
			operation = "" + output + " --> " + "bin" + " = " + Long.toString (Long.parseLong (output), 2);
			output = "" + Long.toString (Long.parseLong (output), 2);
		    }
		    if (hexadecimalFormat)
		    {
			operation = "" + output + " --> " + "bin" + " = " + Long.toString (Long.parseLong (output, 16), 2);
			output = "" + Long.toString (Long.parseLong (output, 16), 2);
		    }
		    outputLine.setText (output);
		    operationLine.setText (operation);
		    decimalFormat = false;
		    binaryFormat = true;
		    octalFormat = false;
		    hexadecimalFormat = false;
		}
		if (body.target == octal)
		{
		    evaluated = true;
		    if (binaryFormat)
		    {
			operation = "" + output + " --> " + "oct" + " = " + Long.toString (Long.parseLong (output, 2), 8);
			output = Long.toString (Long.parseLong (output, 2), 8);
		    }
		    if (octalFormat)
		    {
			operation = "" + output + " --> " + "oct" + " = " + Long.toString (Long.parseLong (output, 8), 8);
			output = "" + Long.toString (Long.parseLong (output, 8), 8);
		    }
		    if (decimalFormat)
		    {
			operation = "" + output + " --> " + "oct" + " = " + Long.toString (Long.parseLong (output), 8);
			output = "" + Long.toString (Long.parseLong (output), 8);
		    }
		    if (hexadecimalFormat)
		    {
			operation = "" + output + " --> " + "oct" + " = " + Long.toString (Long.parseLong (output, 16), 8);
			output = "" + Long.toString (Long.parseLong (output, 16), 8);
		    }
		    outputLine.setText (output);
		    operationLine.setText (operation);
		    decimalFormat = false;
		    binaryFormat = false;
		    octalFormat = true;
		    hexadecimalFormat = false;
		}
		if (body.target == hex)
		{
		    evaluated = true;
		    if (binaryFormat)
		    {
			operation = "" + output + " --> " + "hex" + " = " + Long.toString (Long.parseLong (output, 2), 16);
			output = Long.toString (Long.parseLong (output, 2), 16);
		    }
		    if (octalFormat)
		    {
			operation = "" + output + " --> " + "hex" + " = " + Long.toString (Long.parseLong (output, 8), 16);
			output = "" + Long.toString (Long.parseLong (output, 8), 16);
		    }
		    if (decimalFormat)
		    {
			operation = "" + output + " --> " + "hex" + " = " + Long.toString (Long.parseLong (output), 16);
			output = "" + Long.toString (Long.parseLong (output), 16);
		    }
		    if (hexadecimalFormat)
		    {
			operation = "" + output + " --> " + "hex" + " = " + Long.toString (Long.parseLong (output, 16), 16);
			output = "" + Long.toString (Long.parseLong (output, 16), 16);
		    }
		    outputLine.setText (output);
		    operationLine.setText (operation);
		    decimalFormat = false;
		    binaryFormat = false;
		    octalFormat = false;
		    hexadecimalFormat = true;
		}
		if (body.target == random)
		{
		    evaluated = true;
		    long limit = (long) (0 + Math.random () * Integer.parseInt (output));
		    operation = "rand*" + output + " = " + limit;
		    output = Long.toString (limit);
		    operationLine.setText (operation);
		    outputLine.setText (output);
		}
		if (body.target == Frac)
		{
		    evaluated = true;
		    clear ();
		    outputLine.setText ("LOL, nice try");
		    operationLine.setText ("");
		}
		if (body.target == equals)
		{
		    try
		    {
			if (!evaluated)
			{
			    output = FloatingPointEval (operation);
			    operation += " = ";
			    operationLine.setText (operation);
			    outputLine.setText (output);
			    evaluated = true;
			    hasOperator = false;
			}
		    }
		    catch (Exception e)
		    {
			operation = "";
			output = "Error 2";
			operationLine.setText (operation);
			outputLine.setText (output);
			evaluated = false;
		    }
		}
	    }

	    if (body.target == C)
	    {
		clear ();
		decimalFormat = true;
		binaryFormat = false;
		octalFormat = false;
		hexadecimalFormat = false;
	    }
	    if (body.target == CE)
	    {
		OuClear ();
		operation = deleteNumber (operation, output);
		operation += " ";
		operationLine.setText (operation);
	    }



	    if (body.target == backspace)
	    {
		output = backspace (output);
		operation = backspace (operation);
		outputLine.setText (output);
		operationLine.setText (operation);
	    }
	}
	catch (Exception e)
	{
	    outputLine.setText ("Error 2");
	    operationLine.setText ("");
	}


	return true;
    }

    //RADIO BUTTON ACTION LISTENER
    public void itemStateChanged (ItemEvent e)
    {
	if (e.getSource () == degrees)
	    anglemode = 1;
	if (e.getSource () == radians)
	    anglemode = 2;
	if (e.getSource () == gradians)
	    anglemode = 3;
    }

    
    public String FloatingPointEval (String input)
    {
	int length1, length2;
	String firsthalf = "";
	String secondhalf = "";
	int operatorcount = 0;
	for (length1 = 0 ; length1 < input.length () ; length1++)
	{
	    if (input.charAt (length1) == (char) 32)
		break;
	    firsthalf += input.charAt (length1);
	}


	for (length2 = length1 + 3 ; length2 < input.length () ; length2++)
	{
	    secondhalf += input.charAt (length2);
	}
	int op = findOperator (input, length1);
	switch (op)
	{
	    case 1:
		try
		{
		    return (calculate.Addition (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 2:
		try
		{
		    return (calculate.Subtraction (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 3:
		try
		{
		    return (calculate.Multiplication (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 4:
		try
		{
		    return (calculate.Division (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 5:
		try
		{
		    return (calculate.Power (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 6:
		try
		{
		    return (calculate.Modulo (firsthalf, secondhalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}
	    case 7:
		try
		{
		    return (calculate.nthRoot (secondhalf, firsthalf));
		}
		catch (Exception e)
		{
		    outputLine.setText ("Error 2");
		}

	}


	return "";
    }


    public String deleteNumber (String operation, String output)
    {
	int length1 = operation.length ();
	int length2 = output.length ();
	String value = "";
	int length3 = length1 - length2;
	for (int x = 0 ; x < length3 ; x++)
	    value += operation.charAt (x);

	return value;

    }


    public void clear ()
    {
	output = "0.";
	operation = "";
	decimalOn = false;
	evaluated = false;
	isNegative = false;
	hasOperator = false;
	outputLine.setText (output);
	operationLine.setText (operation);
	decimalFormat = true;
	binaryFormat = false;
	octalFormat = false;
	hexadecimalFormat = false;
    }


    public void OuClear ()
    {
	output = "0.";
	outputLine.setText (output);
	decimalOn = false;

    }


    public void nullSet ()
    {
	output = "";
    }


    public boolean checkOperator (String input)
    {
	for (int x = 0 ; x < input.length () ; x++)
	    for (int y = 0 ; y < listofoperators.length ; y++)
		if (input.charAt (x) == listofoperators [y])
		{
		    hasOperator = true;
		    return true;
		}


	return false;
    }


    public void checkEquals (String input)
    {
	loop:
	for (int x = 0 ; x < input.length () ; x++)
	    if (input.charAt (x) == '=')
	    {
		hasEqual = true;
		break loop;
	    }


	else
	{
	    hasEqual = false;

	}
    }


    public int findOperator (String input, int length)
    {
	if (input.charAt (length + 1) == '+')
	    return 1;
	if (input.charAt (length + 1) == '-')
	    return 2;
	if (input.charAt (length + 1) == '*')
	    return 3;
	if (input.charAt (length + 1) == '/')
	    return 4;
	if (input.charAt (length + 1) == '^')
	    return 5;
	if (input.charAt (length + 1) == '%')
	    return 6;
	if (input.charAt (length + 1) == (char) 8730)
	    return 7;

	return 0;

    }


    public String backspace (String input)
    {
	String output = "";
	if (input.length () != 0)
	{
	    int inputlength = input.length () - 1;
	    char checkspace = input.charAt (inputlength);
	    if (checkspace == (char) 32)
		inputlength -= 1;
	    for (int x = 0 ; x < inputlength ; x++)
		output += input.charAt (x);
	}


	return output;
    }


    public boolean checkDecimal (String input)
    {

	for (int x = 0 ; x <= input.length () - 1 ; x++)
	    if (input.charAt (x) == '.')
		return true;

	return false;
    }


    public boolean checkSyntax (String input)
    {
	return false;
    }


    public void checkZeroDecimal (String input)
    {
	if (decimalOn == false && output.equals ("0."))
	    nullSet ();
    }


    public String noSpaces (String input)
    {
	String output = "";
	for (int x = 0 ; x < input.length () ; x++)
	{
	    if (input.charAt (x) == (char) 32)
		continue;

	    output += input.charAt (x);
	}


	return output;
    }


    public void inputClear ()
    {
	if (evaluated && !hasOperator)
	    clear ();
    }


    public void setColour ()
    {
	operationLine.setBackground (Colours.ivory);
	operationLine.setForeground (Color.black);

	outputLine.setBackground (Colours.ivory);
	outputLine.setForeground (Color.black);

	degrees.setBackground (Colours.ivory);
	radians.setBackground (Colours.ivory);
	gradians.setBackground (Colours.ivory);

	one.setBackground (Color.white);
	two.setBackground (Color.white);
	three.setBackground (Color.white);
	four.setBackground (Color.white);
	five.setBackground (Color.white);
	six.setBackground (Color.white);
	seven.setBackground (Color.white);
	eight.setBackground (Color.white);
	nine.setBackground (Color.white);
	zero.setBackground (Color.white);
	add.setBackground (Color.white);
	subtract.setBackground (Color.white);
	multiply.setBackground (Color.white);
	divide.setBackground (Color.white);
	pow.setBackground (Color.white);
	equals.setBackground (Color.white);
	decimalpoint.setBackground (Color.white);
	negative.setBackground (Color.white);
	factorial.setBackground (Color.white);
	sine.setBackground (Color.white);
	cosine.setBackground (Color.white);
	tangent.setBackground (Color.white);
	reciprocal.setBackground (Color.white);
	root.setBackground (Color.white);
	mod.setBackground (Color.white);
	ln.setBackground (Color.white);
	log.setBackground (Color.white);
	logx.setBackground (Color.white);
	pi.setBackground (Color.white);


	tenx.setBackground (Color.white);
	C.setBackground (Colours.goldenrod);
	CE.setBackground (Colours.goldenrod);
	backspace.setBackground (Color.white);
	binary.setBackground (Color.white);
	octal.setBackground (Color.white);
	hex.setBackground (Color.white);
	decimal.setBackground (Color.white);
	sci.setBackground (Color.white);
	fix.setBackground (Color.white);
	etox.setBackground (Color.white);
	cubedroot.setBackground (Color.white);
	squared.setBackground (Color.white);
	cubed.setBackground (Color.white);
	arcsine.setBackground (Color.white);
	arccosine.setBackground (Color.white);
	arctangent.setBackground (Color.white);
	hypsine.setBackground (Color.white);
	hypcosine.setBackground (Color.white);
	hyptangent.setBackground (Color.white);
	random.setBackground (Color.white);
	yroot.setBackground (Color.white);
	Exp.setBackground (Color.white);
	Int.setBackground (Color.white);
	Frac.setBackground (Color.white);
    }
}


