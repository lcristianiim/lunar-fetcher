package lunar.fetcher;

import java.time.LocalDateTime;
import java.util.List;

public interface Repo {
    LocalDateTime equinox();
    LocalDateTime marchNewMoon();
    LocalDateTime aprilNewMoon();
    LocalDateTime marchFullMoon();
    LocalDateTime aprilFullMoon();
    List<LocalDateTime> marchAndAprilSunSets();
}
