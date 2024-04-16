import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        MainThread[] threads = new MainThread[numThreads];
        BreakThread[] bThreads = new BreakThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            System.out.print("Enter the number of step for thread " + i + ": ");
            int step = scanner.nextInt();
            bThreads[i] = new BreakThread((i+1)*1000);
            threads[i] = new MainThread(i, step, bThreads[i]);
        }

        for (MainThread thread : threads) {
            thread.start();
        }
        for (BreakThread bThread : bThreads) {
            new Thread(bThread).start();
        }
    }
}