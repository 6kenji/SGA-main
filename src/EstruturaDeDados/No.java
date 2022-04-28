package EstruturaDeDados;

public class No 
{
	private No proximo;
	private No anterior;
	private Object elemento;
	
	public No(No anterior,Object elemento) 
	{
		this.anterior=anterior;
		this.elemento=elemento;
	}

	public No(Object elemento, No proximo)
	{
		this.elemento = elemento; 
		this.proximo = proximo;
	}
	
	public No(No anterior,Object elemento, No proximo)
	{
		this.anterior=anterior;
		this.elemento=elemento;
		this.proximo=proximo;
	}

	public No(Object elemento) 
	{
		this.elemento = elemento; 
	}

	public void setProximo(No proximo) 
	{
		this.proximo = proximo; 
	}

	public No getProximo()
	{
		return proximo;
	}
	
	public void setAnterior(No anterior) 
	{
		this.anterior=anterior;
	}
	
	public No getAnterior() 
	{
		return anterior;
	}
	
	public Object getElemento() 
	{
		return elemento;
	}

}