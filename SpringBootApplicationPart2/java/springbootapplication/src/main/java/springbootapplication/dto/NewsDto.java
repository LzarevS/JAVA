package springbootapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private String title;
    private String text;
    private Instant date;
    private String category;

    public void setId(Long id) {
    }
}

