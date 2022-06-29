

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerChat implements ServerChatInterface {
    private static final long serialVersionUID = 1L;
    //array list for the chat clients
    private ArrayList<ClientChatInterface> clientChats;
    //instantiate arraylist
    protected ServerChat() throws RemoteException {
        clientChats = new ArrayList<ClientChatInterface>();
    }
    @Override
    public synchronized void registerClientChat(ClientChatInterface clientChat) throws RemoteException {
        //adding client chat instance to the array list
        this.clientChats.add(clientChat);
    }

    @Override
    public synchronized void broadcastChat(String chat) throws RemoteException {
        //get all the client chat and retrieve message, for each client broadcasting message.
        int x = 0;
        //using the while loop to retrieve message sent by client
        while (x < clientChats.size()) {
            clientChats.get(x++).retrieveMessages(chat);
        }
    }
}
