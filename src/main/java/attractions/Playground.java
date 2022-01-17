package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        return (visitor.getAge()<=15);
    }

}
