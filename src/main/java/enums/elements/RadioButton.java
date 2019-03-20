package enums.elements;

public enum RadioButton {

    GOLD("Gold", 0), SILVER("Silver", 1), BRONZE("Bronze", 2), SELEN("Selen", 3);

    public String label;
    public int position;
    public String elementName = "metal";

    RadioButton(String label, int position) {
        this.label = label;
        this.position = position;
    }
}