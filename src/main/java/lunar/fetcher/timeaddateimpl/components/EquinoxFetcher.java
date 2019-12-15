package lunar.fetcher.timeaddateimpl.components;

import lunar.exception.FetchFieldException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static org.jsoup.Jsoup.connect;

public class EquinoxFetcher {
    private static final Logger LOGGER = Logger.getLogger(EquinoxFetcher.class.getName());

    private EquinoxFetcher() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDateTime fetchEquinox(int year, int location) {
        Document doc = makeRequest(year, location);
        assert doc != null;
        Elements tableElements = doc.select(".table--striped");

        Optional<Element> e = getElementByYear(year, tableElements);

        if (e.isPresent()) {
            return generateEquinoxDate(e.get());
        }
        throw new FetchFieldException("The equinox field was not fetched",
                new Throwable("API error"));
    }

    private static Optional<Element> getElementByYear(int year, Elements tableElements) {
        return tableElements.get(0).child(1)
                    .children()
                    .stream()
                    .filter(c -> c.child(0).parent().toString().contains("<th>" + year + "</th>"))
                    .findFirst();
    }

    private static LocalDateTime generateEquinoxDate(Element e) {
        int y = Integer.parseInt(e.child(0).text());
        int m = getNumberOfMonth(e);
        int day = Integer.parseInt(e.child(1).text().replaceAll("\\D", ""));
        int hour = Integer.parseInt(e.child(2)
                .text().replaceAll("\\D", "").substring(0,2));
        int minutes = Integer.parseInt(e.child(2)
                .text().replaceAll("\\D", "").substring(2));

        return LocalDateTime.of(y, m, day, hour, minutes);
    }

    private static Document makeRequest(int year, int location) {
        Document doc = null;
        try {
            doc = connect("https://www.timeanddate.com/calendar/seasons.html?year=" + year + "&n=" + location).get();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return doc;
    }

    private static int getNumberOfMonth(Element e) {
        String month = e.child(1).text().replaceAll("\\d", "");
        month = month.replace(" ","");
        month = month.substring(0, 1).toUpperCase() + month.substring(1);
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM")
                .withLocale(Locale.ENGLISH);
        TemporalAccessor accessor = parser.parse(month);
        return accessor.get(MONTH_OF_YEAR);
    }
}
