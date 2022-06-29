package Serverrmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class ServerChat{

    protected ServerChat() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ServerChatImpl obj = new ServerChatImpl();
        ServerChatInterface stub = (ServerChatInterface) UnicastRemoteObject.exportObject(obj,0);
        //instance of the ServerChat is bind to the name allocated which is "RMIServerChat"
        Registry Naming = LocateRegistry.getRegistry();
        Naming.rebind("RMIServerChat", stub);
    }
}
