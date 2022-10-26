# Lista Distribuida - Java
Projeto de Lista Distribuída em Java, utilizando Java RMI

## Execução
Para compilar os arquivos, execute:
```
sh compile.sh
```

Para executar o servidor:
```
sh server.sh
```

Em outro terminal, para executar um ou mais clientes:
```
sh client.sh
```

## Exemplos de execução

![image](https://user-images.githubusercontent.com/48719867/198130007-3f278475-1359-437c-80e3-6f244531f29b.png)

## Implicações considerando acesso concorrente

Caso dois clientes realizem operações sobre o mesmo índice da lista, no mesmo momento (dois usuários adicionem um item na mesma posição, por exemplo) poderá haver inconsistências.

Para resolver esse problema foi adicionado o modificador ```synchronized``` em cada método da classe do objeto remoto. Esse modificador faz com que um objeto que está sendo acessado/modificado só possa ser acessado novamente quando a tarefa que está sendo realizada sobre ele seja concluída.
