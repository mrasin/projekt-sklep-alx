package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.math.BigDecimal;


//adnotacje

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, property = "typ"
) //jakie pole będzie dołączone jako dodatkowa informacja
@JsonSubTypes({

        @JsonSubTypes.Type(value = Komputer.class, name = "komputer"),
        @JsonSubTypes.Type(value = Dron.class, name = "dron")
}) //jakie typy będą dołączane

public abstract class Produkt implements Comparable<Produkt>, Serializable {

    protected long id;//protected - publiczna dla klas dziedziczących, prywatna dla wszystkich pozostałych
    protected String nazwa;
    protected BigDecimal cena;

    private static long generatorId = 0L;//zmienna statyczna - jedna dla wszystkich obiektów
    //generatorId jest globalnie zwiększany po dodaniu każdego nowego obiektu klasy Komputer


    public Produkt() {
    }

    public Produkt(String nazwa, BigDecimal cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        generatorId++;
        this.id = generatorId;
    }

    public long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    @Override
    public int compareTo(Produkt o) {
        if (this.cena.compareTo(o.cena) < 0){
            return -1;
        } else if (this.cena.compareTo(o.cena) > 0){
            return 1;
        } else {
            return 0;
        }
    }
}
