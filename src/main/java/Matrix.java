import java.util.Random;

public class Matrix {
    public int matrix[][];
    private int column, row;

    public Matrix(int row, int column) {
        this.column = column;
        this.row = row;

        matrix = new int[row][column];
    }

    public void fill(){
        Random rand = new Random();

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                matrix[i][j] = rand.nextInt(200)-100;
            }
        }
    }

    public int getElement(int x,int y){
        return matrix[x][y];
    }

    public void print(){
        System.out.println();
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
