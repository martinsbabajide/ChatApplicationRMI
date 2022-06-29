

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerChatInterface extends Remote {
    //stores the chat logs
    void registerClientChat(ClientChatInterface clientChat) throws RemoteException;
    //used in broadcasting messages
    void broadcastChat(String chat) throws RemoteException;
}
