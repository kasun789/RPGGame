public class MagicalItemFactory extends ItemFactory{
    @Override
    Weapon createWeapon() {
        return new Weapon(10, WeaponTypeEnum.RANGED, ItemRarity.MEGICAL);
    }

    @Override
    Potion createPotion() {
        return new Potion("Mana Restore", 10, ItemRarity.MEGICAL);
    }

    @Override
    Armor createArmor() {
        return new Armor(15,6, ItemRarity.MEGICAL);
    }
}
