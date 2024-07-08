import java.util.List;

public class EvenThread extends Thread {
    private List<Integer> list;

    public EvenThread(List<Integer> list) {
        this.list = list;
    }

    public void checkEven() throws InterruptedException {
        for (Integer i : list) {
            if (i % 2 == 0) {
                System.out.print("\nEven number form evenThread: " + i);
                Thread.sleep(1100);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.checkEven();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
