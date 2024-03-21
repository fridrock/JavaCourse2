import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class MapSemaphore {
    public static void main(String[] args) {
        Map<Integer, String> syncMap = new HashMap<>();
        var semaphore = new Semaphore(1);
        var first = new Thread(()->{
            try{
                semaphore.acquire();
                System.out.println("First thread");
                syncMap.put(1, "Clynic");
                syncMap.put(2, "K");
                syncMap.put(3, "A");
                syncMap.put(4, "D");
                syncMap.keySet().stream().forEach(k->{
                    System.out.println(k+":"+syncMap.get(k));
                });
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally{
                semaphore.release();
            }
        });
        var second = new Thread(()->{
            try{
                semaphore.acquire();
                System.out.println("Second thread");
                syncMap.put(1, "NIKNOJIsfbh;Op");
                syncMap.put(2, "A");
                syncMap.put(3, "L");
                syncMap.put(4, "O");
                syncMap.keySet().stream().forEach(k->{
                    System.out.println(k+":"+syncMap.get(k));
                });
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally{
                semaphore.release();
            }
        });
        first.start();
        second.start();
    }
}