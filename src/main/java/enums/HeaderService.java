package enums;

public enum HeaderService {

    SUPPORT("Support", 0),
    DATES("Dates", 1),
    SEARCH("Search", 2),
    COMPLEX_TABLE("Complex Table", 3),
    SIMPLE_TABLE("Simple Table", 4),
    USER_TABLE("User Table", 5),
    TABLE_WITH_PAGES("Table with pages", 6),
    DIFFERENT_ELEMENTS("Different elements", 7),
    PERFORMANCE("Performance", 8);

    public String headerName;
    public String sidebarName;
    public int position;

    HeaderService(String name, int position) {
        this.headerName = name.toUpperCase();
        this.sidebarName = name;
        this.position = position;
    }
}