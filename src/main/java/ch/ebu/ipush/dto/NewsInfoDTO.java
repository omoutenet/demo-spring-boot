package ch.ebu.ipush.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsInfoDTO {
    private NewsStatusDTO newsStatus;
    private String clipGuid;

    public NewsStatusDTO getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(NewsStatusDTO newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getClipGuid() {
        return clipGuid;
    }

    public void setClipGuid(String clipGuid) {
        this.clipGuid = clipGuid;
    }
}
