package lunar.fetcher.timeaddateimpl.components;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SunSetFetcherTest {
    SunSetFetcher marchSunSetFetcher_1962;
    SunSetFetcher aprilSunSetFetcher_1962;
    SunSetFetcher marchSunSetFetcher_2020;
    SunSetFetcher aprilSunSetFetcher_2020;
    SunSetFetcher marchSunSetFetcher_1943;
    SunSetFetcher aprilSunSetFetcher_1943;
    SunSetFetcher marchSunSetFetcher_1916;
    SunSetFetcher aprilSunSetFetcher_1916;


    @BeforeAll
    void setUpFixture() {
        marchSunSetFetcher_1962 = new SunSetFetcher(1962, "israel/jerusalem", 3);
        aprilSunSetFetcher_1962 = new SunSetFetcher(1962, "israel/jerusalem", 4);
        marchSunSetFetcher_2020 = new SunSetFetcher(2020, "israel/jerusalem", 3);
        aprilSunSetFetcher_2020 = new SunSetFetcher(2020, "israel/jerusalem", 4);
        marchSunSetFetcher_1943 = new SunSetFetcher(1943, "israel/jerusalem", 3);
        aprilSunSetFetcher_1943 = new SunSetFetcher(1943, "israel/jerusalem", 4);
        marchSunSetFetcher_1916 = new SunSetFetcher(1916, "israel/jerusalem", 3);
        aprilSunSetFetcher_1916 = new SunSetFetcher(1916, "israel/jerusalem", 4);
    }

    @Test
    void testMarchNewMoon_1962() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(1962, 3, 1, 17, 36),
                LocalDateTime.of(1962, 3, 15, 17, 46),
                LocalDateTime.of(1962, 3, 31, 17, 57)
        );

        List<LocalDateTime> result = marchSunSetFetcher_1962.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testAprilNewMoon_1962() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(1962, 4, 1, 17, 58),
                LocalDateTime.of(1962, 4, 15, 18, 7),
                LocalDateTime.of(1962, 4, 30, 18, 17)
        );

        List<LocalDateTime> result = aprilSunSetFetcher_1962.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testMarchNewMoon_2020() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(2020, 3, 1, 17, 37),
                LocalDateTime.of(2020, 3, 15, 17, 47),
                LocalDateTime.of(2020, 3, 31, 18, 58)
        );

        List<LocalDateTime> result = marchSunSetFetcher_2020.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testAprilNewMoon_2020() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(2020, 4, 1, 18, 58),
                LocalDateTime.of(2020, 4, 15, 19, 8),
                LocalDateTime.of(2020, 4, 30, 19, 18)
        );

        List<LocalDateTime> result = aprilSunSetFetcher_2020.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testMarchNewMoon_1943() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(1943, 3, 1, 17, 36),
                LocalDateTime.of(1943, 3, 15, 17, 46),
                LocalDateTime.of(1943, 3, 31, 17, 57)
        );

        List<LocalDateTime> result = marchSunSetFetcher_1943.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testAprilNewMoon_1943() {
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(1943, 4, 1, 18, 57),
                LocalDateTime.of(1943, 4, 15, 19, 7),
                LocalDateTime.of(1943, 4, 30, 19, 17)
        );

        List<LocalDateTime> result = aprilSunSetFetcher_1943.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testMarchNewMoon_1916() {
        int year = 1916;
        int month = 3;
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(year, month, 1, 18, 6),
                LocalDateTime.of(year, month, 15, 18, 16),
                LocalDateTime.of(year, month, 31, 18, 27)
        );

        List<LocalDateTime> result = marchSunSetFetcher_1916.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
    @Test
    void testAprilNewMoon_1916() {
        int year = 1916;
        int month = 4;
        List<LocalDateTime> someExpectedElements = Arrays.asList(
                LocalDateTime.of(year, month, 1, 18, 27),
                LocalDateTime.of(year, month, 15, 18, 37),
                LocalDateTime.of(year, month, 30, 18, 47)
        );

        List<LocalDateTime> result = aprilSunSetFetcher_1916.fetchSunsets();

        someExpectedElements.forEach(el -> assertTrue(result.contains(el)));
    }
}