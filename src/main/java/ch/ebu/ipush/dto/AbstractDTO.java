package ch.ebu.ipush.dto;

public abstract class AbstractDTO {
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
