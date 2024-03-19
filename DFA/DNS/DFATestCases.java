



public class DFATestCases
{


	public static void main(String[] args)
	{
		
		// Setup
		
		
		String[] test_case = new String[6];
		
		
		// False
		test_case[0] = "hello";
		test_case[1] = "wwf.hello.com";
		test_case[2] = "www.hello.abc";
		
		
		// True
		test_case[3] = "www.hello.com";
		test_case[4] = "www.hello.gov";
		test_case[5] = "www.hello.edu";
		
		
		// Automata
		DomainNameDFA automata = new DomainNameDFA();
		
		
		
		// Run tests
		
		
		System.out.println("\n******************************* RUNNING TEST CASES *************************************");
		
		for (int i = 0; i < 6; i++)
		{
			
			
			if ( automata.isInLanguage(test_case[i]) == true)										// If test_case[i] is a string in our language, say that to user
			{
				System.out.println(test_case[i] + " is a domain name.\n");
			}
			
			
			else																					// Otherwise, tell user it is NOT in our language of domain names
			{
				System.out.println(test_case[i] + " is NOT a domain name.\n");
			}
			
		}
		
		
		
		
		
	}



}