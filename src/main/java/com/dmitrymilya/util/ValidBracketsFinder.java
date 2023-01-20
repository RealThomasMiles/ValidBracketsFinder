package com.dmitrymilya.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class ValidBracketsFinder {

    private ValidBracketsFinder() {
    }

    public static String findAllValidBrackets(String input) {
        if (input == null || input.length() == 0) {
            return "0";
        }

        int count = 0;
        List<Integer> validBracketIndices = new ArrayList<>();
        Deque<Integer> bracketsStack = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                bracketsStack.push(i);
            } else if (currentChar == ')') {
                if (!bracketsStack.isEmpty() && input.charAt(bracketsStack.peek()) == '(') {
                    count += 2;
                    Integer openingBracketIndex = bracketsStack.pop();
                    validBracketIndices.add(openingBracketIndex);
                    validBracketIndices.add(i);
                }
            }
        }

        StringBuilder validBracketsBuilder = new StringBuilder();
        validBracketIndices.stream().sorted().map(input::charAt).forEach(validBracketsBuilder::append);
        return count + (count > 0 ? " - " + validBracketsBuilder : "");
    }
}
