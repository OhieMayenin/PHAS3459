/**
 * this main class runs the MonteCarloPiCalculatorTask
 * runs it first using a single thread, and then using a thread pool of four threads
 */

package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) {

		try {
			// single thread
			MonteCarloPiCalculatorTask calculator = new MonteCarloPiCalculatorTask(10000000);
			long startTime = System.currentTimeMillis();
			double piEstimate = calculator.call(); // start calculator task
			System.out.println("Pi calculated using a single thread: " +piEstimate);
			
			// calculate time taken
			long endTime = System.currentTimeMillis();
			long timeTaken = (endTime - startTime);
			System.out.println("Time taken: " +timeTaken +" ms" +"\n");


		}
		catch (Exception e) {e.printStackTrace();}
		
		try {
		// four threads using threadPool
		long nPoints = 10000000L;
		int nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		long startTime = System.currentTimeMillis();
		
		// loop perform calculator task with four threads sharing nPoints equally
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new
					MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;
		
		// sum results from each thread
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi = sum/nThreads;
		
		// calculate time taken
		long endTime = System.currentTimeMillis();
		long timeTaken = (endTime-startTime);
		System.out.println("Pi calculated using four threads: " +pi);
		System.out.println("Time taken: " +timeTaken +" ms" +"\n");
		}
		
		catch (Exception e) {e.printStackTrace();}
		
		// comments
		System.out.println("The calculator was faster when using four threads compared to when just using one.");
		System.out.println("The accuracy of both estimates are the same over many excecutions of the program.");
	}

}
