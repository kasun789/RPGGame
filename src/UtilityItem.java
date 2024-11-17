public class UtilityItem extends Item{
    private String effect;

    public UtilityItem(String name, String effect) {
        super(name, "Utility");
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }
}
