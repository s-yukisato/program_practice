import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, 4)
            .forEach(i -> {
                char c = line.charAt(i);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            });
        int kind = map.size();
        int max = 0;
        for(int value: map.values()) {
            max = Math.max(max, value);
        }
        if (map.containsKey('*')) {
            kind -= 1;
            max += 1;
        }
        if(max == 4) {
            System.out.println("FourCard");
        } else if(max == 3) {
            System.out.println("ThreeCard");
        } else if(max == 2 && kind == 2) {
            System.out.println("TwoPair");
        } else if (max == 2) {
            System.out.println("OnePair");
        } else {
            System.out.println("NoPair");
        }
    }
}
