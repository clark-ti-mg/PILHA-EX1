// Se isso aqui fosse no papel haveriam lágrimas e sangue. 
// Leo, esse exercício não deveria ter perdão. Mas eu te perdoo. :')

import java.util.Scanner;

class Pilha {
    int max_tam;
    int[] pilha;
    int topo = -1;

    public Pilha(int tamanho) {
        this.max_tam = tamanho;
        this.pilha = new int[max_tam];
    }

    public boolean isVazia() {
        return topo == -1;
    }

    public int getTamanho() {
        return topo + 1;
    }

    public void push(int v) throws Exception {
        if (topo == max_tam - 1) {
            throw new Exception("Não há espaço disponível");
        }
        pilha[++topo] = v;
    }

    public int pop() throws Exception {
        if (isVazia()) {
            throw new Exception("Lista vazia");
        }
        return pilha[topo--];
    }

    public int temNaPilha(int v) {
        for (int i = 0; i < this.topo; i++) {
            if (pilha[i] == (v)) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        while (true) {

            int qtdVagoes = teclado.nextInt();

            if (qtdVagoes != 0) {
                int[] vagoesA = new int[qtdVagoes];
                for (int i = 0; i < qtdVagoes; i++) {
                    vagoesA[i] = i + 1;
                }

                while (true) {
                    int[] vagoesB = new int[qtdVagoes];
                    vagoesB[0] = teclado.nextInt();

                    if (vagoesB[0] == 0) {
                        System.out.println();
                        break;
                    }

                    for (int i = 1; i < qtdVagoes; i++) {
                        vagoesB[i] = teclado.nextInt();
                    }

                    Pilha estacao = new Pilha(qtdVagoes);
                    // Início dos vagões A
                    int iVagoesA = 0;
                    boolean isPossivel = true;

                    for (int i = 0; i < qtdVagoes; i++) {
                        while ((iVagoesA < qtdVagoes) && (estacao.isVazia() || estacao.pilha[estacao.topo] != vagoesB[i])) {
                            estacao.push(vagoesA[iVagoesA]);
                            iVagoesA++;
                        }
                        if (!estacao.isVazia() && estacao.pilha[estacao.topo] == vagoesB[i]) {
                            estacao.pop();
                        } else {
                            isPossivel = false;
                            break;
                        }
                    }
                    if (isPossivel) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }

            } else {
                break;
            }

        }
    }
}

