public class MainThread extends Thread {
    private final int id;
    private final int step;
    private final BreakThread breakThread;
    private int termCount;

    public MainThread(int id, int step, BreakThread breakThread) {
        this.id = id;
        this.step = step;
        this.breakThread = breakThread;
        this.termCount = 0;
    }

    @Override
    public void run() {
        long sum = 0;
        int i = 0;
        boolean isStop = false;
        do {
            sum += i * step;
            i++;
            termCount++;
            isStop = breakThread.isCanBreak();
        } while (!isStop);
        System.out.println(id + " - Sum: " + sum + ", Steps: " + termCount);
    }
}