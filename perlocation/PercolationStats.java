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
        thresholds = new double[T];                             // Initialized as 0 ? Save steps to percolate
        dim = N;
        int[] indice = randIntArray(dim * dim);             // generate random indice
        for (int i = 0; i < T; i++) {                           // run T experiments
            Percolation percolationItem = new Percolation(dim);
            for (int j = 0; j < dim * dim; j ++) {              // run through all cells
                if (percolationItem.percolates()) continue;
                int[] coord = index2Coord(indice[j]);
                percolationItem.open(coord[0], coord[1]);       // open site (i, j)
                thresholds[i]++;
            }
            thresholds[i] /= dim * dim;
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
     * Some private methods. index2Coord(int index). public first then private
     * randIntArray(int k)
     */
    private int[] index2Coord(int index) {         // indice are from 0 to dim * dim - 1
        int[] coord = new int[2];
        coord[0] = index / dim + 1;
        coord[1] = index % 3 + 1;
        return coord;
    }
    
    private int[] randIntArray(int k) {                  // int array 0 to k - 1
        int[] randIntSeq = new int[k];
        for (int i = 0; i < k; i++) {
            randIntSeq[i] = i;
        }
        StdRandom.shuffle(randIntSeq);
        return randIntSeq;
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

    }
    
    
    
    
}