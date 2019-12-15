package lunar.fetcher.timeaddateimpl;

import lunar.fetcher.Repo;
import lunar.fetcher.timeaddateimpl.components.EquinoxFetcher;
import lunar.fetcher.timeaddateimpl.components.Month;
import lunar.fetcher.timeaddateimpl.components.MoonPhaseFetcher;
import lunar.fetcher.timeaddateimpl.components.SunSetFetcher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Fetcher implements Repo {
    int year;
    int place;
    String location;

    public Fetcher(int year, int place, String location) {
        this.year = year;
        this.place = place;
        this.location = location;
    }

    @Override
    public LocalDateTime equinox() {
        return EquinoxFetcher.fetchEquinox(year, place);
    }

    @Override
    public LocalDateTime marchNewMoon() {
        MoonPhaseFetcher mf = new MoonPhaseFetcher(year, location);
        return mf.fetchNewMoon(Month.MARCH.getValue());
    }

    @Override
    public LocalDateTime aprilNewMoon() {
        MoonPhaseFetcher mf = new MoonPhaseFetcher(year, location);
        return mf.fetchNewMoon(Month.APRIL.getValue());
    }

    @Override
    public LocalDateTime marchFullMoon() {
        MoonPhaseFetcher mf = new MoonPhaseFetcher(year, location);
        return mf.fetchFullMoon(Month.MARCH.getValue());
    }

    @Override
    public LocalDateTime aprilFullMoon() {
        MoonPhaseFetcher mf = new MoonPhaseFetcher(year, location);
        return mf.fetchFullMoon(Month.APRIL.getValue());
    }

    @Override
    public List<LocalDateTime> marchAndAprilSunSets() {
        List<LocalDateTime> result = new ArrayList<>();
        SunSetFetcher marchSunSetFetcher = new SunSetFetcher(year, location, 3);
        SunSetFetcher aprilSunSetFetcher = new SunSetFetcher(year, location, 4);

        result.addAll(marchSunSetFetcher.fetchSunsets());
        result.addAll(aprilSunSetFetcher.fetchSunsets());

        return result;
    }
}
