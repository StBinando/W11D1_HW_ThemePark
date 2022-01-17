import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;

    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    private ArrayList<IReviewed> things;
    ThemePark themePark;

    Visitor visitor;

    @Before
    public void before(){
        rollerCoaster = new RollerCoaster("Vertigo", 9);
        dodgems = new Dodgems("boh", 3);
        park = new Park("Park", 5);
        playground = new Playground("Playground", 7);
        candyflossStall = new CandyflossStall("Candy","Bob", ParkingSpot.B1, 2);
        iceCreamStall = new IceCreamStall("I Scream", "Alice", ParkingSpot.A4, 9);
        tobaccoStall = new TobaccoStall("Smoke", "Simon", ParkingSpot.B3, 6);
        things = new ArrayList<>();
        things.add(dodgems);
        things.add(park);
        things.add(playground);
        things.add(rollerCoaster);

        things.add(candyflossStall);
        things.add(iceCreamStall);
        things.add(tobaccoStall);

        themePark = new ThemePark(things);

        visitor = new Visitor(22,175, 30);

    }

    @Test
    public void TPHasAttractionsAndStalls(){
        assertEquals(7, themePark.getThings().size());
    }

    @Test
    public void TPCanIncrementCount(){
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void TPCanAddAttractionVisitedToVisitor(){
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals("Vertigo", visitor.getVisitedAttractions().get(0).getName());
    }

    @Test
    public void TPcanGenerateReviewsList(){
        assertEquals(7, themePark.getReviews().size());
        HashMap<String, Integer> map;
        map = new HashMap<>(themePark.getReviews());
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

    @Test
    public void TPCanProvideAllowedAttractions(){
        for (IReviewed r : themePark.getAllAllowedFor(visitor)){
            System.out.println(r.getName());
        }
        assertEquals(3, themePark.getAllAllowedFor(visitor).size());
    }
}
