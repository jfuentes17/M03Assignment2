/*
 * Project Name: BigIntegerForRational.java
 * Author: Julian Fuentes
 * Date Last Updated: 04 February 2024
 * Purpose: This program has the user enter two rational numbers and then
 * 		displays the results of those numbers.
 */

import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;


public class BigIntegerForRational 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first rational number: ");
		BigInteger number1 = scan.nextBigInteger();
		BigInteger number2 = scan.nextBigInteger();
		
		System.out.print("Enter the second rational number: ");
		BigInteger number3 = scan.nextBigInteger();
		BigInteger number4 = scan.nextBigInteger();
		Rational rational1 = new Rational(number1,number2);
		Rational rational2 = new Rational(number3, number4);
		//This creates and initializes two rational numbers.
		
		System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
		System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
		System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
		System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
		System.out.println(rational2 + " is " + rational2.doubleValue());
	}
}
