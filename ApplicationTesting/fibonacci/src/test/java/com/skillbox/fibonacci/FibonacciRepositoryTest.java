package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;


    @Test
    void testSaveFibonacciNumber() {
        FibonacciNumber number = new FibonacciNumber(1, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 1",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );

        assertEquals(1, actual.size());
        assertEquals(number.getIndex(), actual.get(0).getIndex());
        assertEquals(number.getValue(), actual.get(0).getValue());
    }

    @Test
    void testFindByIndex() {
        FibonacciNumber number = new FibonacciNumber(2, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        FibonacciNumber found = repository.findByIndex(2).orElse(null);
        assertEquals(number.getIndex(), found.getIndex());
        assertEquals(number.getValue(), found.getValue());
    }

    @Test
    void testNoDuplicateOnRepeatedInsert() {
        FibonacciNumber number = new FibonacciNumber(3, 2);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 3",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );

        assertEquals(1, actual.size());
        assertEquals(number.getIndex(), actual.get(0).getIndex());
        assertEquals(number.getValue(), actual.get(0).getValue());
    }
}
