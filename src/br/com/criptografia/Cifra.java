package br.com.criptografia;

import java.text.Normalizer;

public class Cifra {
    private final int DESLOCAMENTO = 3;

    private final char A_MAIUSCULO = (char) 65; // 'A' em ASCII.
    private final char Z_MAIUSCULO = (char) 90; // 'Z' em ASCII.

    private final char A_MINUSCULO = (char) 97; // 'a' em ASCII.
    private final char Z_MINUSCULO = (char) 122; // 'z' em ASCII.

    public Cifra(){

    }

    String criptografia(String frase){
        frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
        frase = frase.replaceAll("[^\\p{ASCII}]", "");

        StringBuilder fraseCripto = new StringBuilder(frase);

        for(int i = 0; i < frase.length(); i++){
            char caractere = frase.charAt(i);

            if(caractere >= A_MAIUSCULO && caractere <= Z_MAIUSCULO){
                fraseCripto.setCharAt(i, (char) (((caractere - A_MAIUSCULO + DESLOCAMENTO) % 26) + A_MAIUSCULO));

            }else if(caractere >= A_MINUSCULO && caractere <= Z_MINUSCULO){
                fraseCripto.setCharAt(i, (char) (((caractere - A_MINUSCULO + DESLOCAMENTO) % 26) + A_MINUSCULO));

            }
        }

        return fraseCripto.toString();
    }
}
