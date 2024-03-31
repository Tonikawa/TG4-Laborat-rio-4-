package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    // Método para adicionar dinheiro à máquina
    // Categoria: Comissão (implementação incorreta)
    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            // Possível erro aqui: Deve ser papelMoeda[i] ao invés de papelMoeda[1]
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            // Possível exceção não tratada: PapelMoedaInvalidaException
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    // Método para obter o saldo atual
    // Categoria: Inicialização (retorno null)
    public int getSaldo() {
        return saldo;
    }

    // Método para obter o troco (não implementado)
    // Categoria: Comissão (implementação não concluída)
    public Iterator<Integer> getTroco() {
        return null; // Possível erro: este método não está implementado
    }

    // Método para imprimir o bilhete
    // Categoria: Controle (condição incorreta)
    public String imprimir() throws SaldoInsuficienteException {
        // Possível erro: a condição verifica saldo < valor, deve ser saldo <= valor
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
