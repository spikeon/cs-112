import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client 
{
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;


	public Client()
	{
		try 
        {
        	System.out.println("Connecting to server...");
            socket = new Socket("localhost", 58999);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));                                                                          
        } 
        catch (Exception e)
        {
        	System.out.println("Run the server first.");
        }
	}
	
	public void close()
	{
		try 
		{
			socket.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String sendPassword(String pass)
	{		          		 
        if (!HUSH) System.out.print("Sending: " + pass);
        out.println(pass);
        String result = null;
		try 
		{
			result = in.readLine();
			if (!HUSH)
			{
				if (result.equals("no"))
		        	System.out.println(" (wrong password)");
		        else if (result.equals("yes"))
					System.out.println(" (CORRECT!)");

			}

			if(result.equals("yes") && ! found.contains(pass)) {
				found.add(pass);
				System.out.println("Found Password: " + pass);
			}

		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public static boolean HUSH = false;
	public static Client me;
	public static int max = 4;
	public static String[] alphanumeric = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	public static List<String> found = new ArrayList<String>();
	public static void run(String prefix){
		if(prefix.length() > max) return;
		if(prefix.length() > 0) me.sendPassword(prefix);

		for (String a : alphanumeric) {
			me.run(prefix + a);
		}
	}

    public static void main(String[] args) 
    {

		me = new Client();
        
        //BEGIN YOUR WORK
        HUSH = true; //change this to false for testing

		// Begin Brute Force

		me.max = 0;
		while(me.found.size() <= 7) {
			me.max++;
			System.out.println("Max Length: " + me.max);
			me.run("");
		}

        // END YOUR WORK

		System.out.println("Found: " + me.found.size());
        
        me.close();
    }
}