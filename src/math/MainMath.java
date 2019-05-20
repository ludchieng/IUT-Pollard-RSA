package math;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class MainMath {
	public static void main(String[] args) {
		/*
		//Test factorisation saisie
		Scanner sc = new Scanner(System.in);
		System.out.println("## Enter number to factorize: ");
		String nString = sc.nextLine();
		BigInteger n = new BigInteger(nString);
		Pollard pol = new Pollard3();
		pol.factorize(n);
		*/
		
		/*
		//Test factorisation de très grand nombre POLLARD 3
		Pollard pol = new Pollard3();
		BigInteger n = PrimeNumbers.genBigN(10);
		System.out.println(n);
		pol.factorize(n);
		*/
		
		
		//Test factorisation POLLARD 1
		Pollard pol = new Pollard1();
		BigInteger n = new BigInteger("9919754852093663");
		System.out.println(n);
		pol.factorize(n);
		
		
		/*
		//Test getting prime numbers from list
		try {
			System.out.println(PrimeNumbers.get(0));
			System.out.println(PrimeNumbers.get(100007));
			System.out.println(PrimeNumbers.getRnd());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
