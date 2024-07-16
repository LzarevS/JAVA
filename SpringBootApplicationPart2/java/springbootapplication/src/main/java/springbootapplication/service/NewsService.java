package springbootapplication.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootapplication.model.Category;
import springbootapplication.model.News;
import springbootapplication.dto.NewsDto;
import springbootapplication.repositories.NewsRepository;
import springbootapplication.repositories.CategoryRepository;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public boolean deleteNews(Long id) {
        newsRepository.deleteById(id);
        return true;
    }

    public NewsDto createNews(NewsDto newsDto) {
        News news = new News();
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        news.setDate(Instant.now());

        Optional<Category> categoryOptional = categoryRepository.findByTitle(newsDto.getCategory());
        if (categoryOptional.isEmpty()) {
            throw new IllegalArgumentException("Категория '" + newsDto.getCategory() + "' не найдена");
        }
        Category category = categoryOptional.get();
        news.setCategory(category);

        News savedNews = newsRepository.save(news);

        NewsDto createdNewsDto = new NewsDto();
        createdNewsDto.setId(savedNews.getId());
        createdNewsDto.setTitle(savedNews.getTitle());
        createdNewsDto.setText(savedNews.getText());
        createdNewsDto.setDate(savedNews.getDate());
        createdNewsDto.setCategory(category.getTitle());

        return createdNewsDto;
    }


    public News updateNews(Long id, NewsDto newsDto) {
        News existingNews = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Новость с ID " + id + " не найдена"));

        existingNews.setTitle(newsDto.getTitle());
        existingNews.setText(newsDto.getText());
        existingNews.setDate(Instant.now());

        Optional<Category> category = categoryRepository.findByTitle(newsDto.getCategory());
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Категория '" + newsDto.getCategory() + "' не найдена");
        }
        existingNews.setCategory(category.get());

        return newsRepository.save(existingNews);
    }

    public List<News> getNewsByCategoryId(Long id) {
        return newsRepository.findByCategoryId(id);
    }
}
