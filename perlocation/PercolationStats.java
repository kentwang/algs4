/******************************************************************************
  *  Compilation: javac-alg4 PercolationStats.java
  *  Execution: java PercolationStats
  * 
  *  Percolation Monte Carlo experiment
  *  Author: Ketong Wang
  */

public class PercolationStats {
    // Some private names to hold data
    private double[] thresholds;
    
    /**
     * Initializes the percolation
     */
    public PercolationStats (int N, int T) { //N dimension, T repeating times
        thresholds = new double[T];
        for (int i = 0; i < T; i++) { // run T experiments
            Percolation percolationItem = new Percolation(N);
            StdOut.println(percolationItem.percolates());
            while (!percolationItem.percolates()) {
                int row = new StdRand.uniform(1, N + 1);
                int col = new StdRand.uniform(1, N + 1);
            }
        }
    }
    
    /**
     * Sample mean of percolation threshold
     */
//    public double mean() {}
    
    /**
     * Sample standard deviation of percolation threshold
     */
//    public double stddev() {}
    
    /**
     * returns lower bound of the 95% confidence interval
     */
//    public double confidenceLo() {}
    
    /**
     * returns upper bound of the 95% confidence interval
     */
//    public double confidenceHi() {}
    
    /**
     * test client, described below
     */
    public static void main(String[] args) {
        StdOut.print("Enter the grid dimension N: ");
        int N = StdIn.readInt();
        StdOut.print("Enter the repeating times of experiments T: ");
        int T = StdIn.readInt();
        
        PercolationStats pStats = new PercolationStats(3, 100);
    }
    
    
    
    
}