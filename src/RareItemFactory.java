public class RareItemFactory extends ItemFactory{
    @Override
    Weapon createWeapon() {
        return new Weapon(15, WeaponTypeEnum.MALEE, ItemRarity.RARE);
    }

    @Override
    Potion createPotion() {
        return new Potion("Strength Boost",15, ItemRarity.RARE);
    }

    @Override
    Armor createArmor() {
        return new Armor(20,10, ItemRarity.RARE);
    }
}
