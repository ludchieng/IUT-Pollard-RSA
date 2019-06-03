package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;

import mathclean.Pollard;
import mathclean.Pollard1;
import mathclean.Pollard2;
import mathclean.Pollard3;
import mathclean.PollardResult;

public class TpsTest {
	
	private static final String N_LIST_PATH = "./n_list_distrib.txt";
	private static final int N_LIST_LENGTH = 2228;
	
	public static void main(String[] args) throws Exception {
		System.out.println("#### TPS TEST");
		BigInteger n;
		PollardResult polRes;
		
		for(Pollard.algo algo : Pollard.algo.values()) {
		//Pollard.algo algo = Pollard.algo.POL1;
			//Pour chaque algo
			PrintWriter out = new PrintWriter("./log-tpsTest-"+algo+".csv");
			for(int i=0; i<N_LIST_LENGTH-1; i++) {
				//Pour chaque n
				n = popFromNList(i);
				int timeAvg = 0;
				for(int j=0; j<20; j++) {
					//Pour chaque occurrence
					do {
						//Tant que non réussi
						polRes = Pollard.factorize(n, algo);
						timeAvg += polRes.getTime();
					} while(!polRes.isSuccess());
				}
				timeAvg /= 20;
				out.println(n + "\t" + timeAvg);
			}
			out.close();
		}
	}
	
	public static BigInteger popFromNList(int index) throws IOException {
		// Load prime numbers list text file
		BufferedReader br = new BufferedReader(new FileReader(N_LIST_PATH));
		// Skip lines
		String res = "";
		for(int i=0; i<=index; i++) {
			res = br.readLine();
		}
		return new BigInteger(res);
	}

}
