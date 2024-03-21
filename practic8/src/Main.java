import iterator.ConcreteAggregate;
import mediator.MessageBroker;
import mediator.Student;
import mediator.Teacher;
import mediator.User;

public class Main {
    public static void main(String[] args) {
        var aggregate = new ConcreteAggregate();
        var iterator = aggregate.createIterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        //mediator
        MessageBroker msgBroker = new MessageBroker();
        Teacher u1 = new Teacher(msgBroker, "Alex");
        Student u2 = new Student(msgBroker, "Ivan");
        Student u3 = new Student(msgBroker, "Nikita");
        Teacher u4 = new Teacher(msgBroker, "Alim");
        msgBroker.addUser(u1);
        msgBroker.addUser(u2);
        msgBroker.addUser(u3);
        msgBroker.addUser(u4);
        u1.send("Message from User with name:"+u1.name);
    }
}