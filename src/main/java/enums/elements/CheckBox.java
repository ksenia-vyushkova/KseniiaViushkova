package enums.elements;

public enum CheckBox {

    WATER("Water", 0), EARTH("Earth", 1), WIND("Wind", 2), FIRE("Fire", 3);

    public String label;
    public int position;
    public String on = "true";
    public String off = "false";

    CheckBox(String label, int position) {
        this.label = label;
        this.position = position;
    }
}