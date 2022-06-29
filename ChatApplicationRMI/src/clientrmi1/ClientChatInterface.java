

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientChatInterface extends Remote {
    //method used in retrieving messages
    void retrieveMessages(String message) throws RemoteException;


}
