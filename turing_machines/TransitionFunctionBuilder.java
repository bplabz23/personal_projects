

import java.util.HashMap;



public class TransitionFunctionBuilder
{
    // Fields
    private HashMap<String, TransitionImage> function;

    
    // Methods 

    public TransitionFunctionBuilder()
    {
        function = new HashMap<String, TransitionImage>();
    }

    public void addOrderedPair(String input, String state, char symbol, char direction)
    {
        // 1. Build a transitionImage object out of the given data
        TransitionImage t = new TransitionImage(state, symbol, direction);

        // 2. Add the mapping of (input, transitionImage) to hashMap 
        function.put(input, t);
    }

    public void justMoveUntil(String state, char symbol, char direction)        
    {
        // Prints all the rules for the following situation:
        // "For given state, don't make changes, just keep moving in specified direction until we see specified character"
        
        // Create buffers for our input and image
        String input;
        TransitionImage t;

        // For every character != symbol
        for(char i = 0; i < 128; i++)
        {
            if (i != symbol)
            {
                // Build the transition function input
                input = "(";
                input += state;
                input += ", ";
                input += Character.toString(i);
                input += ")";
                
                // Build the image of the input
                t = new TransitionImage(state, i, direction);

                // Create a mapping of these two elements in the hashMap
                this.function.put(input, t);
            }

        }

    }

    public void printFunction()
    {
        System.out.println( this.function.toString() );
    }


}