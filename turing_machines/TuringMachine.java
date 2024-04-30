

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

    public void setFunction( HashMap<String, TransitionImage> function)
    {
        this.transitionFunction = function;
    }


    // Methods - text processing

    public void processSymbol()
    {
        // 1. Get the tape symbol that the rw-head is currently pointing at
        char currentSymbol = tape.charAt(rwHead);

        // 2. Take the current symbol and state, build a string that the transition function will accept
        String input = "(";
        input += this.state;
        input += ", ";
        input += String.valueOf(currentSymbol);
        input += ")";

        // 3. Get the corresponding transition that is mapped to (current_state, current_symbol)
        TransitionImage transition = transitionFunction.get(input);

        // 4. Update our Turing Machine, as specified by the transition image

        // 4.a Change the current state our machine is in
        this.state = transition.getState();

        // 4.b Change the tape symbol our head is pointing at
        char[] tapeChars = tape.toCharArray();                          // Convert our tape to a char[]
        tapeChars[rwHead] = transition.getSymbol();                     // Write the new tape symbol where the head is pointing
        this.changeTape( String(tapeChars) );                           // Update this change to the machine's tape
    
        // 4.c Move the r/w head, as specified by transition
        char direction = transition.getDirection();
        
        if (direction == 'L')
        {
            this.rwHead--;
        }

        elseif (direction == 'R')
        {
            this.rwHead++;
        }

        
    }


}