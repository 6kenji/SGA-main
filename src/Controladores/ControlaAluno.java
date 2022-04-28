package Controladores;
import EstruturaDeDados.ListaLigada;
import Interfaces.InterfaceGeral;
import Objecto.Aluno;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControlaAluno implements Serializable 
{

    DadosAlunos  da = new DadosAlunos();
    
    public void criarAluno(ListaLigada ov, Aluno a)
    {
        // TODO Auto-generated method stub
        ov = da.lerArquivoBinario("alunos.dat");
	ov.adicionaFim(a);
        da.gravarArquivoBinario(ov,"alunos.dat");
        JOptionPane.showMessageDialog(null, "Aluno criado com sucesso. ");
        imprimirTempoActual();
    }
    
    public void ListarAluno(ListaLigada ov, String nome) 
    {
        // TODO Auto-generated method stub
	JOptionPane.showMessageDialog(null, ov.toString());
    }
    
    public void removerAluno(ListaLigada ov, String nome) 
    {
        // TODO Auto-generated method stub
	for(int i = 0; i<ov.tamanho(); i++) 
        {
            if(((Aluno)ov.pega(i)).equals(nome)) 
            {
		ov.removePosicao(i);
            }
	}
        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso. ");
    }
	
    public void imprimirTempoActual() 
    {
        Date dataHoje = new Date();
        
        DateFormat formatarDataHoje =  new SimpleDateFormat("dd / MM / yyyy  HH:mm:ss");
        
        JOptionPane.showMessageDialog(null, "Data de operacao : "+formatarDataHoje.format(dataHoje));
    }
}