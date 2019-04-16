import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("## Enter number to factorize: ");
		String nString = sc.nextLine();
		BigInteger n = new BigInteger(nString);
		Pollard pol = new Pollard3();
		pol.factorize(n);
	}
}
