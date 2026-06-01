package br.com.criptografia;

import java.text.Normalizer;

public class Cifra {
    static final int DESLOCAMENTO = 3;

    static final char A_MAIUSCULO = (char) 65; // 'A' em ASCII.
    static final char Z_MAIUSCULO = (char) 90; // 'Z' em ASCII.

    static final char A_MINUSCULO = (char) 97; // 'a' em ASCII.
    static final char Z_MINUSCULO = (char) 122; // 'z' em ASCII.

    public Cifra(){

    }

    String criptografia(String frase){
        /*
        Essa parte é focada em decompor todos os caracteres acentuados do parâmetro "frase" e separar a parte acentuada,
        da letra em ASCII. Logo após, é feito uma verificação de tudo que não pertence ao intervalo da tabela ASCII, e
        retira da String.
        */
        frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
        frase = frase.replaceAll("[^\\p{ASCII}]", "");

        //StringBuilder para facilitar a troca de caracteres.
        StringBuilder fraseCripto = new StringBuilder(frase);

        /*
        Aqui a String é percorrida caractere por caractere, fazendo duas comparações:

        1 - Se o caractere for maiúsculo, ou seja, está no intervalo [65 - 90], é o caractere passa por uma equação
        que subtrai 65 do valor do caractere atual para poder somar o deslocamento e pegar o resto mínimo.
        Depois é somado 65 de novo para pegar o valor do caractere 3 casas à direita no alfabeto.

        2 - A mesma coisa, porém no intervalo [97 - 122].

        Esta equação evita que uma letra maiúscula seja trocada por uma minúscula, ou que uma minúscula vire
        um símbolo especial pois mesmo que as letras ^[X-Zx-z]$ sejam inseridas, o resto mínimo "retorna ao início"
        do alfabeto respectivo.
        */
        for(int i = 0; i < frase.length(); i++){
            char caractere = frase.charAt(i);

            if(caractere >= A_MAIUSCULO && caractere <= Z_MAIUSCULO){
                fraseCripto.setCharAt(i, (char) (((caractere - A_MAIUSCULO + DESLOCAMENTO) % 26) + A_MAIUSCULO));

            }else if(caractere >= A_MINUSCULO && caractere <= Z_MINUSCULO){
                fraseCripto.setCharAt(i, (char) (((caractere - A_MINUSCULO + DESLOCAMENTO) % 26) + A_MINUSCULO));

            }
        }

        //Retona a String criptograda, sem acentos e com caracteres especiais intactos.
        return fraseCripto.toString();
    }
}
