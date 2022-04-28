package Controladores;

import EstruturaDeDados.ListaLigada;
import Objecto.Aluno;

public class OperacoesAluno 
{
	protected static ListaLigada alunos = DadosAlunos.lerArquivoBinario("alunos.dat");
	
	public static ListaLigada getAlunos() 
	{
            return alunos;
	}
	public static void setAluno(Aluno aluno) 
	{
            alunos.adicionaFim(aluno);
	}
}
