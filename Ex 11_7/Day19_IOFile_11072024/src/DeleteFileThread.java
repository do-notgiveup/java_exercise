import java.io.File;

public class DeleteFileThread extends Thread {
    private String sourceFile;

    public DeleteFileThread(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public void run() {
        File file = null;
        try {
            file = new File(sourceFile);
            file.delete();
        } catch (Exception io) {
            io.printStackTrace();
        }
    }
}
