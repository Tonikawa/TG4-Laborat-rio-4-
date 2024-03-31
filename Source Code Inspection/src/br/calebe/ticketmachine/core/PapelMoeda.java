package br.calebe.ticketmachine.core;

/**
 *
 * author Calebe de Paula Bianchini
 */
public class PapelMoeda {

    protected int valor; // Valor da nota ou moeda
    protected int quantidade; // Quantidade disponível

    // Construtor da classe PapelMoeda
    // Possível problema: Ausência de validação de entrada
    // Categoria: Comissão (implementação incorreta)
    public PapelMoeda(int valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    // Método para obter o valor do papel moeda
    public int getValor() {
        return valor;
    }

    // Método para obter a quantidade disponível do papel moeda
    public int getQuantidade() {
        return quantidade;
    }
}
