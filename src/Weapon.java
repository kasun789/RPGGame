public class Weapon extends  ItemSpecification{
    private int damage;
    private WeaponTypeEnum weaponTypeEnum;

    Weapon(int damage, WeaponTypeEnum weaponTypeEnum, ItemRarity rarity) {
        this.damage = damage;
        this.weaponTypeEnum = weaponTypeEnum;
        this.rarity = rarity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public WeaponTypeEnum getWeaponTypeEnum() {
        return weaponTypeEnum;
    }

    public void setWeaponTypeEnum(WeaponTypeEnum weaponTypeEnum) {
        this.weaponTypeEnum = weaponTypeEnum;
    }
}
