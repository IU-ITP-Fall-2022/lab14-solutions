package ru.makhmutov.lab.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringSorter {

    private static final int MAX_STRING_LENGTH = 10;
    private static final int LIST_LENGTH = 30;
    private static final int NUMBER_OF_DIGITS = 10;
    private static final int ENGLISH_ALPHABET_LENGTH = 26;
    private static final int LOWER_A_ASCII_CODE = 97;
    private static final int UPPER_A_ASCII_CODE = 65;

    /**
     * This program generates list of strings including
     * English letters and numbers, adds generated duplicates
     * to the same list and then displays sorted list
     * containing non-empty unique strings without numbers
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        List<String> stringList = generateStrings();
        sortAndDisplayStrings(stringList);
    }

    private static List<String> generateStrings() {
        List<String> stringList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < LIST_LENGTH / 2; i++) {
            int strLength = random.nextInt(MAX_STRING_LENGTH);
            StringBuilder sb = new StringBuilder();
            for (int stringElement = 0; stringElement < strLength; stringElement++) {
                boolean isDigit = random.nextBoolean();
                if (isDigit) {
                    sb.append(random.nextInt(NUMBER_OF_DIGITS));
                } else {
                    boolean isUpperCase = random.nextBoolean();
                    int asciiCode = random.nextInt(ENGLISH_ALPHABET_LENGTH) +
                            (isUpperCase ? UPPER_A_ASCII_CODE : LOWER_A_ASCII_CODE);
                    sb.append((char) asciiCode);
                }
            }
            stringList.add(sb.toString());
        }
        stringList.addAll(stringList);
        System.out.println("\nGenerated list:");
        stringList.forEach(System.out::println);
        return stringList;
    }

    private static void sortAndDisplayStrings(List<String> stringList) {
        if (!stringList.isEmpty()) {
            System.out.println("\nSorted list:");
            stringList.stream()
                    .filter(s -> s.matches("[a-zA-Z]+"))
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } else {
            System.out.println("The list is empty, no strings satisfy conditions");
        }
    }
}
