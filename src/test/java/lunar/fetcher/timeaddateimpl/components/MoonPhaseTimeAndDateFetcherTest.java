package lunar.fetcher.timeaddateimpl.components;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoonPhaseTimeAndDateFetcherTest {
    public static final String APRIL = Month.APRIL.getValue();
    public static final String MARCH = Month.MARCH.getValue();

    MoonPhaseFetcher moonPhaseFetcher_2020;
    MoonPhaseFetcher moonPhaseFetcher_1962;
    MoonPhaseFetcher moonPhaseFetcher_1943;
    MoonPhaseFetcher moonPhaseFetcher_1916;


    @BeforeAll
    void setUpFixture() {
        moonPhaseFetcher_2020 = new MoonPhaseFetcher(2020, "israel/jerusalem");
        moonPhaseFetcher_1962 = new MoonPhaseFetcher(1962, "israel/jerusalem");
        moonPhaseFetcher_1943 = new MoonPhaseFetcher(1943, "israel/jerusalem");
        moonPhaseFetcher_1916 = new MoonPhaseFetcher(1916, "israel/jerusalem");
    }

    @Test
    void testMarchNewMoon_2020() {
        LocalDateTime expected = LocalDateTime.of(2020, 3, 24, 11, 28);
        LocalDateTime result = moonPhaseFetcher_2020.fetchNewMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilNewMoon_2020() {
        LocalDateTime expected = LocalDateTime.of(2020, 4, 23, 5, 25);
        LocalDateTime result = moonPhaseFetcher_2020.fetchNewMoon(APRIL);

        assertEquals(expected, result);
    }
    @Test
    void testMarchFullMoon_2020() {
        LocalDateTime expected = LocalDateTime.of(2020, 3, 9, 19, 47);
        LocalDateTime result = moonPhaseFetcher_2020.fetchFullMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilFullMoon_2020() {
        LocalDateTime expected = LocalDateTime.of(2020, 4, 8, 5, 35);
        LocalDateTime result = moonPhaseFetcher_2020.fetchFullMoon(APRIL);

        assertEquals(expected, result);
    }

    @Test
    void testMarchNewMoon_1962() {
        LocalDateTime expected = LocalDateTime.of(1962, 3, 6, 12, 30);
        LocalDateTime result = moonPhaseFetcher_1962.fetchNewMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilNewMoon_1962() {
        LocalDateTime expected = LocalDateTime.of(1962, 4, 4, 21, 44);
        LocalDateTime result = moonPhaseFetcher_1962.fetchNewMoon(APRIL);

        assertEquals(expected, result);
    }
    @Test
    void testMarchFullMoon_1962() {
        LocalDateTime expected = LocalDateTime.of(1962, 3, 21, 9, 55);
        LocalDateTime result = moonPhaseFetcher_1962.fetchFullMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilFullMoon_1962() {
        LocalDateTime expected = LocalDateTime.of(1962, 4, 20, 2, 33);
        LocalDateTime result = moonPhaseFetcher_1962.fetchFullMoon(APRIL);

        assertEquals(expected, result);
    }

    @Test
    void testMarchNewMoon_1943() {
        LocalDateTime expected = LocalDateTime.of(1943, 3, 6, 12, 33);
        LocalDateTime result = moonPhaseFetcher_1943.fetchNewMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilNewMoon_1943() {
        LocalDateTime expected = LocalDateTime.of(1943, 4, 5, 0, 52);
        LocalDateTime result = moonPhaseFetcher_1943.fetchNewMoon(APRIL);

        assertEquals(expected, result);
    }
    @Test
    void testMarchFullMoon_1943() {
        LocalDateTime expected = LocalDateTime.of(1943, 3, 22, 0, 7);
        LocalDateTime result = moonPhaseFetcher_1943.fetchFullMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilFullMoon_1943() {
        LocalDateTime expected = LocalDateTime.of(1943, 4, 20, 14, 10);
        LocalDateTime result = moonPhaseFetcher_1943.fetchFullMoon(APRIL);

        assertEquals(expected, result);
    }

    @Test
    void testMarchNewMoon_1916() {
        LocalDateTime expected = LocalDateTime.of(1916, 3, 20, 18, 41);
        LocalDateTime result = moonPhaseFetcher_1916.fetchNewMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilNewMoon_1916() {
        LocalDateTime expected = LocalDateTime.of(1916, 4, 19, 7, 49);
        LocalDateTime result = moonPhaseFetcher_1916.fetchNewMoon(APRIL);

        assertEquals(expected, result);
    }
    @Test
    void testMarchFullMoon_1916() {
        LocalDateTime expected = LocalDateTime.of(1916, 3, 6, 19, 46);
        LocalDateTime result = moonPhaseFetcher_1916.fetchFullMoon(MARCH);

        assertEquals(expected, result);
    }
    @Test
    void testAprilFullMoon_1916() {
        LocalDateTime expected = LocalDateTime.of(1916, 4, 5, 7, 27);
        LocalDateTime result = moonPhaseFetcher_1916.fetchFullMoon(APRIL);

        assertEquals(expected, result);
    }
}