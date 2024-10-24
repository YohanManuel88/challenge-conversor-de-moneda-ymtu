package com.alurachallenge.conversor;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ConversionLogic {

    public static void performConversion(Scanner read) {
        String output = null;
        String base = null;
        String target = null;
        double amount = 0;

        ArrayList<String[]> currencies = CurrencyUtils.getCurrencies();
        System.out.println("Escriba el codigo de la moneda origen del siguiente listado: (ej. CLP) ");

        //Llamada al metodo displayCurrecies para imprimir las monedas disponibles.
        CurrencyUtils.displayCurrecies( currencies );

        // Ciclo para la moneda base con manejo de excepciones
        while (true) {
            try {
                base = read.nextLine().toUpperCase();

                if (base.matches(".*\\d.*")) {  // Verifica si contiene números
                    throw new IllegalArgumentException("El código de la moneda no puede contener números. Intente de nuevo.");
                }

                if (CurrencyUtils.isValidCurrency(base, currencies)) {
                    break;  // Salir del ciclo si es válido
                } else {
                    System.out.println("Código de moneda origen inválido. Verifique el listado e intente de nuevo.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Ciclo para la moneda destino con manejo de excepciones
        while (true) {
            try {
                System.out.println("Ahora Ingrese el código de la moneda destino (ej. COP):");
                target = read.nextLine().toUpperCase();

                if (target.matches(".*\\d.*")) {  // Verifica si contiene números
                    throw new IllegalArgumentException("El código de la moneda no puede contener números. Intente de nuevo.");
                }

                if (CurrencyUtils.isValidCurrency(target, currencies)) {
                    break;  // Salir del ciclo si es válido
                } else {
                    System.out.println("Código de moneda destino inválido. Verifique el listado e intente de nuevo.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Ciclo para la cantidad a convertir con manejo de InputMismatchException
        while (true) {
            try {
                System.out.println("Ingrese el valor de (" + base + ") a convertir: ");
                amount = read.nextDouble();

                read.nextLine();  // Limpiar el buffer de entrada
                break;  // Salir del ciclo si se ingresa un número válido
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no es un número válido. Intente de nuevo.");
                read.nextLine();  // Limpiar el buffer en caso de error
            }
        }

        //Llamado a la API
        ApiClient api = new ApiClient();
        Currency currency = api.search( base, target, amount );

        // Formatea el valor en moneda para mejor presentación usando la clase NumberFormat
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance( Locale.US);
        String formattedAmount = currencyFormat.format(amount);
        String formattedResult = currencyFormat.format(currency.conversion_result());

        //se da formato a la marca de tiempo para el historial, el atributo withNano y el parametro 0
        //indican que no muestre centecimas de segundo
        var hora = LocalDateTime.now().withNano( 0 );
        output = hora +"  --  "+formattedAmount + " " + base + " equivalen a: " + formattedResult + " " + target;
        //Imprime el resultado
        System.out.println("\n-------------------------------------------------");
        System.out.println( "Resultado obtenido a las : "+  output );
        System.out.println("--------------------------------------------------");
        ConversionHistoryManager.saveConversions( output );





    }


}
