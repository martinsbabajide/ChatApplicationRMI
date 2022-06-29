package Serverrmi;

import Clientrmi.ClientChatInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerChatInterface extends Remote {
    //stores the chat logs
   public void registerClientChat(ClientChatInterface clientChat) throws RemoteException;
    //used in broadcasting messageszszxzas
    public void broadcastChat(String chat) throws RemoteException;
}
