package br.com.criptografia;

public class Main{
    void main(){
        Cifra cifra = new Cifra();
        Arquivo arquivo = new Arquivo();

        Controller controller = new Controller(cifra, arquivo);

    }
}