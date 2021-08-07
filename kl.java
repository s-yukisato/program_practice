import java.util.Scanner;
import java.util.stream.IntStream;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int x = Integer.parseInt(sc.next());
        int[] min_max = {2147483647, 0};
        IntStream.range(0, n)
            .forEach(i -> {
                int a = Integer.parseInt(sc.next());
                int b = Integer.parseInt(sc.next());
                int c = Integer.parseInt(sc.next());
                int d = Integer.parseInt(sc.next());
                
                int total_distance = a;
                int total_cost = b;
                
                while(total_distance <= x) {
                    total_distance += c;
                    total_cost += d;
                }
                min_max[0] = Math.min(min_max[0], total_cost);
                min_max[1] = Math.max(min_max[1], total_cost);
                
            });
        System.out.println(min_max[0] + " " + min_max[1]);
    }
}
