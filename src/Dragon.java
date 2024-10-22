public class Dragon extends Enemy{
    public Dragon(int level, int mana, int strength, int agility, String rank) {
        this.setName("Dragon");
        this.setMana(mana);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setRank(rank);
        this.setHealth(level * strength);
    }
}
