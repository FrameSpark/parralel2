public class ParallelSearch {
    private Matrix matrix;
    private int threadCount; // Количество потоков
    private Struct[] structs; // структуры для потоков
    private SearchThread[] searchThreads; //Объекты с потоками

    public ParallelSearch(Matrix matrix) {
        this.matrix = matrix;
        threadCount = Runtime.getRuntime().availableProcessors();
    }

    public void solve(){
        System.out.println("Запущенно в " + threadCount + " потоках");
        System.out.println(threadRun((threadCount)));
    }

    private int threadRun(int threadCount){
        structs = new Struct[threadCount];
        searchThreads = new SearchThread[threadCount];

        int blocks = matrix.getRow() / threadCount;

        long start = System.currentTimeMillis();
        for(int i=0; i<threadCount; i++){
            structs[i] = new Struct(matrix);
            if(i == threadCount-1 )
             searchThreads[i] = new SearchThread(structs[i],blocks*i,matrix.getRow(), matrix.getColumn());
            else
                searchThreads[i] = new SearchThread(structs[i],blocks*i,blocks*(i+1), matrix.getColumn());
            searchThreads[i].start();
        }
        // ожидаем завершения
        for (int i = 0; i < threadCount; i++){
            try {
               searchThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int s = structs[0].maxElement;
        for (int i = 0; i < threadCount; i++)
            if (structs[i].maxElement != 0 && s < structs[i].maxElement )
                s = structs[i].maxElement;


        System.out.println("Время выполнения " + (System.currentTimeMillis() - start));
        return s;
    }
}
