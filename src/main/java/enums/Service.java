package enums;

public enum Service {

    SUPPORT("Support", 0),
    DATES("Dates", 1),
    COMPLEX_TABLE("Complex Table", 2),
    SIMPLE_TABLE("Simple Table", 3),
    TABLE_WITH_PAGES("Table with pages", 5),
    DIFFERENT_ELEMENTS("Different elements", 6);

    public String headerName;
    public String sidebarName;
    public int position;

    Service(String name, int position) {
        this.headerName = name.toUpperCase();
        this.sidebarName = name;
        this.position = position;
    }
}