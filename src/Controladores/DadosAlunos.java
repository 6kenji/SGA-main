package Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import EstruturaDeDados.ListaLigada;

public class DadosAlunos 
{
public static void gravarArquivoBinario(ListaLigada dados, String ArquivoDados) {
        
        File arquivo = new File (ArquivoDados);

        try {
            
            arquivo.delete();
            
            arquivo.createNewFile();
            
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arquivo));
            
            objOutput.writeObject(dados);
            
            objOutput.close();

        }catch (IOException erro){
    
            System.out.printf("Erro: %s", erro.getMessage());
        
        }
    
    }

    public static ListaLigada lerArquivoBinario(String ArquivoDados) {
        
    	ListaLigada dados = new ListaLigada();
    
        try {
            
            File arquivo = new File(ArquivoDados);
        
            if(arquivo.exists()) {
            
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arquivo));
            
                dados = (ListaLigada)objInput.readObject();
            
                objInput.close();
            }
        
        }catch(IOException erro1) {
        
            System.out.printf("Erro: %s", erro1.getMessage());
        
        }catch(ClassNotFoundException erro2) {
            
            System.out.printf("Erro: %s", erro2.getMessage());
        
        }
        
        return(dados);
    
    }
}