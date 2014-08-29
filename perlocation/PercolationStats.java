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
    private int repeat;
    private double confIntervMultiplier = 1.96;
    
    /**
     * Initializes the percolation
     */
    public PercolationStats(int N, int T) {                    // N dimension, T repeating times
        if(N <= 0 || T <= 0) throw new IllegalArgumentException();
        thresholds = new double[T];                             // Initialized as 0 ? Save steps to percolate
        dim = N;
        repeat = T;
        for(int i = 0; i < T; i++) {                           // run T experiments
            int[] indice = randIntArray(dim * dim);             // generate random indice, should be inside each experiment
//            StdArrayIO.print(indice);
            Percolation percolationItem = new Percolation(dim);
            for(int j = 0; j < dim * dim; j++) {              // run through all cells
                if(percolationItem.percolates()) continue;
                int[] coord = index2Coord(indice[j]);
//                StdOut.println("coord");
//                StdArrayIO.print(coord);
                percolationItem.open(coord[0], coord[1]);       // open site (i, j)
                thresholds[i]++;
            }
            thresholds[i] /= dim * dim;
        }
    }
    
    /**
     * Sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(thresholds);
    }
    
    /**
     * Sample standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(thresholds);
    }
    
    /**
     * returns lower bound of the 95% confidence interval
     */
    public double confidenceLo() {
        return StdStats.mean(thresholds) - confIntervMultiplier 
            * StdStats.stddev(thresholds) / Math.sqrt(repeat);
    }
    
    /**
     * returns upper bound of the 95% confidence interval
     */
    public double confidenceHi() {
        return StdStats.mean(thresholds) + confIntervMultiplier 
            * StdStats.stddev(thresholds) / Math.sqrt(repeat);
    }
    
    /**
     * Some private methods. index2Coord(int index). public first then private
     * randIntArray(int k)
     */
    private int[] index2Coord(int index) {         // indice are from 0 to dim * dim - 1
        int[] coord = new int[2];
        coord[0] = index / dim + 1;
        coord[1] = index - (coord[0] - 1) * dim + 1;
        return coord;
    }
    
    private int[] randIntArray(int k) {                  // int array 0 to k - 1
        int[] randIntSeq = new int[k];
        for(int i = 0; i < k; i++) {
            randIntSeq[i] = i;
        }
        StdRandom.shuffle(randIntSeq);
        return randIntSeq;
    }
    
    /**
     * test client, described below
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
                             
        PercolationStats pStats = new PercolationStats(N, T);
//        StdArrayIO.print(pStats.thresholds);
        StdOut.println("mean                    = " + pStats.mean());
        StdOut.println("stddev                  = " + pStats.stddev());
        StdOut.println("95% confidence interval = " + pStats.confidenceLo() 
                           + ", " + pStats.confidenceHi());

    }
    
    
    
    
}