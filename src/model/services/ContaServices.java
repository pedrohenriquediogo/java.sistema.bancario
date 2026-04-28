package model.services;

import java.util.ArrayList;

import model.entities.Conta;
import model.exceptions.DomainException;

public class ContaServices {

	public static Conta cadastrar(long id, String nome) {
		return new Conta(nome, id);
	}

	public static void transferir(ArrayList<Conta> contas, long origemId , long destinoId, double v_transacao) {
		Conta origem = null ;
		Conta destino = null;

		for (Conta c : contas) {
			if (c.getId() == origemId) {
				origem = c;
			}
			if( c.getId() == destinoId) {
				destino = c;
			}
			if(origem != null && destino != null) {
				break;
			}
		}
		
		if(origem == destino) {
			throw new DomainException("Não é possivel tranferir para a mesma conta.");
		}else if(origem == null && destino == null) {
			throw new DomainException("Usuarios não encontrados.");
		}else if (origem == null) {
			throw new DomainException("Usuario origem não encontrado.");
		}else if (destino == null) {
			throw new DomainException("Usuario destino não encontrado.");
		}
		origem.saque(v_transacao);
		destino.deposito(v_transacao);
	}
}
