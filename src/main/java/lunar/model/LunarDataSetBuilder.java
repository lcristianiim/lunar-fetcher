package lunar.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LunarDataSetBuilder {
    private int year;
    private LocalDateTime equinox;
    private LocalDateTime marchFullMoon;
    private LocalDateTime marchNewMoon;
    private LocalDateTime aprilNewMoon;
    private LocalDateTime aprilFullMoon;
    private List<LocalDateTime> sunSets = new ArrayList<>();

    public LunarDataSetBuilder year(int year) {
        this.year = year;
        return this;
    }
    public LunarDataSetBuilder equinox(LocalDateTime equinox) {
        this.equinox = equinox;
        return this;
    }
    public LunarDataSetBuilder marchFullMoon(LocalDateTime marchFullMoon) {
        this.marchFullMoon = marchFullMoon;
        return this;
    }
    public LunarDataSetBuilder marchNewMoon(LocalDateTime marchNewMoon) {
        this.marchNewMoon = marchNewMoon;
        return this;
    }
    public LunarDataSetBuilder aprilNewMoon(LocalDateTime aprilNewMoon) {
        this.aprilNewMoon = aprilNewMoon;
        return this;
    }
    public LunarDataSetBuilder aprilFullMoon(LocalDateTime aprilFullMoon) {
        this.aprilFullMoon = aprilFullMoon;
        return this;
    }
    public LunarDataSetBuilder addSunsets(List<LocalDateTime> sunsetList) {
        sunSets = new ArrayList<>();
        sunSets.addAll(sunsetList);
        return this;
    }

    public LunarDataSet build() {
        LunarDataSet set = new LunarDataSet();
        set.setYear(year);
        set.setEquinox(equinox);
        set.setMarchNewMoon(marchNewMoon);
        set.setMarchFullMoon(marchFullMoon);
        set.setAprilNewMoon(aprilNewMoon);
        set.setAprilFullMoon(aprilFullMoon);
        set.setSunSets(sunSets);
        return set;
    }
}
