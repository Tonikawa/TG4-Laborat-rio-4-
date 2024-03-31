package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    // Construtor da classe Troco
    // Possíveis problemas: Erros na lógica dos loops de atribuição
    // Categoria: Comissão (implementação incorreta)
    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        // Os loops abaixo não atualizam o valor de "valor", resultando em loops infinitos
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
        }
        // Possível erro: Índice incorreto, deve ser papeisMoeda[0] ao invés de papeisMoeda[1]
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
        }
        // Possível erro: Índice incorreto, deve ser papeisMoeda[1] ao invés de papeisMoeda[1]
        papeisMoeda[1] = new PapelMoeda(2, count);
    }

    // Método para obter um iterador de papéis moeda
    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    // Classe interna para iterar sobre os papéis moeda
    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        // Método para verificar se há mais papéis moeda
        // Possível problema: Índice inicial incorreto
        // Categoria: Controle (uso incorreto de índice)
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) { // Possível erro: O loop deve começar em 5, não em 6
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        // Método para obter o próximo papel moeda
        // Possível problema: Implementação incorreta do loop
        // Categoria: Comissão (implementação incorreta)
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) { // Possível erro: O loop deve começar em 5, não em 6
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        // Método para remover um papel moeda
        public void remove() {
            next();
        }
    }
