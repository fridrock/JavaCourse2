import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var firstLine = sc.nextLine();
        var goalsFirstMatch = Arrays.stream(firstLine.split(":")).map(s->Integer.parseInt(s)).collect(Collectors.toList());
        var secondLine = sc.nextLine();
        var goalsSecondMatch = Arrays.stream(secondLine.split(":")).map(s->Integer.parseInt(s)).collect(Collectors.toList());
        var owner = sc.nextInt();
        int differenceOutside, differenceInside;
        if (owner == 1) {
            differenceInside = goalsFirstMatch.get(0)-goalsFirstMatch.get(1);
            differenceOutside = goalsSecondMatch.get(0)-goalsSecondMatch.get(1);
        }else{
            differenceOutside = goalsFirstMatch.get(0)-goalsFirstMatch.get(1);
            differenceInside = goalsSecondMatch.get(0)-goalsSecondMatch.get(1);
        }
        if(differenceInside+differenceOutside>0){
            System.out.println(0);
        }else if(differenceInside+differenceOutside==0){
            
        }

    }
}
