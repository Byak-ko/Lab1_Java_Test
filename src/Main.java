import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BreakThread breakThread = new BreakThread();
        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        MainThread[] threads = new MainThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            System.out.print("Enter the number of step for thread " + i + ": ");
            int step = scanner.nextInt();
            threads[i] = new MainThread(i, 2, breakThread);
        }


        for (MainThread thread : threads) {
            thread.start();
        }


        new Thread(breakThread).start();
    }
}