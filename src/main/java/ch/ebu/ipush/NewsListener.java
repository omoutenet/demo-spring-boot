package ch.ebu.ipush;

import javax.persistence.PrePersist;
import java.util.UUID;

/**
 * Created by sopra_om on 01.02.2017.
 */
public class NewsListener {
    @PrePersist
    public void prePersist(News news) {
        if (news.getId() == null) {
            news.setId(UUID.randomUUID().toString());
        }
    }
}
