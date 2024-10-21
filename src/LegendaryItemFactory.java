public class LegendaryItemFactory extends ItemFactory{
    @Override
    Weapon createWeapon() {
        return new Weapon(25, WeaponTypeEnum.RANGED, ItemRarity.LEGENDARY);
    }

    @Override
    Potion createPotion() {
        return new Potion("Invincibility", 30, ItemRarity.LEGENDARY);
    }

    @Override
    Armor createArmor() {
        return new Armor(50,20, ItemRarity.LEGENDARY);
    }
}
