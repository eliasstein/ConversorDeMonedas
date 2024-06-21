package com.oracle.conversorMonedas;


import java.util.Scanner;

public class General {
    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("Sea bienvenido al conversor de monedas");
        boolean exit=true;
        double money=0,total=0;
        while(exit){
            System.out.println("1) Dolar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Peso argentino");
            System.out.println("7) Salir");
            System.out.println("*************************************************");
            System.out.print("Elija una opcion valida: ");
            Scanner scan = new Scanner(System.in);
            var option = Integer.valueOf(scan.nextLine());
            switch (option){
                case 1:
                    System.out.print("Ingrese la cantidad de USD: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().USDTo(money,"ARS");
                    System.out.println("El total es de: "+total);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de ARS: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().ToUSD(money,"ARS");
                    System.out.println("El total es de: "+total);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad de USD: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().USDTo(money,"BRL");
                    System.out.println("El total es de: "+total);
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad de BRL: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().ToUSD(money,"BRL");
                    System.out.println("El total es de: "+total);
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de USD: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().USDTo(money,"COP");
                    System.out.println("El total es de: "+total);
                    break;
                case 6:
                    System.out.print("Ingrese la cantidad de COP: ");
                    money = Double.parseDouble(scan.nextLine());
                    total = new Conversor().COPToARS(money);
                    System.out.println("El total es de: "+total);
                    break;
                case 7:
                    exit=false;
                    break;
                default:
                    System.out.println("La opcion introducida es incorrecta.");
                    break;
            }
            System.out.println("Presione enter para continuar...");
            scan.nextLine();

        }
    }
}
