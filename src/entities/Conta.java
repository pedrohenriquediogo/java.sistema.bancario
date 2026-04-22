package entities;

public class Conta 
{
	private String nome;
	private long id;
	private double saldo;
		
	public Conta(String nome, long id) 
	{
		this.nome = nome;
		this.id = id;
		this.saldo = 0;
	}
	
	public void deposito(double v_deposito) 
	{
		if(v_deposito > 0) {
		this.saldo += v_deposito;
		} else {
			System.out.println("Valor inválido.");
		}
	}
	
	public boolean saque(double v_saque) 
	{
		if(this.saldo >= v_saque) {
			this.saldo -= v_saque;
			return true;
			} else {
			return false;
			}
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public long getId() 
	{
		return id;
	}
	
	public double getSaldo() 
	{
		return saldo;
	}

}
