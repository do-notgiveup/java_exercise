import java.util.List;

public class OddThread extends Thread {
    private List<Integer> list;

    public OddThread(List<Integer> list) {
        this.list = list;
    }

    public void checkOdd() throws InterruptedException {
        for (Integer i : list) {
            if (i % 2 != 0) {
                Thread.sleep(1000);
                System.out.print("\nOdd number form oddThread: " + i);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.checkOdd();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
