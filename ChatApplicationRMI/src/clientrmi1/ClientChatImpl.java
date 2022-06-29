

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientChatImpl {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String serverChatURL = "rmi://localhost/RMIServerChat";
        //Get chatserver instance
        ServerChatInterface serverChat = (ServerChatInterface) Naming.lookup(serverChatURL);
        //instantiate a thread and call a start method
        //arg[0] name the user enters
        new Thread(new ClientChat(args[0], serverChat)).start();
    }
}
