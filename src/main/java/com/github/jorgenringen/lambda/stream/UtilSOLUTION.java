package com.github.jorgenringen.lambda.stream;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;

public class Util {

    public static List<String> mapToUppercase(List<String> input) {
    	return input.stream()
    			.map(String::toUpperCase)
    			.collect(Collectors.toList());
    }

    // bad name !!! should be named "... with more than THREE characters"
    public static List<String> removeElementsWithMoreThanFourCharacters(List<String> input) {
    	return input.stream()
    			.filter(s -> s.length() < 4)
    			.collect(Collectors.toList());
    }

    public static List<String> sortStrings(List<String> input) {
    	return input.stream()
    			.sorted(Comparator.naturalOrder())
    			.collect(Collectors.toList());
    }

    public static List<Integer> sortIntegers(List<String> input) {
    	return input.stream()
    			.map(Integer::valueOf) // why doesn't .mapToInt(Integer::parseInt) work
    								   // ^ this is a primitive Stream (IntStream), collect needs an object stream ( Stream<Something> )
    								   // solution below
    			.sorted()
    			.collect(Collectors.toList());
    	
//    	return input.stream()
//    			.mapToInt(Integer::parseInt) // but why not use a function that returns Integer instead of int? therefore above solution
//    			.sorted()
//    			.boxed()
//    			.collect(Collectors.toList());
    }

    public static List<Integer> sortIntegersDescending(List<String> input) {
    	return input.stream()
    			.map(Integer::valueOf)
    			.sorted(Comparator.reverseOrder())
    			.collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> numbers) {
    	return numbers.stream()
    			.mapToInt(Integer::intValue)
    			.sum();

//    	// my first second attempt was
//    	return numbers.stream()
//    			.mapToInt(i -> i) // cryptic, why does this work?
//    			.sum();
    }

    public static List<String> flattenToSingleCollection(List<List<String>> input) {
    	return input.stream()					// list of list as stream of lists
    			.flatMap(l -> l.stream())  		// stream every list
    			.collect(Collectors.toList());  // collect what is streamed into a list
    }

    public static String separateNamesByComma(List<Person> input) {
    	return input.stream()
    			.map(Person::getName)
    			.collect(Collectors.joining(", ", "Names: ", "."));
    }

    public static String findNameOfOldestPerson(List<Person> input) {
    	return input.stream()
    			.max(Comparator.comparingInt(p -> p.getAge()))
    			.get()
    			.getName();
    }

    public static List<String> filterPeopleLessThan18YearsOld(List<Person> input) {
    	return input.stream()
    			.filter(p -> p.getAge() < 18)
    			.map(Person::getName)
    			.collect(Collectors.toList());
    }

    public static IntSummaryStatistics getSummaryStatisticsForAge(List<Person> input) {
    	return input.stream()
				.collect(Collectors.summarizingInt(Person::getAge));

//    			// first attempt
//    			.mapToInt(Person::getAge)
//    			.summaryStatistics();
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> input) {
    	return input.stream()
    			.collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
    }

    public static Map<String, List<Person>> partitionByNationality(List<Person> input) {
    	return input.stream()
    			.collect(Collectors.groupingBy(Person::getCountry));
    }
}
