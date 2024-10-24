package com.alurachallenge.conversor;

import java.io.*;
import java.util.ArrayList;

public class ConversionHistoryManager {
    private static final String HISTORY_FILE = "conversiones.log";

    public static void saveConversions(String output) {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter( (HISTORY_FILE), true ) )) {
            writer.write( output );
            writer.newLine();

        } catch (IOException e) {
            System.out.println( "Error al guardar el historial: " + e.getMessage() );
        }

        }

    public static void displayConversions() {
        ArrayList<String> historyEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader( new FileReader( HISTORY_FILE ) )) {
            String line;
            while ((line = reader.readLine()) != null) {
                historyEntries.add( line );
            }
        } catch (IOException e) {
            System.out.println( "Error al leer el archivo del historial de conversiones: " + e.getMessage() );
        }

        if (historyEntries.isEmpty()) {
            System.out.println( "No hay historial de conversiones." );
        } else {
            System.out.println( "***-***-***-Historial de Conversiones-***-***-***" );
            for (String entry : historyEntries) {
                System.out.println( entry );
            }
        }
    }


}



