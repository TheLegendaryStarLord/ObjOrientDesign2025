package echo;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class RequestHandler extends Correspondent implements Runnable {
    protected boolean active; 
    
    
    public RequestHandler(Socket s) {
        super(s);
        active = true;
    }
    public RequestHandler() {
        super();
        active = true;
    }
    
    protected String response(String msg) throws Exception {
        return "echo: " + msg;
    }
    
    protected void shutDown() {
        if (Server.DEBUG) System.out.println("handler shutting down");
                active = false;
    }
     public void run() {
        while(active) {
            try {
                String request = receive();
                System.out.println("received: " + request);
                if(request.equals("quit")) {
                    shutDown();
                    break;
                }
                String response = response(request);
                System.out.println("sending: " + response);
                send(response);
                Thread.sleep(300);
                } catch(Exception e) {
                send(e.getMessage() + "... ending session");
                break;
            }
        }
        
    }
}