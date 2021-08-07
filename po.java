import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int[] stairs = new int[n+b];
        stairs[0] = 1;
        long ans = IntStream.range(0, n)
            .filter(i -> {
                if (stairs[i] == 0) {
                    return true;
                }
                stairs[i + a] = 1;
                stairs[i + b] = 1;
                return false;
            })
            .count();
        System.out.println(ans);
    }
}
