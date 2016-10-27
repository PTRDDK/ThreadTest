import java.util.ArrayList;

/**
 * Created by piotrek on 10.10.16.
 */
public class ThreadTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        String[] file = new String[args.length];
        try{
            for(int i = 0; i < args.length; i++){
                file[i] = args[i];
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        ArrayList<Thread> threads = new ArrayList<Thread>();
        ArrayList<Thread> threads2 = new ArrayList<Thread>();
        for (int i = 0; i < file.length; i++) {
            Thread t1 = new Thread(new ReadFile(file[i]));
            threads.add(t1);

            Thread t2 = new Thread(new ReadFile(file[i]));
            threads2.add(t2);
        }


        //synchronicznie
        long startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println("Synchronicznie trwalo to: " + (System.currentTimeMillis() - startTime) + "ms");

        //asynchronicznie
        startTime = System.currentTimeMillis();
        for (Thread thread : threads2) {
            thread.start(); //startujemy watek jeden po drugim odrazu
        }
        for (Thread thread : threads2) {
            thread.join(); //czekamy na zakonczenie watku
        }
        System.out.println("Asynchronicznie trwalo to: " + (System.currentTimeMillis() - startTime) + "ms");
    }

}

