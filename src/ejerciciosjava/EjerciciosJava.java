/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosjava;

import java.util.Arrays;

/**
 *
 * @author Joaquin Sierra
 */
public class EjerciciosJava {

    public int[] maximo(int[] listaNumeros) {
        int[] numerosMaximos = {0, 0};
        for (int i = 0; i < listaNumeros.length; i++) {
            if (numerosMaximos[0] < listaNumeros[i]) {
                numerosMaximos[1] = numerosMaximos[0];
                numerosMaximos[0] = listaNumeros[i];
            } else if (numerosMaximos[1] < listaNumeros[i]) {
                numerosMaximos[1] = listaNumeros[i];
            }
        }
        return numerosMaximos;
    }

    //NIVEL 1
    public boolean palindromoEjercicio1(String frase) {
        String palindromo = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                palindromo = palindromo + frase.charAt(i);
            }
        }
        String palindromo2 = "";
        int longitudFrase = palindromo.length();
        for (int i = 0; i < longitudFrase; i++) {
            palindromo2 = palindromo2 + palindromo.charAt(longitudFrase - i - 1);
        }
        return palindromo.equals(palindromo2);
    }

    public boolean isograma(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            for (int j = i + 1; j < palabra.length(); j++) {
                if (palabra.charAt(i) == palabra.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean anagrama(String palabra1, String palabra2) {
        char[] array1 = palabra1.toCharArray();
        char[] array2 = palabra2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return new String(array1).equals(new String(array2));
    }

    public String acronimo(String palabra) {
        String cadena = "";
        String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        for (int i = 0; i < palabra.length(); i++) {
            for (int j = 0; j < mayus.length(); j++) {
                if (palabra.charAt(i) == mayus.charAt(j)) {
                    cadena += palabra.charAt(i);
                }
            }
        }
        return cadena;
    }

    public void calendario(int mes) {
        String[] filas = new String[7];
        for (int i = 0; i < 7; i++) {
            filas[i] = "";

        }
        String n = " 0";
        int v = 0;
        int num = 0;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j < filas.length; j++) {
                if (v >= mes) {
                    n = " 0";
                    num += 1;
                }
                if (num > 9) {
                    n = " ";
                }
                if (num > 31 || v < mes) {
                    n = " XX";
                }
                filas[i] += n;
                if (num <= 31 && v >= mes) {
                    filas[i] += num;
                }
                v += 1;
            }
        }
        for (int i = 0; i < filas.length; i++) {
            System.out.println((filas[i]));
        }
    }

    //NIVEL 2
    public boolean escaleraDePalabras(char[][] escalera) {
        boolean esc = true;
        int letrasDiferentes;
        for (int fila = 0; fila < escalera.length - 1; fila++) {
            letrasDiferentes = 0;
            if (escalera[fila].length == escalera[fila + 1].length) {
                for (int columna = 0; columna < escalera[fila].length; columna++) {
                    if (escalera[fila][columna] != escalera[fila + 1][columna]) {
                        letrasDiferentes++;
                    }
                    if (letrasDiferentes > 1) {
                        esc = false;
                    }
                }
            } else {
                System.out.println("Distinta longitud");
            }
        }
        return esc;
    }

    public static void main(String[] args) {
        EjerciciosJava ejercicio1 = new EjerciciosJava();

        System.out.println(ejercicio1.palindromoEjercicio1("ACASO HUBO BUHOS ACA"));//TRUE
        System.out.println(ejercicio1.palindromoEjercicio1("JOAQUIN SIERRA"));//FALSE

        System.out.println(ejercicio1.isograma("hola"));//TRUE
        System.out.println(ejercicio1.isograma("holo"));//FALSE

        System.out.println(ejercicio1.anagrama("mora", "amor"));//TRUE
        System.out.println(ejercicio1.anagrama("moro", "amor"));//FALSE

        System.out.println(ejercicio1.acronimo("Alta Velocidad Española"));//AVE
        System.out.println(ejercicio1.acronimo("Objeto Volador No Identificado"));//OVNI
        System.out.println(ejercicio1.acronimo("Tecnología de la Informacion y de las Comunicaciones"));//TIC

        ejercicio1.calendario(3);

        System.out.println();
        char[][] listaPalabras = {
            {'P', 'A', 'T', 'A'},
            {'P', 'A', 'T', 'O'},
            {'R', 'A', 'T', 'O'},
            {'R', 'A', 'M', 'O'},
            {'G', 'A', 'M', 'O'},
            {'G', 'A', 'T', 'O'},
            {'M', 'A', 'T', 'O'},};
        System.out.println(ejercicio1.escaleraDePalabras(listaPalabras));

    }
}
