package edu.kidswhocode.shapes;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * PersonStreamTesterApp.
 *
 * @author Zakir Magdum
 */
public class PersonStreamTesterApp {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<Person> persons = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> persons.add(new Person(faker.name().firstName(),
                faker.name().lastName(),
                faker.number().numberBetween(10, 60),
                faker.number().numberBetween(12, 90),
                faker.bool().bool() ? Person.Gender.FEMALE : Person.Gender.MALE)));
       // 1. Looping
        persons.stream().forEach(System.out::println);






















        // 2. filter
        System.out.println("Finding persons more than 25 years old");
        persons.stream().filter(p -> p.getAge() > 25).forEach(System.out::println);

        // 3. finding first female
        System.out.println("Finding first female");
        persons.stream().filter(p -> p.getGender() == Person.Gender.FEMALE).findFirst().ifPresent(System.out::println);

        // 4. convert
        System.out.println("Printing last name and first name");
        persons.stream().map(p -> p.getLastName() + ", " + p.getFirstName()).forEach(System.out::println);

        // 5. maximum, minimum
        System.out.println("Finding minimum and maximum");
        System.out.println("Maximum age " + persons.stream().map(p -> p.getAge()).max(Integer::max).get());
        System.out.println("Minimum height " + persons.stream().map(p -> p.getAge()).min(Integer::min).get());

        // 6. collect
        System.out.println("Collecting");
        // 6.a from one collection to the other
        persons.stream().collect(Collectors.toSet()).forEach(System.out::println);

        // 6.b joiner
        System.out.println(persons.stream().filter(p -> p.getGender() == Person.Gender.FEMALE).map(p -> p.getLastName() + ", " +
                p.getFirstName()).collect(Collectors.joining(",")));

        // 7. convert to map
        System.out.println("Converting to map");
        Map<String, Person> personMap = persons.stream().filter(p -> p.getGender() == Person.Gender.MALE)
                .collect(Collectors.toMap(p -> p.getLastName() + ", " + p.getFirstName(), p -> p));

        System.out.println(personMap.keySet());
        // 8. sort
        System.out.println("Sort ");
        persons.stream().sorted((s1, s2) -> {
            if (s1.getLastName().equals(s2.getLastName())) {
                return s1.getFirstName().compareTo(s2.getFirstName());
            }
            return s1.getLastName().compareTo(s2.getLastName());
        }).forEach(System.out::println);

        // 9. parallel streams
        System.out.println("Using parallel streams");
        IntStream.range(0, 5000).forEach(i -> persons.add(new Person(faker.name().firstName(), faker.name().lastName(),
                faker.number().numberBetween(10, 60), faker.number().numberBetween(12, 90),
                faker.bool().bool() ? Person.Gender.FEMALE : Person.Gender.MALE)));
        persons.parallelStream().filter(p -> p.getAge() > 50).forEach(System.out::println);

    }
}
