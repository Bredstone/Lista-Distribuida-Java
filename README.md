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

## Implicações considerando acesso concorrente

No nosso exemplo podemos perceber que caso dois clientes estejam acessando o mesmo índice da lista no mesmo momento, e se um resolver alterar seu valor enquanto outro remove o mesmo, poderá haver uma inconsistência.

Para resolver este problema bastaria colocarmos o modificador synchronized em cada método da classe do objeto remoto onde pode haver a geração de inconsistência.

Esse modificador faz com que um objeto que está sendo acessado só possa ser acessado novamente quando a tarefa que está sendo realizada sobre ele seja concluida.
