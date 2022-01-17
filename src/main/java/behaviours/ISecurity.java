package behaviours;

import people.Visitor;

public interface ISecurity {
    public Boolean isAllowedTo(Visitor visitor);
}
