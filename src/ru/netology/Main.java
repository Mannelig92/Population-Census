package ru.netology;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {          // Сделал количество человек поменьше
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long result1 = persons.stream()        // Это работает
                .filter(x -> x.getAge() < 18)
                .count();
//        System.out.println("Количество несовершеннолетних " + result1);

        List<String> result2 = persons.stream()        // Это работает
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
//        System.out.println("Фамилии призывников: " + result2);

        List<String> result3 = persons.stream()   // Проблема, не понимаю в чём, почему не работает со стрингом
                .filter(x -> x.getSex() == Sex.MAN && x.getAge() >= 18 && x.getAge() < 65)
                .filter(x -> x.getSex() == Sex.WOMAN && x.getAge() >= 18 && x.getAge() < 60)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(result3);

//        numberOfMinors(persons);       // Пока скрыл всё это, далее постараюсь вынести в отдельные методы
//        conscript(persons);
//        peoplesWithHigherEducation(persons);
    }
//    static void numberOfMinors(Collection persons){
//        long result = persons.stream()
//                .filter(x -> x.getAge() > 18)
//                .count();
//        System.out.println(result);
//    }
//    static void conscript(Collection persons){
//
//    }
//    static void peoplesWithHigherEducation(Collection persons){
//
//    }
}
