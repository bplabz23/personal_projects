

/*
*		File Name:	DomainNameDFA.java
*
*		Author:			Basil Moledina
*		Date:			3/18/2024
*		Description:	A DFA that determines if a word/string is a domain name.
*
*
*
*		Note:			This design is based on the fact that Java does not support pass-by-reference (i.e. Makes recursion more challenging)
*
*						General design pattern is "check" letter ( == or != ),  then "consume" (index++)
*
*						To get the "real" feel of a DFA, we can also use Scanners
*/




public class DomainNameDFA
{
	
	public DomainNameDFA()
	{}	// Empty Constructor
	
	
	
	
	
	
	// Check if this word is in the language consisting of all domain names (is our word a domain name?)
	public boolean isInLanguage(String word)
	{
		
		// Setup
		int index = 0;		// Keep track of which letter is to be consumed next
		
		
		
		//	Step 1: Check for the empty word
		if (word.length() == 0)
		{
			return false;
		}			
		
		
		
		
		
		
		// Step 2: Check for www- prefix (weed out everything else)
		while( index < 3 )
		{
			if (word.charAt(index) != 'w')
			{
				// if our prefix is made of anything not a w, this is not a domain name
				return false;
			}				
			
			index++;	// We have just consumed a letter
			
		}
		
		
		
		
		
		
		
		// Step 3: Check for www.-prefix. 
		if (word.charAt(3) != '.')
		{
			// If sub-domain (www) does not terminate in ., this is not in our language
			return false;
		}
		
		index++;

			
			
			
			
			
			
			
			
			
			
		// Step 4: The actual domain name can be made of any characters, but terminates in a '.' so just consume characters until we see that
		//		WARNING: This section can cause infinite loops and have bounds exceptions, an if/then needs to return false if our domain name is too big or ceases to end (say, is 200 characters)

		while ( word.charAt(index) != '.' )
		{
			index++;
		}
		
		index++;	// Do this one more time for when we do finally 
		
		
		
		
		// 	Step 5.a Assuming this is a correct word, we only have 3 letters left - the top-level domain. Copy those letters into a new array. Make a substring
		//		WARNING: IT IS A MASSIVE ASSUMPTION THAT THIS IS CORRECT AND THAT THERE ARE ONLY 3 LETTERS LEFT
		
		char[] substring = new char[3];
		
		
		// Get letter from word, throw into the array. Do it 3 times
		for (int i = 0; i < 3; i++)
		{
			substring[i] = word.charAt(index);
			index++;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//	Step 5.b  Check if our substring is any of the following post-fixes:  .com, .gov, .edu
		//		If so, return true. This is supposed to a simple program. To our satisfaction, this is a word in our language.
		
		
		
		if ( substring[0] == 'c' )					// Check if it is .com - and if it is, return that is in the language
		{
		
			if ( substring[1] == 'o' )
			{
				
					if( substring[2] == 'm' )
					{
						return true;
					}
				
			}
		}
		
		
		
		
		
	
		
		if ( substring[0] == 'g' )				// Check if it is .gov - and if it is, return that is in the language
		{
		
			if ( substring[1] == 'o' )
			{
				
					if( substring[2] == 'v' )
					{
						return true;
					}
				
			}
		}
		
		
		
		
		
		
		
		if (substring[0] == 'e')					// Check if it is .edu - and if it is, return that is in the language
		{
		
			if (substring[1] == 'd')
			{
				
					if(substring[2] == 'u')
					{
						return true;
					}
				
			}
		
		}
		
		
		
		
	
		
		
		return false;										// Else, by default, this word is NOT in our language
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}