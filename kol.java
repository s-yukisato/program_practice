import java.util.*;
import java.util.stream.IntStream;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        List<Integer> aList = new ArrayList<>();
        IntStream.range(0, a.length())
            .forEach(i -> aList.add(a.charAt(i) - 96));
        List<Integer> bList = new ArrayList<>();
        IntStream.range(0, b.length())
            .forEach(i -> bList.add(b.charAt(i) - 96));

        // aList.stream().forEach(i -> System.out.println(i));
        
        List<Integer> conn1 = new ArrayList<>();
        conn1.addAll(aList);
        conn1.addAll(bList);
        
        List<Integer> conn2 = new ArrayList<>();
        conn2.addAll(bList);
        conn2.addAll(aList);
        
        int ans = Math.max(f(conn1), f(conn2));
        System.out.println(ans);
    }
    
    static Integer f(List<Integer> list) {
        while(list.size() != 1) {
            List<Integer> tmp = new ArrayList<>();
            IntStream.range(0, list.size() -1)
                .forEach(i -> tmp.add((list.get(i) + list.get(i + 1)) % 101));
            list.clear();
            list.addAll(tmp);
            tmp.clear();
        }
        return list.get(0);
    }
}
