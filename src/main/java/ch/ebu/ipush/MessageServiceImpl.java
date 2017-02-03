package ch.ebu.ipush;

import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
    private static final String NEWS_S_WITH_ID_S_CREATED = "News <a href='/news/%s' target='_blank'>%s</a> %s !";
    private static final String SLUG_JSON_PATH = "$.metadata.slug";
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public MessageServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void sendNewsUpdated(News news) {
        notification(news, "updated");
    }

    @Override
    public void sendNewsCreated(News news) {
        notification(news, "created");
    }

    private void notification(News news, String message) {
        final String slug = JsonPath.parse(news.getContent()).read(SLUG_JSON_PATH);
        simpMessagingTemplate.convertAndSend(TOPIC_NEWS, new NewsSlug(String.format(NEWS_S_WITH_ID_S_CREATED, news.getId(), slug, message)));
    }

}
