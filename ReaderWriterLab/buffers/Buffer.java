package buffers;

import java.util.*;

public class Buffer {

	private List<Message<String>> buffer = new LinkedList<Message<String>>();
	public int CAPACITY = 3;
			
	public synchronized boolean write(Message<String> msg) { 
        	while (buffer.size() >= CAPACITY){
        	   try{
                        wait();
        	   } catch(InterruptedException ie){
                	System.err.println(ie.getMessage());
        	   }
        	   
        	   }
		Utils.sleep(100);
		boolean success = false;
		if (buffer.size() < CAPACITY) {
			buffer.add(msg);
			success = true;
		}
		Utils.sleep(50);
		notify();
		return success;
	}
	
	public synchronized Message<String> read() { 
        	
        	while(buffer.isEmpty() == true){
		  try{
		      wait();
		  } catch(InterruptedException ie){
		      System.err.println(ie.getMessage());
		  }
                }
                
        	Utils.sleep(50);
		Message<String> res = (buffer.isEmpty())? null: buffer.remove(0); 
		Utils.sleep(100);
		notify();
		return res;
	}
	public String toString() { return buffer.toString(); }

}