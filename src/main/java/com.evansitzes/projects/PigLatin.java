package main.java;

import java.util.Scanner;

public class PigLatin {

    private static final String VOWELS = "aeiou";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input a line, or \'exit\'");
            final String line = scanner.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            if ("exit".equals(line)) {
                return;
            }

            final String[] words = line.split(" ");

            for (final String word : words) {
                if (word.isEmpty()) {
                    continue;
                }

                System.out.print(transformSingleWord(word) + " ");
            }

            System.out.println();
        }
    }

    private static String transformSingleWord(final String word) {
        for (final char letter : word.toCharArray()) {

            if (VOWELS.indexOf(letter) == -1) {
                continue;
            }

            final String firstPart = new String(word.toCharArray(), 0, word.indexOf(letter));
            final String secondPart = new String(word.toCharArray(), word.indexOf(letter), word.length() - firstPart.length());

            return secondPart + firstPart + "ay";
        }

        return word + "ay";
    }
}