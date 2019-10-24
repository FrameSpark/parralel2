public class NonParallel {
    public int solve(int row, int column){
        Matrix matrix = new Matrix(row,column);
        matrix.fill();
        return calculate(matrix);

    }

    public int solve(Matrix matrix){
        return calculate(matrix);

    }

    private int calculate(Matrix m){
        int max = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < m.getRow(); i++)
            for (int j = 0; j < m.getColumn(); j++) {
                if (m.matrix[i][j] % 2 != 0 && max == 0) {
                    max = m.matrix[i][j];
                }
                if (m.matrix[i][j] % 2 != 0 && max < m.matrix[i][j]) {
                    max = m.matrix[i][j];
                }
            }
        System.out.println("Время работы в непараллельном режиме " + (System.currentTimeMillis() - start));
        return max;
    }

}
