public class CharacterFactory {
    public static Character createCharacter(String type, String name, int level) {
        Character character;
        switch (type.toLowerCase()) {
            case "warrior":
                character = new Warrior(name,level);
                CommonItemFactory commonItemFactory = new CommonItemFactory();
                character.setWeapon(commonItemFactory.createWeapon());
                character.setArmor(commonItemFactory.createArmor());
                break;

            case "archer":
                character = new Archer(name,level);
                LegendaryItemFactory legendaryItemFactory = new LegendaryItemFactory();
                character.setWeapon(legendaryItemFactory.createWeapon());
                character.setArmor(legendaryItemFactory.createArmor());
                break;

            case "mage":
                character = new Mage(name,level);
                MagicalItemFactory magicalItemFactory = new MagicalItemFactory();
                character.setWeapon(magicalItemFactory.createWeapon());
                character.setArmor(magicalItemFactory.createArmor());
                break;

            default:
                throw new IllegalArgumentException("Unknown character type");
        }
        return character;
    }
}
