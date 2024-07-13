package com.aluracursos.conversormonedas.conversor;

import com.aluracursos.conversormonedas.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Menu {

    Conversor conversor = new Conversor();
    private Scanner scanner = new Scanner(System.in);

    private String monedaInicial;
    private String monedaFinal;
    private Double valor;
    int opcion = 0;


    public void mostrarMenu() throws IOException {

        System.out.println("*********************************");
        System.out.println("Sea bienvenido al conversor de modena");

        String menu = """
                1 - Dólar =>> Peso argentino
                2 - Peso argentino =>> Dólar
                3 - Dólar =>>Real brasileño
                4 - Real brasileño =>> Dólar
                5 - Dólar =>> Peso colombiano 
                6 - Peso colombiano =>> Dólar
                7 - Salir
                ***Elija una opción válida***
                *********************************
                """;



        while (opcion != 7) {
            System.out.println(menu);
            opcion = scanner.nextInt();
            double ValorAConvertir=0;
            if (opcion != 7){
                System.out.println("Ingresa el valor que deseas convertir:");
                ValorAConvertir = scanner.nextDouble();
            }



            switch (opcion) {
                case 1:
                    //de dolar a peso argentino

                    monedaInicial = "USD";
                    monedaFinal = "ARS";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + " USD a Pesos argentinos es de " + valor + " pesos argentinos");
                    System.out.println("\n");
                    break;


                case 2:
                    //de peso argentino  a dolar

                    monedaInicial = "ARS";
                    monedaFinal = "USD";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + "  Pesos argentinos s USD es de " + valor + " USD");
                    System.out.println("\n");
                    break;


                case 3:
                    //de dolar a real brasileño

                    monedaInicial = "USD";
                    monedaFinal = "BRL";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + "   USD  a Real Brasileño es de " + valor + " reales brasileños");
                    System.out.println("\n");
                    break;


                case 4:
                    //de real brasileño a dolar

                    monedaInicial = "BRL";
                    monedaFinal = "USD";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + "   Real Brasileño a USD es de " + valor + " USD");
                    System.out.println("\n");
                    break;

                case 5:
                    //de Dólar a Peso colombiano

                    monedaInicial = "USD";
                    monedaFinal = "COP";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + "   USD a Peso Colombiano es de " + valor + " Peso Colombiano");
                    System.out.println("\n");
                    break;

                case 6:
                    //Peso colombiano a Dólar

                    monedaInicial = "COP";
                    monedaFinal = "USD";
                    valor = conversor.convertir(monedaInicial, monedaFinal)* ValorAConvertir;
                    System.out.println("La conversión resultante de " + ValorAConvertir + "  Peso Colombiano a USD es de " + valor + " USD");
                    System.out.println("\n");
                    break;

                case 7:
                    //Salir

                    if (opcion == 7)
                        System.out.println("¡Hasta pronto!");


            }
        }
    }
}