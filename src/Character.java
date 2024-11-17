public abstract class Character implements IObserver{
    private String name;
    private int mana;
    private int health;
    private int level;
    private int strength;
    private int experience;
    private int agility;
    private Integer[] attackGrid;
    private Inventory inventory = new Inventory();

    private WeaponItem equippedWeapon;
    private DefensiveItem equippedDefensive;
    private UtilityItem equippedUtility;

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    private ICharacterState state;
    private Armor armor;

    public ICharacterState getState() {
        return state;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    private Weapon weapon;

    public Integer[] getAttackGrid() {
        return attackGrid;
    }

    public void setAttackGrid(Integer[] attackGrid) {
        this.attackGrid = attackGrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setState(ICharacterState state) {
        this.state = state;
        state.handleState(this);
    }

    abstract void attack(Enemy enemy);
    abstract void displayStats();
    abstract void takeDamage(int grid, int damage);
    abstract void gainExperience(int xp);
    abstract void increaseStatus();

    public void heal() {
        this.health = this.health + 1;
        System.out.println("Healing");
    }

    public void defend() {
        System.out.println("Defending");
    }

    public void moveTo(int x, int y) {
        System.out.println("Moving " + x + "to" + y);
    }

    public void equipItem(Item item) {
        if (item instanceof WeaponItem && equippedWeapon == null) {
            if (inventoryContains(item)) {
                inventory.removeInventoryItem(item);
                equippedWeapon = (WeaponItem) item;
                System.out.println(item + " equipped as weapon.");
            } else {
                System.out.println(item + " not found in inventory.");
            }
        } else if (item instanceof DefensiveItem && equippedDefensive == null) {
            if (inventoryContains(item)) {
                inventory.removeInventoryItem(item);
                equippedDefensive = (DefensiveItem) item;
                System.out.println(item + " equipped as defensive item.");
            } else {
                System.out.println(item + " not found in inventory.");
            }
        } else if (item instanceof UtilityItem && equippedUtility == null) {
            if (inventoryContains(item)) {
                inventory.removeInventoryItem(item);
                equippedUtility = (UtilityItem) item;
                System.out.println(item + " equipped as utility item.");
            } else {
                System.out.println(item + " not found in inventory.");
            }
        } else {
            System.out.println("Cannot equip this item or slot already occupied.");
        }
    }

    private boolean inventoryContains(Item item) {
        return inventory.getInventoryItems().contains(item);
    }

    public void unequipItem(String slot) {
        switch (slot.toLowerCase()) {
            case "weapon":
                if (equippedWeapon != null) {
                    inventory.addInventoryItem(equippedWeapon);
                    System.out.println("Unequipped " + equippedWeapon);
                    equippedWeapon = null;
                } else {
                    System.out.println("No weapon equipped.");
                }
                break;

            case "defensive":
                if (equippedDefensive != null) {
                    inventory.addInventoryItem(equippedDefensive);
                    System.out.println("Unequipped " + equippedDefensive);
                    equippedDefensive = null;
                } else {
                    System.out.println("No defensive item equipped.");
                }
                break;

            case "utility":
                if (equippedUtility != null) {
                    inventory.addInventoryItem(equippedUtility);
                    System.out.println("Unequipped " + equippedUtility);
                    equippedUtility = null;
                } else {
                    System.out.println("No utility item equipped.");
                }
                break;

            default:
                System.out.println("Invalid slot specified.");
        }
    }

    // Display currently equipped items
    public void displayEquipment() {
        System.out.println("Equipped Items:");
        System.out.println("- Weapon: " + (equippedWeapon != null ? equippedWeapon : "None"));
        System.out.println("- Defensive: " + (equippedDefensive != null ? equippedDefensive : "None"));
        System.out.println("- Utility: " + (equippedUtility != null ? equippedUtility : "None"));
    }

    // Accessor for the character's inventory
    public Inventory getInventory() {
        return inventory;
    }
}
