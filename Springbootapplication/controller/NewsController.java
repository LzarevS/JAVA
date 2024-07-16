package springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapplication.dto.NewsDto;
import springbootapplication.model.News;
import springbootapplication.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        if (news != null) {
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> allNews = newsService.getAllNews();
        return new ResponseEntity<>(allNews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto) {
        NewsDto createdNews = newsService.createNews(newsDto);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        News updatedNews = newsService.updateNews(id, newsDto);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        boolean deleted = newsService.deleteNews(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<News>> getNewsByCategoryId(@PathVariable Long id) {
        List<News> newsList = newsService.getNewsByCategoryId(id);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }
}
