

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerChatImpl {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        //instance of the ServerChat is bind to the name allocated which is "RMIServerChat"
        Naming.rebind("RMIServerChat", new ServerChat());
    }
}
