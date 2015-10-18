
package test.pkg2;

/**
 *
 * @author Nurul.Nadia.Idris
 * For Test 2 - Company A
 */


import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CompanyA{
	
   public static void main(String[] args) throws IOException{
       
                    
	InetAddress ip;
	try {
			
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
			
	} catch (UnknownHostException | SocketException e) {
	}
        
        
        //To get IPV6 
	try
	    {
	       InetAddress inet = InetAddress.getByName("fe80::c938:8629:afd3:d2d0%13");

	        boolean status = inet.isReachable(5000);
                System.out.println ("IPv6 Address:");
	        if (status)
	        {
	            System.out.println(inet.getCanonicalHostName() + " Host Reached\t" + java.net.Inet6Address.getByName("fe80::c938:8629:afd3:d2d0%13").getHostAddress());
	        }
	        else
	        {
	           System.out.println(inet.getCanonicalHostName() + " Host is Unreachable");
	        }

	    }
	 catch (UnknownHostException e)
	    {
	        System.err.println("Host does not exists");
	    }
	 catch (IOException e)
	    {
	       System.err.println("Error in reaching the Host");
	    }
	
	RunnableDemo R1 = new RunnableDemo( "Thread-1");
            R1.start();

            RunnableDemo R2 = new RunnableDemo( "Thread-2");
            R2.start();  
       
   }
 }
    class RunnableDemo1 implements Runnable {
       private Thread t;
       private final String threadName;

       RunnableDemo1( String name){
           threadName = name;
           System.out.println("Creating " +  threadName );
       }
       public void run() {
          System.out.println("Running " +  threadName );
          try {
             for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
             }
         } catch (InterruptedException e) {
             System.out.println("Thread " +  threadName + " interrupted.");
         }
         System.out.println("Thread " +  threadName + " exiting.");
       }

       public void start ()
       {
          System.out.println("Starting " +  threadName );
          if (t == null)
          {
             t = new Thread (this, threadName);
             t.start ();
          }
       }

    }


