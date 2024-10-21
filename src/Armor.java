public class Armor extends ItemSpecification{
    private int defence;
    private int durability;

    Armor(int defence, int durability, ItemRarity rarity) {
        this.defence = defence;
        this.durability = durability;
        this.rarity = rarity;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
