/*****************************************************************************
  * Compilation: javac-algs4 Percolation.java
  * Executtion: java-algs4 Percolation
  * 
  * Percolation system class "Percolation"
 */

/**
 * 
 */

public class Percolation {
    private int[] states;                        // states of all cells, 0/1
    private int dim;                             // dimension of the percolation
    private WeightedQuickUnionUF cells;
    
    /*************************************************/
    /* Define public methods for the Percolation API */
    /**
     * Initializes an empty Percolation class "Percolation" with all sites closed
     * @param N, dimension of the system
     */
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException();
        states = new int[N * N + 2];                 // SYNTAX, avoid NULL
        dim = N;
        cells = new WeightedQuickUnionUF(N * N + 2); // SYNTAX, additional top and bottom cells
        for (int j = 0; j < N * N; j++) {
            states[j] = 0;
        }
        states[N * N] = 1;
        states[N * N + 1] = 1;
    }
    
    /**
     * open the site (i, j) if it is not open
     */
    public void open(int i, int j) {
        isInRange(i, j);                             // validate indice
        if (isOpen(i, j)) return;
        int siteIndex = coord2Index(i, j);           // index of new site
        states[siteIndex] = 1;                       // open site (i, j)
        
        /** union to top/bottom if first/last row **/
        if (i == 1) cells.union(siteIndex, dim * dim);
        if (i == dim) cells.union(siteIndex, dim * dim  + 1);
        
        /** union neighbor cells **/
        if (inRangeBoolean(i - 1, j) && isOpen(i - 1, j)) 
            cells.union(coord2Index(i - 1, j), siteIndex);
        if (inRangeBoolean(i + 1, j) && isOpen(i + 1, j)) 
            cells.union(coord2Index(i + 1, j), siteIndex);
        if (inRangeBoolean(i, j - 1) && isOpen(i, j - 1)) 
            cells.union(coord2Index(i, j - 1), siteIndex);
        if (inRangeBoolean(i, j + 1) && isOpen(i, j + 1)) 
            cells.union(coord2Index(i, j + 1), siteIndex);
    }
    
    /**
     * check if site (i, j) is open
     */
    public boolean isOpen(int i, int j) {
        return states[coord2Index(i, j)] == 1;
    }
    
    /**
     * check if site (i, j) is full, connected to the top cell
     */
    public boolean isFull(int i, int j) {
        isInRange(i, j);
        return cells.connected(coord2Index(i, j), dim * dim);        
    }
    
    /**
     * check if the system can percolate
     */
    public boolean percolates() {
        return cells.connected(dim * dim, dim * dim + 1);
    }
    
    /****************************************/
    /* Define private methods for the class */
    /**
     * check if the location (i, j) is with in our range
     */
    private void isInRange(int i, int j) {
        if (i <= 0 || i > dim || j <= 0 || j > dim)
            throw new IndexOutOfBoundsException();
    }
    
    private boolean inRangeBoolean(int i, int j) {
        return !(i <= 0 || i > dim || j <= 0 || j > dim);
    }
    
    /**
     * Translate (i, j) to index
     */
    private int coord2Index(int i, int j) {
        return (i - 1) * dim + j - 1;
    }
    
    /**
     * A test main function
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation percolationItem = new Percolation(N);
        
        /**
         * test public interfatces
         */
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            percolationItem.open(i, j);
        }
        
        StdOut.println(percolationItem.percolates());
    }
}









