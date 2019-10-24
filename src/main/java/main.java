public class main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(10,10);
        matrix.fill();
        NonParallel nonParallel = new NonParallel();
        matrix.print();
        System.out.println(nonParallel.solve(matrix));
        ParallelSearch ps = new ParallelSearch(matrix);
        ps.solve();
    }



}
