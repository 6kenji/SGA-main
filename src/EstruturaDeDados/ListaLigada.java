package EstruturaDeDados;

import java.io.Serializable;

import Interfaces.InterfaceGeral;

public class ListaLigada implements InterfaceGeral, Serializable
{
	private No primeiro;
	private No ultimo;
	private int totalElem;
        
        public int getPosicao(Object elemento){
            
            if(elemento == null)
                throw new IllegalArgumentException("Elemento nao pode ser nulo.");
            
            No atual = this.primeiro;
		for (int i = 0; i < totalElem; i++) 
		{
			if (atual.getElemento().equals(elemento)) 
			{
				return i;
			}
			atual = atual.getProximo();
		}
		return -1;
        }
	
	@Override
	public void adicionaInicio(Object elemento) 
	{
            // TODO Auto-generated method stub
            No novo = new No(elemento, this.primeiro);
            this.primeiro = novo;
            if (this.totalElem == 0)
            {
		this.ultimo = this.primeiro;
            }
            this.totalElem++;
	}

	@Override
	public void adicionaPosicao(int posicao, Object elemento)
	{
		// TODO Auto-generated method stub
		if(!posicaoOcupada(posicao)) 
		{
			throw new IllegalArgumentException("Posicao nao existe");
		}

		if (posicao == 0) 
		{
			this.adicionaInicio(elemento);
		} 
		else if (posicao == this.totalElem) 
		{
			this.adicionaInicio(elemento);
		} 
		else 
		{
			No anterior = this.pegaNo(posicao - 1);
			No novo = new No(elemento, anterior.getProximo());
			anterior.setProximo(novo);
			this.totalElem++;
		}
	}

	@Override
	public void adicionaFim(Object elemento)
	{
		// TODO Auto-generated method stub
		No no=new No(elemento);
		if(totalElem == 0) 
		{
			adicionaInicio(elemento);
		} else {
			this.ultimo.setProximo(no);
			no.setAnterior(this.ultimo);
			this.ultimo=no;
			this.totalElem++;
		}
	}

	@Override
	public Object pega(int posicao) 
	{
		// TODO Auto-generated method stub
		return pegaNo(posicao).getElemento();	
	}

	@Override
	public void removeInicio() 
	{
		// TODO Auto-generated method stub
		this.primeiro=this.primeiro.getProximo();
		this.primeiro.setAnterior(null);
		totalElem--;
		if (totalElem == 0)
		{
			this.ultimo = null; 
		}
	}

	@Override
	public void removePosicao(int posicao) 
	{
		// TODO Auto-generated method stub
		if (!this.posicaoValida(this.totalElem - 1)) 
		{
			throw new IllegalArgumentException("Posicao nao existe");
		}
		if (this.totalElem == 1) 
		{
			this.removeInicio();
		}
		else 
		{
			No penultima = (No) this.pega(totalElem - 1);
			penultima.setProximo(null);
			this.ultimo = penultima;
			this.totalElem--;
		}
	}

	@Override
	public void removeFim()
	{
		// TODO Auto-generated method stub
		if (this.totalElem == 1) 
		{
			removeInicio();
		} else {
			No penultimo = this.ultimo.getAnterior();
			penultimo.setProximo(null);
			this.ultimo = penultimo;
			this.totalElem--;
		}
	}

	@Override
	public boolean contem(Object elemento)
	{
		// TODO Auto-generated method stub
		No atual = this.primeiro;
		while (atual != null) 
		{
			if (atual.getElemento().equals(elemento)) 
			{
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}

	@Override
	public int tamanho()
	{
		// TODO Auto-generated method stub
		return totalElem;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	private boolean posicaoOcupada(int posicao) 
	{
		return posicao >= 0 && posicao < this.totalElem;
	}

	private boolean posicaoValida(int posicao) 
	{
		return posicao >= 0 && posicao <= this.totalElem;
	}

	private No pegaNo(int posicao) 
	{
		if (!this.posicaoOcupada(posicao)) 
		{
			throw new IllegalArgumentException("Posicao invalida!");
		}
		No actual = primeiro;
		for (int i = 0; i < posicao; i++) 
		{
			actual = actual.getProximo();
		}
		return actual;
	}
}
