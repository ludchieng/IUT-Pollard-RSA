package math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DataPerformer {

	//private static final String ALGO = "pol1";
	//private static Pollard pol = new Pollard1();
	//private static final String ALGO = "pol2";
	//private static Pollard pol = new Pollard2();
	private static final String ALGO = "pol3";
	private static Pollard pol = new Pollard3();

	//private static final String N_LIST = "1-150";
	private static final String N_LIST = "1-300";
	//private static final String N_LIST = "1-500";
	//private static final String N_LIST = "1-2000";
	//private static final String N_LIST = "1-5000";
	//private static final String N_LIST = "1-10000";
	//private static final String N_LIST = "1-100000";
	private static final int N_LIST_LENGTH = 5000;

	private static PrintWriter writer;
	private static int readCursor = 0;
	private static ArrayList<PollardResult> listResults = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		//Initialize DataMiner
		long timeInit = System.currentTimeMillis();
		
		// Generating filename
		int fileNumber = 0;
		String fileName;
		File f;
		do {
		fileNumber++;
		fileName = "./log-"
				+ N_LIST + "-"
				+ ALGO + "-"
				+ System.getProperty("user.name") + "-"
				+ fileNumber;
		
			f = new File(fileName + ".csv");
		} while(f.exists());
		
		writer = new PrintWriter(fileName + ".csv", "UTF-8");
		
		System.out.println("#### DATA PERFORMER - " + timeInit);
		/*writer.println("#### DATA PERFORMER" + '\n'
				+ "Timestamp: " + timeInit + '\n'
				+ "Algorithm: " + ALGO + '\n'
				+ "N list: " + N_LIST_PATH + '\n'
				+ "N list length: " + N_LIST_LENGTH + '\n'
				+ "User: " + System.getProperty("user.name") + '\n'
				+ "Available cores: "
				+ Runtime.getRuntime().availableProcessors() + '\n'
				+ "Memory available to JVM: " + 
		        Runtime.getRuntime().totalMemory() + " bytes" + '\n'
		);*/

		// Print header
		//writer.println(\"n\",\"resP\",\"success\",\"x0\",\"x\",\"nbReboot\",\"i\",\"time (µs)\"");
		
		// Begin iterations
		while(readCursor<N_LIST_LENGTH) {
			//Prepare iteration
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n### ITERATION no." + readCursor + '\t' + timestamp);
			
			// Perform factorization
			long timeBegin, timeEnd, time;
			
			// Factorize next n
			BigInteger n = popFromNList();
			System.out.println("n = " + n);
			
			// Factorize
			PollardResult res;
			timeBegin = System.nanoTime();
			res = pol.perform(n);
			timeEnd = System.nanoTime();
			
			// Write files
			time = timeEnd - timeBegin;
			res.setTime(time);
			
			// Add res to arraylist
			listResults.add(res);
			
			// Print res to csv file
			writer.println(res.getN() + "\t" + res.getP() + "\t" + res.getSuccess() + "\t" + 
					res.getX0() + "\t" + res.getXFinal() + "\t" + res.getNbReboot() + "\t" + res.getI() + "\t" + res.getTime()/1000);
			
			readCursor++;
		}
		
		// Close DataMiner
		writer.close();
		long timeFinal = System.currentTimeMillis();
		long timeTotal = timeFinal - timeInit;
		save(fileName, listResults);
		System.out.println("#### DATA PERFORMER - DONE IN " + timeTotal/1000 + '.' + timeTotal%1000 + " s");
	}
	
	public static BigInteger popFromNList() throws IOException {
		// Load prime numbers list text file
		BufferedReader br = new BufferedReader(new FileReader("./n_list_" + N_LIST + ".txt"));
		// Skip lines
		String res = "";
		for(int i=0; i<=readCursor; i++) {
			res = br.readLine();
		}
		return new BigInteger(res);
	}
	
	public static void save(String fileName, ArrayList<PollardResult> listResult) throws IOException {
	    FileOutputStream fos = new FileOutputStream("./" + fileName + ".arraylist");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(listResult);
	    oos.close();
	    fos.close();
	}
	
	public static ArrayList<PollardResult> load(String filename) throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(new File(filename + ".arraylist"));
		ObjectInputStream oi = new ObjectInputStream(fi);
		ArrayList<PollardResult> listResult = (ArrayList<PollardResult>) oi.readObject();
		oi.close();
		fi.close();
		return listResult;
	}
}
