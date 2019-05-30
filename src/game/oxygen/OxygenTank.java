package game.oxygen;
import edu.monash.fit2099.engine.*;

/**
 * This class is used to create an instance of the Item OxygenTank
 */
public class OxygenTank extends Item {

    private int count = 0;
    private final static int NOOFMOVES = 10;

    /**
     * This will get the count
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * This function is used to increment the count
     */
    public void incrementCount() {
        this.count ++;
    }

    /**
     * This function will return true when the count reaches the max no. of moves
     * @return true or false
     */
    public boolean empty() {
        if (count>=NOOFMOVES) {
            return true;
        } else{
            return false;
        }
    }

    public OxygenTank(){
        super("Oxygen Tank",'Ö');
    }
}
