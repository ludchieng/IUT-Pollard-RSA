package tests;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;

import mathclean.*;

public class X0Test {
	
	public static void main(String[] args) throws Exception {
		System.out.println("#### X0 TEST");
		BigInteger n = new BigInteger("3921");
		HashSet<BigInteger> x0s = new HashSet<>();
		LinkedList<PollardResult> polRes = new LinkedList<>();
		long moy = 0;
		
		System.out.println("## Generating x0");
		for(long i=0; i<n.longValue(); i++) {
			if(i!=0 && i!=1) {
				x0s.add(new BigInteger(Long.toString(i)));
			}
			if(i%10000 == 0) {
				System.out.println("# Reached i="+i);
			}
		}

		System.out.println("## Factorizing n");
		for(BigInteger x0 : x0s) {
			PollardResult p = Pollard3.factorizeWithX0(n, x0);
			moy += p.getTime();
			polRes.add(p);
		}
		moy /= x0s.size();

		System.out.println("## Printing out results");
		PrintWriter out = new PrintWriter("./log-x0test.txt");
		out.println("Moyenne = " + moy);
		
		for(PollardResult p : polRes) {
			out.println(p);
		}
		System.out.println("Moyenne = " + moy);
		out.close();
	}
}
