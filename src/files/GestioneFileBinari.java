package files;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class GestioneFileBinari {

    public static Object caricaDati(String nomeFile) throws Exception { //leggere un file
        Object temp = null;
        ObjectInputStream leggiFile = null;

        try {
            leggiFile = new ObjectInputStream(new FileInputStream(nomeFile));
            temp = leggiFile.readObject();
        }
        catch (Exception e) { //IOException e FileNotFoundException
            throw e;
        }
        finally {
            if(leggiFile != null)
                leggiFile.close();
        }
        return temp;
    }

    public static void salvaDati(Object obj, String nomeFile) throws Exception { //scrivere sul file
        ObjectOutputStream scriviFile = null;
        try {
            scriviFile = new ObjectOutputStream(new FileOutputStream(nomeFile));
            scriviFile.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            if(scriviFile != null)
                scriviFile.close();
        }
    }
}
