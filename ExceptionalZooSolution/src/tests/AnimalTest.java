package tests;


import exceptions.AllergyException;
import exceptions.NotHungry;
import model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnimalTest {

    @Test
    public void eatIsHungryNotAllergic(){
        // expecting eatenTimes to be 1, and no exceptions thrown.
        Animal animal = new Animal(true, false);
        int eatenTimes = 0;

        try{
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got allergic when shouldn't have");
        } catch (NotHungry notHungry) {
            fail("Got not hungry when we shouldn't have");
        }

        assertTrue(eatenTimes == 1);
    }

    @Test
    public void eatNotHungryNotAllergic(){
        // expecting a NotHungry exception to be thrown
        // and for eatenTimes to remain 0
        Animal animal = new Animal(false, false);
        int eatenTimes = 0;

        try{
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got allergy exception");
        } catch (NotHungry notHungry) {
            // don't have to do anything here!
        }
        assertTrue(eatenTimes == 0);
    }


}