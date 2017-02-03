package ch.ebu.ipush;

import ch.ebu.ipush.fwk.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableAsync
public class DemoApplication extends AsyncConfigurerSupport{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Load data on start
     */
    @Component
    @Profile("!test")
    public class StartCommandLine implements InitCommandLineRunner {

        private final NewsRepository newsRepository;
        private final ObjectMapper objectMapper;
        private final MessageService messageService;
        @Value("${file.location}")
        private String location;
        @Value("${import.duration}")
        private int duration;
        private Boolean inProgress = false;
        private String messageStatus = "";
        private Callable<String> messageStatusAsync = this::getMessageStatus;

        StartCommandLine(NewsRepository newsRepository, ObjectMapper objectMapper, MessageService messageService) {
            this.newsRepository = newsRepository;
            this.objectMapper = objectMapper;
            this.messageService = messageService;
        }

        @Override
        public void run(String... strings) throws Exception {
            inProgress = true;

            TypeReference<Map<String, Object>> mapTypeReference = new TypeReference<Map<String, Object>>() {
            };

            final Map<String, Object> result = objectMapper.readValue(this.getClass().getResourceAsStream(location), mapTypeReference);

            final int nb = result.size();

            AtomicInteger index = new AtomicInteger();

            result.values().forEach(jsonNode -> {
                final News s = new News();
                final String content = JacksonUtil.toString(jsonNode);
                String cdnId = JsonPath.parse(content).read("$.newsml.cdnId");
                s.setId(cdnId);
                s.setContent(content);

                newsRepository.save(s);
                messageService.sendNewsCreated(s);
                final int ind = index.incrementAndGet();
                messageStatus = "Loading " + ind + " / " + nb;

                if (isWaitParameter(strings)) {
                    try {
                        Thread.sleep(duration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            messageStatus = "";
            inProgress = false;
        }

        private boolean isWaitParameter(String[] strings) {
            return strings.length > 0 && WAIT.equals(strings[0]);
        }

        @Override
        public boolean isInProgress() {
            return inProgress;
        }

        @Override
        public String getMessageStatus() {
            return messageStatus;
        }

        @Override
        public Callable<String> getMessageStatusAsync() {
            return messageStatusAsync;
        }
    }


}
