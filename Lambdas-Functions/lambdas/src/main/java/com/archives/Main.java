package com.archives;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // clases anonimas y Lambdas Expression
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Clase anonima");
            }
        };

        r.run();

        Runnable b = () -> System.out.println("Lambda Expression");
        b.run();

        // Consumer<T> -> void , Supplier -> T, Function<T, R> -> R, Predicate<T> ->
        // boolean
        Consumer<String> word = s -> System.out.println(s.charAt(0)); // no retorna nada pero ejecuta lo logica que
                                                                      // requieras
        word.accept("Hola");

        Consumer<Integer> number = n -> {
            System.out.println(n * 2);
        };

        number.accept(5);

        // supplier no espera parametros pero retorna un valor
        Supplier<Double> ramdomNumber = () -> Math.random();
        System.out.println(ramdomNumber.get());

        // Function
        Function<String, Integer> parsear = Integer::parseInt;
        System.out.println(parsear.apply("0"));

        // predicate
        Predicate<Integer> esPar = n -> n % 2 == 0;
        boolean isPar = esPar.test(4);
        System.out.println(isPar);

        // ejercicios
        List<String> names = List.of("Ana", "Mario", "Lucia", "Andrea", "Carlos");
        List<String> result = names.stream()
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println(result);

        // Programcion funcional
        // Map
        List<String> words = List.of("Juan", "Andres", "Ana");
        List<Integer> lenghtWord = Array.map(words, String::length);
        System.out.println(lenghtWord);

        // filter
        List<String> words2 = List.of("Anas", "tre", "xss");
        List<String> isEqualLenght = Array.filter(words2, n -> n.length() == 3);
        System.out.println(isEqualLenght);

        // reduce

        // flatMap
        List<List<String>> names3 = List.of(
                List.of("Luis"),
                List.of("Ana"),
                List.of("Andrea"));

        // resultado esperado -> ['L', 'u','i','s','A','n','a','A','n','d','r','e','a']
        List<String> chars = Array.flatMap(
                Array.flatMap(names3, fila -> fila), // aplanar matriz
                name -> name.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .toList() // convertir nombre → lista de chars
        );

        System.out.println(chars);
    }
}