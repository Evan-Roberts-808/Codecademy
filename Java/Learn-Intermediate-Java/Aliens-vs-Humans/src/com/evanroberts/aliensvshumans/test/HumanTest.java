import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    private Human human;
    private Alien alien;

    @BeforeEach
    void setUp() {
        human = new Human("John");
    }

    @Test
    void testTakeDamage() {
        human.takeDamage(20);
        assertEquals(80, human.getHealth());
    }

    @Test
    void testActivateArmorAbility() {
        assertEquals(0, human.getArmor());

        human.activateArmorAbility();

        assertEquals(10, human.getArmor());
    }

    @Test
    void testActivateOffensiveAbility() {
        Alien alien = new Alien("Alien1", "SomeRace");

        int initialAlienHealth = alien.getHealth();

        human.activateOffensiveAbility(alien);

        assertEquals(initialAlienHealth - 15, alien.getHealth());
    }

    @Test
    void testUseItem() {
        int initialHumanHealth = human.getHealth();

        human.useItem("Food");

        assertEquals(initialHumanHealth + 30, human.getHealth());
    }

}