import java.time.LocalDate;

abstract class Site {
    protected int ID;
    protected char site;
    protected char mail;
    protected char username;
    protected char password;

    public Site(int ID, char site, char mail, char username, char password) {
        this.ID = ID;
        this.site = site;
        this.mail = mail;
        this.deliveryTime = deliveryTime;
    }

    public boolean IsFresh() {
        LocalDate expirationDate = deliveryTime.plusDays(storageLifeDays);
        return LocalDate.now().isBefore(expirationDate);
    }
}