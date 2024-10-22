public class Slime extends Enemy{

    public Slime(int level, int mana, int strength, int agility, String rank) {
        this.setName("Slime");
        this.setMana(mana);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setRank(rank);
        this.setHealth(level * strength);
    }
}
