import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DistributedList<U> extends UnicastRemoteObject implements ListInterface<U> {
  List<U> list;

  public DistributedList() throws RemoteException {
    list = new ArrayList<U>();
  }

  @Override
  public void add(int index, U element) throws RemoteException {
    list.add(index, element);
  }

  @Override
  public U get(int index) throws RemoteException {
    return list.get(index);
  }

  @Override
  public U remove(int index) throws RemoteException {
    return list.remove(index);
  }

  @Override
  public int size() throws RemoteException {
    return list.size();
  }
}
