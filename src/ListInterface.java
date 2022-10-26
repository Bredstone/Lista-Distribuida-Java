import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ListInterface<E> extends Remote {
  // Adiciona um objeto na lista
  public void add(int index, E element) throws RemoteException;
  // Retorna um objeto da lista
  public E get(int index) throws RemoteException;
  // Remove um objeto da lista
  public E remove(int index) throws RemoteException;
  // Retorna o tamanho da lista
  public int size() throws RemoteException;
}