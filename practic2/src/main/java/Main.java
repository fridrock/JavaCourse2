public class Main {
    public static void main(String[] args) {
        var test = new HumanWorker();
        System.out.println("SORTED");
        test.sortByLastSymb().forEach(System.out::println);
        System.out.println("FILTERING");
        test.filterByWeight().forEach(System.out::println);
        System.out.println("SORTED BY DATE");
        test.sortByDate().forEach(System.out::println);
        System.out.println("GET MULTIPLICATION");
        try {
            System.out.println(test.getMultiplication());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
