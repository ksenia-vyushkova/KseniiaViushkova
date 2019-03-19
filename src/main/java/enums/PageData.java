package enums;

public enum PageData {

    INDEX_PAGE("https://epam.github.io/JDI/index.html", "Home Page"),
    DIFFERENT_ELEMENTS_PAGE("https://epam.github.io/JDI/different-elements.html", "Different Elements"),
    DATES_PAGE("https://epam.github.io/JDI/dates.html", "Dates");


    public String url;
    public String title;

    PageData(String url, String title) {
        this.url = url;
        this.title = title;
    }
}