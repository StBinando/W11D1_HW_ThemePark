package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        return (visitor.getAge()>=12)&(visitor.getHeight()>=145);
    }

    @Override
    public double getTicket(Visitor visitor) {
        if (visitor.getHeight()>200){
            return 8.40*2;
        } else {
            return 8.40;
        }
    }
}
