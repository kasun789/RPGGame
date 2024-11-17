public class WeaponItem extends Item{
    private int damage;

    public WeaponItem(String name, int damage) {
        super(name, "Weapon");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
