package Controladores;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import EstruturaDeDados.ListaLigada;

public class DadosAlunos {
    
    private String filename;

    public DadosAlunos(String filename) {
        this.filename = filename;
    }

    @SuppressWarnings("unchecked")
    public ListaLigada read() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(filename)));
            ListaLigada vector = (ListaLigada) inputStream.readObject();
            inputStream.close();
            return vector;
        } catch (IOException | ClassNotFoundException e) {
            return new ListaLigada ();
        }
    }

    public void write(ListaLigada vector) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(filename)));
            outputStream.writeObject(vector);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}