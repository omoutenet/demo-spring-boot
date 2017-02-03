package ch.ebu.ipush.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetadataDTO {
    private String slug;
    private String source;
    @JsonProperty("clip-basename")
    private String clipBasename;
    private String origin;
    private String city;
    @JsonProperty("transmission-type")
    private String transmissionType;

    public MetadataDTO() {

    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClipBasename() {
        return clipBasename;
    }

    public void setClipBasename(String clipBasename) {
        this.clipBasename = clipBasename;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}
