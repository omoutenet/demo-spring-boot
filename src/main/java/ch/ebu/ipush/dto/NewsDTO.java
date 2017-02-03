package ch.ebu.ipush.dto;

import ch.ebu.ipush.fwk.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsDTO extends AbstractDTO implements Comparable<NewsDTO> {
    private String member;
    private String state;
    private String author;
    private String type;
    @JsonProperty("from-offer-version")
    private Integer fromOfferVersion;
    private NewsmlDTO newsml;
    private List<String> recipientsList;
    private List<File> files;
    private Integer version;
    private Integer downloads;
    @JsonProperty("identifiers")
    private IdentifierDTO identifiers;
    private MetadataDTO metadata;
    @JsonProperty("iaro-state")
    private String iaroState;
    @JsonProperty("last-update-info")
    private LastUpdateInfoDTO lastUpdateInfo;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFromOfferVersion() {
        return fromOfferVersion;
    }

    public void setFromOfferVersion(Integer fromOfferVersion) {
        this.fromOfferVersion = fromOfferVersion;
    }


    public NewsmlDTO getNewsml() {
        return newsml;
    }

    public void setNewsml(NewsmlDTO newsml) {
        this.newsml = newsml;
    }

    public List<String> getRecipientsList() {
        return recipientsList;
    }

    public void setRecipientsList(ArrayList<String> recipientsList) {
        this.recipientsList = recipientsList;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public IdentifierDTO getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(IdentifierDTO identifiers) {
        this.identifiers = identifiers;
    }

    public MetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDTO metadata) {
        this.metadata = metadata;
    }

    public String getIaroState() {
        return iaroState;
    }

    public void setIaroState(String iaroState) {
        this.iaroState = iaroState;
    }

    public LastUpdateInfoDTO getLastUpdateInfo() {
        return lastUpdateInfo;
    }

    public void setLastUpdateInfo(LastUpdateInfoDTO lastUpdateInfo) {
        this.lastUpdateInfo = lastUpdateInfo;
    }

    @Override
    public String toString() {
        return "News{" +
                "member='" + member + '\'' +
                ", state='" + state + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", fromOfferVersion=" + fromOfferVersion +
                ", newsml=" + newsml +
                ", recipientsList=" + recipientsList +
                ", files=" + files +
                ", version=" + version +
                ", downloads=" + downloads +
                ", identifiers=" + identifiers +
                ", metadata=" + metadata +
                ", iaroState='" + iaroState + '\'' +
                ", lastUpdateInfo=" + lastUpdateInfo +
                '}';
    }

    private LocalDateTime getTimeStamp() {
        return DateUtil.convertToLocalDateTime(getLastUpdateInfo().getTstamp());
    }

    @Override
    public int compareTo(NewsDTO o) {
        if (this == o) {
            return 0;
        }

        return getTimeStamp().compareTo(o.getTimeStamp());
    }
}
