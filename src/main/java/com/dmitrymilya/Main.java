package com.dmitrymilya;

import com.dmitrymilya.util.ValidBracketsFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(ValidBracketsFinder.findAllValidBrackets(input));
    }
}
