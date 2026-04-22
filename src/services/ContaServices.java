package services;

import java.util.ArrayList;

import entities.Conta;

public class ContaServices {

	public static Conta cadastrar(long id, String nome) {
		return new Conta(nome, id);
	}

	public static void transferir(ArrayList<Conta> contas, long origemId, long destinoId, double v_transacao) {
		Conta origem = null;
		Conta destino = null;

		for (Conta c : contas) {
			if (c.getId() == origemId)
				origem = c;
			if (c.getId() == destinoId)
				destino = c;
		}

		if (origem != null && destino != null) {
			if (origem.saque(v_transacao) == true) {
				destino.deposito(v_transacao);
			} else {
				System.out.println("Saldo insuficiente.");
			}
		} else {
			System.out.println("Conta não encontrada.");
		}
	}

}
