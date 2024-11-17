public abstract class Item {
    protected String name;
    protected String itemType;

    public Item(String name, String itemType) {
        this.name = name;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return name + " (" + itemType + ")";
    }
}
