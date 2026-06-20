# Criptografia
___

##  Resumo
A criptografia é um estilo de algoritmo amplamente utilizado para diversas áreas por questões de segurança, seja para esconder uma mensagem importante, ou apenas para proteger dados e arquivos. O projeto consiste pelo processo de criptografia de textos usado pelo líder romano Júlio César, que para reconhecimento, o algoritmo foi batizado de **Cifra de César**. O fluxo do código se inicia com um texto escrito em um arquivo de entrada (.txt) na pasta _criptografia/_. Logo após, é verificado se há uma pasta _retorno/_ e se há algum arquivo de saída (.txt) inserido, no caso de não houver, ambos serão criados. Caso o processo de verificação confirme a existência do diretório e do arquivo, se inicia a criptografia do texto que é impresso no arquivo de saída (.txt) dentro do diretório _retorno/_, ambos os arquivos são salvos e fechados para que nenhum dos dois sejam corrompidos.
___

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

Depois de todos os caracteres acentuados passarem pelo processo de formatação, se inicia o processo da criptografia do texto.

Dentro do loop for, a string é percorrida caractere por caractere, fazendo duas comparações:
1. Se o caractere for **maiúsculo** - **Intervalo: [65-90] = [A-Z]**.
2. Se o caractere for **minúsculo** - **Intervalo: [97-122] = [a-z]**.

Em ambos os casos, o valor do caractere é inserido em uma equação que subtrai um valor A (65 para maiúsculo e 97 para minúsculo) do seu valor para somar ao deslocamento com o intuito de obter o resto mínimo. Depois, este é somado com o mesmo valor que havia sido subtraído no início (65 para maiúsculo e 97 para minúsculo), para obter o caractere 3 casas à direita no alfabeto.

Equação (De forma genérica): $((C - A + D) \equiv R \pmod{26} )+A$ 
+ **C**: Valor inteiro do caractere;
+ **A**: Valor do caractere A em função do intervalo;
+ **D**: Deslocamento;
+ **R**: Resto mínimo.

Na sequência de todo esse processo, a função retorna o texto criptografado.

### Arquivo

Esta classe é focada em gerenciar toda a manipulação dos arquivos, suas funções são as seguintes:
+ **_escreverTexto_**: Recebe uma String como parâmetro (texto criptografado) e imprime no diretório (Arquivo de saída) **caminhoArquivo**;
+ **_verificarPasta_**: Responsável por duas verificação, sendo a primeira se há uma pasta, e a segunda, se há algum arquivo dentro;
+ **_criarArquivo_**: Caso a **_verificarPasta_** retorne **true**, essa função é chamada para criar o arquivo de saída;
+ **_abrirArquivo_**: Abre o arquivo de entrada para ativar o **Scanner**;
+ **_lerArquivo_**: Percorre todas as linhas do arquivo de entrada até receber um valor nulo, que significa que não há mais linhas no arquivo, e guarda em uma variável de retorno;
+ **_fecharArquivo_**: Verifica se o **Scanner** é nulo, se não, fecha o **Scanner**.
___
