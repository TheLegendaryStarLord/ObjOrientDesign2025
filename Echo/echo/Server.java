package echo;

import java.util.*;
import java.io.*;
import java.net.*;

public class Server {

    protected ServerSocket mySocket;
    protected int myPort;
    public static boolean DEBUG = true;
    protected Class<?> handlerType;

    public Server(int port, String handlerTypeName) {
        try {
            myPort = port;
            mySocket = new ServerSocket(myPort);
            this.handlerType = Class.forName(handlerTypeName);
        } catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } // catch
    }


    public void listen() {
        while(true) {
            try{
            // accept a connection
            Socket clientSocket = mySocket.accept();
            // make handler
            RequestHandler handler = makeHandler(clientSocket);
            // start handler in its own thread
            Thread t = new Thread(handler);
            t.start();
            System.out.println("Server listening on port: "+ myPort);
                    } catch (IOException e) {
                    System.err.println("Error accepting connection: " + e.getMessage());
                    }
        } // while
    }

    public RequestHandler makeHandler(Socket s) {
        RequestHandler handler = new RequestHandler(s);
        try{
        // handler = handlerType.getDeclaredConstructor().newInstance()
            handler = (RequestHandler) handlerType.newInstance();
        // set handler's socket to s
            handler.setSocket(s);
        // return handler
        return handler;
            } catch (Exception e) {
                System.err.println("error creating handler: " + e.getMessage());
            }
            return handler;   
    }



    public static void main(String[] args) {
        int port = 5555;
        String service = "echo.RequestHandler";
        if (1 <= args.length) {
            service = args[0];
        }
        if (2 <= args.length) {
            port = Integer.parseInt(args[1]);
        }
        Server server = new Server(port, service);
        server.listen();
    }
}