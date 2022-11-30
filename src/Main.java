import java.util.*;

public class Main {
    public static void print(Collection<Person> list) {
        for (Iterator<Person> iterator = list.iterator(); iterator.hasNext(); ) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(new Person(
                                  names.get(random.nextInt(names.size())),
                                  families.get(random.nextInt(families.size())),
                                  random.nextInt(100),
                                  Sex.values()[random.nextInt(Sex.values().length)],
                                  Education.values()[random.nextInt(Education.values().length)]
                      )
            );
        }
        long numbersOfTeenager = people.stream().filter(n -> n.getAge() < 18).count();



        print(people);




    }
}
