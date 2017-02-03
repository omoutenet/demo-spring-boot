package ch.ebu.ipush.fwk;

import org.slf4j.Logger;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Utility class for date
 */
public class DateUtil {

    private static final Logger LOG = getLogger(DateUtil.class);
    public static String TIME_ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    public static String TIME_SPLUNK_FORMAT = "dd/MM/yyyy HH:mm:ss.SSS";
    public static String TIME_MEDIA_BUS_FORMAT = "yyyy-MM-dd HH:mm:ss,SSSX";
    public static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_ISO_FORMAT);
    public static DateTimeFormatter TIME_MEDIA_BUS_FORMATTER = DateTimeFormatter.ofPattern(TIME_MEDIA_BUS_FORMAT);
    public static DateTimeFormatter TIME_SPLUNK_FORMATTER = DateTimeFormatter.ofPattern(TIME_SPLUNK_FORMAT);
    public static DateTimeFormatter TIME_SPLUNK_SEARCH_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy:HH:mm:ss");

    public static LocalDateTime convertToLocalDateTime(String s) {
        return OffsetDateTime.parse(s, TIME_FORMATTER).toLocalDateTime();
    }

    public static OffsetDateTime convertToOffsetDateTimeForMediaBus(String s) {
        String string = s;
        if (!string.contains("Z")) {
            // add UTC timeZone
            string = string + "Z";

            try {
                return OffsetDateTime.parse(string, TIME_MEDIA_BUS_FORMATTER);
            } catch (DateTimeException e) {
                LOG.warn("Parsing error for {} : {}", string, e);
                return null;
            }
        }else {
            try {
                return OffsetDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss,SSS"));
            } catch (DateTimeException e1) {
                throw new IllegalArgumentException("Invalid date format");
            }
        }
    }

    public static OffsetDateTime convertToOffsetDateTime(String s) {
        return OffsetDateTime.parse(s, TIME_FORMATTER);
    }

    public static LocalDateTime convertToLocalDateTimeFromSplunkFormat(String s) {
        return OffsetDateTime.parse(s, TIME_SPLUNK_FORMATTER).toLocalDateTime();
    }

    /**
     * Now in string ISO
     *
     * @return
     */
    public static String now() {
        final OffsetDateTime now = OffsetDateTime.now(Clock.systemUTC());

        return TIME_SPLUNK_FORMATTER.format(now);
    }

    public static OffsetDateTime nowLocalDateTime() {
        final OffsetDateTime now = OffsetDateTime.now(Clock.systemUTC());

        return now;
    }

    /**
     * Convert in ISO
     *
     * @param localDateTime
     * @return
     */
    public static String convertAsIsoFormat(LocalDateTime localDateTime) {
        return TIME_FORMATTER.format(localDateTime);
    }

    public static String convertAsIsoFormatFromOffset(Temporal localDateTime) {
        return TIME_FORMATTER.format(localDateTime);
    }

    public static String convertSplunkFormat(String tStamp) {
        final LocalDateTime localDateTime = convertToLocalDateTime(tStamp);

        return TIME_SPLUNK_FORMATTER.format(localDateTime);
    }

    public static String convertTemporalToSplunkFormat(Temporal localDateTime) {
        return TIME_SPLUNK_FORMATTER.format(localDateTime);
    }

    public static String convertFromTimestampToDateTime(Long transmissionStart) {
        final Instant instant = Instant.ofEpochMilli(transmissionStart);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        return convertTemporalToSplunkFormat(ldt);
    }

    public static OffsetDateTime getDayBeforeNow() {
        return OffsetDateTime.now(Clock.systemUTC()).truncatedTo(ChronoUnit.DAYS).minusDays(1);
    }

    public static OffsetDateTime getStartOfDay() {
        return OffsetDateTime.now(Clock.systemUTC()).truncatedTo(ChronoUnit.DAYS);
    }

    public static OffsetDateTime getDayAfterNow() {
        return OffsetDateTime.now(Clock.systemUTC()).truncatedTo(ChronoUnit.DAYS).plusDays(1);
    }

    public static String convertTemporalToSplunkSearchFormat(OffsetDateTime localDateTime) {
        return TIME_SPLUNK_SEARCH_FORMATTER.format(localDateTime);
    }
}
