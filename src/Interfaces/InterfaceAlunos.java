package Interfaces;

import EstruturaDeDados.ListaLigada;
import Objecto.Aluno;

public interface InterfaceAlunos
{
    void criarAluno(ListaLigada ov, Aluno a);
    void listarAlunoUmAtributo(ListaLigada ov, String nome);
    void listarAlunoDoisAtributos(ListaLigada ov, String nome, String apelido);
    void eliminaAlunoPosicao(ListaLigada ov, int posicaoTabela);
    void imprimirTodosDados(ListaLigada ov, Aluno a);
    void imprimeNomeIgual(ListaLigada ov, Aluno a);
    void imprimeOrdemCrescente(ListaLigada ov, Aluno a);
    void removerAluno(ListaLigada ov, String nome);
}