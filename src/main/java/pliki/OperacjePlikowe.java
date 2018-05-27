package pliki;

import model.Sklep;

public interface OperacjePlikowe {

    public abstract void zapisz(Sklep sklep) throws Exception;//metody nie mają ciała, definiujemy tylko to, jak
    //mają one wyglądać

    public Sklep wczytaj() throws Exception;

}
