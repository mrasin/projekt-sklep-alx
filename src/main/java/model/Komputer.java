package model;

import java.math.BigDecimal;

public class Komputer extends Produkt{

    private String marka;
    private int ram;

    public Komputer() {}

    public Komputer(String nazwa, BigDecimal cena, String marka, int ram) {
        super(nazwa, cena);//wywołanie konstruktora klasy bazowej, super - odniesienie się do klasy, z której dziedziczmy
        this.marka = marka;
        this.ram = ram;
    }

    public String getMarka() {
        return marka;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "marka='" + marka + '\'' +
                ", ram=" + ram +
                ", id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
