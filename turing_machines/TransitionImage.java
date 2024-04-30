



public class TransitionImage
{
    // Fields

    private String state;
    private char tapeSymbol;
    private char direction;

    // Methods

    public TransitionImage(String state, char tapeSymbol, char direction)
    {
        this.state = state;
        this.tapeSymbol = tapeSymbol;
        this.direction = direction;
    }

    public String getState() 
    {
        return state;
    }

    public char getSymbol()
    {
        return this.tapeSymbol;
    }

    public char getDirection()
    {
        return this.direction;
    }




}