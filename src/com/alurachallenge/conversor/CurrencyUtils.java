package com.alurachallenge.conversor;

import java.util.ArrayList;

public class CurrencyUtils {

    // Metodo que crea y obtiene el ArrayList de monedas
    public static ArrayList<String[]> getCurrencies() {
        ArrayList<String[]> currencies = new ArrayList<>();
        currencies.add( new String[]{"USD", "Dólar estadounidense"} );
        currencies.add( new String[]{"EUR", "Euro"} );
        currencies.add( new String[]{"JPY", "Yen japonés"} );
        currencies.add( new String[]{"GBP", "Libra esterlina"} );
        currencies.add( new String[]{"AUD", "Dólar australiano"} );
        currencies.add( new String[]{"CAD", "Dólar canadiense"} );
        currencies.add( new String[]{"CHF", "Franco suizo"} );
        currencies.add( new String[]{"CNY", "Yuan chino"} );
        currencies.add( new String[]{"MXN", "Peso mexicano"} );
        currencies.add( new String[]{"BRL", "Real brasileño"} );
        currencies.add( new String[]{"ARS", "Peso argentino"} );
        currencies.add( new String[]{"COP", "Peso colombiano"} );
        currencies.add( new String[]{"CLP", "Peso chileno"} );
        currencies.add( new String[]{"PEN", "Sol peruano"} );
        currencies.add( new String[]{"DOP", "Peso dominicano"} );
        return currencies;
    }

    //Metodo que formatea en tres columnas para imprimir el contenido del ArrayList currencies

    public static void displayCurrecies(ArrayList<String[]> currencies) {

        int counter = 0;
        for (String[] index : currencies) {
            // %s es para strings, -5s es para alinear a la izquierda con 5 caracteres, -25s para nombre con 25 caracteres
            System.out.printf( "%-5s %-25s", index[0], index[1] );
            counter++;

            // Cada 3 elementos, hacer un salto de línea
            if (counter % 3 == 0) {
                System.out.println();
            }
        }
    }


    // Metodo para validar si un código de moneda es válido
    public static boolean isValidCurrency(String code, ArrayList<String[]> currencies) {
        for (String[] currency : currencies) {
            if (currency[0].equalsIgnoreCase(code)) {
                return true; // Si el código coincide con algún código en el ArrayList, es válido
            }
        }
        return false; // Si no coincide, no es válido
    }



}
