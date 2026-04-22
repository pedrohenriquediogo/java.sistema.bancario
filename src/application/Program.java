package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import services.ContaServices;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		long id;
		String nome;
		ArrayList<Conta> contas = new ArrayList<>();
		
		System.out.println("Digite seu ID: ");
		id = scanner.nextLong();
		System.out.println("Digite seu nome: ");
		scanner.nextLine();
		nome = scanner.nextLine();
		
		Conta conta = new Conta(nome, id);
		contas.add(conta);
		
		int cursor;
		boolean atividade = true;
		
		while (atividade) 
		{
				System.out.printf("Olá, %s!\n1 - Sacar \n2 - Efetuar pagamento\n3 - Consultar saldo\n4 - Depositar\n5 - Cadastrar\n6 - Sair", nome);
				cursor = scanner.nextInt();
				
				switch (cursor) {
				
				case 1: 
					/*saque**/
					System.out.println("Valor saque: ");
					double v_saque = scanner.nextDouble();
					conta.saque(v_saque);
					break;
				
				case 2:
					/* efetuar pagamento **/
					System.out.println("ID do destinatário: ");
					long destinoId = scanner.nextLong();
					System.out.println("Valor: ");
					double valortrans = scanner.nextDouble();
					ContaServices.transferir(contas, conta.getId(), destinoId, valortrans);
					break;
						
				case 3:
					/* Consultar saldo */
					System.out.println("Saldo: " + conta.getSaldo());
					break;
					
					
				case 4: 
					/* Depositar*/
					System.out.println("Valor do depósito: ");
					double v_deposito = scanner.nextDouble();
					conta.deposito(v_deposito);
					break;
				
				case 5: 
					/*Cadastrar */ 
					System.out.println("Novo ID: ");
					long novo_id = scanner.nextLong();
					System.out.println("Novo nome: ");
					scanner.nextLine();
					String novo_nome = scanner.nextLine();
					Conta nova = ContaServices.cadastrar(novo_id, novo_nome);
					contas.add(nova);
					break;
					
				case 6: 
					atividade = false;
				}
		}
		scanner.close();
	}
	}
