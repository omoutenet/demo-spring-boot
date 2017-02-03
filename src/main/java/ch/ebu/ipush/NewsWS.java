package ch.ebu.ipush;

import ch.ebu.ipush.fwk.JacksonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
@Transactional()
public class NewsWS {
    private final NewsRepository newsRepository;
    private final ObjectMapper objectMapper;
    private final MessageService messageService;
    @Autowired
    private InitCommandLineRunner commandLineRunner;

    @Autowired
    public NewsWS(NewsRepository newsRepository, ObjectMapper objectMapper, MessageService messageService) {
        this.newsRepository = newsRepository;
        this.objectMapper = objectMapper;
        this.messageService = messageService;
    }

    @PutMapping(path = "/{id}")
    public Object update(@PathVariable("id") String id, @RequestBody Object o) {
        final News news = newsRepository.findOne(id);
        if (news == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found content with id " + id);
        }

        news.setContent(JacksonUtil.toString(o));

        final News newsSaved = newsRepository.save(news);
        messageService.sendNewsUpdated(newsSaved);

        return ResponseEntity.ok("content delete");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        final News one = newsRepository.findOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found content with id " + id);
        }


        newsRepository.delete(one);

        return ResponseEntity.ok("content delete");
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Object o) {
        final News news = new News();
        news.setContent(JacksonUtil.toString(o));

        final News newsSaved = newsRepository.save(news);

        messageService.sendNewsCreated(newsSaved);

        return ResponseEntity.ok(news.getId());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") String id) {
        final News one = newsRepository.findOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found content with id " + id);
        }


        return ResponseEntity.ok(convertToString(one));
    }

    @GetMapping
    public List<Object> findAll() throws IOException {
        return newsRepository.findAll()
                .stream()
                .map(this::convertToString)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/map")
    public Map<String, Object> findAllToMap() throws IOException {
        return newsRepository.findAll()
                .stream()
                .collect(Collectors.toMap(News::getId, news -> JacksonUtil.toObject(news.getContent())));
    }

    @GetMapping("/reload")
    @PostMapping("/reload")
    public Callable<String> reload() throws Exception {

        if (commandLineRunner.isInProgress()){
            return commandLineRunner.getMessageStatusAsync();
        }

        newsRepository.deleteAll();
        commandLineRunner.run(InitCommandLineRunner.WAIT);

        return commandLineRunner.getMessageStatusAsync();
    }

    private Object convertToString(News news) {
        return JacksonUtil.toObject(news.getContent());
    }

}
