package enums.elements;

public enum Slider {

    LEFT_SLIDER("From"), RIGHT_SLIDER("To");

    public String alias;

    Slider(String alias) {
        this.alias = alias;
    }
}