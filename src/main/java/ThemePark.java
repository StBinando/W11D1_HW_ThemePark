import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThemePark {
    private ArrayList<IReviewed> reviewed;
    private HashMap<String, Integer> reviews;
    private ArrayList<IReviewed> allowed;

    public ThemePark(ArrayList<IReviewed> reviewed) {
        this.reviewed = reviewed;
    }

    public ArrayList<IReviewed> getThings() {
        return this.reviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.increaseVisitCount();
        visitor.addVisitedAttraction(attraction);
    }

    public HashMap getReviews(){
        reviews = new HashMap<>();
        for (IReviewed r: reviewed){
            this.reviews.put(r.getName(), r.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        allowed = new ArrayList<>();
        for (IReviewed r : reviewed){
            if (r instanceof Attraction){
                if (((Attraction) r).isAllowedTo(visitor)){
                    allowed.add(r);
                }
            }

        }
        return allowed;
    }
}
