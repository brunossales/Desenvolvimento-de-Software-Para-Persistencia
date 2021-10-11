

 ## 1. Escreva uma aplicação para ler um arquivo binário origem e gravá-lo em outro arquivo (arquivo destino).

### s nomes dos arquivos (origem e destino) devem ser definidos na chamada da aplicação via argumento de linha de comando.
### A leitura e gravação devem ser realizadas em blocos de bytes e não byte a byte.
### Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida.
### Teste vários tamanhos de bloco e encontre um tamanho que ofereça um bom desempenho. Crie uma tabela para comparar os resultados encontrados.

## 2. Escolha e baixe um arquivo csv a partir do link e use-o nas questões a seguir. Na resolução desta questão, não enviar os arquivos envolvidos, mas somente os resultados pedidos em arquivo PDF.

### Gere as somas md5 e sha1 do arquivo encriptado. 
### Compacte via linha de comando o arquivo csv original usando compressões zip, gzip, bzip2, rar e 7zip. Depois disso compare os tempos e tamanhos dos arquivos gerados. Dica: para obter o tempo de execução, use o comando time.
### Exemplo: time zip iris.zip iris.csv
## 3. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

### arquivo config.properties
### linha_inicial = 1
### linha_final = 3
### Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da linha_inicial até a linha_final, conforme definidas no arquivo de propriedades config.properties.