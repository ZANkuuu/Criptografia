package br.com.criptografia;

public class Controller {
    private Cifra cifra;
    private Arquivo arquivo;

    public Controller(Cifra cifra, Arquivo arquivo){
        this.cifra = cifra;
        this.arquivo = arquivo;

        fluxo();
    }

    void fluxo(){
        if(arquivo.verificarPasta()) arquivo.criarArquivo();

        arquivo.abrirArquivo();
        arquivo.escreverTexto(cifra.criptografia(arquivo.lerArquivo()));
        arquivo.fecharArquivo();
    }
}