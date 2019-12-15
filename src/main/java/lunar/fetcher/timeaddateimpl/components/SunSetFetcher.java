package lunar.fetcher.timeaddateimpl.components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SunSetFetcher {
    private static final Logger LOGGER = Logger.getLogger(SunSetFetcher.class.getName());

    Elements tableData;
    private int year;
    private int month;


    public SunSetFetcher(int year, String location, int month) {
        this.year = year;
        this.month = month;
            Document doc = null;
            try {
                doc = Jsoup.connect(" https://www.timeanddate.com/sun/" + location + "?month="+ month + "&year=" + year).get();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }

        assert doc != null;
        tableData = doc.select(".zebra");
    }

    public List<LocalDateTime> fetchSunsets() {
        return fetchTableData();
    }

    private List<LocalDateTime> fetchTableData() {
        Map<String, String> list = new HashMap<>();
        tableData.get(0).child(1).children().forEach(c -> {
            if (c.children().size() == 13) {
                list.put(c.child(0).text(), c.child(2).text().replaceAll("\\D", "").substring(0, 4));
            }
        });

        List<LocalDateTime> result = new ArrayList<>();

        list.keySet().forEach(key -> result.add(createLocalDateTime(key, list)));

        return result;
    }

    private LocalDateTime createLocalDateTime(String key, Map<String, String> list) {
        int day = Integer.parseInt(key);
        String time = list.get(key);
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(2));
        return LocalDateTime.of(year, month, day, hour, min);
    }
}
