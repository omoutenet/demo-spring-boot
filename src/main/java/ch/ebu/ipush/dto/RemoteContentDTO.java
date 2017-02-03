package ch.ebu.ipush.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RemoteContentDTO {
    private String cdnStatus;
    private String href;
    private String version;
    private String rendition;
    private String mediaId;
    private String contentType;
    private String mediaVersion;
    private String durationUnit;
    private String videoDefinition;
    private String size;

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getVideoDefinition() {
        return videoDefinition;
    }

    public void setVideoDefinition(String videoDefinition) {
        this.videoDefinition = videoDefinition;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMediaVersion() {
        return mediaVersion;
    }

    public void setMediaVersion(String mediaVersion) {
        this.mediaVersion = mediaVersion;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getRendition() {
        return rendition;
    }

    public void setRendition(String rendition) {
        this.rendition = rendition;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCdnStatus() {
        return cdnStatus;
    }

    public void setCdnStatus(String cdnStatus) {
        this.cdnStatus = cdnStatus;
    }

}
