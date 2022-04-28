package Tabela;

import Objecto.Aluno;
import java.util.LinkedList;
import java.util.UUID;

import javax.swing.table.AbstractTableModel;

public class TableModelAlunos extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Aluno> dados = new LinkedList<Aluno>();
	private String[] colunas = {"ID do Aluno","Nome","Apelido","Sexo","Nacionalidade"};
	
	public LinkedList<Aluno> getDados() {
            return dados;
	}

	public void setDados(LinkedList<Aluno> dados) {
		this.dados = dados;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
            
            // TODO Auto-generated method stub
            
            switch(coluna) {
		
		case 0 : return dados.get(linha).getId();
		
		case 1 :return dados.get(linha).getNome();

		case 2 :return dados.get(linha).getApelido();
		
		case 3 :return dados.get(linha).getSexo();

		case 4 :return dados.get(linha).getNacionalidade();

            }
		
            return null;
	}
	
	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		// TODO Auto-generated method stub
		
		switch(coluna) {
		
		case 0 : dados.get(linha).setId(UUID.fromString((String) valor));
                    break;
		
		case 1 : dados.get(linha).setNome((String) valor);
                    break;

		case 2 : dados.get(linha).setApelido((String) valor);
                    break;
		
		case 3 : dados.get(linha).setSexo((String) valor);
                    break;
		
		case 4 : dados.get(linha).setNacionalidade((String) valor);
                    break;
		}
		this.fireTableRowsUpdated(linha, linha);
	
	}
	
	public void AddRow(Aluno a) {
		this.dados.add(a);
		this.fireTableDataChanged();
	}
	
	public void RemoveRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

}
