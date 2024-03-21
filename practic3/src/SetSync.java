import java.util.HashSet;
import java.util.Set;

public class SetSync {
    public static void main(String[] args) {
        Set<Integer> syncSet = new HashSet<>();
        var first = new Thread(()->{
            synchronized (syncSet){
                System.out.println("First thread");
                syncSet.add(1);
                syncSet.add(2);
                syncSet.add(3);
                System.out.println(syncSet);
            }
        });
        var second = new Thread(()->{
            synchronized (syncSet){
                System.out.println("Second thread");
                syncSet.add(4);
                syncSet.add(5);
                syncSet.add(6);
                System.out.println(syncSet);
            }
        });
        var third = new Thread(()->{
            synchronized (syncSet){
                System.out.println("Third thread");
                syncSet.add(7);
                syncSet.add(8);
                syncSet.add(9);
                System.out.println(syncSet);
            }
        });
        first.start();
        second.start();
        third.start();

    }
}
