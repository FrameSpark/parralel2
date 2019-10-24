public class Struct {
    public Matrix matrix;
    public int maxElement;

    public Struct(Matrix matrix) {
        this.matrix = matrix;
        this.maxElement = 0;
    }

    public int getElement(int x, int y){
        return matrix.getElement(x,y);
    }


}


