/*
 * Project Name: BigIntegerForRational.java
 * Author: Julian Fuentes
 * Date Last Updated: 04 February 2024
 * Purpose: This program has the user enter two rational numbers and then
 * 		displays the results of those numbers.
 */

import java.util.*;
import java.math.*;

public class Rational extends Number implements Comparable
{
	private BigInteger[] rational = new BigInteger[2];
	
	public Rational() 
	{
		this(new BigInteger("0"), new BigInteger("1"));
	}
	//This should construct a rational with default properties.
	
	public Rational(BigInteger numberator, BigInteger denominator) 
	{
		BigInteger gcd = gcd(numberator, denominator);
		rational[0] = (denominator.compareTo(BigInteger.ZERO) > 0
				? BigInteger.ONE :
					new BigInteger("-1")).multiply(numberator.divide(gcd));
		rational[1] = denominator.divide(gcd);
	}
	//This should construct a rational with specified numerator and denominator.
	
	private static BigInteger gcd(BigInteger n, BigInteger d) 
	{
		BigInteger n1 = n;
		BigInteger n2 = d;
		BigInteger gcd = BigInteger.ONE;
		for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 
				&& k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) 
		{
			if(n1.remainder(k).compareTo(BigInteger.ZERO) == 0 
					&& n2.remainder(k).compareTo(BigInteger.ZERO) == 0)
				gcd = k;
		}
		return gcd;
	}
	//This should find the GCD of the two numbers.
	
	public BigInteger getNumerator() 
	{
		return rational[0];
	}
	//This should return the numerator;
	
	public BigInteger getDenominator() 
	{
		return rational[1];
	}
	//This should return the denominator.
	
	public Rational add(Rational secondRational) 
	{
		BigInteger n = (rational[0].multiply(secondRational.getDenominator()))
				.add(rational[1].multiply(secondRational.getNumerator()));
		BigInteger d = rational[1].multiply(secondRational.getDenominator());
		return new Rational(n,d);
	}
	//This should add a rational number to this rational.
	
	public Rational subtract(Rational secondRational) 
	{
		BigInteger n = (rational[0].multiply(secondRational.getDenominator()))
				.subtract(rational[1].multiply(secondRational.getNumerator()));
		
		BigInteger d = rational[1].multiply(secondRational.getDenominator());
		return new Rational(n,d);
	}
	//This should subtract a rational number from this rational.
	
	public Rational multiply(Rational secondRational) 
	{
		BigInteger n = rational[0].multiply(secondRational.getNumerator());
		BigInteger d = rational[1].multiply(secondRational.getDenominator());
		return new Rational(n,d);
	}
	//This should multiply a rational number by this rational.
	
	public Rational divide(Rational secondRational) 
	{
		BigInteger n = rational[0].multiply(secondRational.getDenominator());
		BigInteger d = rational[1].multiply(secondRational.getNumerator());
		return new Rational(n,d);
	}
	//This should divide a rational number by this rational.
	
	@Override
	public String toString() 
	{
		if(rational[1].compareTo(BigInteger.ONE)==0) 
			return rational[0] + "";
		else
			return rational[0] + "/" + rational[1];
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(((this.subtract((Rational)(other))).getNumerator())
				.compareTo(BigInteger.ZERO)==0)
			return true;
		else
			return false;
	}
	//This should override the equals method.
	
	@Override
	public int intValue() 
	{
		return (int)doubleValue();
	}
	//This should implement the abstract intValue method.
	
	@Override
	public float floatValue() 
	{
		return (float)doubleValue();
	}
	//This should implement the abstract floatValue method.
	
	@Override
	public double doubleValue() 
	{
		return this.getNumerator().doubleValue()/
				this.getDenominator().doubleValue();
	}
	//This should implement the doubleValue method.
	
	@Override
	public long longValue() 
	{
		return (long)doubleValue();
	}
	//This should implement the abstract longValue method.
	
	@Override
	public int compareTo(Object obj) 
	{
		BigInteger zero = BigInteger.ZERO;
		BigInteger n = this.subtract((Rational)obj).getNumerator();
		if(n.compareTo(zero) > 0)
			return 1;
		else if(n.compareTo(zero) < 0)
			return -1;
		else
			return 0;
	}
	//This should implement the compareTo method.
}
