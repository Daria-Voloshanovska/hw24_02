import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class MainTest {





    @Nested
    public class Test_findCommonPerson{


       @Test
        @DisplayName("list has common person")
        public void listHasCommonPerson(){
            List<Person> list1 = List.of(
                    new Person("Jack", 12),
                    new Person("John", 22),
                    new Person("Jack", 22),
                    new Person("Oleg", 24)
            );
            List<Person> list2 = List.of(
                    new Person("John", 22),
                    new Person("Jack", 22),
                    new Person("Oleg", 24),
                    new Person("Lena", 25),
                    new Person("Irina", 23)
            );

            Set<Person> expected = Set.of(
                    new Person("John", 22),
                    new Person("Jack", 22),
                    new Person("Oleg", 24)
            );
            Set<Person> actual = Main.findCommonPerson(list1,list2);
            Assertions.assertEquals(expected,actual);
        }

        @Test
        @DisplayName("lists have not common person")
        public void listHasNotCommonPerson(){
            List<Person> list1 = List.of(
                    new Person("Jack", 12),
                    new Person("John", 22),
                    new Person("Jack", 22),
                    new Person("Oleg", 24)
            );
            List<Person> list2 = List.of(

                    new Person("Lena", 25),
                    new Person("Irina", 23)
            );



            Set<Person> actual = Main.findCommonPerson(list1,list2);
            Assertions.assertTrue(actual.isEmpty());
        }

        @Test
        @DisplayName("list1 is null, expected empty list")
        public void list1Null(){
            List<Person> list1 = null;
            List<Person> list2 = List.of(

                    new Person("Lena", 25),
                    new Person("Irina", 23)
            );

            Set<Person> actual = Main.findCommonPerson(list1,list2);
            Assertions.assertTrue(actual.isEmpty());
        }
        @Test
        @DisplayName("list2 is null, expected empty list")
        public void list2Null(){
            List<Person> list2 = null;
            List<Person> list1 = List.of(

                    new Person("Lena", 25),
                    new Person("Irina", 23)
            );

            Set<Person> actual = Main.findCommonPerson(list1,list2);
            Assertions.assertTrue(actual.isEmpty());
        }
        @Test
        @DisplayName("list1 and list2 are null, expected empty list")
        public void listsNull(){
            Set<Person> actual = Main.findCommonPerson(null,null);
            Assertions.assertTrue(actual.isEmpty());
        }

    }

}