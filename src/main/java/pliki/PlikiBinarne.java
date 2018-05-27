package pliki;

import model.Sklep;

import java.io.*;

public class PlikiBinarne implements OperacjePlikowe {

    // InputStream, OutputStream - pliki binarne
    // Reader (Scanner), Writer - pliki tekstowe

    public void zapisz (Sklep sklep) throws IOException {
        FileOutputStream fos = new FileOutputStream("sklep.bin");
        ObjectOutputStream ous = new ObjectOutputStream(fos); //dekorowanie FileOutputStream,
        // aby uzyskać dodatkowe metody (wyjść na wyższy poziom), bo FileOutputStream jest niskopoziomowy (zapis bajtów itp.)

        ous.writeObject(sklep); // zamiana obiektu sklep na zapis binarny i jego zapis do pliku .bin

        ous.close();
        fos.close();
    }

    public Sklep wczytaj() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("sklep.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sklep sklep = (Sklep)ois.readObject(); //mechanizm serializacji nie zapisuje typu obiektu

        ois.close();
        fis.close();

        return sklep;
    }
}
