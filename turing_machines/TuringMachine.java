

// Libraries 
import java.util.HashMap;

public class TuringMachine
{

    // Fields
    
    private String tape;
    private int rwHead;
    private String state;
    private HashMap<String, TransitionImage> transitionFunction;



    // Methods - setup/initialization

    public TuringMachine() 
    {
        this.tape = "";
        this.rwHead = 0;
        this.state = "q0";
        this.transitionFunction = new HashMap<String, TransitionImage>();
    }

    public TuringMachine(String tape, int rwHead, HashMap<String, TransitionImage> function)
    {
        this.tape = tape;
        this.rwHead = rwHead;
        this.state = "q0";
        this.transitionFunction = function;
    }

    public String getTape() 
    {
        return this.tape;
    }
 
    public String changeTape(String newTape) 
    {
        String oldTape = this.tape;
        this.tape = newTape;
        return oldTape;
    }

    public int getHeadPosition() 
    {
        return this.rwHead;
    }

    public void resetHead() 
    {
        this.rwHead = 0;
    }

    public String getState()
    {
        return this.state;
    }

    public void resetState()
    {
        this.state = "q0";
    }

    public void setFunction( HashMap<String, TransitionImage> function)
    {
        this.transitionFunction = function;
    }


    // Methods - text processing


    public bool processSymbol()
    {
        // 1. Check if there is anymore tape to be analyzed. If not, exit and return false 
        if ( this.rwHead >= tape.length() || this.rwHead < 0 )
        {
            return false;
        }

        // 2. Get the current tape symbol that the head is pointing at.
        char currentSymbol = tape.charAt(rwHead);


        // 3. Take the current symbol and state, build a string that the transition function will accept
        String input = "(";
        input += this.state;
        input += ", ";
        input += String.valueOf(currentSymbol);
        input += ")";

        // 4. Get the corresponding transition that is mapped to (current_state, current_symbol)
        TransitionImage transition = transitionFunction.get(input);

        // 5. Before we update our Turing machine as described the transition image, check IF WE EVEN GOT ONE
        if (transition = null)
        {
            // If not, exit and return false
            return false;
        }

        // 6.a Change the current state our machine is in
        this.state = transition.getState();

        // 6.b Change the tape symbol our head is pointing at
        char[] tapeChars = tape.toCharArray();                          // Convert our tape to a char[]
        tapeChars[rwHead] = transition.getSymbol();                     // Write the new tape symbol where the head is pointing
        this.changeTape( String(tapeChars) );                           // Update this change to the machine's tape
    
        // 6.c Move the r/w head, as specified by transition
        char direction = transition.getDirection();
        
        if (direction == 'L')
        {
            this.rwHead--;
        }

        else if (direction == 'R')
        {
            this.rwHead++;
        }


        // 7. Return true (meaning: "there was tape AND the machine processed it") 
        return true;
    }

    public void processTapeWithPrint()
    {
        // 1. Print what the Turing machine looks like initially
        this.printMachine();

        // 2. Keep processing the tape one cell at a time, until it halts (no more tape or no specified transition)
        while( this.processSymbol() )
        {   
            // Print a snapshot of the machine after it processes a symbol (changes)
            this.printMachine();
        }

        // 3. Print the machine one last time (when it halts)
        this.printMachine();

    }

    



    // Methods - machine output

    public String printMachine()
    {
        // 1. Print the tape
        for (int i = 0; i < tape.length(); i++)
        {
            System.out.print( tape.charAt(this.rwHead) );
            System.out.print(' ');
        }

        System.out.print("\n");

        // 2. Print the R/W head
        for (int i = 0; i < tape.length(); i++)
        {
            if ( i == rwHead)
            {
                System.out.print( tape.charAt(this.rwHead) );
            }
            
            System.out.print(' ');
        }
    
        system.out.print("\n");

        // 3. Print state
        System.out.print("State: ");
        System.out.println(this.state);

        System.out.println("\n");
    }






}