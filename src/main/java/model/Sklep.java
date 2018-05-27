package model;

import java.io.Serializable;
import java.util.*;

public class Sklep implements Serializable {

    //Serializable - pliki są serializowane (mogą być zapisywane binarnie)

    //składowe sklepu
    private Collection<Produkt> produkty;
    private String nazwa;

    public Sklep() {
    }

    public Sklep(String nazwa){
        this.produkty = new ArrayList<>();
        this.nazwa = nazwa;
    }
    //metody
    public void dodaj(Produkt produkt){
        produkty.add(produkt);
    }

    public void usun (long id){
        Iterator<Produkt> iterator = produkty.iterator();
        while (iterator.hasNext()){
            Produkt produkt = iterator.next();
            if (produkt.getId() == id){
                iterator.remove();
            }
        }
    }

    public void wyswietl(){
        for (Produkt tmpProdukt: produkty){
            System.out.println(tmpProdukt);
        }
    }

    public void sortujOdNajdrozszego() {
        List<Produkt> kopiaProdukty = new ArrayList<>(produkty); //utworzenie kopii listy, żeby możliwe było zastosowanie sortowania,
        //które nie było wcześniej możliwe dla obiektu klasy Collection (bo mógłby on być np. Setem, którego
        //nie da się posortować)

        Collections.sort(kopiaProdukty);
        for (Produkt tmp: kopiaProdukty){
            System.out.println(tmp);
        }
    }

    public void sortujPoNazwie() {
        Comparator<Produkt> nazwaKomparator = new Comparator<Produkt>() {
            // obiekt klasy anonimowej, która nie została nigdzie zdefiniowana
            @Override
            public int compare(Produkt o1, Produkt o2) {
                if (o1.nazwa.compareTo(o2.nazwa) < 0){
                    return -1;
                }
                else if (o1.nazwa.compareTo(o2.nazwa) > 0){
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        List<Produkt> kopiaProdukty = new ArrayList<>(produkty);
        Collections.sort(kopiaProdukty, nazwaKomparator);
        for (Produkt tmp: kopiaProdukty){
            System.out.println(tmp);
        }
    }

    public Collection<Produkt> getProdukty() {
        return produkty;
    }

    public String getNazwa() {
        return nazwa;
    }
}
