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
    private int dim;
    
    /**
     * Initializes the percolation
     */
    public PercolationStats (int N, int T) {                    // N dimension, T repeating times
        thresholds = new double[T];                             // Save steps to percolate
        dim = N;
//        for (int i = 0; i < T; i++) {                           // run T experiments
//            Percolation percolationItem = new Percolation(N);
//            StdOut.println(percolationItem.percolates());
//            while (!percolationItem.percolates()) {
//                int row = StdRandom.uniform(1, N + 1);
//                int col = StdRandom.uniform(1, N + 1);
//            }
//        }
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
     * Some private methods. index2Coord(). public first then private
     */
    private int[] index2Coord(int index) {         // indice are from 0 to dim * dim - 1
        int[] coord = new int[2];
        coord[0] = index / dim + 1;
        coord[1] = index % 3 + 1;
        return coord;
    }
    
    /**
     * test client, described below
     */
    public static void main(String[] args) {
        StdOut.print("Enter the grid dimension N: ");
        int N = StdIn.readInt();
        StdOut.print("Enter the repeating times of experiments T: ");
        int T = StdIn.readInt();
                     
        PercolationStats pStats = new PercolationStats(N, T);
//        int[] coord = pStats.index2Coord(7);
//        for (int i = 0;  i < coord.length; i++) {
//            StdOut.println(coord[i]);
//        }
//        StdOut.println(5%3);
    }
    
    
    
    
}