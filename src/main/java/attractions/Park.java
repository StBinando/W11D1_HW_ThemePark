package attractions;

import people.Visitor;

public class Park extends Attraction {

    public Park(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Boolean isAllowedTo(Visitor visitor) {
        return true;
    }
}
