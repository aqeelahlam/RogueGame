package game;
import edu.monash.fit2099.engine.*;
public class OxygenTank extends Item {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void incrementCount()
    {
        this.count ++;
    }
    public boolean empty()
    {
        if (count>=10)
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
