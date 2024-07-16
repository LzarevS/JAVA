package springbootapplication.service;
import org.springframework.stereotype.Service;
import springbootapplication.Model.News;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsService {

    private final ConcurrentHashMap<Long, News> newsMap = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public News getById(Long id) {
        return newsMap.get(id);
    }

    public List<News> getAll() {
        return new ArrayList<>(newsMap.values());
    }

    public News create(News news) {
        Long id = idCounter.incrementAndGet();
        news.setId(id);
        news.setDate(Instant.now());
        newsMap.put(id, news);
        return news;
    }

    public News update(News news) {
        Long id = news.getId();
        if (newsMap.containsKey(id)) {
            news.setDate(Instant.now());
            newsMap.put(id, news);
            return news;
        } else {
            return null;
        }
    }

    public boolean deleteById(Long id) {
        return newsMap.remove(id) != null;
    }
}

