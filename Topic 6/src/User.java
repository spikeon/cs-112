
public class User 
{
	public String first_name, last_name, email, country, username, password, ip; 
	
	public User(String[] parts)
	{
		first_name = parts[0];
		last_name = parts[1];
		email = parts[2];
		country = parts[3];
		username = parts[4];
		password = parts[5];
	}
}
