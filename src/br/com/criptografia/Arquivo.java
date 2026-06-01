package br.com.criptografia;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
    private Scanner in;
    private String caminhoArquivo = "src/br/com/criptografia/retorno/Saida.txt";

    public Arquivo(){
    }

    void escreverTexto(String textoCriptografado){
        try(BufferedWriter escreverArquivo = new BufferedWriter(new FileWriter(this.caminhoArquivo))){
            escreverArquivo.write(textoCriptografado);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na criação do arquivo");
            e.printStackTrace();
        }

    }

    boolean verificarPasta(){
        File pastaRetorno = new File(caminhoArquivo).getParentFile();

        if(pastaRetorno == null || !pastaRetorno.exists()) return true;

        String[] conteudo = pastaRetorno.list();

        return conteudo != null && conteudo.length == 0;
    }

    void criarArquivo(){
        File arquivo = new File(caminhoArquivo);

        try{
            if(arquivo.createNewFile()) JOptionPane.showMessageDialog(null, "Arquivo com texto criptografado criado em: " + caminhoArquivo);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na criação do arquivo");
            e.printStackTrace();
        }
    }

    void abrirArquivo(){
        try{
            in = new Scanner(new File("src/br/com/criptografia/Entrada.txt"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "404 - Arquivo não encontrado.");
        }
    }

    String lerArquivo(){
        if(in == null) return "";

        String texto = "";
        while(in.hasNextLine()){
            texto += in.nextLine() + "\n";
        }
        return texto;
    }

    void fecharArquivo(){
        if(in != null) in.close();
    }
}