import java.util.Arrays;
import java.util.Random;

public class Archer extends Character{

    public Archer(String name, int level) {
        setName(name);
        setLevel(1);
        setExperience(0);
        setHealth(20 * level);
        setStrength(5);
        setAttackGrid(new Integer[]{0, 1, 5, 8, 15, 17, 18, 20});
    }

    @Override
    public void attack(Enemy enemy) {
        System.out.println("Archer shoots an arrow at " + enemy.getName() + " for " + getStrength() + " damage!");
        enemy.takeDamage(getStrength());
    }

    @Override
    public void displayStats() {
        //System.out.println(getName() + " - HP: " + getHealth());
    }


    @Override
    void takeDamage(int grid, int damage) {
        if(Arrays.binarySearch(getAttackGrid(), grid) >= 0) {
            setHealth(getHealth() - damage);
            System.out.println("Archer takes " + damage + " damage! Remaining Health: " + getHealth()+"\n");

            if (getHealth() <= 0) {
                System.out.println("\nArcher has been defeated!");
            }
        }else {
            System.out.println("Missed ! Enemy Arrow\n");
        }
    }

    @Override
    void gainExperience(int xp) {
        setExperience(getExperience() + xp);
        System.out.println("\n"+getName() + " gains " + xp + " experience points!");

        // Level up logic
        if (getExperience() >= 100 * getLevel()) { // Example threshold for leveling up
            setLevel(getLevel() + 1);
            setExperience(0); // Reset experience after leveling up
            System.out.println("\n"+getName() + " has leveled up to level " + getLevel() + "!");
            increaseStatus(); // Optionally increase stats on level up
        }
    }


    protected void increaseStatus() {
        setHealth(getHealth() + 10); // Increase health on level up
        setStrength(getStrength() + 5); // Increase strength on level up
        setAgility(getAgility() + 2);
    }
}
