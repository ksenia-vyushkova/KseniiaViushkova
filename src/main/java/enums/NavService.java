package enums;

public enum NavService {

    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    public String headerName;
    public String sidebarName;

    NavService(String name) {
        this.headerName = name.toUpperCase();
        this.sidebarName = name;
    }
}