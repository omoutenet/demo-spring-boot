package ch.ebu.ipush.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaScheduledDTO {
    private String qcode;
    private Long transmissionStart;
    private Integer isLive;
    private String ebuStatus;
    private Long scheduledStart;
    private Boolean ignoreTiming;
    private Long transmissionEnd;
    private Long scheduledEnd;

    public Long getScheduledEnd() {
        return scheduledEnd;
    }

    public void setScheduledEnd(Long scheduledEnd) {
        this.scheduledEnd = scheduledEnd;
    }

    public Long getTransmissionEnd() {
        return transmissionEnd;
    }

    public void setTransmissionEnd(Long transmissionEnd) {
        this.transmissionEnd = transmissionEnd;
    }

    public Boolean getIgnoreTiming() {
        return ignoreTiming;
    }

    public void setIgnoreTiming(Boolean ignoreTiming) {
        this.ignoreTiming = ignoreTiming;
    }

    public Long getScheduledStart() {
        return scheduledStart;
    }

    public void setScheduledStart(Long scheduledStart) {
        this.scheduledStart = scheduledStart;
    }

    public String getEbuStatus() {
        return ebuStatus;
    }

    public void setEbuStatus(String ebuStatus) {
        this.ebuStatus = ebuStatus;
    }

    public Integer getIsLive() {
        return isLive;
    }

    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    public Long getTransmissionStart() {
        return transmissionStart;
    }

    public void setTransmissionStart(Long transmissionStart) {
        this.transmissionStart = transmissionStart;
    }

    public String getQcode() {
        return qcode;
    }

    public void setQcode(String qcode) {
        this.qcode = qcode;
    }

}
