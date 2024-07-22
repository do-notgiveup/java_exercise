import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileThread extends Thread {
    private String destinationFile;

    public WriteFileThread(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(destinationFile));
            for (int i = Main.count; i < Main.list.size(); i++) {
                if (i == 10) {
                    if (Main.countTest == 0) {
                        Main.countTest++;
                        Thread.sleep(5000);
                    }
                }
                bw.append(Main.list.get(Main.count++));
                bw.newLine();
                System.out.println("vua add duoc: " + i);
            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
