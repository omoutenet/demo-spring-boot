package ch.ebu.ipush;

public class NewsMessage {

    private String slug;

    public NewsMessage() {
    }

    public NewsMessage(String slug) {
        this.slug = slug;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}