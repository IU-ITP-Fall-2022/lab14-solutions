package ru.makhmutov.lab.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lambda {

    private static final int LIST_LENGTH = 10;

    /**
     * This program allows generating a list of integer numbers
     * with random positive and negative values. By using lambda
     * expressions all absolute number values which are divisible
     * by 3 are displayed
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        List<Integer> integerList = generateList();
        System.out.println(integerList);
        displayUpdatedList(integerList);
    }

    private static void displayUpdatedList(List<Integer> integerList) {
        integerList.stream()
                .filter(x -> x % 3 == 0)
                .map(Math::abs)
                .forEach(System.out::println);
    }

    private static List<Integer> generateList() {
        List<Integer> integerList = new ArrayList<>(LIST_LENGTH);
        Random random = new Random();
        for (int i = 0; i < LIST_LENGTH; i++) {
            integerList.add(random.nextInt());
        }
        return integerList;
    }
}
