package model.entities;

import model.exceptions.DomainException;

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
		if(v_deposito <= 0) {
			throw new DomainException("Valor inválido.");
		}
		this.saldo += v_deposito;
	}
	
	public void saque(double v_saque) 
	{
		if(this.saldo < v_saque) {
			throw new DomainException("Saldo insuficiente.");
			}
		if(v_saque <= 0){
				throw new DomainException("Valor negativo.");
			}
			
		this.saldo-= v_saque;
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
