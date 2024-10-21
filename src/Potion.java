public class Potion extends ItemSpecification{
    private String effect;
    private int duration;

    Potion(String effect, int duration, ItemRarity rarity) {
        this.effect = effect;
        this.duration = duration;
        this.rarity = rarity;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
