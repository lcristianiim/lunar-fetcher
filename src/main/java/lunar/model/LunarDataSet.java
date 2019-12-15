package lunar.model;

import java.time.LocalDateTime;
import java.util.List;

public class LunarDataSet {
    private int year;
    private LocalDateTime equinox;
    private LocalDateTime marchFullMoon;
    private LocalDateTime marchNewMoon;
    private LocalDateTime aprilNewMoon;
    private LocalDateTime aprilFullMoon;
    private List<LocalDateTime> sunSets;


    public int getYear() {
        return year;
    }

    public LunarDataSet setYear(int year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getAprilFullMoon() {
        return aprilFullMoon;
    }

    public LunarDataSet setAprilFullMoon(LocalDateTime aprilFullMoon) {
        this.aprilFullMoon = aprilFullMoon;
        return this;
    }

    public LocalDateTime getEquinox() {
        return equinox;
    }

    public LunarDataSet setEquinox(LocalDateTime equinox) {
        this.equinox = equinox;
        return this;
    }

    public LocalDateTime getMarchFullMoon() {
        return marchFullMoon;
    }

    public LunarDataSet setMarchFullMoon(LocalDateTime marchFullMoon) {
        this.marchFullMoon = marchFullMoon;
        return this;
    }

    public LocalDateTime getMarchNewMoon() {
        return marchNewMoon;
    }

    public void setMarchNewMoon(LocalDateTime marchNewMoon) {
        this.marchNewMoon = marchNewMoon;
    }

    public LocalDateTime getAprilNewMoon() {
        return aprilNewMoon;
    }

    public List<LocalDateTime> getSunSets() {
        return sunSets;
    }

    public void setSunSets(List<LocalDateTime> sunSets) {
        this.sunSets = sunSets;
    }

    public void setAprilNewMoon(LocalDateTime aprilNewMoon) {
        this.aprilNewMoon = aprilNewMoon;
    }

}
