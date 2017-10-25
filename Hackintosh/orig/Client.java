import java.io.*;
import java.net.*;
 
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
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public static boolean HUSH = false;
    public static void main(String[] args) 
    {                                  
        Client me = new Client();
        
        //BEGIN YOUR WORK
        HUSH = true; //change this to false for testing
        me.sendPassword("1234");
        me.sendPassword("secret");
        me.sendPassword("letmein");        
        me.sendPassword("willthiswork");        
        // END YOUR WORK
        
        me.close();
    }
}