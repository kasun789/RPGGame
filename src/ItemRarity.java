public enum ItemRarity {
    COMMON(1),MEGICAL(2),RARE(3),LEGENDARY(4);

    private int id;

    ItemRarity(int id) {
        this.id = id;
    }

    private String getDescription(int id) {
        switch (id) {
            case 1:
                return "Common";
            case 2:
                return "Magical";
            case 3:
                return "Rare";
            case 4:
                return "Legendary";
            default:
                return "";
        }
    }

}
