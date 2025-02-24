import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for findDuplicatePerson Method")
class MainTest {


    @Nested
    @DisplayName("Tests for Finding Duplicate Persons in a List")
    class FindDuplicatesPersonTests{

    }
    @Test
    @DisplayName("Duplicates are present in the list")
    void testDuplicatesPresent() {
        List<Person> personList = List.of(
                new Person("Jack",30),
                new Person("Bob",26),
                new Person("Jack",30),
                new Person("John",43),
                new Person("Bob",26),
                new Person("Olga",24)
        );

        Set<Person> duplicates = Main.findDuplicatePerson(personList);
        Assertions.assertEquals(2, duplicates.size(), "Expected 2 duplicates");
        Assertions.assertTrue(duplicates.contains(new Person("Jack", 30)));
        Assertions.assertTrue(duplicates.contains(new Person("Bob", 26)));
    }
    @Test
    @DisplayName("No duplicates in the list")
    void testNoDuplicates() {
        List<Person> personList = List.of(
                new Person("Jack", 30),
                new Person("Bob", 26),
                new Person("John", 43),
                new Person("Olga", 24)
        );

        Set<Person> duplicates = Main.findDuplicatePerson(personList);
        Assertions.assertTrue(duplicates.isEmpty(), "Expected an empty duplicate list");

    }

    @Test
    @DisplayName("Empty list test")
    void testEmptyList() {
        List<Person> personList = List.of();
        Set<Person> duplicates = Main.findDuplicatePerson(personList);
        Assertions.assertTrue(duplicates.isEmpty(), "Expected an empty duplicate list");
    }
}