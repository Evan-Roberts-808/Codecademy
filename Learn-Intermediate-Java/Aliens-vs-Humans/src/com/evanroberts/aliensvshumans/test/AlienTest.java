import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienTest {
    private Alien healerAlien;
    private Alien shapeshifterAlien;

    @BeforeEach
    void setUp() {
        healerAlien = new Alien("HealerAlien", "Healer");
        shapeshifterAlien = new Alien("ShapeshifterAlien", "Shapeshifter");
    }

    @Test
    void testHealerAlienActivateAbility() {
        int initialHealth = healerAlien.getHealth();
        healerAlien.activateAbility();

        assertEquals(initialHealth + 20, healerAlien.getHealth());
    }

    @Test
    void testShapeshifterAlienActivateAbility() {
        int initialHealth = shapeshifterAlien.getHealth();
        shapeshifterAlien.activateAbility();

        assertEquals(initialHealth + 20, shapeshifterAlien.getHealth());
        assertTrue(shapeshifterAlien.getName().startsWith("Shapeshifted "));
        assertTrue(shapeshifterAlien.getAlienRace().startsWith("Morphed "));
    }

    @Test
    void testTakeDamage() {
        alien.takeDamage(30);
        assertEquals(70, alien.getHealth());
    }

    @Test
    void testMutagenItem() {
        boolean initialMutationState = shapeshifterAlien.isMutated();
        shapeshifterAlien.useItem("Mutagen");

        assertTrue(shapeshifterAlien.isMutated());
        assertFalse(initialMutationState);
    }

}