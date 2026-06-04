package com.files;

import java.lang.reflect.Field;
import java.util.Arrays;

//refletion api
public class Main {
    public static void main(String[] args) throws Exception {
        Persona persona = new Persona("bryan", "311999999", "test@test.com");

        Class<?> clazz = Persona.class; // puede ser el class llamando a la clase
        Class<?> clazz2 = Class.forName("com.files.Persona"); // o indicando el nombre del modulo

        System.out.println(clazz.getName()); // nombre de la clase
        System.out.println(clazz.getFields()); // atributos de la clase
        System.out.println(clazz.getMethods()); // metodos de la clase
        System.out.println(clazz.getConstructors()); // constructores de la clase

        // obtener todos los atributos de una clase
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        // o un campo en especifico
        Field nameField = clazz.getDeclaredField("name");
        System.out.println(nameField.getName());

        // leer el valor del campo
        
    }
}