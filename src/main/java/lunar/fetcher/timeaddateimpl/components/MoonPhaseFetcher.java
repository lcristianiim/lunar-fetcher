package lunar.fetcher.timeaddateimpl.components;

import lunar.exception.FetchFieldException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

public class MoonPhaseFetcher {
    private static final Logger LOGGER = Logger.getLogger(MoonPhaseFetcher.class.getName());

    Elements newsHeadlines;
    private int year;

    public MoonPhaseFetcher(int year, String location) {
        this.year = year;

            Document doc = null;
            try {
                doc = Jsoup.connect("https://www.timeanddate.com/moon/phases/" + location + "?year=" + year).get();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }

        assert doc != null;
        newsHeadlines = doc.select(".zebra");
    }

    public LocalDateTime fetchNewMoon(String month) {
        return fetchTableData(1, 2, month);
    }

    public LocalDateTime fetchFullMoon(String month) {
        return fetchTableData(5, 6, month);
    }

    private LocalDateTime fetchTableData(int dayAndMonthColumn, int timeColumn, String monthAsDisplayedInTable) {
        Map<String, String> list = new HashMap<>();
        newsHeadlines.get(0).child(1).children().forEach(c -> list.put(c.child(dayAndMonthColumn).text(), c.child(timeColumn).text()));
        Optional<String> key = list.keySet().stream().filter(e -> e.contains(monthAsDisplayedInTable)).findAny();

        if (key.isPresent()) {
            return createDate(monthAsDisplayedInTable, list, key.get());
        }
        throw new FetchFieldException("The field " + monthAsDisplayedInTable + " was not fetched",
                new Throwable("API error"));
    }

    private LocalDateTime createDate(String monthAsDisplayedInTable, Map<String, String> list, String key) {
        int day = Integer.parseInt(key.replaceAll("\\D", ""));
        int hour = Integer.parseInt(list.get(key).replaceAll("\\D", "").substring(0, 2));
        int min = Integer.parseInt(list.get(key).replaceAll("\\D", "").substring(2));
        int month = getMonthNumber(monthAsDisplayedInTable);

        return LocalDateTime.of(year, month, day, hour, min);
    }

    private int getMonthNumber(String monthAsDisplayedInTable) {
        monthAsDisplayedInTable = monthAsDisplayedInTable.substring(0, 1).toUpperCase() + monthAsDisplayedInTable.substring(1);
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM")
                .withLocale(Locale.ENGLISH);
        return parser.parse(monthAsDisplayedInTable).get(MONTH_OF_YEAR);
    }
}
