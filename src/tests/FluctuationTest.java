package tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import mathclean.Numbers;
import mathclean.Pollard;
import mathclean.Pollard1;
import mathclean.Pollard2;
import mathclean.Pollard3;
import mathclean.PollardResult;

public class FluctuationTest {

	public static void main(String[] args) throws IOException {
		System.out.println("#### FLUCTUATION TEST");
		BigInteger n;
		BigInteger x0;
		BigInteger a;
		PollardResult polRes;
		
		for(Pollard.algo algo : Pollard.algo.values()) {
			//Pour chaque algo
			PrintWriter out = new PrintWriter("./log-FluctuationTest-"+algo+".csv");
			for(int i=2; i<=7; i++) {
				//Pour chaque taille en nb de digits de n
				n = Numbers.getRndN(i);
				x0 = Numbers.rnd(n);
				a = Numbers.rnd(n);
				for(int j=0; j<1000; j++) {
					//Pour chaque occurrence
					switch(algo) {
					case POL1:
						polRes = Pollard1.factorizeWithX0AndA(n, x0, a);
						break;
					case POL2:
						polRes = Pollard2.factorizeWithX0AndA(n, x0, a);
						break;
					case POL3:
						polRes = Pollard3.factorizeWithX0(n, x0);
						break;
					default:
						polRes = null;
					}
					
					out.println(n + "\t" + polRes.getTime());
				}
			}
			out.close();
		}
	}
}
