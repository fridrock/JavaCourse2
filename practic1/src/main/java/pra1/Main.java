package pra1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<List<Student>> hasMax = (students)->{
            for(Student s : students){
                if(s.ball==100) return true;
            }
            return false;
        };
        var st1 = new Student(1, 50);
        var st2 = new Student(2, 100);
        var st3 = new Student(3, 40);
        var without = new ArrayList<Student>();
        without.addAll(List.of(st1, st3));
        var with = new ArrayList<Student>();
        with.addAll(List.of(st1,st2,st3));
        System.out.println(hasMax.test(without));
        System.out.println(hasMax.test(with));
    }
}
