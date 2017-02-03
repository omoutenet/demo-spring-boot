package ch.ebu.ipush;

public interface MessageService {
    String TOPIC_NEWS = "/topic/news";

    void sendNewsCreated(News news);

    void sendNewsUpdated(News news);
}
