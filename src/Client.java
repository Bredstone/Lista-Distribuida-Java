import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
  Scanner in;
  ListInterface<String> list;

  @SuppressWarnings("unchecked")
  public Client() {
    in = new Scanner(System.in);

    try {
      list = (ListInterface<String>) Naming.lookup("rmi://127.0.1.1/ListaDistribuida");
    } catch (RemoteException e) {
      System.out.println("\nRemoteException: " + e.toString());  
    } catch (NotBoundException e) {
      System.out.println("\nNotBoundException: " + e.toString());  
    } catch (Exception e) {
      System.out.println("\nException: " + e.toString());  
    }
  }

  public void execute() {
    String op, value;
    int index;

    try {
      System.out.println("Entre com um dos comandos a seguir:");
      System.out.println("\t\tadd <index> <valor>");
      System.out.println("\t\tget <index>");
      System.out.println("\t\tremove <index>");
      System.out.println("\t\tsize");
      System.out.println("\t\tsair");

      menu_while:
      while (true) {
        op = in.next();
        
        switch (op.toLowerCase()) {
          case "add":
            index = in.nextInt();
            value = in.next();
            list.add(index, value);

            System.out.println("Item adicionado!");
            break;

          case "get":
            index = in.nextInt();
            value = list.get(index);

            System.out.println("Valor: " + value);
            break;

          case "remove":
            index = in.nextInt();
            value = list.remove(index);

            System.out.println("Item removido: " + value);
            break;

          case "size":
            System.out.println("Tamanho: " + list.size());
            break;

          case "sair":
            System.out.println("Saindo do programa...");
            break menu_while;

          default:
            System.out.println("Opção Inválida!");
            break;
        }
      }
		
      in.close();
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Índice fora dos limites!");
    } catch (InputMismatchException e) {
      System.out.println("Valor inválido!");
    } catch (Exception e) {		
      System.out.println("Exception: " + e.toString()); 
    }
  }

  public static void main(String[] args) {
    Client c = new Client();
    c.execute();
  }
}