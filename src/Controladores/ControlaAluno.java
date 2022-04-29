package Controladores;
import EstruturaDeDados.ListaLigada;
import Interfaces.InterfaceGeral;
import Objecto.Aluno;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;

public class ControlaAluno implements Serializable 
{
    static final String dados = "alunos.dat";
    DadosAlunos  dadosAluno;
    ListaLigada listaAluno;

    public ControlaAluno() {
        dadosAluno = new DadosAlunos(dados) ;
        this.load();
    }

    public Aluno addAluno(String nome, String apelido, String nacionalidade, String sexo) {
        if (this.listaAluno == null)
            load();
        Aluno aluno = new Aluno( nome, apelido, nacionalidade, sexo);
        this.listaAluno.adicionaFim(aluno);
        this.save();
        return aluno;
    }

    public Aluno updateAluno(String nome, String apelido, String nacionalidade, String sexo, UUID id) {
        Aluno aux = new Aluno(nome, apelido, nacionalidade, sexo);
        aux.setId(id);
        int posicao = listaAluno.getPosicao(aux);
        Aluno aluno = (Aluno) listaAluno.pega(posicao);
        if (aluno != null) {
            if (nome.trim().equals(""))
                aux.setNome(aluno.getNome());
            if (apelido.trim().equals(""))
                aux.setApelido(aluno.getApelido());
            if (nacionalidade.trim().equals(""))
                aux.setNacionalidade(aluno.getNacionalidade());
            if (sexo.trim().equals(""))
                aux.setSexo(aluno.getSexo());
            listaAluno.removePosicao(posicao);
            listaAluno.adicionaPosicao(posicao, aux);
            this.save();
            return aux;
        }
        return null;
    }

    public Aluno[] getAluno() {
        Aluno[] arrayAluno = new Aluno[this.listaAluno.tamanho()];

        for (int i = 0; i < arrayAluno.length; i++) {
            arrayAluno[i] = (Aluno) this.listaAluno.pega(i);
        }

        return arrayAluno;
    }

    private void load() {
        this.listaAluno = dadosAluno.read();
    }

    private void save() {
        if (this.listaAluno == null)
            throw new RuntimeException();
        this.dadosAluno.write(this.listaAluno);
    }

    public boolean deleteCliente(int posicao) {
        
        try{
            listaAluno.removePosicao(posicao);
            this.save();
            return true;
            
        }catch(Exception ex){
            return false;   
        }
    }
}