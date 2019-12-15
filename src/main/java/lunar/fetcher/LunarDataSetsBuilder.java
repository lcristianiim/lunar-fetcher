package lunar.fetcher;

import lunar.fetcher.timeaddateimpl.Fetcher;
import lunar.model.LunarDataSet;
import lunar.model.LunarDataSetBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LunarDataSetsBuilder {
   private int startYear;
   private int endYear;
   private int numberRepresentationOfPlace;
   private String location;

    public LunarDataSetsBuilder(int startYear, int endYear, int numberRepresentationOfPlace, String location) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.numberRepresentationOfPlace = numberRepresentationOfPlace;
        this.location = location;
    }

    public List<LunarDataSet> generateLunarData() {
        List<LunarDataSet> result = new ArrayList<>();
        if (startYear == endYear) {
            result.add(buildLunarDataSet(startYear));
            return result;
        }

        IntStream.range(startYear, endYear + 1)
                .forEach(year -> result.add(buildLunarDataSet(year)));
        return result;
    }

    private LunarDataSet buildLunarDataSet(int year) {
        LunarDataSetBuilder builder = new LunarDataSetBuilder();
        Repo fetcher = new Fetcher(year, numberRepresentationOfPlace, location);
         return builder
                .year(year)
                .equinox(fetcher.equinox())
                .marchNewMoon(fetcher.marchNewMoon())
                .aprilNewMoon(fetcher.aprilNewMoon())
                .marchFullMoon(fetcher.marchFullMoon())
                .aprilFullMoon(fetcher.aprilFullMoon())
                .addSunsets(fetcher.marchAndAprilSunSets())
                .build();
    }
}
