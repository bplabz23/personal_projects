

import java.util.HashMap;


public class Main
{

    public static void main(String[] args)
    {

        // Build the transition function
        
        TransitionFunctionBuilder b = new TransitionFunctionBuilder();
        b.justMoveUntil('<', "q0", 'R');
        b.forAllExcept('>', "q1", ' ', 'R');
        b.addOrderedPair("(q0, <)", "q1", ' ', 'R');
        b.addOrderedPair("(q1, >)", "q0", ' ', 'R');

        HashMap<String, TransitionImage> func = b.getFunction();

        // Build the machine, give it the function and the tape
        String tape = "<html> <p>Hello World!<\\p> <\\html>";
        TuringMachine m = new TuringMachine(tape, 0, func);


        // Run it
        System.out.println("\n****************************************** START **********************************************");
        System.out.println("\n");
        m.processTapeWithPrint();
    }


}