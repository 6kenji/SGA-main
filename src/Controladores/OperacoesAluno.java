package Controladores;

import EstruturaDeDados.ListaLigada;
import Objecto.Aluno;

public class OperacoesAluno 
{
	protected static ListaLigada alunos = DadosAlunos.lerArquivoBinario("alunos.dat");
	
	public static ListaLigada getClientes() 
	{
		return alunos;
	}
	public static void setClientes(Aluno aluno) 
	{
		alunos.adicionaFim(aluno);
	}
}
