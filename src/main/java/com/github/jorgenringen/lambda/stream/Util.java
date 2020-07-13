package com.github.jorgenringen.lambda.stream;


import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {

    public static List<String> mapToUppercase(List<String> input) {
        throw new UnsupportedOperationException();    }

    public static List<String> removeElementsWithMoreThanFourCharacters(List<String> input) {
        throw new UnsupportedOperationException();    }

    public static List<String> sortStrings(List<String> input) {
        throw new UnsupportedOperationException();    }

    public static List<Integer> sortIntegers(List<String> input) {
        throw new UnsupportedOperationException();    }

    public static List<Integer> sortIntegersDescending(List<String> input) {
        throw new UnsupportedOperationException();    }

    public static Integer sum(List<Integer> numbers) {
        throw new UnsupportedOperationException();    }

    public static List<String> flattenToSingleCollection(List<List<String>> input) {
        throw new UnsupportedOperationException();
    }

    public static String separateNamesByComma(List<Person> input) {
        String namesSeparatedByComa = input.stream()
                .map(person -> person.getName())
                .collect(Collectors.joining(", "));

        return "Names: " + namesSeparatedByComa + ".";
    }

    public static String findNameOfOldestPerson(List<Person> input) {
        return input.stream()
                .max(Comparator.comparing(person -> person.getAge()))
                .map(person -> person.getName())
                .orElseThrow(() -> new IllegalStateException("A person with max age should exist"));
    }

    public static List<String> filterPeopleLessThan18YearsOld(List<Person> input) {
        throw new UnsupportedOperationException();    }

    public static IntSummaryStatistics getSummaryStatisticsForAge(List<Person> input) {
        throw new UnsupportedOperationException();    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> input) {
        throw new UnsupportedOperationException();    }

    public static Map<String, List<Person>> partitionByNationality(List<Person> input) {
        throw new UnsupportedOperationException();    }
}
