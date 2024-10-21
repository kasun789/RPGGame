public enum WeaponTypeEnum {
    MALEE(1), RANGED(2);

    private int id;

    WeaponTypeEnum(int id) {
        this.id = id;
    }

    private String getDescription(int id) {
        switch (id) {
            case 1:
                return "Malee";
            case 2:
                return "Ranged";
            default:
                return "";
        }
    }
}
