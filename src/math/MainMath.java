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
		
		
		//Test factorisation POLLARD 2
		Pollard pol = new Pollard2();
		BigInteger n = new BigInteger("22");
		System.out.println(n);
		try {
			pol.factorizeWith(n, new BigInteger("12"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		
		/*
		//Test getting prime numbers from list
		try {
			System.out.println(PrimeNumbers.get(0));
			System.out.println(PrimeNumbers.get(100007));
			System.out.println(PrimeNumbers.getRnd());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*
		//Test random big integer
		for(int i=0; i<100; i++) {
			System.out.println(Numbers.rnd(new BigInteger("1000000000")));
		}
		for(int i=0; i<20; i++) {
			System.out.println(Numbers.rnd(new BigInteger("1000000")));
		}
		for(int i=0; i<10; i++) {
			System.out.println(Numbers.rnd(new BigInteger("1000")));
		}
		*/
	}
}
