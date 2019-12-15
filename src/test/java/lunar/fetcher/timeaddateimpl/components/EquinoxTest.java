package lunar.fetcher.timeaddateimpl.components;

import lunar.fetcher.timeaddateimpl.TimeAndDateFetcher;
import lunar.fetcher.Repo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquinoxTest {

    @Test
    void fetchEquinox_2020() {
        Repo repo = new TimeAndDateFetcher(2020, 110, "israel/jerusalem");
        LocalDateTime expected = LocalDateTime.of(2020, 3, 20, 5, 49);
        LocalDateTime result = repo.equinox();
        assertEquals(expected, result);
    }
    @Test
    void fetchEquinox_1962() {
        Repo repo = new TimeAndDateFetcher(1962, 110, "israel/jerusalem");
        LocalDateTime expected = LocalDateTime.of(1962, 3, 21, 4, 29);
        LocalDateTime result = repo.equinox();
        assertEquals(expected, result);
    }
    @Test
    void fetchEquinox_1943() {
        Repo repo = new TimeAndDateFetcher(1943, 110, "israel/jerusalem");
        LocalDateTime expected = LocalDateTime.of(1943, 3, 21, 14, 2);
        LocalDateTime result = repo.equinox();
        assertEquals(expected, result);
    }
}