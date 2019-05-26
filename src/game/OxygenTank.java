package game;
import edu.monash.fit2099.engine.*;
public class OxygenTank extends Item {

    private int count = 0;
    private final static int NOOFMOVES = 10;

    public int getCount() {
        return count;
    }

    public void incrementCount()
    {
        this.count ++;
    }
    public boolean empty()
    {
        if (count>=NOOFMOVES)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public OxygenTank(){
        super("Oxygen Tank",'Ö');
    }
}
