package enums.elements;

public enum Log {

    SLIDER_LOG(9, "Range 2(", "):", " link clicked");

    public int nIgnoresSymbols;
    private String textStart;
    private String textMiddle;
    private String textEnd;

    Log(int nIgnoresSymbols, String textStart, String textMiddle, String textEnd) {
        this.nIgnoresSymbols = nIgnoresSymbols;
        this.textStart = textStart;
        this.textMiddle = textMiddle;
        this.textEnd = textEnd;
    }

    public String constructLog(String s1, String s2) {
        return textStart + s1 + textMiddle + s2 + textEnd;
    }
}