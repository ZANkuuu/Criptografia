# Criptografia
___

##  Resumo
O projeto consiste em utilizar um arquivo de entrada (.txt) na pasta _criptografia/_ para inserir o texto a ser criptografado, o fluxo do código pega todo o texto do arquivo de entrada e utiliza do algoritmo da **Cifra de César** para fazer o processo de criptografia e logo após verifica se há um arquivo dentro da pasta _retorno/_, caso não haja, um novo arquivo de saída (.txt) é gerado e o texto criptografado é impresso no arquivo de saída criado, e ambos os arquivos são salvos e fechados para que nenhum dos dois sejam corrompidos.

### Palavras-chave: 
criptografia; ascii; arquivo.
___

## Cifra de César



## Classes

### Main
A classe **Main** que você já conhece. Nesse caso, foi utilizado um Dependecy Injection das classes **Cifra** e **Arquivo** para melhor controle de possíveis atualizações do código. Simultâneamente, a instância da classe **Controller** é feita para inicializar o código.

### Controller
Essa classe funciona como o cérebro de tudo, ela rege como as coisas acontecem de forma simples. Na função **_fluxo_**, há a verificação citada anteriormente, no caso se há um arquivo na pasta _/retorno_, e depois as demais funções são chamadas.

### Cifra
Classe responsável por todo o algoritmo de criptografia, primeiramente foram declaradas constantes responsáveis pela base do código. 
+ **_DESLOCAMENTO_**: Está separada para se destacar caso queira aumentar ou diminuir o deslocamento da cifra. 

As outras quatro constantes são inícios e fins das respectivas letras na tabela ASCII.

A função **_criptografia_** inicia com algumas validações para evitar que o código tenha mal funcionamento:
+ Primeiro há a "normalização" de letras acentuadas (á, à, ê, etc.) sendo maiúsculas ou minúsculas. Todos os caracteres acentuados são decompostos da frase e o acento é separado da letra, depois o que não é letra (Acentos) é retirado da frase.
+ Depois a criação de um StringBuilder para facilitar a substituição de cada caracterece. (Obs: Caracteres especiais (" ", "-", ",", etc.) passam direto pela verificação e não são substítuidos.)

Agora que todos os caracteres acentuados foram "corrigidos", vamos para a criptografia.

Dentro do loop for, a string é percorrida caractere por caractere, fazendo duas comparações:
1. Se o caractere for **maiúsculo** - **Intervalo: [65-90] = [A-Z]**.
2. Se o caractere for **minúsculo** - **Intervalo: [97-122] = [a-z]**.

Em ambos os casos, o valor do caractere é inserido em uma equação que subtrai um valor A (65 para maiúsculo e 97 para minúsculo) do seu valor para somar ao deslocamento com o intuito de obter o resto mínimo. Depois, este é somado com o mesmo valor que havia sido subtraído no início (65 para maiúsculo e 97 para minúsculo), para obter o caractere 3 casas à direita no alfabeto.

Equação (De forma genérica): $((C - A + D) \equiv R \pmod{26} )+A$ 
+ C: Valor inteiro do caractere;
+ A: Valor do caractere A em função do intervalo;
+ D: Deslocamento;
+ R: Resto mínimo.

Na sequência de todo esse processo, a função retorna o texto criptografado.

### Arquivo

Focada em gerenciar 
