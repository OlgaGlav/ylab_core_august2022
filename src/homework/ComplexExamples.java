package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    public static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();

        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        task1();

        System.out.println();
        System.out.println("**************************************************");
        System.out.println("Task2");
        System.out.println();
        int[] data = {3, 4, 2, 7};
        int neededSumma = 10;
        System.out.println(Arrays.toString(task2(data, neededSumma)));

        System.out.println();
        System.out.println("**************************************************");
        System.out.println("Task3");
        System.out.println();

        fuzzySearch("car", "ca6$$#_rtwheel"); // true
        fuzzySearch("cwhl", "cartwheel"); // true
        fuzzySearch("cwhee", "cartwheel"); // true
        fuzzySearch("cartwheel", "cartwheel"); // true
        fuzzySearch("cwheeel", "cartwheel"); // false
        fuzzySearch("lw", "cartwheel"); // false
    }


    /*
      Task1
          Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

          Что должно получиться
              Key:Amelia
              Value:4
              Key: Emily
              Value:1
              Key: Harry
              Value:3
              Key: Jack
              Value:1
       */
    private static void task1() {
        Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .collect(Collectors.groupingBy(Person::getName))
                .forEach((key, value) -> {
                    System.out.println("Key:" + key);
                    System.out.println("Value:" + value.size());
                });
    }

    /*
    Task2

        [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */
    private static int[] task2(int[] data, int neededSumma) {
        if (data == null) {
            System.out.println("Can't check. Сatch and treat NullPointerException");
            return new int[0];
        }
        Arrays.sort(data);
        int j = data.length - 1;
        int i = 0;
        while (i < j) {
            if (data[i] + data[j] == neededSumma) {
                return new int[]{data[i], data[j]};
            }
            if (data[i] + data[j] < neededSumma) {
                i++;
            } else {
                j--;
            }
        }
        throw new RuntimeException("Numbers are not found");
    }

    /*
       Task3
           Реализовать функцию нечеткого поиска
                   fuzzySearch("car", "ca6$$#_rtwheel"); // true
                   fuzzySearch("cwhl", "cartwheel"); // true
                   fuzzySearch("cwhee", "cartwheel"); // true
                   fuzzySearch("cartwheel", "cartwheel"); // true
                   fuzzySearch("cwheeel", "cartwheel"); // false
                   fuzzySearch("lw", "cartwheel"); // false
        */
    public static boolean fuzzySearch(String first, String second) {

        if (first == null || second == null) {
            System.out.println("Can't check. Сatch and treat NullPointerException");
            return false;
        }

        if (first.length() > second.length()) {
            return false;
        }

        int indicatorSecond = 0;
        char[] firstChars = first.toCharArray();

        for (int i = 0; i < firstChars.length; i++) {
            int index = second.indexOf(firstChars[i], indicatorSecond);
            if (index == -1 ||
                    //if the length of the remaining string is greater than the number of letters in the second word
                    ((firstChars.length - i) > (second.length() - index))) {
                return false;
            }
            indicatorSecond = index + 1;
        }
        return true;
    }
}
