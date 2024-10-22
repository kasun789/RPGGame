public class Goblin extends Enemy{
    public Goblin(int level, int mana, int strength, int agility, String rank) {
        this.setName("Goblin");
        this.setMana(mana);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setRank(rank);
        this.setHealth(level * strength);
    }
}
