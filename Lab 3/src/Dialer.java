
public interface Dialer 
{
	//concatenates a digit to the phone number
	public void pressKey(int key);
	//clears the phone number (set to blank)
	public void clear();
	//gets the name of the contact that's associated with the phone number
	public String getAssociatedContact();
}
