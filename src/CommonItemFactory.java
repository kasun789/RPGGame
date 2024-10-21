public class CommonItemFactory extends ItemFactory{
    @Override
    Weapon createWeapon() {
        return new Weapon(5 , WeaponTypeEnum.MALEE, ItemRarity.COMMON );
    }

    @Override
    Potion createPotion() {
        return new Potion("Heal", 5, ItemRarity.COMMON);
    }

    @Override
    Armor createArmor() {
        return new Armor(10, 3, ItemRarity.COMMON);
    }
}
