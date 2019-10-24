//Класс объекты которого выполняются в потоке
public class SearchThread extends Thread {
    private Struct struct;
    public int leftX,
               rightX,
               countY;

    public SearchThread(Struct struct, int leftX, int rightX, int countY) {
        this.struct = struct;
        this.leftX = leftX;
        this.rightX = rightX;
        this.countY = countY;
    }

    @Override
    public void run(){
        for (int i =leftX; i < rightX; i++) {
            for (int j = 0; j < countY; j++) {
                if (struct.getElement(i,j) % 2 != 0 && ( struct.maxElement < struct.getElement(i,j) || struct.maxElement  == 0 ))
                    struct.maxElement = struct.getElement(i,j);
            }
        }
    }
}
