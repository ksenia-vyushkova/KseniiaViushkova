package enums;

public enum UserTableUser {

    ROMAN("Roman", "roman", 0),
    SERGEY_IVAN("Sergey Ivan", "ivan", 1),
    VLADZIMIR("Vladzimir", "vlad", 2),
    NELEN_BENNETT("Helen Bennett", "helen", 3),
    YOSHI_TANNAMURI("Yoshi Tannamuri", "yoshi", 4),
    GIOVANNI_ROVELLI("Giovanni Rovelli", "gio", 5);

    public String name;
    public String cssId;
    public int position;

    UserTableUser(String name, String cssId, int position) {
        this.name = name;
        this.cssId = cssId;
        this.position = position;
    }
}