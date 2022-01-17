package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double getTicket(Visitor visitor) {
        if (visitor.getAge()<12){
            return 4.50/2;
        }else{
            return 4.50;
        }
    }

    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        return true;
    }
}
