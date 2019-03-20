package enums.elements;

public enum SelectOption {

    RED("Red", 0), GREEN("Green", 1), BLUE("Blue", 2), YELLOW("Yellow", 3);

    public String option;
    public int postion;
    public String elementName = "Color";

    SelectOption(String option, int postion) {
        this.option = option;
        this.postion = postion;
    }
}