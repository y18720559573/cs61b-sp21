package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        int factor = 1;
        for (int i = 1; i < 9; i++){
            int N = 1000 * factor;
            factor = factor * 2;
            ns.addLast(N);
            int j = 0;
            SLList S = new SLList();
            while (j < N){
                S.addLast(j);
                j += 1;
            }
            Stopwatch timer = new Stopwatch();
            for (int k = 0; k < 10000; k++){
                    S.getLast();
            }
            double time = timer.elapsedTime();
            opCounts.addLast(10000);
            times.addLast(time);
        }

        printTimingTable(ns, times, opCounts);
    }

}
