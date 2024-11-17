public class DefensiveItem extends Item{
    private int defense;

    public DefensiveItem(String name, int defense) {
        super(name, "Defensive");
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
