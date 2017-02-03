package ch.ebu.ipush.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsmlDTO {
    private String lastModified;
    private Integer version;
    private String filename;
    private String itemState;
    private String guid;
    private String cdnId;
    private NewsInfoDTO newsInfo = new NewsInfoDTO();
    private List<RemoteContentDTO> remoteContents = new ArrayList<>();
    private List<MetaScheduledDTO> metaScheduleds = new ArrayList<>();

    public List<MetaScheduledDTO> getMetaScheduleds() {
        return metaScheduleds;
    }

    public void setMetaScheduleds(List<MetaScheduledDTO> metaScheduleds) {
        this.metaScheduleds = metaScheduleds;
    }

    public List<RemoteContentDTO> getRemoteContents() {
        return remoteContents;
    }

    public void setRemoteContents(List<RemoteContentDTO> remoteContents) {
        this.remoteContents = remoteContents;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getItemState() {
        return itemState;
    }

    public void setItemState(String itemState) {
        this.itemState = itemState;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCdnId() {
        return cdnId;
    }

    public void setCdnId(String cdnId) {
        this.cdnId = cdnId;
    }

    public NewsInfoDTO getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfoDTO newsInfo) {
        this.newsInfo = newsInfo;
    }
}
