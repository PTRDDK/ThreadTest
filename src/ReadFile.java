import java.io.*;
import java.util.Scanner;

/**
 * Created by piotrek on 10.10.16.
 */
public class ReadFile implements Runnable {

    private String fileName;
    private BufferedReader br;

    public ReadFile(String file) {

        fileName = file;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println(Thread.currentThread().getName() + " started ");
            int lineNr = 0;
            while ((line = br.readLine()) != null) {
                lineNr++;
            }
            System.out.println("Liczba wierszy: " + lineNr);
        }
        catch(IOException er){
            er.printStackTrace();
        }
    }
}
