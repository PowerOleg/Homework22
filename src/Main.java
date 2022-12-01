import java.util.*;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            people.add(new Person(
                            names.get(random.nextInt(names.size())),
                            families.get(random.nextInt(families.size())),
                            random.nextInt(100),
                            Sex.values()[random.nextInt(Sex.values().length)],
                            Education.values()[random.nextInt(Education.values().length)]
                    )
            );
        }
        printEasyTasks(people);
        System.out.println("3. The list of capable people with higher education:");
        Stream<Person> MAN = people.stream().filter(n -> n.getSex() == Sex.MAN).filter(n -> n.getAge() < 65);
        Stream<Person> WOMAN = people.stream().filter(n -> n.getSex() == Sex.WOMAN).filter(n -> n.getAge() < 60);
        List<Person> capablePeople = Stream.concat(MAN, WOMAN).filter(n -> n.getAge() >= 18)
                .filter(n -> n.getEducation() == Education.HIGHER)
                .sorted((o1, o2) -> Character.compare(o1.getFamily().charAt(0), o2.getFamily().charAt(0)))
                .toList();
        capablePeople.forEach(n -> System.out.println(n));
    }
    public static void printEasyTasks(Collection<Person> people) {
        long numbersOfTeenager = people.stream().filter(n -> n.getAge() < 18).count();
        System.out.println("1. The number of people under 18 year: " + numbersOfTeenager);

        List<String> surnamesToRecruit = people.stream().filter(n -> n.getAge() >= 18)
                .filter(n -> n.getAge() < 27).map(n -> n.getFamily()).toList();
        System.out.println("2. Surnames of people for a military recruitment: ");
        surnamesToRecruit.forEach(n -> System.out.println(n));
    }
}
