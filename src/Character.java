public abstract class Character {
    private String name;
    private int mana;
    private int health;
    private int level;
    private int strength;
    private int experience;
    private int agility;
    private Integer[] attackGrid;

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
}
