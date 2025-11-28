package com.archives;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        Mono<String> hello = Mono.just("hola");

        hello.subscribe(System.out::println);

        System.out.println("------------------- ejercicio 1 ---------------------->");
        // ejercicio 1
        Predicate<String> condition = new Predicate<String>() {
            @Override
            public boolean test(String arg0) {
                if (arg0.length() > 4) {
                    return true;
                }
                return false;
            }
        };
        // lambda expression
        Predicate<String> conditionLambda = arg0 -> arg0.length() > 4;

        String word = "bryan";
        System.out.println(condition.test(word));
        System.out.println(conditionLambda.test(word));

        System.out.println("------------------- ejercicio 2 ---------------------->");
        /**
         * ✅ Ejercicio 2 — Crea un Function
         * 
         * Transforma un String a su longitud.
         */
        Function<String, Integer> converterMethodReference = String::length;
        Function<String, Integer> converterLambda = arg1 -> arg1.length();
        Function<String, Integer> converterOverride = new Function<String, Integer>() {
            @Override
            public Integer apply(String arg0) {
                return arg0.length();
            }
        };
        System.out.println(converterMethodReference.apply(word));
        System.out.println(converterLambda.apply(word));
        System.out.println(converterOverride.apply(word));

        System.out.println("------------------- ejercicio 3 ---------------------->");

        /**
         * ✅ Ejercicio 3 — Crea un Supplier
         * 
         * Devuelve un número aleatorio entre 1 y 10.
         */

        Supplier<Long> randomNumberLambda = () -> Math.round(Math.random() * 10);
        Supplier<Long> randomNumberOverride = new Supplier<Long>() {
            @Override
            public Long get() {
                return Math.round(Math.random() * 10);
            }
        };
        System.out.println(randomNumberLambda.get());
        System.out.println(randomNumberOverride.get());

        System.out.println("------------------- ejercicio 4 ---------------------->");
        /**
         * ✅ Ejercicio 4 — Crea un Consumer
         * 
         * Imprime un mensaje formateado:
         */
        Consumer<String> logger = value -> System.out.println(String.format("Procesando: %s", value));
        Consumer<String> loggerOverride = new Consumer<String>() {
            @Override
            public void accept(String arg0) {
                System.out.println(String.format("Procesando: %s", arg0));
            }
        };
        logger.accept("Conexion");
        loggerOverride.accept("Conexion");

        System.out.println("------------------- ejercicio 5 ---------------------->");
        /**
         * ✅ Ejercicio 5 — composition: andThen + compose
         * 
         * Dadas dos funciones:
         * 
         * Una que convierte un nombre a mayúsculas
         * 
         * Otra que devuelve la longitud
         * 
         * Usa compose y andThen para obtener:
         * 
         * “mario” → transformarlo primero a MAYÚSCULAS y luego a longitud
         * 
         * “mario” → obtener la longitud y luego convertirla en String "5"
         */

        Function<String, String> uppercase = String::toUpperCase;
        Function<String, Integer> lenghtWord = String::length;
        Function<String, Integer> result = uppercase.andThen(lenghtWord);

        String uppercaseResult = uppercase.apply("Bryan");
        Integer value = result.apply("Bryan");
        System.out.println(value);
        System.out.println(uppercaseResult);

        System.out.println("------------------- ejercicio 6 ---------------------->");
        /**
         * 🧪 FASE 2 — Streams (Nivel medio)
         * ✅ Ejercicio 6 — Filtrar + map + sorted + print
         * Haz un stream que:
         * 
         * Filtre los nombres con más de 4 letras
         * 
         * Los convierta a mayúsculas
         * 
         * Los ordene
         * 
         * Los imprima
         */

        List<String> names = List.of("Ana", "Mario", "Lucia", "Andrea", "Carlos");
        names.stream()
                .filter(n -> n.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        
        System.out.println("------------------- Mono / Flux  ---------------------->");
        
        System.out.println("------------------- ejercicio 1 ---------------------->");
        
        Supplier<String> exerciseOneSupplier = () -> "Iniciando \n Procesando...";
        Mono<String> exerciseOneMono = Mono.fromSupplier(exerciseOneSupplier);
        System.out.println(exerciseOneMono);
        System.out.println(exerciseOneMono.subscribe(System.out::println));


        
    }
}