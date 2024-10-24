package com.alurachallenge.conversor;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner read = new Scanner( System.in );
        boolean exit = false;

        //Mensaje de inicio del programa, se llama al metodo performConversion para iniciar la primer conversion:
        System.out.println("\n***-***-***-Bienvenido a la App Convertidor de Monedas-***-***-***\n");
        ConversionLogic.performConversion( read );

        while (!exit) {
            //Menu de opciones para continuar o terminar el app
            System.out.println( "\n***-***-***-Seleccione una opción-***-***-***" );
            System.out.println( "1 - Realizar una nueva conversión" );
            System.out.println( "2 - Ver el historial de conversiones" );
            System.out.println( "3 - Salir" );

            // If para el manejo de la opciones del menu.
            var opc = read.nextLine().toUpperCase();

            switch (opc) {
                case "1":
                    ConversionLogic.performConversion( read );
                    break;
                case "2":
                    ConversionHistoryManager.displayConversions();
                    break;
                case "3":
                    System.out.println( "La App ha finalizado" );
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija 1, 2 o 3.");
                    break;
            }

        }
        read.close();

    }
}
