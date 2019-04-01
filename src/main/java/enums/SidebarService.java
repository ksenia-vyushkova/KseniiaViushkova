package enums;

public enum SidebarService {

    SUPPORT("Support", 0),
    DATES("Dates", 1),
    COMPLEX_TABLE("Complex Table", 2),
    SIMPLE_TABLE("Simple Table", 3),
    SEARCH("Search", 4),
    USER_TABLE("User Table", 5),
    TABLE_WITH_PAGES("Table with pages", 6),
    DIFFERENT_ELEMENTS("Different elements", 7),
    PERFORMANCE("Performance", 8);

    public String headerName;
    public String sidebarName;
    public int position;

    SidebarService(String name, int position) {
        this.headerName = name.toUpperCase();
        this.sidebarName = name;
        this.position = position;
    }
}