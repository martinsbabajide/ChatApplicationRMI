package Clientrmi;

import Serverrmi.ServerChatInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientChat extends UnicastRemoteObject implements ClientChatInterface, Runnable {
    private static final long serialVersionUID = 1L;
    private ServerChatInterface serverChat;
    private String id = null;

    protected ClientChat(String id, ServerChatInterface serverChat) throws RemoteException {
        this.id = id;
        this.serverChat = serverChat;
        //registering chat client with the chat server instance
        serverChat.registerClientChat(this);
    }

    @Override
    public void retrieveMessages(String message) throws RemoteException {
        //prints message when retrieved
        System.out.println(message);
    }

    @Override
    //executing the instances as threads
    public void run() {
        //text scanner for user input and reading messages from the commandline
        Scanner sc = new Scanner(System.in);
        String mg;
        while (true) {
            mg = sc.nextLine();
            //used for broadcasting the messages
            try {
                serverChat.broadcastChat(id +" : "+mg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }
}
