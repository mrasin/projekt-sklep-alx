package controller;

import model.Dron;
import model.Komputer;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    public void wyswietlMenu() {
        //odczyt z pliku

        Scanner scanner = new Scanner(System.in);
        System.out.print("Jaki sposób zapisu wybierasz? (1 - pliki binarne, 2 - pliki tekstowe, JSON): ");

        OperacjePlikowe pliki;

        String wyborPliku = scanner.nextLine();
        switch (wyborPliku) {
            case "1": {
                pliki = new PlikiBinarne();
                break;
            }
            case "2": {
                pliki = new PlikiJson();
                break;
            }
            default:
                pliki = new PlikiJson();
                break;
        }

        //PlikiJson pliki = new PlikiJson();
        //PlikiBinarne plikiBinarne = new PlikiBinarne();

        Sklep sklep;
        try {
            sklep = pliki.wczytaj();

        } catch (Exception e) {
            System.out.println("Błąd odczytu, startujemy z pustym sklepem");
            e.printStackTrace();

            sklep = new Sklep("www.allegro.pl");
        }

        //Sklep sklep = new Sklep("www.allegro.pl");
        System.out.println("1 - dodaj komputer");
        System.out.println("2 - usuń");
        System.out.println("3 - wyświetl listę produktów");
        System.out.println("4 - dodaj dron");
        System.out.println("5 - wyświetl produkty od najdroższego do najtańszego");
        System.out.println("6 - wyświetl posortowane po nazwie");
        System.out.println("q - wyjdź");

        String wybor;

        do {
        System.out.print("Podaj wybór: ");
        wybor = scanner.nextLine();
            switch (wybor) {
                    case "1": {
                        //wczytać informacje o komputerze
                        System.out.print("Podaj nazwę komputera: ");
                        String nazwa = scanner.nextLine();
                        System.out.print("Podaj cenę komputera: ");
                        BigDecimal cena = scanner.nextBigDecimal();
                        scanner.nextLine(); //trzeba dodawać za BigDecimal, int, double, bo w przciewnym przypadku zostaje \n
                        //który jest wciągany przez kolejny scanner

                        System.out.print("Podaj markę komputera: ");
                        String marka = scanner.nextLine();
                        System.out.print("Podaj ilość pamięci RAM (Gb): ");
                        int ram = scanner.nextInt();
                        scanner.nextLine();

                        //stworzyć obiekt typu Komputer
                        Komputer komputer = new Komputer(nazwa, cena, marka, ram);

                        //wywołać metodę dodaj klasy Sklep
                        sklep.dodaj(komputer);
                        break;
                }
                case "2":
                //wczytać ID
                    System.out.print("Podaj ID usuwanego komputera: ");
                    Long podaneId = scanner.nextLong();
                    scanner.nextLine();

                    //wywołać metodę usun klasy Sklep
                    sklep.usun(podaneId);
                    break;

                case "3":
                    //wywołać metodę wyświetl klasy Sklep
                    sklep.wyswietl();
                    break;

                case "4": {
                    System.out.print("Podaj nazwę drona: ");
                    String nazwa = scanner.nextLine();
                    System.out.print("Podaj cenę drona: ");
                    BigDecimal cena = scanner.nextBigDecimal();
                    scanner.nextLine();
                    System.out.print("Podaj zasięg drona: ");
                    double zasieg = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Określ, czy ma kamerę (t/n): ");
                    String wejscie = scanner.nextLine();

                    boolean czyMaKamere;
                    if (wejscie.equalsIgnoreCase("t")){
                        czyMaKamere = true;
                    }
                    else {
                      czyMaKamere = false;
                    }

                    //stworzyć obiekt typu Dron
                    Dron dron = new Dron(nazwa, cena, zasieg, czyMaKamere);

                    //wywołać metodę dodaj klasy Sklep
                    sklep.dodaj(dron);
                    break;
                }

                case "5":
                    sklep.sortujOdNajdrozszego();
                break;

                case "6":
                    sklep.sortujPoNazwie();
                    break;


                case "q":
                case "Q":
                    //zapis do pliku
                    try {
                        pliki.zapisz(sklep);
                    } catch (Exception e) {
                        System.out.println("Błąd zapisu do pliku");
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Błędna odpowiedź, spróbuj jeszcze raz");
            }
        } while (!wybor.equalsIgnoreCase("q"));
    }
}
